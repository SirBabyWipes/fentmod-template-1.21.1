package net.lilbabywipes.fentmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.lilbabywipes.fentmod.block.ModBlocks;
import net.lilbabywipes.fentmod.block.custom.WeedCropBlock;
import net.lilbabywipes.fentmod.entities.ModEntities;
import net.lilbabywipes.fentmod.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class FentModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.dirtyCrackPipeEntityType, (context) ->
                new FlyingItemEntityRenderer(context));

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.WEED_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.COCA_CROP);
    }
}
