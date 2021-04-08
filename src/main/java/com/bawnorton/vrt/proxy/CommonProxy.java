package com.bawnorton.vrt.proxy;

import com.bawnorton.vrt.addons.recipies.VRTSmeltingRecipies;
import com.bawnorton.vrt.events.ChunkEvents;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
    public void registerItemRenderer(Item item, int meta, String id) {
    }

    public void init(FMLInitializationEvent event) {
        VRTSmeltingRecipies.init();
    }

    public void preInit(FMLPreInitializationEvent event) {
    }

    public void postInit(FMLPostInitializationEvent postEvent) {
        MinecraftForge.EVENT_BUS.register(new ChunkEvents());
    }
}
