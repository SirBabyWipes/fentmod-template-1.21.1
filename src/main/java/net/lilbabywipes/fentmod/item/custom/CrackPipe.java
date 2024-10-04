package net.lilbabywipes.fentmod.item.custom;

import net.lilbabywipes.fentmod.component.ModComponents;
import net.lilbabywipes.fentmod.data.ModServerData;
import net.lilbabywipes.fentmod.data.PlayerData;
import net.lilbabywipes.fentmod.data.Substances;
import net.lilbabywipes.fentmod.effects.ModEffects;
import net.lilbabywipes.fentmod.item.ModItems;
import net.lilbabywipes.fentmod.utils.ModConstants;
import net.lilbabywipes.fentmod.utils.utils;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class CrackPipe extends Item {
    public static int MAX_USES = 2;
    public CrackPipe(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        PlayerData data = ModServerData.getPlayerData(user.getUuid());
        //overdose condition
        if ((data.crunked - data.resistance) > ModConstants.OVERDOSE_THRESH) {
            user.playSound(SoundEvents.ENTITY_ENDER_DRAGON_DEATH, 2F, 1F);
        }

        boolean usable = stack.getOrDefault(ModComponents.CRACK_PIPE_USEABLE, true);
        int currentCount = stack.getOrDefault(ModComponents.CRACK_PIPE_COUNT, 0);
        if (currentCount >= MAX_USES) {
            //replace with broken pipe
            decrementCrack(user);
            if (!stack.isEmpty()) {
                stack.decrement(1);
                ItemStack dirtyCrackStack = new ItemStack(ModItems.DIRTY_CRACK_PIPE);
                if (user instanceof PlayerEntity) {
                    if (!((PlayerEntity) user).getInventory().insertStack(dirtyCrackStack)); {
                        ((PlayerEntity) user).dropItem(dirtyCrackStack, false);
                    }
                }
            }

            applyCrackEffect(user);

            return stack;
        }

        if (!usable) { return stack; }

        if(!world.isClient) {
            applyCrackEffect(user);
            currentCount++;
            stack.set(ModComponents.CRACK_PIPE_COUNT, currentCount);
        }

        decrementCrack(user);

        ModServerData.updatePlayerData(user, Substances.COCAIN);

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

        if (!utils.hasItem(user.getInventory(), ModItems.COCAINE)) { return item; }

        user.setCurrentHand(hand);
        ItemStack pipeStack = user.getStackInHand(hand);
        //int currentCount = pipeStack.getOrDefault(ModComponents.CRACK_PIPE_COUNT, 0);

        boolean hasCrack = user.getInventory().main.stream().anyMatch(stack -> stack.isOf(ModItems.COCAINE));
        pipeStack.set(ModComponents.CRACK_PIPE_USEABLE, hasCrack);
        return item;
    }

    private static void applyCrackEffect(LivingEntity user) {
        user.addStatusEffect(
                new StatusEffectInstance(
                        Registries.STATUS_EFFECT.getEntry(ModEffects.COCAIN),
                        60*20,
                        1
                )
        );
    }

    private static void decrementCrack(LivingEntity user) {
        if (user instanceof PlayerEntity player ) {
            if (!utils.hasItem(player.getInventory(), ModItems.COCAINE)) { return; }
            ItemStack crackStack = utils.getItemFromInventory(((PlayerEntity) user).getInventory(), ModItems.COCAINE).get();
            crackStack.decrement(1);
        }
    }

}
