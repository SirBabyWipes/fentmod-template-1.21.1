package net.lilbabywipes.fentmod.networking;

import net.lilbabywipes.fentmod.networking.ModNetworkingConstants;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;

public record SalviaHighPayload(boolean active) implements CustomPayload {
    public static final CustomPayload.Id<SalviaHighPayload> ID = new CustomPayload.Id<>(ModNetworkingConstants.SALVIA_HIGH_ID);
    public static final PacketCodec<RegistryByteBuf, SalviaHighPayload> CODEC = PacketCodec.tuple(PacketCodecs.BOOL, SalviaHighPayload::active, SalviaHighPayload::new);

    @Override
    public CustomPayload.Id<? extends CustomPayload> getId() {
        return ID;
    }
}