package net.lilbabywipes.fentmod.entities;

import net.lilbabywipes.fentmod.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class DirtyCrackPipeEntity extends ThrownItemEntity {
    public DirtyCrackPipeEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
       super(entityType, world);
    }

    public DirtyCrackPipeEntity(World world, LivingEntity owner) {
        super(ModEntities.dirtyCrackPipeEntityType, owner, world);
    }

    public DirtyCrackPipeEntity(World world, double x, double y, double z) {
        super(ModEntities.dirtyCrackPipeEntityType, x, y, z, world);
    }

    @Override
    protected void onEntityHit(EntityHitResult hitResult) {
        super.onEntityHit(hitResult);
        Entity entity = hitResult.getEntity();
        double odds = getRandomRange();
        if (odds <= 0.25 && (entity instanceof LivingEntity livingEntity)) {
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 20 * 3, 2));
        }
    }

    @Override
    protected void onBlockCollision(BlockState state) {
        super.onBlockCollision(state);
        if (!this.getWorld().isClient) {
            this.kill();
        }
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.DIRTY_CRACK_PIPE;
    }

    private static double min = 0.0D;
    private static double max = 1.0D;
    private static double getRandomRange() {
        return min + Math.random() * (max - min);
    }
}
