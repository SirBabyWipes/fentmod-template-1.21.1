package net.lilbabywipes.fentmod.data;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.PersistentState;

import java.util.HashMap;
import java.util.UUID;

// not actually persistent state as of 01/10/24
public class ModServerData extends PersistentState {
    public static HashMap<UUID, PlayerData> players = new HashMap<>();

    public static void intialize() {
        //update nbt data with players hashmap
        return;
    }

    public static PlayerData getPlayerData(UUID uuid) {
        return  players.computeIfAbsent(uuid, id -> new PlayerData());
    }

    public static void updatePlayerData(UUID uuid, PlayerData data) {
        players.put(uuid, data);
    }

    public static void updatePlayerData(LivingEntity player, PlayerData data) {
        if (player instanceof PlayerEntity) {
            updatePlayerData(player.getUuid(), data);
        }
    }

    public static void updatePlayerData(LivingEntity player, Substances drug) {
        PlayerData data = getPlayerData(player.getUuid());

        switch (drug) {
            case Substances.COCAIN -> {
                data.resistance += 2;
                data.crunked += 6;
                break;
            }

            case Substances.WEED -> {

                break;
            }

            case Substances.FENT -> {
                data.resistance += 5;
                data.crunked += 15;
               break;
            }
        }

        updatePlayerData(player, data);
    }

    @Override
    public NbtCompound writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        return null;
    }
}
