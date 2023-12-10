package com.inf.gemsandtrinkets.datagen;

import com.inf.gemsandtrinkets.block.ModBlocks;
import com.inf.gemsandtrinkets.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        //Metal Detector
        getOrCreateTagBuilder(ModTags.Blocks.METAL_DETECTOR_DETECTABLE_BLOCKS)
                .add(ModBlocks.RUBY_ORE)
                .add(ModBlocks.DEEPSLATE_RUBY_ORE)
                .add(ModBlocks.NETHER_RUBY_ORE);

        //Pickaxe Mineable
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.RUBY_BLOCK)
                .add(ModBlocks.RAW_RUBY_BLOCK)
                .add(ModBlocks.RUBY_ORE)
                .add(ModBlocks.NETHER_RUBY_ORE)
                .add(ModBlocks.DEEPSLATE_RUBY_ORE)
                .add(ModBlocks.SAPPHIRE_BLOCK)
                .add(ModBlocks.RAW_SAPPHIRE_BLOCK);

        //Shovel Mineable
        //getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE).add();

        //Axe Mineable
        //getOrCreateTagBuilder(BlockTags.AXE_MINEABLE).add();

        //Hoe Mineable
        //getOrCreateTagBuilder(BlockTags.HOE_MINEABLE).add();

        //Needs Tool Level 4 (Netherite)
        //getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4"))).add();

        //Needs Tool Level 3 (Diamond)
        //getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL).add();

        //Needs Tool Level 2 (Iron)
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.RAW_SAPPHIRE_BLOCK)
                .add(ModBlocks.SAPPHIRE_BLOCK)
                .add(ModBlocks.RUBY_BLOCK)
                .add(ModBlocks.RAW_RUBY_BLOCK)
                .add(ModBlocks.RUBY_ORE)
                .add(ModBlocks.NETHER_RUBY_ORE)
                .add(ModBlocks.DEEPSLATE_RUBY_ORE);

        //Needs Tool Level 1 (Stone)
        //getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL).add();

        //Fences Tag
        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.RUBY_FENCE);

        //Fence Gates Tag
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.RUBY_FENCE_GATE);

        //Walls Tag
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.RUBY_WALL);

    }
}
