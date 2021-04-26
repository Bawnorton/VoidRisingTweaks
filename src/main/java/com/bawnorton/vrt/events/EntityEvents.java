package com.bawnorton.vrt.events;

import net.minecraft.entity.Entity;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import thaumcraft.common.entities.EntityFluxRift;

import static com.bawnorton.vrt.Global.rifts;

@Mod.EventBusSubscriber
public class EntityEvents {

    @SubscribeEvent
    public static void entitySpawn(EntityJoinWorldEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof EntityFluxRift) {
            rifts.add((EntityFluxRift) entity);
        }
    }
}
