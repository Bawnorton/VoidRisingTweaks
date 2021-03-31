package com.bawnorton.vrt;

import com.bawnorton.vrt.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = Global.MOD_ID, name = Global.MOD_NAME, version = Global.VERSION, dependencies = Global.DEPENDENCIES)
public class VoidRisingTweaks
{

    private static Logger logger;

    @SidedProxy(clientSide = Global.BR_CLIENT_PROXY, serverSide = Global.BR_SERVER_PROXY)
    private static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("Biome Radiation Loaded");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent postEvent) {
        proxy.postInit(postEvent);
    }
}
