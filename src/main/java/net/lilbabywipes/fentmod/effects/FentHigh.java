package net.lilbabywipes.fentmod.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class FentHigh extends StatusEffect {
    public FentHigh() {
        super(StatusEffectCategory.BENEFICIAL, 100);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity pLivingEntity, int pAmplifier) {
        if(!pLivingEntity.getWorld().isClient) {
            //pLivingEntity.setSneaking(true);
            pLivingEntity.heal(10);

            long currentTime = pLivingEntity.getWorld().getTime();
            if (currentTime % 40 == 0) {
                pLivingEntity.setVelocity(getRandomOffset(), 0, getRandomOffset());
                pLivingEntity.velocityModified = true;
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
}
