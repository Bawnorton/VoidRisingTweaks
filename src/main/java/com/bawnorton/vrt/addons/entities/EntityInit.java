package com.bawnorton.vrt.addons.entities;

import com.bawnorton.vrt.Global;
import com.bawnorton.vrt.VoidRisingTweaks;
import com.bawnorton.vrt.addons.entities.bosses.BossBase;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import static com.bawnorton.vrt.Global.ENTITY_BOSS;
import static com.bawnorton.vrt.Global.ENTITY_CRAWLER;

public class EntityInit {
    public static void registerEntites() {
        registerEntity("crawler", EntityCrawler.class, ENTITY_CRAWLER, 50, 16777215, 0);
        registerEntity("boss", BossBase.class, ENTITY_BOSS, 100, 8388673, 8430913);
    }

    private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int colour1, int colour2) {
        EntityRegistry.registerModEntity(
                new ResourceLocation(
                        Global.MOD_ID + ":" + name
                ), entity, name, id, VoidRisingTweaks.instance, range, 1, true, colour1, colour2);
    }
}
