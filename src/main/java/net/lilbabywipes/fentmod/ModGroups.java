package net.lilbabywipes.fentmod;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.lilbabywipes.fentmod.block.ModBlocks;
import net.lilbabywipes.fentmod.item.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModGroups {
    public static final ItemGroup MOD_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(FentMod.MOD_ID, "mod_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.WEED))
                    .displayName(Text.translatable("itemgroup.fentmod.mod_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.WEED);
                        entries.add(ModItems.GRINDER);
                        entries.add(ModItems.COCAINE);
                        entries.add(ModBlocks.COCAINE_BLOCK);
                        entries.add(ModItems.JOINT);
                        entries.add(ModItems.BONGFULL);
                        entries.add(ModItems.BONGEMPTY);
                        entries.add(ModItems.GROUNDWEED);
                        entries.add(ModItems.FENT);
                        entries.add(ModItems.CRACK_PIPE);
                        entries.add(ModItems.DIRTY_CRACK_PIPE);
                        entries.add(ModItems.WEED_SEEDS);
                        entries.add(ModItems.COCA_SEEDS);
                        entries.add(ModBlocks.COCAINE_CARPET_BLOCK);
                        entries.add(ModItems.NARCAN);
                        entries.add(ModItems.SALVIA);
                        entries.add(ModItems.SALVIA_SEEDS);
                        entries.add(ModItems.BEER);
                        entries.add(ModItems.SUPERWHEAT);
                        entries.add(ModItems.BONGSALVIA);
                        entries.add(ModItems.MORPHINE);
                        entries.add(ModItems.JOHNSITEM);

                    }).build());



    public static void registerItemGroup() {
        FentMod.LOGGER.info("Registering Item Groups for " + FentMod.MOD_ID);
    }
}
