package net.lilbabywipes.fentmod.sound;

import net.lilbabywipes.fentmod.FentMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    private ModSounds() {
        // private empty constructor to avoid accidental instantiation
    }

    public static final SoundEvent Blade = registerSound("blade");
    public static final SoundEvent BigXthePlug = registerSound("bigxtheplug");



    // actual registration of all the custom SoundEvents*
    private static SoundEvent registerSound(String id) {
        Identifier identifier = Identifier.of(FentMod.MOD_ID, id);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    // This static method starts class initialization, which then initializes
    // the static class variables (e.g. ITEM_METAL_WHISTLE).
    public static void initialize() {
        FentMod.LOGGER.info("Registering " + FentMod.MOD_ID + " Sounds");
        // Technically this method can stay empty, but some developers like to notify
        // the console, that certain parts of the mod have been successfully initialized
    }
}
