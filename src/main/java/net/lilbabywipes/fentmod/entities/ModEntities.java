package net.lilbabywipes.fentmod.entities;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.lilbabywipes.fentmod.FentMod;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static EntityType<DirtyCrackPipeEntity> dirtyCrackPipeEntityType;

    public static void initalize() {
        //this method has been deprecated but it's the only method on documentation
        dirtyCrackPipeEntityType = Registry.register(
                Registries.ENTITY_TYPE,
                Identifier.of(FentMod.MOD_ID, "dirty_crack_pipe"),
                FabricEntityTypeBuilder.<DirtyCrackPipeEntity>create(SpawnGroup.MISC, DirtyCrackPipeEntity::new)
                        .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                        .trackRangeBlocks(4).trackedUpdateRate(10)
                        .build()

        );
    }
}
