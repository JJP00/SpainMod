package com.jjp00.aprendiendo;

import com.jjp00.aprendiendo.registro.RegBlock;
import com.jjp00.aprendiendo.registro.RegItem;
import com.mojang.logging.LogUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import static com.jjp00.aprendiendo.Utils.MOD_ID;

// The value here should match an entry in the META-INF/mods.toml file

//holaaa
@Mod(MOD_ID)
public class Aprendiendo
{
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public Aprendiendo()
    {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        RegItem.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        RegBlock.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());

    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

}
