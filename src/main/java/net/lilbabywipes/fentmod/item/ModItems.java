package net.lilbabywipes.fentmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.lilbabywipes.fentmod.FentMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModItems {
    public static final Item WEED = registerItem("weed", new Item(new Item.Settings()));
    public static final Item GRINDER = registerItem("grinder", new Item(new Item.Settings()));
    public static final Item COCAINE = registerItem("cocaine", new Item(new Item.Settings()));

    private static Item registerItem(String name,Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(FentMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        FentMod.LOGGER.info("Registering Mod Items for" + FentMod.MOD_ID);


    }
}