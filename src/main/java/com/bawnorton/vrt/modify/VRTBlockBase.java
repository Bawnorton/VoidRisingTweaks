package com.bawnorton.vrt.modify;

import com.bawnorton.vrt.VoidRisingTweaks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class VRTBlockBase extends Block implements VRTHasModel {
    public VRTBlockBase(String name, Material material) {
        super(material);
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.FOOD);

        VRTBlockInit.BLOCKS.add(this);
        VRTItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }
    @Override
    public void registerModels() {
        VoidRisingTweaks.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
