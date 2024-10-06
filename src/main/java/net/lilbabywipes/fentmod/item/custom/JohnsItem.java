package net.lilbabywipes.fentmod.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class JohnsItem extends Item {

    public JohnsItem(Settings settings) {
        super(settings);
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.setHealth(30);
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION,20*30,100));
        return super.use(world, user, hand);
    }
}




















