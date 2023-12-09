package com.inf.gemsandtrinkets;

import com.inf.gemsandtrinkets.block.ModBlocks;
import com.inf.gemsandtrinkets.item.ModItemGroups;
import com.inf.gemsandtrinkets.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GemsAndTrinkets implements ModInitializer {

	public static final String MOD_ID = "gemsandtrinkets";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModItemGroups.registerModItemGroups();
		ModBlocks.registerModBlocks();
		FuelRegistry.INSTANCE.add(ModItems.COAL_BRIQUETTE, 300);
	}
}