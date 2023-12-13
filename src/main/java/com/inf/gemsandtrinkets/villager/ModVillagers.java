package com.inf.gemsandtrinkets.villager;

import com.google.common.collect.ImmutableSet;
import com.inf.gemsandtrinkets.GemsAndTrinkets;
import com.inf.gemsandtrinkets.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillagers {

    public static final RegistryKey<PointOfInterestType> GEM_POI_KEY = poiKey("gempoi");
    public static final PointOfInterestType GEM_POI = registerPoi("gempoi", Blocks.ENCHANTING_TABLE);
    public static final VillagerProfession JEWELER = registerProfession("jeweler", GEM_POI_KEY);

    private static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(GemsAndTrinkets.MOD_ID, name),
                new VillagerProfession(name, entry -> entry.matchesKey(type), entry -> entry.matchesKey(type),
                        ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_MASON));
    }
    private static PointOfInterestType registerPoi(String name, Block block) {
        return PointOfInterestHelper.register(new Identifier(GemsAndTrinkets.MOD_ID, name), 1, 1, block);
    }
    private static RegistryKey<PointOfInterestType> poiKey(String name) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, new Identifier(GemsAndTrinkets.MOD_ID, name));
    }
    public static void registerVillagers() {
        GemsAndTrinkets.LOGGER.info("Registering Custom villagers for "+GemsAndTrinkets.MOD_ID);
    }
}
