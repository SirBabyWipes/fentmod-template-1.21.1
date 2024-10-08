package net.lilbabywipes.fentmod.item.custom;

import net.lilbabywipes.fentmod.data.ModServerData;
import net.lilbabywipes.fentmod.data.Substances;
import net.lilbabywipes.fentmod.item.ModItems;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class BongSalviaItem extends Item {
    private static final int MAX_USE_TIME = 80;

    public BongSalviaItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        super.finishUsing(stack, world, user);
        if (user instanceof ServerPlayerEntity serverPlayerEntity) {
            Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
        }

        if (!world.isClient) {
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 1200, 2));
        }

        if (user instanceof PlayerEntity playerEntity && !playerEntity.isCreative()) {
            stack.decrement(1);

            if (!stack.isEmpty()) {
                ItemStack emptyBong = new ItemStack(ModItems.BONGEMPTY);
                if (!playerEntity.getInventory().insertStack(emptyBong)) {
                    playerEntity.dropItem(emptyBong, false);
                }
            }
        }

        //ModServerData.updatePlayerData(user, Substances.SALVIA);

        return stack.isEmpty() ? new ItemStack(ModItems.BONGEMPTY) : stack;

    }
    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 80;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public SoundEvent getDrinkSound() {
        return SoundEvents.ITEM_HONEY_BOTTLE_DRINK;
    }

    @Override
    public SoundEvent getEatSound() {
        return SoundEvents.ITEM_HONEY_BOTTLE_DRINK;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return ItemUsage.consumeHeldItem(world, user, hand);
    }
}
