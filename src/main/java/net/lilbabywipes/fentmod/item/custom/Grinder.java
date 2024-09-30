package net.lilbabywipes.fentmod.item.custom;

import net.lilbabywipes.fentmod.item.ModItems;
import net.lilbabywipes.fentmod.utils.utils;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Grinder extends Item {

    public Grinder(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        return stack;
    }

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 10;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        TypedActionResult<ItemStack> item = ItemUsage.consumeHeldItem(world, user, hand);

        if (!utils.hasItem(user.getInventory(), ModItems.WEED)) {
            return item;
        }

        ItemStack weedStack = utils.getItemFromInventory(user.getInventory(), ModItems.WEED).get();
        weedStack.decrement(1);

        if(utils.hasItem(user.getInventory(), ModItems.GROUNDWEED)) {
            ItemStack groundStack = utils.getItemFromInventory(user.getInventory(), ModItems.GROUNDWEED).get();
            groundStack.increment(1);
        } else {
            ItemStack groundStack = new ItemStack(ModItems.GROUNDWEED);
            user.getInventory().insertStack(groundStack);
        }

        return item;
    }
}
