package net.lilbabywipes.fentmod.item.custom;

import net.lilbabywipes.fentmod.data.ModServerData;
import net.lilbabywipes.fentmod.data.PlayerData;
import net.lilbabywipes.fentmod.data.Substances;
import net.lilbabywipes.fentmod.effects.ModEffects;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.registry.Registries;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

import javax.print.attribute.Attribute;
import java.util.jar.Attributes;

public class CigaretteItem extends Item {
    private static final int MAX_USE_TIME = 40;

    public CigaretteItem(Settings settings) {
        super(settings);
    }


    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        ModServerData.updatePlayerData(user, Substances.NIC);
        user.sendMessage(Text.literal("finished using"));
        if (user instanceof ServerPlayerEntity serverPlayerEntity) {
            Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
        }

        if (!world.isClient) {

        }

        if (user instanceof PlayerEntity playerEntity && !playerEntity.isCreative()) {
            stack.decrement(1);
        }

        if (user instanceof PlayerEntity playerEntity) {
            world.playSound(null, playerEntity.getX(), playerEntity.getY(), playerEntity.getZ(), SoundEvents.ENTITY_BLAZE_BURN, playerEntity.getSoundCategory(), 1.0F, 1.0F);
        }
        super.finishUsing(stack, world, user);
        return stack;
    }
    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 40;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return ItemUsage.consumeHeldItem(world, user, hand);
    }
}
