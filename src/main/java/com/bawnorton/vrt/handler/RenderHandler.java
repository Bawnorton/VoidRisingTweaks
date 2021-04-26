package com.bawnorton.vrt.handler;

import com.bawnorton.vrt.addons.entities.EntityCrawler;
import com.bawnorton.vrt.addons.entities.render.RenderCrawler;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler {
    public static void registerEntityRenders() {
        RenderingRegistry.registerEntityRenderingHandler(EntityCrawler.class, RenderCrawler::new);
    }
}
