package net.lilbabywipes.fentmod.effects;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.lilbabywipes.fentmod.FentModClient;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.util.math.MathHelper;


public class EffectsLayer implements HudRenderCallback {

    @Override
    public void onHudRender(DrawContext drawContext, RenderTickCounter tickCounter) {
        MinecraftClient client = MinecraftClient.getInstance();

    }
}
