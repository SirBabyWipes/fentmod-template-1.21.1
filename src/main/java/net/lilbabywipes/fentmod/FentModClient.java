package net.lilbabywipes.fentmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.lilbabywipes.fentmod.block.ModBlocks;
import net.lilbabywipes.fentmod.block.custom.WeedCropBlock;
import net.lilbabywipes.fentmod.entities.ModEntities;
//import net.lilbabywipes.fentmod.hud.SalviaHudEffect;
import net.lilbabywipes.fentmod.item.ModItems;
import net.lilbabywipes.fentmod.networking.SalviaHighPayload;
import net.lilbabywipes.fentmod.utils.utils;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.util.math.MathHelper;

public class FentModClient implements ClientModInitializer {
    public boolean active = false;

    @Override
    public void onInitializeClient() {
        HudRenderCallback.EVENT.register(new SalviaHudEffect());
        ClientPlayNetworking.registerGlobalReceiver(SalviaHighPayload.ID, (payload, context) -> {
            active = payload.active();
            System.out.println(active);
        });

        EntityRendererRegistry.register(ModEntities.dirtyCrackPipeEntityType, (context) ->
                new FlyingItemEntityRenderer(context));

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.WEED_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.COCA_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.SALVIA_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.COCAINE_CARPET_BLOCK);
    }

    public class SalviaHudEffect implements HudRenderCallback {
        @Override
        public void onHudRender(DrawContext drawContext, RenderTickCounter tickCounter) {
            HudRenderCallback.EVENT.register((context, tickDeltaManager) -> {
                long currentTime = MinecraftClient.getInstance().world.getTime();
                if (currentTime % 40 == 0 && active) {
                    int color = utils.getRandomInt(0, 1000000000);
                    int targetColor = utils.getRandomInt(0, 1000000000);

                    float totalTickDelta = tickDeltaManager.getTickDelta(true);

                    float lerpedAmount = MathHelper.abs(MathHelper.sin(totalTickDelta / 50F));
                    int lerpedColor = ColorHelper.Argb.lerp(lerpedAmount, color, targetColor);

                    int width = MinecraftClient.getInstance().getWindow().getWidth();
                    int height = MinecraftClient.getInstance().getWindow().getHeight();

                    context.fill(0, 0, width, height, -100, lerpedColor);
                }
            });
        }
    }
}
