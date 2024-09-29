package net.lilbabywipes.fentmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.lilbabywipes.fentmod.FentMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block COCAINE_BLOCK = registerBlock("cocaine_block",
            new Block(AbstractBlock.Settings.create().strength(.5f).sounds(BlockSoundGroup.WART_BLOCK)));





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
