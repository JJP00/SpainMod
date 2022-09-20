package com.jjp00.aprendiendo.registro;

import com.jjp00.aprendiendo.Utils;
import com.jjp00.aprendiendo.bloques.jamonero;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RegBlock {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Utils.MOD_ID);

    public static final RegistryObject<Block> estandarteJamon = BLOCKS.register("jamonero", jamonero::new);


}
