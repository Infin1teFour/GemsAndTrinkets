package com.inf.gemsandtrinkets.item;

import com.inf.gemsandtrinkets.GemsAndTrinkets;
import com.inf.gemsandtrinkets.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup GEMS_AND_TRINKETS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(GemsAndTrinkets.MOD_ID, "sapphire"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.gemsandtrinkets"))
                    .icon(() -> new ItemStack(ModItems.SAPPHIRE)).entries((displayContext, entries) -> {
                        //Ruby Blocks
                        entries.add(ModItems.RAW_RUBY);
                        entries.add(ModBlocks.RAW_RUBY_BLOCK);
                        entries.add(ModItems.RUBY);
                        entries.add(ModBlocks.RUBY_BLOCK);
                        entries.add(ModBlocks.RUBY_STAIRS);
                        entries.add(ModBlocks.RUBY_SLAB);
                        entries.add(ModBlocks.RUBY_BUTTON);
                        entries.add(ModBlocks.RUBY_PRESSURE_PLATE);
                        entries.add(ModBlocks.RUBY_FENCE);
                        entries.add(ModBlocks.RUBY_FENCE_GATE);
                        entries.add(ModBlocks.RUBY_WALL);
                        entries.add(ModBlocks.RUBY_DOOR);
                        entries.add(ModBlocks.RUBY_TRAPDOOR);

                        //Ruby Ores
                        entries.add(ModBlocks.RUBY_ORE);
                        entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);
                        entries.add(ModBlocks.NETHER_RUBY_ORE);


                        //Sapphire Blocks
                        entries.add(ModItems.RAW_SAPPHIRE);
                        entries.add(ModBlocks.RAW_SAPPHIRE_BLOCK);
                        entries.add(ModItems.SAPPHIRE);
                        entries.add(ModBlocks.SAPPHIRE_BLOCK);

                        //Ruby Tools
                        entries.add(ModItems.RUBY_PICKAXE);
                        entries.add(ModItems.RUBY_AXE);
                        entries.add(ModItems.RUBY_SHOVEL);
                        entries.add(ModItems.RUBY_HOE);
                        entries.add(ModItems.RUBY_SWORD);

                        //Ruby Armor
                        entries.add(ModItems.RUBY_HELMET);
                        entries.add(ModItems.RUBY_CHESTPLATE);
                        entries.add(ModItems.RUBY_LEGGINGS);
                        entries.add(ModItems.RUBY_BOOTS);


                        //Misc
                        entries.add(ModItems.RUBY_DETECTOR);
                        entries.add(ModBlocks.SOUND_BLOCK);
                        entries.add(ModItems.GEM_APPLE);
                        entries.add(ModItems.COAL_BRIQUETTE);
                        entries.add(ModItems.RUBY_STAFF);

                    }).build());
    public static void registerModItemGroups() {
        GemsAndTrinkets.LOGGER.info("Registering mod item groups for " + GemsAndTrinkets.MOD_ID);
    }
}
