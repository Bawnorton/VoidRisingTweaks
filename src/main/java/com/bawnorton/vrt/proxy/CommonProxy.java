package com.bawnorton.vrt.proxy;

import com.bawnorton.vrt.ChunkUpdates;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
    public void postInit(FMLPostInitializationEvent postEvent) {
        MinecraftForge.EVENT_BUS.register(new ChunkUpdates());
    }
}
