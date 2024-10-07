package net.lilbabywipes.fentmod.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class Nicotine extends StatusEffect {
    public Nicotine() {
        super(StatusEffectCategory.BENEFICIAL, 100);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity pLivingEntity, int pAmplifier) {
        if (pLivingEntity instanceof PlayerEntity playerEntity) {
            long currentTime = pLivingEntity.getWorld().getTime();
            if (currentTime % 1 == 0) {

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
