package net.lilbabywipes.fentmod.component;

import com.mojang.serialization.Codec;
import net.lilbabywipes.fentmod.FentMod;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModComponents {
    public static ComponentType<Integer> CRACK_PIPE_COUNT;
    public static ComponentType<Boolean> CRACK_PIPE_USEABLE;

    public static void initalize() {
        CRACK_PIPE_COUNT = Registry.register(
                Registries.DATA_COMPONENT_TYPE,
                Identifier.of(FentMod.MOD_ID, "crack_pipe_count"),
                ComponentType.<Integer>builder().codec(Codec.INT).build()
        );

        CRACK_PIPE_USEABLE = Registry.register(
                Registries.DATA_COMPONENT_TYPE,
                Identifier.of(FentMod.MOD_ID, "crack_pipe_usable"),
                ComponentType.<Boolean>builder().codec(Codec.BOOL).build()
        );
    }
}
