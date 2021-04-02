package com.bawnorton.vrt.modify;

import com.bawnorton.vrt.VoidRisingTweaks;
import com.bawnorton.vrt.proxy.ClientProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class VRTItemBase extends Item implements VRTHasModel {
    public VRTItemBase(String name) {
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.FOOD);

        VRTItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        VoidRisingTweaks.proxy.registerItemRenderer(this, 0, "inventory");
    }

}
