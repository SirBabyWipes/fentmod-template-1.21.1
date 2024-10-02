package net.lilbabywipes.fentmod.effects;


import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.lilbabywipes.fentmod.networking.SalviaHighPayload;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.client.network.ServerInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

import java.util.UUID;

public class SalviaHigh extends StatusEffect {
    public SalviaHigh() {
        super(StatusEffectCategory.BENEFICIAL, 100);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity pLivingEntity, int pAmplifier) {

        //FentModClient.salviaHigh=true;
        return super.applyUpdateEffect(pLivingEntity, pAmplifier);
    }

    @Override
    public void onEntityRemoval(LivingEntity entity, int amplifier, Entity.RemovalReason reason) {
        if (entity instanceof ServerPlayerEntity) {
            ServerPlayNetworking.send((ServerPlayerEntity) entity, new SalviaHighPayload(false));
        }
    }
    @Override
    public void onApplied(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
            ServerPlayNetworking.send((ServerPlayerEntity) entity, new SalviaHighPayload(true));
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmpwlifirer) { return true; }

    @Override
    public void onRemoved(AttributeContainer attributeContainer) {
        //FentModClient.salviaHigh=false;
        super.onRemoved(attributeContainer);
    }
}
