package com.inf.gemsandtrinkets.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent GEM_APPLE = new FoodComponent.Builder().hunger(5).saturationModifier(1.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 2), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 4800, 2), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 3000, 1), 1.0f)
            .alwaysEdible().build();

}
