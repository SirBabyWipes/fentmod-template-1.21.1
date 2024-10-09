package net.lilbabywipes.fentmod.block;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.lilbabywipes.fentmod.FentMod;
import net.lilbabywipes.fentmod.block.custom.CocaCropBlock;
import net.lilbabywipes.fentmod.block.custom.CocaineCarpetBlock;
import net.lilbabywipes.fentmod.block.custom.TobaccoCropBlock;
import net.lilbabywipes.fentmod.block.custom.WeedCropBlock;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;


public class ModBlocks {

    public static final Block COCAINE_BLOCK = registerBlock("cocaine_block",
            new Block(AbstractBlock.Settings.create().strength(.5f).sounds(BlockSoundGroup.WART_BLOCK)));

    public static final CarpetBlock COCAINE_CARPET_BLOCK = (CarpetBlock) registerBlock("cocaine_carpet_block",
            new CocaineCarpetBlock(AbstractBlock.Settings.create().strength(.1f).sounds(BlockSoundGroup.SNOW)));

    public static final CropBlock WEED_CROP = Registry.register(Registries.BLOCK, Identifier.of(FentMod.MOD_ID, "weed_crop"),
            new WeedCropBlock(Blocks.WHEAT.getSettings())); // same settings as wheat

    public static final CropBlock COCA_CROP = Registry.register(Registries.BLOCK, Identifier.of(FentMod.MOD_ID, "coca_crop"),
            new CocaCropBlock(Blocks.WHEAT.getSettings())); // same settings as wheat

    public static final CropBlock SALVIA_CROP = Registry.register(Registries.BLOCK, Identifier.of(FentMod.MOD_ID, "salvia_crop"),
            new CocaCropBlock(Blocks.WHEAT.getSettings())); // same settings as wheat

    public static final CropBlock TOBACCO_CROP = Registry.register(Registries.BLOCK, Identifier.of(FentMod.MOD_ID, "tobacco_crop"),
            new TobaccoCropBlock(Blocks.WHEAT.getSettings()));






    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(FentMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(FentMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        FentMod.LOGGER.info("Registering Mod Blocks for " + FentMod.MOD_ID);
    }




}
