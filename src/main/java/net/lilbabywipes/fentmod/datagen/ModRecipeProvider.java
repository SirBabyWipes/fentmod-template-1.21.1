package net.lilbabywipes.fentmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.lilbabywipes.fentmod.block.ModBlocks;
import net.lilbabywipes.fentmod.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        //offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.COCAINE, RecipeCategory.DECORATIONS, ModBlocks.COCAINE_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BONGEMPTY, 1)
                .pattern("# #")
                .pattern("# #")
                .pattern(" # ")
                .input('#', Blocks.GLASS)
                .criterion(hasItem(Blocks.GLASS), conditionsFromItem(Blocks.GLASS))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BONGFULL, 1)
                .input(ModItems.WEED)
                .input(ModItems.BONGEMPTY)
                .criterion(hasItem(ModItems.WEED), conditionsFromItem(ModItems.WEED))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COCAINE_CARPET_BLOCK, 1)
                .input(ModItems.COCAINE)
                .input(ModItems.COCAINE)
                .criterion(hasItem(ModItems.COCAINE), conditionsFromItem(ModItems.COCAINE))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.JOINT, 1)
                .input(ModItems.WEED)
                .input(Items.PAPER)
                .criterion(hasItem(ModItems.WEED), conditionsFromItem(ModItems.WEED))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.WEED_SEEDS, 1)
                .input(ModItems.WEED)
                .criterion(hasItem(ModItems.WEED), conditionsFromItem(ModItems.WEED))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.COCA_SEEDS, 1)
                .input(ModItems.COCAINE)
                .criterion(hasItem(ModItems.COCAINE), conditionsFromItem(ModItems.COCAINE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GRINDER, 1)
                .pattern(" # ")
                .pattern("# #")
                .pattern(" # ")
                .input('#', Items.IRON_INGOT)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CRACK_PIPE, 1)
                .pattern("  #")
                .pattern("GGG")
                .pattern("   ")
                .input('G', Items.GLASS)
                .input('#', Items.AMETHYST_SHARD)
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter);
    }
}
