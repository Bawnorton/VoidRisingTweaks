package com.bawnorton.vrt.addons.recipies;

import com.bawnorton.vrt.addons.blocks.VRTBlockInit;
import com.bawnorton.vrt.addons.items.VRTItemInit;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.registry.GameRegistry;

import static net.minecraftforge.fml.common.registry.GameRegistry.addSmelting;

public class VRTSmeltingRecipies {
    public static void init() {
        FurnaceRecipes.instance().addSmeltingRecipeForBlock(VRTBlockInit.TAINT_ANDESITE, new ItemStack(VRTItemInit.CHARRED_TAINT), 0.1F);
        FurnaceRecipes.instance().addSmeltingRecipeForBlock(VRTBlockInit.TAINT_COBBLESTONE, new ItemStack(VRTItemInit.CHARRED_TAINT), 0.1F);
        FurnaceRecipes.instance().addSmeltingRecipeForBlock(VRTBlockInit.TAINT_DIORITE, new ItemStack(VRTItemInit.CHARRED_TAINT), 0.1F);
        FurnaceRecipes.instance().addSmeltingRecipeForBlock(VRTBlockInit.TAINT_GRANITE, new ItemStack(VRTItemInit.CHARRED_TAINT), 0.1F);
        FurnaceRecipes.instance().addSmeltingRecipeForBlock(VRTBlockInit.TAINT_SAND, new ItemStack(VRTItemInit.CHARRED_TAINT), 0.1F);
        FurnaceRecipes.instance().addSmeltingRecipeForBlock(VRTBlockInit.TAINT_SANDSTONE, new ItemStack(VRTItemInit.CHARRED_TAINT), 0.1F);
        FurnaceRecipes.instance().addSmeltingRecipeForBlock(VRTBlockInit.TAINT_STONE_BRICKS, new ItemStack(VRTItemInit.CHARRED_TAINT), 0.1F);
    }
}
