package net.lilbabywipes.fentmod.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.world.TeleportTarget;

public class FentHigh extends StatusEffect {
    public FentHigh() {
        super(StatusEffectCategory.BENEFICIAL, 100);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity pLivingEntity, int pAmplifier) {
        if(!pLivingEntity.getWorld().isClient) {
            //pLivingEntity.setSneaking(true);
            pLivingEntity.setSwimming(true);
            pLivingEntity.setAbsorptionAmount(100);
        }

        return super.applyUpdateEffect(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmplifirer) { return true; }
}
