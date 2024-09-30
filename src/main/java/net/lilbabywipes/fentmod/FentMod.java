package net.lilbabywipes.fentmod;

import net.fabricmc.api.ModInitializer;

import net.lilbabywipes.fentmod.block.ModBlocks;
import net.lilbabywipes.fentmod.component.ModComponents;
import net.lilbabywipes.fentmod.effects.ModEffects;
import net.lilbabywipes.fentmod.entities.ModEntities;
import net.lilbabywipes.fentmod.item.ModItems;
import net.lilbabywipes.fentmod.utils.ModCustomTrades;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FentMod implements ModInitializer {
	public static final String MOD_ID = "fentmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModEntities.initalize();
		ModComponents.initalize();
		ModEffects.init();
		ModCustomTrades.registerCustomTrades();
		ModGroups.registerItemGroup();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}