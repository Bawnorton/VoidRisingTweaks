package com.bawnorton.vrt.addons.blocks;

import appeng.api.AEApi;
import cofh.thermalfoundation.init.TFBlocks;
import nc.enumm.MetaEnums;
import nc.init.NCBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.block.properties.IProperty;
import net.minecraft.init.Blocks;
import net.minecraft.block.state.IBlockState;
import cofh.thermalfoundation.block.BlockOre;
import techreborn.init.ModBlocks;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class  VRTBlockInit {
    public static final List<Block> BLOCKS = new ArrayList<Block>();
    //
    // BLOCKS
    //
//index
    public static final Block TAINTED_ANDESITE = new VRTTaintBlock("tainted_andesite_full");
    public static final Block TAINT_ANDESITE = new VRTTaintBlock("taint_andesite");
    public static final Block TAINT_CLAY = new VRTTaintBlock("taint_clay");
    public static final Block TAINT_COBBLESTONE = new VRTTaintBlock("taint_cobblestone");
    public static final Block TAINT_DIORITE = new VRTTaintBlock("taint_diorite");
    public static final Block TAINT_GRANITE = new VRTTaintBlock("taint_granite");
    public static final Block TAINT_GRAVEL = new VRTTaintBlock("taint_gravel");
    public static final Block TAINT_SAND = new VRTTaintBlock("taint_sand");
    public static final Block TAINT_SANDSTONE = new VRTTaintBlock("taint_sandstone");
    public static final Block TAINT_STONE_BRICKS = new VRTTaintBlock("taint_stone_bricks");
    //
    // ORES
    //
    public static final Block TAINT_ORE_BAUXITE = new VRTTaintBlock("taint_ore_bauxite");
    public static final Block TAINT_ORE_BORON = new VRTTaintBlock("taint_ore_boron");
    public static final Block TAINT_ORE_COPPER = new VRTTaintBlock("taint_ore_copper");
    public static final Block TAINT_ORE_GALENA = new VRTTaintBlock("taint_ore_galena");
    public static final Block TAINT_ORE_GOLD = new VRTTaintBlock("taint_ore_gold");
    public static final Block TAINT_ORE_IRIDIUM = new VRTTaintBlock("taint_ore_iridium");
    public static final Block TAINT_ORE_IRON = new VRTTaintBlock("taint_ore_iron");
    public static final Block TAINT_ORE_LEAD = new VRTTaintBlock("taint_ore_lead");
    public static final Block TAINT_ORE_LITHIUM = new VRTTaintBlock("taint_ore_lithium");
    public static final Block TAINT_ORE_NICKEL = new VRTTaintBlock("taint_ore_nickel");
    public static final Block TAINT_ORE_MAGNESIUM = new VRTTaintBlock("taint_ore_Magnesium");
    public static final Block TAINT_ORE_SILVER = new VRTTaintBlock("taint_ore_silver");
    public static final Block TAINT_ORE_THORIUM = new VRTTaintBlock("taint_ore_thorium");
    public static final Block TAINT_ORE_TIN = new VRTTaintBlock("taint_ore_tin");
    public static final Block TAINT_ORE_URANIUM = new VRTTaintBlock("taint_ore_uranium");
    //
    // GEMS
    //
    public static final Block TAINT_ORE_CERTUS = new VRTTaintBlock("taint_ore_certus");
    public static final Block TAINT_ORE_CHARGED_CERTUS = new VRTTaintBlock("taint_ore_charged_certus");
    public static final Block TAINT_ORE_COAL = new VRTTaintBlock("taint_ore_coal");
    public static final Block TAINT_ORE_DIAMOND = new VRTTaintBlock("taint_ore_diamond");
    public static final Block TAINT_ORE_EMERALD = new VRTTaintBlock("taint_ore_emerald");
    public static final Block TAINT_ORE_LAPIS = new VRTTaintBlock("taint_ore_lapis");
    public static final Block TAINT_ORE_REDSTONE = new VRTTaintBlock("taint_ore_redstone");
    public static final Block TAINT_ORE_RUBY = new VRTTaintBlock("taint_ore_ruby");
    public static final Block TAINT_ORE_SAPPHIRE = new VRTTaintBlock("taint_ore_sapphire");

    public static final Hashtable<Block, IBlockState> defaultBlocks = new Hashtable<Block, IBlockState>(){{
        put(TAINT_ANDESITE, Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE));
        put(TAINT_COBBLESTONE, Blocks.COBBLESTONE.getDefaultState());
        put(TAINT_DIORITE, Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.DIORITE));
        put(TAINT_GRANITE, Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE));
        put(TAINT_GRAVEL, Blocks.GRAVEL.getDefaultState());
        put(TAINT_SAND, Blocks.SAND.getDefaultState());
        put(TAINT_SANDSTONE, Blocks.SANDSTONE.getDefaultState());
        put(TAINT_STONE_BRICKS, Blocks.STONEBRICK.getDefaultState().withProperty(BlockStoneBrick.VARIANT, BlockStoneBrick.EnumType.CRACKED));
        put(TAINT_ORE_BAUXITE, TROre(4));
        put(TAINT_ORE_BORON, NCOre(5));
        put(TAINT_ORE_COPPER, TFOre(0));
        put(TAINT_ORE_GALENA, TROre(0));
        put(TAINT_ORE_GOLD, Blocks.GOLD_ORE.getDefaultState());
        put(TAINT_ORE_IRIDIUM, TROre(1));
        put(TAINT_ORE_IRON, Blocks.IRON_ORE.getDefaultState());
        put(TAINT_ORE_LEAD, TFOre(3));
        put(TAINT_ORE_LITHIUM, NCOre(6));
        put(TAINT_ORE_NICKEL, TFOre(5));
        put(TAINT_ORE_MAGNESIUM, NCOre(7));
        put(TAINT_ORE_SILVER, TFOre(2));
        put(TAINT_ORE_THORIUM, NCOre(3));
        put(TAINT_ORE_TIN, TFOre(1));
        put(TAINT_ORE_URANIUM, NCOre(4));
        put(TAINT_ORE_CERTUS, AEApi.instance().definitions().blocks().quartzOre().maybeBlock().get().getDefaultState());
        put(TAINT_ORE_CHARGED_CERTUS, AEApi.instance().definitions().blocks().quartzOreCharged().maybeBlock().get().getDefaultState());
        put(TAINT_ORE_COAL, Blocks.COAL_ORE.getDefaultState());
        put(TAINT_ORE_DIAMOND, Blocks.DIAMOND_ORE.getDefaultState());
        put(TAINT_ORE_EMERALD, Blocks.EMERALD_ORE.getDefaultState());
        put(TAINT_ORE_LAPIS, Blocks.LAPIS_BLOCK.getDefaultState());
        put(TAINT_ORE_REDSTONE, Blocks.REDSTONE_ORE.getDefaultState());
        put(TAINT_ORE_RUBY, TROre(2));
        put(TAINT_ORE_SAPPHIRE, TROre(3));
    }};

    private static IBlockState TFOre(int meta) {
        return TFBlocks.blockOre.getDefaultState().withProperty(BlockOre.VARIANT, (BlockOre.Type)BlockOre.VARIANT.getAllowedValues().toArray()[meta]);
    }

    private static IBlockState TROre(int meta) {
        return ModBlocks.ORE.getDefaultState().withProperty((IProperty) ModBlocks.ORE.getDefaultState().getPropertyKeys().iterator().next(), (String) ModBlocks.ORE.getDefaultState().getPropertyKeys().iterator().next().getAllowedValues().toArray()[meta]);
    }

    private static IBlockState NCOre(int meta) {
        return NCBlocks.ore.getDefaultState().withProperty((IProperty)NCBlocks.ore.getDefaultState().getPropertyKeys().stream().iterator().next(), (MetaEnums.OreType) NCBlocks.ore.getDefaultState().getPropertyKeys().stream().iterator().next().getAllowedValues().toArray()[meta]);
    }
}
