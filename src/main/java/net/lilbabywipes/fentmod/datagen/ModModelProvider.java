package net.lilbabywipes.fentmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.lilbabywipes.fentmod.block.ModBlocks;
import net.lilbabywipes.fentmod.block.custom.WeedCropBlock;
import net.lilbabywipes.fentmod.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

import javax.annotation.processing.Generated;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    //when registering crops you only need to register the crop block and not the seed item
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COCAINE_BLOCK);
        blockStateModelGenerator.registerWoolAndCarpet(ModBlocks.COCAINE_BLOCK, ModBlocks.COCAINE_CARPET_BLOCK);

        blockStateModelGenerator.registerCrop(ModBlocks.WEED_CROP, WeedCropBlock.AGE, 0, 1, 2, 3, 4);
        blockStateModelGenerator.registerCrop(ModBlocks.COCA_CROP, WeedCropBlock.AGE, 0, 1, 2, 3, 4);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.BONGEMPTY, Models.GENERATED);
        itemModelGenerator.register(ModItems.BONGFULL, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRACK_PIPE, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIRTY_CRACK_PIPE, Models.GENERATED);
        itemModelGenerator.register(ModItems.FENT, Models.GENERATED);
        itemModelGenerator.register(ModItems.GRINDER, Models.GENERATED);
        itemModelGenerator.register(ModItems.GROUNDWEED, Models.GENERATED);
        itemModelGenerator.register(ModItems.JOINT, Models.GENERATED);
        itemModelGenerator.register(ModItems.WEED, Models.GENERATED);
        itemModelGenerator.register(ModItems.NARCAN, Models.GENERATED);
        //itemModelGenerator.register(ModItems.WEED_SEEDS, Models.GENERATED);
        //itemModelGenerator.register(ModItems.COCA_SEEDS, Models.GENERATED);
        itemModelGenerator.register(ModItems.COCAINE, Models.GENERATED);
    }
}
