package com.bawnorton.vrt.proxy;

import com.bawnorton.vrt.ChunkUpdates;
import com.bawnorton.vrt.modify.VRTConfigBlocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

public class ClientProxy {
    public void postInit(FMLPostInitializationEvent preEvent) {
        VRTConfigBlocks.initBlocks();
        MinecraftForge.EVENT_BUS.register(new ChunkUpdates());
    }
}