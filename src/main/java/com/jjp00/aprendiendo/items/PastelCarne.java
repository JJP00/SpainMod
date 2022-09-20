package com.jjp00.aprendiendo.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.ArrayVoxelShape;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

public class PastelCarne extends Item {

    private static final FoodProperties pastel_carne = (new FoodProperties.Builder()).nutrition(12).saturationMod(1.4F)
            .effect(new MobEffectInstance(MobEffects.REGENERATION, 200), 1.0F)
            .build();

    public PastelCarne() {
        super(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(pastel_carne));
    }

}
