package com.bawnorton.vrt;

import com.bawnorton.vrt.addons.*;
import com.bawnorton.vrt.addons.blocks.VRTBlockInit;
import com.bawnorton.vrt.addons.items.VRTItemInit;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


@EventBusSubscriber
public class Registar {

    @SubscribeEvent
    public static void registerItems(Register<Item> event) {
        event.getRegistry().registerAll(VRTItemInit.ITEMS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void registerBlocks(Register<Block> event) {
        event.getRegistry().registerAll(VRTBlockInit.BLOCKS.toArray(new Block[0]));
    }

    @SubscribeEvent
    public static void registerModel(ModelRegistryEvent event) {
        for(Item item: VRTItemInit.ITEMS) {
            if(item instanceof VRTHasModel) {
                ((VRTHasModel)item).registerModels();
            }
        }
        for(Block block: VRTBlockInit.BLOCKS) {
            if(block instanceof VRTHasModel) {
                ((VRTHasModel)block).registerModels();
            }
        }
    }
}
