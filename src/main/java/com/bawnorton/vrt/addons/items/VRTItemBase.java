package com.bawnorton.vrt.addons.items;

import com.bawnorton.vrt.VoidRisingTweaks;
import com.bawnorton.vrt.addons.VRTHasModel;
import net.minecraft.item.Item;

public class VRTItemBase extends Item implements VRTHasModel {
    public VRTItemBase(String name) {
    	setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(VoidRisingTweaks.TABVRT);

        VRTItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        VoidRisingTweaks.proxy.registerItemRenderer(this, 0, "inventory");
    }

}
