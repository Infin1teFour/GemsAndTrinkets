package com.inf.gemsandtrinkets.block;

import com.inf.gemsandtrinkets.GemsAndTrinkets;
import com.inf.gemsandtrinkets.block.custom.SoundBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    //Misc
    public static final Block SOUND_BLOCK = registerBlock("sound_block",
            new SoundBlock(FabricBlockSettings.copyOf(Blocks.TARGET)));

    //Sapphire
    public static final Block SAPPHIRE_BLOCK = registerBlock("sapphire_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block RAW_SAPPHIRE_BLOCK = registerBlock("raw_sapphire_block",
            new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)));

    //Ruby Ores
    public static final Block RUBY_ORE = registerBlock("ruby_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 7),
                    FabricBlockSettings.copyOf(Blocks.EMERALD_ORE)));
    public static final Block DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 7),
                    FabricBlockSettings.copyOf(Blocks.DEEPSLATE_EMERALD_ORE)));
    public static final Block NETHER_RUBY_ORE = registerBlock("nether_ruby_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(4, 8),
                    FabricBlockSettings.copyOf(Blocks.NETHER_QUARTZ_ORE)));

    //Ruby Blocks
    public static final Block RUBY_BLOCK = registerBlock("ruby_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block RAW_RUBY_BLOCK = registerBlock("raw_ruby_block",
            new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)));

    public static final Block RUBY_STAIRS = registerBlock("ruby_stairs",
            new StairsBlock(ModBlocks.RUBY_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block RUBY_SLAB = registerBlock("ruby_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block RUBY_BUTTON = registerBlock("ruby_button",
            new ButtonBlock(BlockSetType.IRON, 10, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block RUBY_PRESSURE_PLATE = registerBlock("ruby_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block RUBY_FENCE = registerBlock("ruby_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block RUBY_FENCE_GATE = registerBlock("ruby_fence_gate",
            new FenceGateBlock(WoodType.CRIMSON, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block RUBY_WALL = registerBlock("ruby_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block RUBY_DOOR = registerBlock("ruby_door",
            new DoorBlock(BlockSetType.IRON, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque().sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block RUBY_TRAPDOOR = registerBlock("ruby_trapdoor",
            new TrapdoorBlock(BlockSetType.IRON, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque().sounds(BlockSoundGroup.AMETHYST_BLOCK)));



    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(GemsAndTrinkets.MOD_ID, name), block);
    }
    public static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(GemsAndTrinkets.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
    public static void registerModBlocks() {
        GemsAndTrinkets.LOGGER.info("Registering mod blocks for " + GemsAndTrinkets.MOD_ID);
    }
}
