package net.lilbabywipes.fentmod.effects;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.text.Text;
import org.joml.Matrix4f;

public class WeedHigh extends StatusEffect {
    public WeedHigh() {
        super(StatusEffectCategory.BENEFICIAL, 100);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity pLivingEntity, int pAmplifier) {

        if(!pLivingEntity.getWorld().isClient) {

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
