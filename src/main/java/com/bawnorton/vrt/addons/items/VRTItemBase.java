package com.bawnorton.vrt.addons.items;

import com.bawnorton.vrt.VoidRisingTweaks;
import com.bawnorton.vrt.addons.VRTHasModel;
import net.minecraft.item.Item;
import thaumcraft.common.config.ConfigItems;

public class VRTItemBase extends Item implements VRTHasModel {
    public VRTItemBase(String name) {
    	setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(ConfigItems.TABTC);

        VRTItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        VoidRisingTweaks.proxy.registerItemRenderer(this, 0, "inventory");
    }

}
