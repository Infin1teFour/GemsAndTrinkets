package com.inf.gemsandtrinkets.datagen;

import com.inf.gemsandtrinkets.block.ModBlocks;
import com.inf.gemsandtrinkets.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;

import java.util.List;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> RUBY_SMELTABLES = List.of(
            ModItems.RAW_RUBY,
            ModBlocks.RUBY_ORE,
            ModBlocks.DEEPSLATE_RUBY_ORE,
            ModBlocks.NETHER_RUBY_ORE
    );
    private static final List<ItemConvertible> SAPPHIRE_SMELTABLES = List.of(
            ModItems.RAW_SAPPHIRE
    );
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        //Ruby smelt and blast
        offerSmelting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY,
                0.7f, 200, "ruby");
        offerBlasting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY,
                0.7f, 100, "ruby");

        //Sapphire smelt and blast
        offerSmelting(exporter, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE,
                0.7f, 200, "sapphire");
        offerBlasting(exporter, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE,
                0.7f, 100, "sapphire");

        //Ruby block to item
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RUBY,
                RecipeCategory.DECORATIONS, ModBlocks.RUBY_BLOCK);

        //Sapphire block to item
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.SAPPHIRE,
                RecipeCategory.DECORATIONS, ModBlocks.SAPPHIRE_BLOCK);

        //Ruby block to item
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_RUBY,
                RecipeCategory.DECORATIONS, ModBlocks.RAW_RUBY_BLOCK);

        //Sapphire block to item
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_SAPPHIRE,
                RecipeCategory.DECORATIONS, ModBlocks.RAW_SAPPHIRE_BLOCK);

        //Raw ruby from stone
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_RUBY, 1)
                .pattern("###")
                .pattern("#R#")
                .pattern("###")
                .input('#', Items.STONE)
                .input('R', ModItems.RUBY)
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter);

        //Gem Apple
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.GEM_APPLE, 1)
                .pattern("RGR")
                .pattern("BAB")
                .pattern("RGR")
                .input('G', Items.EMERALD)
                .input('R', ModItems.RUBY)
                .input('B', ModItems.SAPPHIRE)
                .input('A', Items.APPLE)
                .criterion(hasItem(Items.APPLE), conditionsFromItem(Items.APPLE))
                .offerTo(exporter);

        //Gem Apple Alternate
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.GEM_APPLE, 1)
                .pattern("RBR")
                .pattern("GAG")
                .pattern("RBR")
                .input('G', Items.EMERALD)
                .input('R', ModItems.RUBY)
                .input('B', ModItems.SAPPHIRE)
                .input('A', Items.APPLE)
                .criterion(hasItem(Items.APPLE), conditionsFromItem(Items.APPLE))
                .offerTo(exporter);

        //Ruby Detector
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBY_DETECTOR, 1)
                .pattern(" RI")
                .pattern(" #R")
                .pattern("S  ")
                .input('I', Items.IRON_INGOT)
                .input('R', Items.REDSTONE)
                .input('S', Items.STICK)
                .input('#', ModItems.RUBY)
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter);

        //Sound Block
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.SOUND_BLOCK, 1)
                .pattern("###")
                .pattern("#S#")
                .pattern("###")
                .input('#', ItemTags.WOOL)
                .input('S', ModItems.SAPPHIRE)
                .criterion(hasItem(ModItems.SAPPHIRE), conditionsFromItem(ModItems.SAPPHIRE))
                .offerTo(exporter);


    }
}
