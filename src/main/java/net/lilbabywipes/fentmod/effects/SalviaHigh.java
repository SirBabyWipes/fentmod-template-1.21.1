package net.lilbabywipes.fentmod.effects;


import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.lilbabywipes.fentmod.FentMod;
import net.lilbabywipes.fentmod.data.ModServerData;
import net.lilbabywipes.fentmod.networking.SalviaHighPayload;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import org.apache.logging.log4j.core.jmx.Server;

import java.util.List;
import java.util.UUID;

public class SalviaHigh extends StatusEffect {
    UUID playerUUID;
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
            this.playerUUID = entity.getUuid();
            ServerPlayNetworking.send((ServerPlayerEntity) entity, new SalviaHighPayload(true));
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmpwlifirer) { return true; }

    @Override
    public void onRemoved(AttributeContainer attributeContainer) {
       ServerPlayerEntity player = FentMod.server.getPlayerManager().getPlayer(this.playerUUID);
       ServerPlayNetworking.send(player, new SalviaHighPayload(false));
        //FentModClient.salviaHigh=false;
        super.onRemoved(attributeContainer);
    }
}
