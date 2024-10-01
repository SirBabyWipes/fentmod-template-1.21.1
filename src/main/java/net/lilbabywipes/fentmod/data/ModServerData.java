package net.lilbabywipes.fentmod.data;

import com.jcraft.jogg.Packet;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.lilbabywipes.fentmod.FentMod;
import net.minecraft.data.client.Models;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Identifier;
import net.minecraft.world.PersistentState;
import net.minecraft.world.PersistentStateManager;
import net.minecraft.world.World;
import org.apache.http.impl.io.IdentityInputStream;

import javax.accessibility.AccessibleStateSet;
import java.util.HashMap;
import java.util.UUID;

public class ModServerData extends PersistentState {
    public Integer resistance;
    public Integer crunked;

    public static HashMap<UUID, PlayerData> players = new HashMap<>();

    public static void initalize() {
        ServerTickEvents.END_SERVER_TICK.register(world -> {
            players.forEach((uuid, player) -> {

            });
        });
    }

    @Override
    public NbtCompound writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        nbt.putInt("crunked", crunked);
        nbt.putInt("resistance", resistance);

        return nbt;
    }

    public static ModServerData createFromNbt(NbtCompound tag, RegistryWrapper.WrapperLookup registryLookup) {
        ModServerData state = new ModServerData();
        state.crunked = tag.getInt("crunked");
        state.resistance = tag.getInt("resistance");

        NbtCompound playersNbt = tag.getCompound("players");
        playersNbt.getKeys().forEach(key -> {
            PlayerData playerData = new PlayerData();

            playerData.crunked = playersNbt.getCompound(key).getInt("crunked");

            UUID uuid = UUID.fromString(key);
            state.players.put(uuid, playerData);
        });

        return state;
    }

    private static Type<ModServerData> type = new Type<> (
        ModServerData::new,
        ModServerData::createFromNbt,
        null
    );

    public static ModServerData getServerState(MinecraftServer server) {
        PersistentStateManager stateManager = server.getWorld(World.OVERWORLD).getPersistentStateManager();
        ModServerData state = stateManager.getOrCreate(type, FentMod.MOD_ID);

        state.markDirty();

        return state;
    }

    public static PlayerData getPlayerState(LivingEntity player) {
        ModServerData serverState = getServerState(player.getWorld().getServer());

        PlayerData data = serverState.players.computeIfAbsent(player.getUuid(), uuid -> new PlayerData());

        return data;
    }

    public static int updatePlayerResistance(LivingEntity player) {
        ModServerData serverSate = getServerState(player.getWorld().getServer());

        PlayerData data = serverSate.players.computeIfAbsent(player.getUuid(), uuid -> new PlayerData());

        data.resistance -= 1;
        return 0;
    }
}
