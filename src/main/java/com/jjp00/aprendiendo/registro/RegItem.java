package com.jjp00.aprendiendo.registro;

import com.jjp00.aprendiendo.Utils;
import com.jjp00.aprendiendo.items.Hojaldre;
import com.jjp00.aprendiendo.items.JamonFood;
import com.jjp00.aprendiendo.items.PastelCarne;
import com.jjp00.aprendiendo.items.JamonItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RegItem {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Utils.MOD_ID);
    //registrador diferido
    public static final RegistryObject<Item> hojaldre = ITEMS.register("hojaldre", Hojaldre::new);
    public static final RegistryObject<Item> pastel_carne = ITEMS.register("pastel_carne", PastelCarne::new);
    public static final RegistryObject<Item> jamon = ITEMS.register("jamon", JamonItem::new);
    public static final RegistryObject<Item> jamonFood = ITEMS.register("jamonfood", JamonFood::new);
    //registro del item
    public static final RegistryObject<Item> jamonero = ITEMS.register("jamonero",
            () -> new BlockItem(RegBlock.estandarteJamon.get(),
            new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
}
