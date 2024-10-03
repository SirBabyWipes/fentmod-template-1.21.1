package net.lilbabywipes.fentmod.events;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.lilbabywipes.fentmod.FentMod;
import net.lilbabywipes.fentmod.data.ModServerData;
import net.lilbabywipes.fentmod.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModEvents {
    public static final Identifier FERN_LOOT_TABLE = Blocks.FERN.getLootTableKey().getValue();
    public static final Identifier FORTRESS_LOOT_TABLE = Identifier.of("minecraft", "chests/nether_bridge");
    public static void initialize() {
        ServerLifecycleEvents.SERVER_STARTED.register(s -> FentMod.server = s);

        ServerTickEvents.END_SERVER_TICK.register(server -> {
            if(server.getTicks() % (20 * 60 * 5) == 0) {
                ModServerData.players.forEach((uuid, playerData) -> {
                    if (playerData.crunked > 0) { playerData.crunked -= 1; }
                    if (playerData.resistance > 0) { playerData.resistance -=1; }
                    if (playerData.narcanResistacne > 0) { playerData.narcanResistacne -= 0.10; }
                    if (playerData.alcDeep > 0) { playerData.alcDeep -= 1; }
                });
            }
        });

        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if(source.isBuiltin() && FERN_LOOT_TABLE.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .with(ItemEntry.builder(ModItems.WEED_SEEDS))
                        .conditionally(RandomChanceLootCondition.builder(0.25f));

                tableBuilder.pool(poolBuilder);
            }

            if(source.isBuiltin() && FORTRESS_LOOT_TABLE.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.75f))
                        .with(ItemEntry.builder(ModItems.COCA_SEEDS))
                        .with(ItemEntry.builder(ModItems.SALVIA_SEEDS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder);
            }
        });
    }
}
