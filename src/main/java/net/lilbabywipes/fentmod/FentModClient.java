package net.lilbabywipes.fentmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.lilbabywipes.fentmod.block.ModBlocks;
import net.lilbabywipes.fentmod.block.custom.WeedCropBlock;
import net.lilbabywipes.fentmod.entities.ModEntities;
import net.lilbabywipes.fentmod.item.ModItems;
import net.lilbabywipes.fentmod.utils.utils;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.util.math.MathHelper;

public class FentModClient implements ClientModInitializer {
    public static boolean salviaHigh = false;


    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.dirtyCrackPipeEntityType, (context) ->
                new FlyingItemEntityRenderer(context));

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.WEED_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.COCA_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.SALVIA_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.COCAINE_CARPET_BLOCK);

    }
}
