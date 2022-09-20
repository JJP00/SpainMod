package com.jjp00.aprendiendo.event;

import com.jjp00.aprendiendo.Utils;
import com.jjp00.aprendiendo.event.loot.CerdoDaJamon;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = Utils.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)

public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {

        event.getRegistry().registerAll(
                new CerdoDaJamon.Serializer().setRegistryName(new ResourceLocation(Utils.MOD_ID, "cerdojamon"))
        );
    }
}
