package net.lilbabywipes.fentmod.item.custom;

import net.lilbabywipes.fentmod.FentMod;
import net.lilbabywipes.fentmod.sound.ModSounds;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageEffects;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Morphine extends Item {

    public Morphine(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return super.use(world, user, hand);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 2 * 20, 2));
        entity.takeKnockback(.1,0,0);
        entity.setHealth(entity.getHealth()+1);
        entity.playSound(ModSounds.BigXthePlug);

        user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 1 * 20, 4));
        user.damage(user.getDamageSources().mobAttack(user), 2);
        return super.useOnEntity(stack, user, entity, hand);
    }
}




















