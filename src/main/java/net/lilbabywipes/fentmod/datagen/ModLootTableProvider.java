package net.lilbabywipes.fentmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.lilbabywipes.fentmod.block.ModBlocks;
import net.lilbabywipes.fentmod.block.custom.WeedCropBlock;
import net.lilbabywipes.fentmod.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.COCAINE_BLOCK);
        addDrop(ModBlocks.COCAINE_CARPET_BLOCK);

        //weed seeds
        BlockStatePropertyLootCondition.Builder weedBuilder = BlockStatePropertyLootCondition.builder(ModBlocks.WEED_CROP).properties(
                StatePredicate.Builder.create()
                        .exactMatch(WeedCropBlock.AGE, 4)
        );
        addDrop(ModBlocks.WEED_CROP, cropDrops(ModBlocks.WEED_CROP, ModItems.WEED, ModItems.WEED_SEEDS, weedBuilder));

        //coca seeds
        BlockStatePropertyLootCondition.Builder cocaBuilder = BlockStatePropertyLootCondition.builder(ModBlocks.COCA_CROP).properties(
                StatePredicate.Builder.create()
                        .exactMatch(WeedCropBlock.AGE, 4)
        );

        addDrop(ModBlocks.COCA_CROP, cropDrops(ModBlocks.COCA_CROP, ModItems.COCAINE, ModItems.COCA_SEEDS, cocaBuilder));

        //salvia seeds
        BlockStatePropertyLootCondition.Builder salviaBuilder = BlockStatePropertyLootCondition.builder(ModBlocks.SALVIA_CROP).properties(
                StatePredicate.Builder.create()
                        .exactMatch(WeedCropBlock.AGE, 4)
        );

        addDrop(ModBlocks.SALVIA_CROP, cropDrops(ModBlocks.SALVIA_CROP, ModItems.SALVIA, ModItems.SALVIA_SEEDS, salviaBuilder));

        //addDrop(ModBlocks.TOBACCO_CROP, cropDrops(ModBlocks.TOBACCO_CROP, M))
    }
}
