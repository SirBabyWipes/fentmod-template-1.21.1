package net.lilbabywipes.fentmod.effects;

import net.lilbabywipes.fentmod.FentMod;
import net.lilbabywipes.fentmod.data.ModServerData;
import net.lilbabywipes.fentmod.data.PlayerData;
import net.lilbabywipes.fentmod.data.Substances;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class Drunk extends StatusEffect {
    public Drunk() {
        super(StatusEffectCategory.BENEFICIAL, 100);
    }
    private double time = 0;
    private static final double timeStep = .01;
    private static final double a = 0.5;

    @Override
    public boolean applyUpdateEffect(LivingEntity pLivingEntity, int pAmplifier) {
        if (pLivingEntity instanceof PlayerEntity playerEntity) {
            long currentTime = pLivingEntity.getWorld().getTime();
            if (currentTime % 1 == 0) {
                float yawOffset = (float) ((a * pAmplifier * Math.sin(time)) / (1 + Math.cos(time) * Math.cos(time)));
                float pitchOffset = (float) ((a * pAmplifier * Math.sin(time) * Math.cos(time)) / (1 + Math.cos(time) * Math.cos(time)));

                playerEntity.setYaw(playerEntity.getYaw() + yawOffset);
                playerEntity.setPitch(playerEntity.getPitch() + pitchOffset);

                time += timeStep + getRandomOffset();
            }
        }
        return super.applyUpdateEffect(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmpwlifirer) { return true; }

    private static double min = -0.25;
    private static double max = 0.25;
    private static double getRandomOffset() {
        return min + Math.random() * (max - min);
    }

    @Override
    public void onRemoved(AttributeContainer attributeContainer) {
        super.onRemoved(attributeContainer);
    }
}
