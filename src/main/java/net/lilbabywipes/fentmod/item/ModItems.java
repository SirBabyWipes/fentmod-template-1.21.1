package net.lilbabywipes.fentmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.lilbabywipes.fentmod.FentMod;
import net.lilbabywipes.fentmod.block.ModBlocks;
import net.lilbabywipes.fentmod.item.custom.*;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModItems {
    public static final Item WEED = registerItem("weed", new Item(new Item.Settings()));
    public static final Item GRINDER = registerItem("grinder", new Grinder(new Item.Settings()));
    public static final Item BONGEMPTY = registerItem("bongempty", new Item(new Item.Settings()));
    public static final Item GROUNDWEED = registerItem("groundweed", new Item(new Item.Settings()));
    public static final Item SALVIA = registerItem("salvia", new Item(new Item.Settings()));

    public static final Item JOINT = registerItem("joint", new JointItem(new Item.Settings()));
    public static final Item BONGFULL = registerItem("bongfull", new BongFullItem(new Item.Settings()));
    public static final Item COCAINE = registerItem("cocaine", new CocaineItem(new Item.Settings()));

    public static final Item FENT = registerItem("fent", new FentItem(new Item.Settings()));

    public static final Item CRACK_PIPE = registerItem("crack_pipe", new CrackPipe(new Item.Settings()));
    public static final Item DIRTY_CRACK_PIPE = registerItem("dirty_crack_pipe", new DirtyCrackPipe(new Item.Settings()));
    public static final Item NARCAN = registerItem("narcan", new NarcanItem(new Item.Settings()));

    public static final Item WEED_SEEDS = registerItem("weed_seeds",
            new AliasedBlockItem(ModBlocks.WEED_CROP, new Item.Settings()));
    public static final Item COCA_SEEDS = registerItem("coca_seeds",
            new AliasedBlockItem(ModBlocks.COCA_CROP, new Item.Settings()));
    public static final Item SALVIA_SEEDS = registerItem("salvia_seeds",
            new AliasedBlockItem(ModBlocks.SALVIA_CROP, new Item.Settings()));



    private static Item registerItem(String name,Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(FentMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        FentMod.LOGGER.info("Registering Mod Items for" + FentMod.MOD_ID);


    }
}