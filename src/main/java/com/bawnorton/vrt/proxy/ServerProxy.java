package com.bawnorton.vrt.proxy;

import com.bawnorton.vrt.addons.entities.EntityInit;
import com.bawnorton.vrt.commands.CrawlerSpawnRate;
import com.bawnorton.vrt.commands.TaintTickRate;
import com.bawnorton.vrt.handler.RenderHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

public class ServerProxy extends CommonProxy {
    public static void serverInit(FMLServerStartingEvent event) {
        event.registerServerCommand(new TaintTickRate());
        event.registerServerCommand(new CrawlerSpawnRate());
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {

    }
}
