package com.bawnorton.vrt;

import com.bawnorton.vrt.addons.VRTCreativeTab;
import com.bawnorton.vrt.proxy.CommonProxy;
import com.bawnorton.vrt.proxy.ServerProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = Global.MOD_ID, name = Global.MOD_NAME, version = Global.VERSION, dependencies = "after:nuclearcraft;after:techreborn")
public class VoidRisingTweaks {
    public static final VRTCreativeTab TABVRT = new VRTCreativeTab("vrtTab");
    @SidedProxy(clientSide = Global.BR_CLIENT_PROXY, serverSide = Global.BR_SERVER_PROXY)
    public static CommonProxy proxy;
    @Mod.Instance("vrt")
    public static VoidRisingTweaks instance;
    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
        logger.info("Void Rising Tweaks Loaded");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent postEvent) {
        proxy.postInit(postEvent);
    }

    @EventHandler
    public static void serverInit(FMLServerStartingEvent event) {
        ServerProxy.serverInit(event);
    }
}

