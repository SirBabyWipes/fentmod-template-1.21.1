package net.lilbabywipes.fentmod.item.custom;

import net.lilbabywipes.fentmod.component.ModComponents;
import net.lilbabywipes.fentmod.item.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.text.TextContent;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

import java.util.Optional;

public class CrackPipe extends Item {
    public static int MAX_USES = 2;
    public CrackPipe(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        boolean usable = stack.getOrDefault(ModComponents.CRACK_PIPE_USEABLE, true);
        int currentCount = stack.getOrDefault(ModComponents.CRACK_PIPE_COUNT, 0);
        if (currentCount >= MAX_USES) {
            //replace with broken pipe
            decrementCrack(user);
            stack = new ItemStack(ModItems.DIRTY_CRACK_PIPE);

            return stack;
        }

        if (!usable) { return stack; }

        if(!world.isClient) {
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 10, 1));
            currentCount++;
            stack.set(ModComponents.CRACK_PIPE_COUNT, currentCount);
        }

        decrementCrack(user);

        return stack;
    }

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 20;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        TypedActionResult<ItemStack> item = ItemUsage.consumeHeldItem(world, user, hand);

        user.setCurrentHand(hand);
        ItemStack pipeStack = user.getStackInHand(hand);
        //int currentCount = pipeStack.getOrDefault(ModComponents.CRACK_PIPE_COUNT, 0);

        boolean hasCrack = user.getInventory().main.stream().anyMatch(stack -> stack.isOf(ModItems.COCAINE));
        if (hasCrack) {
            //currentCount++;
            //pipeStack.set(ModComponents.CRACK_PIPE_COUNT, currentCount);
            pipeStack.set(ModComponents.CRACK_PIPE_USEABLE, true);
        } else {
            pipeStack.set(ModComponents.CRACK_PIPE_USEABLE, false);
        }

        return item;
    }

    public static void decrementCrack(LivingEntity user) {
        if (user instanceof PlayerEntity player ) {
            ItemStack crackStack = player.getInventory().main.stream().findFirst().get();
            crackStack.decrement(1);
        }
    }

}
