package net.lilbabywipes.fentmod.item.custom;

import net.lilbabywipes.fentmod.FentModClient;
import net.lilbabywipes.fentmod.data.ModServerData;
import net.lilbabywipes.fentmod.data.PlayerData;
import net.lilbabywipes.fentmod.utils.ModConstants;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class NarcanItem extends Item {
    public NarcanItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        TypedActionResult<ItemStack> item = ItemUsage.consumeHeldItem(world, user, hand);

        PlayerData data = ModServerData.getPlayerData(user.getUuid());
        data.crunked *= (ModConstants.NARCAN_REDUCTION * (1 - data.narcanResistacne));
        data.narcanResistacne += ModConstants.NARCAN_RESISTANCE_INCREASE;

        ItemStack narcanStack = user.getStackInHand(hand);
        narcanStack.decrement(1);

        ModServerData.updatePlayerData(user.getUuid(), data);

        return item;
    }
}
