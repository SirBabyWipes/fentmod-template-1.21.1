package net.lilbabywipes.fentmod.effects;

import net.lilbabywipes.fentmod.FentMod;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static StatusEffect FENT;

    public static void init() {
        FENT = Registry.register(Registries.STATUS_EFFECT, Identifier.of(FentMod.MOD_ID, "overdose"), new FentHigh());
    }
}
