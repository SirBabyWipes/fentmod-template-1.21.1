package net.lilbabywipes.fentmod.effects;

import net.lilbabywipes.fentmod.FentMod;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static StatusEffect FENT;
    public static StatusEffect WEED;
    public static StatusEffect SALVIA;
    public static StatusEffect DRUNK;
    public static StatusEffect COCAIN;

    public static void init() {
        COCAIN = Registry.register(Registries.STATUS_EFFECT, Identifier.of(FentMod.MOD_ID, "cocain"), new CocainHigh()
                .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, Identifier.of("effect.cocain"), 0.5, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_SPEED, Identifier.of("effect.cocain"), 1, EntityAttributeModifier.Operation.ADD_VALUE)
                .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, Identifier.of("effect.cocain"), 5.0, EntityAttributeModifier.Operation.ADD_VALUE)
        );

        WEED = Registry.register(Registries.STATUS_EFFECT, Identifier.of(FentMod.MOD_ID, "high"), new WeedHigh());

        SALVIA = Registry.register(Registries.STATUS_EFFECT, Identifier.of(FentMod.MOD_ID, "salvia_high"), new SalviaHigh());

        FENT = Registry.register(Registries.STATUS_EFFECT, Identifier.of(FentMod.MOD_ID, "overdose"), new FentHigh()
                .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, Identifier.of("effect.fent"), 0.2, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, Identifier.of("effect.fent"), 2, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
        );

        DRUNK = Registry.register(Registries.STATUS_EFFECT, Identifier.of(FentMod.MOD_ID, "drunk"), new Drunk()
                .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, Identifier.of("effect.drunk"), 5.0, EntityAttributeModifier.Operation.ADD_VALUE)
        );
    }
}
