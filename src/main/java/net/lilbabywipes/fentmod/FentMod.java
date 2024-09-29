package net.lilbabywipes.fentmod;

import net.fabricmc.api.ModInitializer;

import net.lilbabywipes.fentmod.block.ModBlocks;
import net.lilbabywipes.fentmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FentMod implements ModInitializer {
	public static final String MOD_ID = "fentmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModGroups.registerItemGroup();


		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}