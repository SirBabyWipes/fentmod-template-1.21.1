package net.lilbabywipes.fentmod.events;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.lilbabywipes.fentmod.FentMod;
import net.lilbabywipes.fentmod.data.ModServerData;

public class ModEvents {
    public static void initalize() {
        ServerLifecycleEvents.SERVER_STARTED.register(s -> FentMod.server = s);

        ServerTickEvents.END_SERVER_TICK.register(server -> {
            if(server.getTicks() % (20 * 60 * 5) == 0) {
                ModServerData.players.forEach((uuid, playerData) -> {
                    playerData.crunked -= 1;
                    if (playerData.resistance < 100) {
                        playerData.resistance -=1;
                    }

                    playerData.narcanResistacne -= 0.10;
                    playerData.alcDeep -= 1;
                });
                //decrement
            }
        });
    }
}
