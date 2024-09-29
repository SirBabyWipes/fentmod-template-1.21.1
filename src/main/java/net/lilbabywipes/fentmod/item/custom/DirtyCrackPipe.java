package net.lilbabywipes.fentmod.item.custom;

import net.lilbabywipes.fentmod.entities.DirtyCrackPipeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class DirtyCrackPipe extends Item {
    public DirtyCrackPipe(Settings settings) { super(settings);}

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if(!world.isClient) {
            DirtyCrackPipeEntity pipeEntity = new DirtyCrackPipeEntity(world, user);
            pipeEntity.setItem(stack);
            pipeEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 500F, 0.0F);
            pipeEntity.velocityModified = true;

            world.spawnEntity(pipeEntity);
        }

        if (!user.getAbilities().creativeMode) {
            stack.decrement(1);
        }

        return TypedActionResult.success(stack, world.isClient());
    }
}
