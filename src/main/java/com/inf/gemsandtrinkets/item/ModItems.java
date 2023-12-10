package com.inf.gemsandtrinkets.item;

import com.inf.gemsandtrinkets.GemsAndTrinkets;
import com.inf.gemsandtrinkets.item.custom.MetalDetectorItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item SAPPHIRE = registerItem("sapphire", new Item(new FabricItemSettings()));
    public static final Item RAW_SAPPHIRE = registerItem("raw_sapphire", new Item(new FabricItemSettings()));
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item RAW_RUBY = registerItem("raw_ruby", new Item(new FabricItemSettings()));
    public static final Item COAL_BRIQUETTE = registerItem("coal_briquette", new Item(new FabricItemSettings()));


    public static final Item GEM_APPLE = registerItem("gem_apple", new Item(new FabricItemSettings().food(ModFoodComponents.GEM_APPLE)));
    public static final Item RUBY_DETECTOR = registerItem("ruby_detector", new MetalDetectorItem(new FabricItemSettings().maxDamage(64)));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(GemsAndTrinkets.MOD_ID, name), item);
    }
    public static void registerModItems() {
        GemsAndTrinkets.LOGGER.info("Registering mod items for " + GemsAndTrinkets.MOD_ID);
    }
}
