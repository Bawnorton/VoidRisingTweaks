package com.bawnorton.vrt.proxy;

import com.bawnorton.vrt.ChunkUpdates;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

public class CommonProxy {
    public void registerItemRenderer(Item item, int meta, String id) {}

    public void postInit(FMLPostInitializationEvent preEvent) {
        MinecraftForge.EVENT_BUS.register(new ChunkUpdates());
    }
}
