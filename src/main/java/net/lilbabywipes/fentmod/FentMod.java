package net.lilbabywipes.fentmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.lilbabywipes.fentmod.block.ModBlocks;
import net.lilbabywipes.fentmod.component.ModComponents;
import net.lilbabywipes.fentmod.data.ModServerData;
import net.lilbabywipes.fentmod.effects.ModEffects;
import net.lilbabywipes.fentmod.entities.ModEntities;
import net.lilbabywipes.fentmod.item.ModItems;
import net.lilbabywipes.fentmod.networking.ModNetworking;
import net.lilbabywipes.fentmod.networking.ModNetworkingConstants;
import net.lilbabywipes.fentmod.utils.ModCustomTrades;
import net.minecraft.server.MinecraftServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FentMod implements ModInitializer {
	public static final String MOD_ID = "fentmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static MinecraftServer server = null;

	@Override
	public void onInitialize() {
		ServerLifecycleEvents.SERVER_STARTED.register(s -> server = s);
		ModEntities.initalize();
		ModComponents.initalize();
		ModEffects.init();
		ModNetworking.initalize();
		ModCustomTrades.registerCustomTrades();
		ModGroups.registerItemGroup();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModServerData.intialize();
	}
}