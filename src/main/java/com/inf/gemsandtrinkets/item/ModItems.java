package com.inf.gemsandtrinkets.item;

import com.inf.gemsandtrinkets.GemsAndTrinkets;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item SAPPHIRE = registerItem("sapphire", new Item(new FabricItemSettings()));
    public static final Item RAW_SAPPHIRE = registerItem("raw_sapphire", new Item(new FabricItemSettings()));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(GemsAndTrinkets.MOD_ID, name), item);
    }
    public static void registerModItems() {
        GemsAndTrinkets.LOGGER.info("Registering mod items for" + GemsAndTrinkets.MOD_ID);
    }
}
