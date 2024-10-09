package net.lilbabywipes.fentmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.lilbabywipes.fentmod.block.ModBlocks;
import net.lilbabywipes.fentmod.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        //smeltables
        List<ItemConvertible> TOBACCO_SMELTABLES = List.of(ModItems.TOBACCO_LEAVES);
        offerSmelting(exporter, TOBACCO_SMELTABLES, RecipeCategory.MISC, ModItems.DRIED_TABACCO_LEAVES, 0.25f, 150, "tobacco");

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

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BONGSALVIA, 1)
                .input(ModItems.SALVIA)
                .input(ModItems.BONGEMPTY)
                .criterion(hasItem(ModItems.SALVIA), conditionsFromItem(ModItems.SALVIA))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SUPERWHEAT, 1)
                .input(Items.HAY_BLOCK)
                .input(Items.HAY_BLOCK)
                .input(Items.HAY_BLOCK)
                .input(Items.HAY_BLOCK)
                .input(Items.HAY_BLOCK)
                .input(Items.HAY_BLOCK)
                .input(Items.HAY_BLOCK)
                .input(Items.HAY_BLOCK)
                .input(Items.HAY_BLOCK)
                .criterion(hasItem(Items.HAY_BLOCK), conditionsFromItem(Items.HAY_BLOCK))
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

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SALVIA_SEEDS, 1)
                .input(ModItems.SALVIA)
                .criterion(hasItem(ModItems.SALVIA), conditionsFromItem(ModItems.SALVIA))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CIGARETTE, 1)
                .input(ModItems.DRIED_TABACCO_LEAVES)
                .input(Items.PAPER)
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

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BEER, 1)
                .pattern("SSS")
                .pattern("S#S")
                .pattern("SSS")
                .input('S', ModItems.SUPERWHEAT)
                .input('#', Items.WATER_BUCKET)
                .criterion(hasItem(ModItems.SUPERWHEAT), conditionsFromItem(ModItems.SUPERWHEAT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MORPHINE, 1)
                .pattern("SSS")
                .pattern("S#S")
                .pattern("SSS")
                .input('S', ModItems.FENT)
                .input('#', Items.NETHER_STAR)
                .criterion(hasItem(ModItems.FENT), conditionsFromItem(ModItems.FENT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.JOHNSITEM, 1)
                .pattern("SSS")
                .pattern("S#S")
                .pattern("SSS")
                .input('S', Items.DIRT)
                .input('#', Items.OAK_BOAT)
                .criterion(hasItem(ModItems.JOHNSITEM), conditionsFromItem(ModItems.JOHNSITEM))
                .offerTo(exporter);

    }
}
