package com.bawnorton.vrt.addons;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import static com.bawnorton.vrt.addons.items.VRTItemInit.CHARRED_TAINT;

public class VRTCreativeTab extends CreativeTabs {
    public VRTCreativeTab(String label) {
        super(label);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(CHARRED_TAINT);
    }
}
