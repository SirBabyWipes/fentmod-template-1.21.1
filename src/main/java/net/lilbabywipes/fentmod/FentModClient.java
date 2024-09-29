package net.lilbabywipes.fentmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.lilbabywipes.fentmod.entities.ModEntities;
import net.lilbabywipes.fentmod.item.ModItems;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class FentModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.dirtyCrackPipeEntityType, (context) ->
                new FlyingItemEntityRenderer(context));
    }
}
