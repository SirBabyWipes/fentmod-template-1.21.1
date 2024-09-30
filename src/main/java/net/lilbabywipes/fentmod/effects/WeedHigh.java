package net.lilbabywipes.fentmod.effects;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.text.Text;

public class WeedHigh extends StatusEffect {
    public WeedHigh() {
        super(StatusEffectCategory.BENEFICIAL, 100);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity pLivingEntity, int pAmplifier) {
        if(!pLivingEntity.getWorld().isClient) {

            long currentTime = pLivingEntity.getWorld().getTime();
            if (currentTime % 40 == 0) {

            }
        }

        return super.applyUpdateEffect(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmplifirer) { return true; }

    private static double min = -0.25;
    private static double max = 0.25;
    private static double getRandomOffset() {
        return min + Math.random() * (max - min);
    }
}
