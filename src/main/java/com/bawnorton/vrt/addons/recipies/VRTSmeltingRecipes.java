package com.bawnorton.vrt.addons.recipies;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.List;
import java.util.Map;

import static com.bawnorton.vrt.addons.blocks.VRTBlockInit.TAINTED_BLOCKS;
import static com.bawnorton.vrt.addons.blocks.VRTBlockInit.defaultBlocks;
import static com.bawnorton.vrt.addons.items.VRTItemInit.TAINTED_ITEMS;

public class VRTSmeltingRecipes {
    public static void init() {
        for(Map.Entry<String, List<Item>> taintedItem: TAINTED_ITEMS.entrySet()) {
            for(Item Variant: taintedItem.getValue()) {
                GameRegistry.addSmelting(Variant, new ItemStack(
                        defaultBlocks.get(
                                TAINTED_BLOCKS.get(taintedItem.getKey()).get(0)
                        ).getBlock()
                ), 0.2f);
            }
        }
    }
}
