package net.lilbabywipes.fentmod.networking;

import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;

public class ModNetworking {
    public static void initalize() {
        PayloadTypeRegistry.playS2C().register(SalviaHighPayload.ID, SalviaHighPayload.CODEC);
    }
}