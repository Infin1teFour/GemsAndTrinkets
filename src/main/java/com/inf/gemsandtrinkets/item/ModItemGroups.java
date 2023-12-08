package com.inf.gemsandtrinkets.item;

import com.inf.gemsandtrinkets.GemsAndTrinkets;
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
                        entries.add(ModItems.RAW_SAPPHIRE);
                        entries.add(ModItems.SAPPHIRE);
                    }).build());
    public static void registerModItemGroups() {
        GemsAndTrinkets.LOGGER.info("Registering mod item groups for" + GemsAndTrinkets.MOD_ID);
    }
}
