package com.jjp00.aprendiendo.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

public class JamonFood extends Item {

    private static final FoodProperties jamonFood = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.4F).build();

    public JamonFood() {
        super(new Properties().food(jamonFood).tab(CreativeModeTab.TAB_FOOD));
    }
}
