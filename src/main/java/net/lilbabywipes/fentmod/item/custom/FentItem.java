package net.lilbabywipes.fentmod.item.custom;

import net.lilbabywipes.fentmod.data.ModServerData;
import net.lilbabywipes.fentmod.data.PlayerData;
import net.lilbabywipes.fentmod.data.Substances;
import net.lilbabywipes.fentmod.effects.ModEffects;
import net.lilbabywipes.fentmod.utils.ModConstants;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;

public class FentItem extends Item {
    public FentItem(Settings settings) { super(settings); }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        PlayerData data = ModServerData.getPlayerData(user.getUuid());
        if ((data.crunked - data.resistance) > ModConstants.OVERDOSE_THRESH) {
            //user.playSound(SoundEvents.ENTITY_ENDER_DRAGON_DEATH, 2F, 1F);
            user.kill();
        }

        super.finishUsing(stack, world, user);
        if (!world.isClient) {
            user.addStatusEffect(
                    new StatusEffectInstance(
                        Registries.STATUS_EFFECT.getEntry(ModEffects.FENT),
                        1000,
                        0
                    )
            );

        }
        user.sendMessage(Text.literal("finished using"));
        ModServerData.updatePlayerData(user, Substances.FENT);

        return stack;
    }

    @Override
    public UseAction getUseAction(ItemStack stack){
        return UseAction.DRINK;
    }

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 40;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return ItemUsage.consumeHeldItem(world, user, hand);
    }
}
