//package com.bawnorton.vrt.modify;
//
//import net.minecraft.block.Block;
//import net.minecraft.client.renderer.block.model.ModelResourceLocation;
//import net.minecraft.item.ItemBlock;
//import net.minecraftforge.client.model.ModelLoader;
//import net.minecraftforge.fml.common.registry.ForgeRegistries;
//import net.minecraftforge.fml.common.registry.GameRegistry;
//import net.minecraftforge.registries.IForgeRegistry;
//
//public class VRTConfigBlocks {
//    public VRTConfigBlocks() {}
//
//    public static void initBlocks() {
//        BlockTaintSandstone.block = registerCustom(new BlockTaintSandstone());
//    }
//
//    public static Block registerCustom(Block block) {
//        return registerCustom(block, new ItemBlock(block));
//    }
//
//    public static Block registerCustom(Block block, ItemBlock itemBlock) {
//        block.setTranslationKey("taint_sandstone_unlocalized");
//        itemBlock.setRegistryName(block.getRegistryName());
//        ForgeRegistries.ITEMS.register(itemBlock);
//        ModelLoader.setCustomModelResourceLocation(itemBlock, 0, new ModelResourceLocation(itemBlock.getRegistryName(), "normal"));
//        return block;
//    }
//}
