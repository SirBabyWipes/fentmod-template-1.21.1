package net.lilbabywipes.fentmod.effects;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.lilbabywipes.fentmod.FentModClient;
import net.lilbabywipes.fentmod.utils.utils;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.util.math.MathHelper;

public class SalviaHigh extends StatusEffect {
    public SalviaHigh() {
        super(StatusEffectCategory.BENEFICIAL, 100);
    }
    @Override
    public boolean applyUpdateEffect(LivingEntity pLivingEntity, int pAmplifier) {
        FentModClient.salviaHigh=true;
        if(!pLivingEntity.getWorld().isClient) {
            long currentTime = pLivingEntity.getWorld().getTime();
            if (FentModClient.salviaHigh){
                HudRenderCallback.EVENT.register((context, tickDeltaManager) -> {
                    if (currentTime % 40 == 0) {
                        int color = utils.getRandomInt(0, 1000000000);
                        int targetColor = utils.getRandomInt(0, 1000000000);

                        float totalTickDelta = tickDeltaManager.getTickDelta(true);

                        float lerpedAmount = MathHelper.abs(MathHelper.sin(totalTickDelta / 50F));
                        int lerpedColor = ColorHelper.Argb.lerp(lerpedAmount, color, targetColor);

                        context.fill(0, 0, 10000, 10000, 0, lerpedColor);
                    }
                });
            }
        }
        return super.applyUpdateEffect(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmpwlifirer) { return true; }

    @Override
    public void onRemoved(AttributeContainer attributeContainer) {
        FentModClient.salviaHigh=false;
        HudRenderCallback.EVENT.register((context, tickDeltaManager) -> {
            context.fill(0,0,0,0,0, 0);
        });
        super.onRemoved(attributeContainer);
    }
}
