package net.lilbabywipes.fentmod.utils;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.lilbabywipes.fentmod.item.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;

public class ModCustomTrades {
    public static void registerCustomTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 5, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.DIAMOND, 2),
                    new ItemStack(ModItems.FENT, 1),
                    2, 7, 0.3F
            ));
        });
    }
}
