package net.lilbabywipes.fentmod;

import com.mojang.blaze3d.systems.RenderSystem;
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
import net.minecraft.client.render.*;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.util.math.MathHelper;
import org.joml.Matrix4f;

public class FentModClient implements ClientModInitializer {
    public boolean active = false;

    @Override
    public void onInitializeClient() {
        HudRenderCallback.EVENT.register(new SalviaHudEffect());
        ClientPlayNetworking.registerGlobalReceiver(SalviaHighPayload.ID, (payload, context) -> {
            //active = payload.active();
        });

        EntityRendererRegistry.register(ModEntities.dirtyCrackPipeEntityType, (context) ->
                new FlyingItemEntityRenderer(context));

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.WEED_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.COCA_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.SALVIA_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.COCAINE_CARPET_BLOCK);
    }

    public class SalviaHudEffect implements HudRenderCallback {
        int color;
        @Override
        public void onHudRender(DrawContext drawContext, RenderTickCounter tickCounter) {
            HudRenderCallback.EVENT.register((context, tickDeltaManager) -> {
                if (active) {
                    Matrix4f transformationMatrix = drawContext.getMatrices().peek().getPositionMatrix();
                    Tessellator tessellator = Tessellator.getInstance();

                    // Begin a triangle strip buffer using the POSITION_COLOR vertex format.
                    BufferBuilder buffer = tessellator.begin(VertexFormat.DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);

                    // Write our vertices, Z doesn't really matter since it's on the HUD.
                    buffer.vertex(transformationMatrix, 20, 20, 5).color(0xFF414141);
                    buffer.vertex(transformationMatrix, 5, 40, 5).color(0xFF000000);
                    buffer.vertex(transformationMatrix, 35, 40, 5).color(0xFF000000);
                    buffer.vertex(transformationMatrix, 20, 60, 5).color(0xFF414141);

                    // We'll get to this bit in the next section.
                    RenderSystem.setShader(GameRenderer::getPositionColorProgram);
                    RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 0.5F);

                    // Draw the buffer onto the screen.
                    BufferRenderer.drawWithGlobalProgram(buffer.end());
                }
            });
        }
    }
}
