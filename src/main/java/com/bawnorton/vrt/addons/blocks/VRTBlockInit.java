package com.bawnorton.vrt.addons.blocks;

import appeng.api.AEApi;
import cofh.thermalfoundation.block.BlockOre;
import cofh.thermalfoundation.init.TFBlocks;
import nc.enumm.MetaEnums;
import nc.init.NCBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import techreborn.init.ModBlocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class VRTBlockInit {
    public static final List<Block> BLOCKS = new ArrayList<>();
    //
    // BLOCKS
    //
    public static final Block TAINTED_ANDESITE = new VRTTaintBlock("tainted_andesite_full");
    public static final Block MOSTLY_TAINTED_ANDESITE = new VRTTaintBlock("tainted_andesite_most");
    public static final Block PARTIALLY_TAINTED_ANDESITE = new VRTTaintBlock("tainted_andesite_some");
    public static final Block SLIGHTLY_TAINTED_ANDESITE = new VRTTaintBlock("tainted_andesite_few");
    public static final Block TAINTED_CLAY = new VRTTaintBlock("tainted_clay_full");
    public static final Block MOSTLY_TAINTED_CLAY = new VRTTaintBlock("tainted_clay_most");
    public static final Block PARTIALLY_TAINTED_CLAY = new VRTTaintBlock("tainted_clay_some");
    public static final Block SLIGHTLY_TAINTED_CLAY = new VRTTaintBlock("tainted_clay_few");
    public static final Block TAINTED_COBBLESTONE = new VRTTaintBlock("tainted_cobblestone_full");
    public static final Block MOSTLY_TAINTED_COBBLESTONE = new VRTTaintBlock("tainted_cobblestone_most");
    public static final Block PARTIALLY_TAINTED_COBBLESTONE = new VRTTaintBlock("tainted_cobblestone_some");
    public static final Block SLIGHTLY_TAINTED_COBBLESTONE = new VRTTaintBlock("tainted_cobblestone_few");
    public static final Block TAINTED_DIORITE = new VRTTaintBlock("tainted_diorite_full");
    public static final Block MOSTLY_TAINTED_DIORITE = new VRTTaintBlock("tainted_diorite_most");
    public static final Block PARTIALLY_TAINTED_DIORITE = new VRTTaintBlock("tainted_diorite_some");
    public static final Block SLIGHTLY_TAINTED_DIORITE = new VRTTaintBlock("tainted_diorite_few");
    public static final Block TAINTED_DIRT = new VRTTaintBlock("tainted_dirt_full");
    public static final Block MOSTLY_TAINTED_DIRT = new VRTTaintBlock("tainted_dirt_most");
    public static final Block PARTIALLY_TAINTED_DIRT = new VRTTaintBlock("tainted_dirt_some");
    public static final Block SLIGHTLY_TAINTED_DIRT = new VRTTaintBlock("tainted_dirt_few");
    public static final Block TAINTED_GRANITE = new VRTTaintBlock("tainted_granite_full");
    public static final Block MOSTLY_TAINTED_GRANITE = new VRTTaintBlock("tainted_granite_most");
    public static final Block PARTIALLY_TAINTED_GRANITE = new VRTTaintBlock("tainted_granite_some");
    public static final Block SLIGHTLY_TAINTED_GRANITE = new VRTTaintBlock("tainted_granite_few");
    public static final Block TAINTED_GRAVEL = new VRTTaintBlock("tainted_gravel_full");
    public static final Block MOSTLY_TAINTED_GRAVEL = new VRTTaintBlock("tainted_gravel_most");
    public static final Block PARTIALLY_TAINTED_GRAVEL = new VRTTaintBlock("tainted_gravel_some");
    public static final Block SLIGHTLY_TAINTED_GRAVEL = new VRTTaintBlock("tainted_gravel_few");
    public static final Block TAINTED_SAND = new VRTTaintBlock("tainted_sand_full");
    public static final Block MOSTLY_TAINTED_SAND = new VRTTaintBlock("tainted_sand_most");
    public static final Block PARTIALLY_TAINTED_SAND = new VRTTaintBlock("tainted_sand_some");
    public static final Block SLIGHTLY_TAINTED_SAND = new VRTTaintBlock("tainted_sand_few");
    public static final Block TAINTED_SANDSTONE = new VRTTaintBlock("tainted_sandstone_full");
    public static final Block MOSTLY_TAINTED_SANDSTONE = new VRTTaintBlock("tainted_sandstone_most");
    public static final Block PARTIALLY_TAINTED_SANDSTONE = new VRTTaintBlock("tainted_sandstone_some");
    public static final Block SLIGHTLY_TAINTED_SANDSTONE = new VRTTaintBlock("tainted_sandstone_few");
    public static final Block TAINTED_STONE = new VRTTaintBlock("tainted_stone_full");
    public static final Block MOSTLY_TAINTED_STONE = new VRTTaintBlock("tainted_stone_most");
    public static final Block PARTIALLY_TAINTED_STONE = new VRTTaintBlock("tainted_stone_some");
    public static final Block SLIGHTLY_TAINTED_STONE = new VRTTaintBlock("tainted_stone_few");
    public static final Block TAINTED_STONE_BRICKS = new VRTTaintBlock("tainted_stone_bricks_full");
    public static final Block MOSTLY_TAINTED_STONE_BRICKS = new VRTTaintBlock("tainted_stone_bricks_most");
    public static final Block PARTIALLY_TAINTED_STONE_BRICKS = new VRTTaintBlock("tainted_stone_bricks_some");
    public static final Block SLIGHTLY_TAINTED_STONE_BRICKS = new VRTTaintBlock("tainted_stone_bricks_few");
    public static final Block TAINTED_ORE_BAUXITE = new VRTTaintBlock("tainted_ore_bauxite_full");
    public static final Block MOSTLY_TAINTED_ORE_BAUXITE = new VRTTaintBlock("tainted_ore_bauxite_most");
    public static final Block PARTIALLY_TAINTED_ORE_BAUXITE = new VRTTaintBlock("tainted_ore_bauxite_some");
    public static final Block SLIGHTLY_TAINTED_ORE_BAUXITE = new VRTTaintBlock("tainted_ore_bauxite_few");
    public static final Block TAINTED_ORE_BORON = new VRTTaintBlock("tainted_ore_boron_full");
    public static final Block MOSTLY_TAINTED_ORE_BORON = new VRTTaintBlock("tainted_ore_boron_most");
    public static final Block PARTIALLY_TAINTED_ORE_BORON = new VRTTaintBlock("tainted_ore_boron_some");
    public static final Block SLIGHTLY_TAINTED_ORE_BORON = new VRTTaintBlock("tainted_ore_boron_few");
    public static final Block TAINTED_ORE_COPPER = new VRTTaintBlock("tainted_ore_copper_full");
    public static final Block MOSTLY_TAINTED_ORE_COPPER = new VRTTaintBlock("tainted_ore_copper_most");
    public static final Block PARTIALLY_TAINTED_ORE_COPPER = new VRTTaintBlock("tainted_ore_copper_some");
    public static final Block SLIGHTLY_TAINTED_ORE_COPPER = new VRTTaintBlock("tainted_ore_copper_few");
    public static final Block TAINTED_ORE_GALENA = new VRTTaintBlock("tainted_ore_galena_full");
    public static final Block MOSTLY_TAINTED_ORE_GALENA = new VRTTaintBlock("tainted_ore_galena_most");
    public static final Block PARTIALLY_TAINTED_ORE_GALENA = new VRTTaintBlock("tainted_ore_galena_some");
    public static final Block SLIGHTLY_TAINTED_ORE_GALENA = new VRTTaintBlock("tainted_ore_galena_few");
    public static final Block TAINTED_ORE_GOLD = new VRTTaintBlock("tainted_ore_gold_full");
    public static final Block MOSTLY_TAINTED_ORE_GOLD = new VRTTaintBlock("tainted_ore_gold_most");
    public static final Block PARTIALLY_TAINTED_ORE_GOLD = new VRTTaintBlock("tainted_ore_gold_some");
    public static final Block SLIGHTLY_TAINTED_ORE_GOLD = new VRTTaintBlock("tainted_ore_gold_few");
    public static final Block TAINTED_ORE_IRIDIUM = new VRTTaintBlock("tainted_ore_iridium_full");
    public static final Block MOSTLY_TAINTED_ORE_IRIDIUM = new VRTTaintBlock("tainted_ore_iridium_most");
    public static final Block PARTIALLY_TAINTED_ORE_IRIDIUM = new VRTTaintBlock("tainted_ore_iridium_some");
    public static final Block SLIGHTLY_TAINTED_ORE_IRIDIUM = new VRTTaintBlock("tainted_ore_iridium_few");
    public static final Block TAINTED_ORE_IRON = new VRTTaintBlock("tainted_ore_iron_full");
    public static final Block MOSTLY_TAINTED_ORE_IRON = new VRTTaintBlock("tainted_ore_iron_most");
    public static final Block PARTIALLY_TAINTED_ORE_IRON = new VRTTaintBlock("tainted_ore_iron_some");
    public static final Block SLIGHTLY_TAINTED_ORE_IRON = new VRTTaintBlock("tainted_ore_iron_few");
    public static final Block TAINTED_ORE_LEAD = new VRTTaintBlock("tainted_ore_lead_full");
    public static final Block MOSTLY_TAINTED_ORE_LEAD = new VRTTaintBlock("tainted_ore_lead_most");
    public static final Block PARTIALLY_TAINTED_ORE_LEAD = new VRTTaintBlock("tainted_ore_lead_some");
    public static final Block SLIGHTLY_TAINTED_ORE_LEAD = new VRTTaintBlock("tainted_ore_lead_few");
    public static final Block TAINTED_ORE_LITHIUM = new VRTTaintBlock("tainted_ore_lithium_full");
    public static final Block MOSTLY_TAINTED_ORE_LITHIUM = new VRTTaintBlock("tainted_ore_lithium_most");
    public static final Block PARTIALLY_TAINTED_ORE_LITHIUM = new VRTTaintBlock("tainted_ore_lithium_some");
    public static final Block SLIGHTLY_TAINTED_ORE_LITHIUM = new VRTTaintBlock("tainted_ore_lithium_few");
    public static final Block TAINTED_ORE_NICKEL = new VRTTaintBlock("tainted_ore_nickel_full");
    public static final Block MOSTLY_TAINTED_ORE_NICKEL = new VRTTaintBlock("tainted_ore_nickel_most");
    public static final Block PARTIALLY_TAINTED_ORE_NICKEL = new VRTTaintBlock("tainted_ore_nickel_some");
    public static final Block SLIGHTLY_TAINTED_ORE_NICKEL = new VRTTaintBlock("tainted_ore_nickel_few");
    public static final Block TAINTED_ORE_MAGNESIUM = new VRTTaintBlock("tainted_ore_magnesium_full");
    public static final Block MOSTLY_TAINTED_ORE_MAGNESIUM = new VRTTaintBlock("tainted_ore_magnesium_most");
    public static final Block PARTIALLY_TAINTED_ORE_MAGNESIUM = new VRTTaintBlock("tainted_ore_magnesium_some");
    public static final Block SLIGHTLY_TAINTED_ORE_MAGNESIUM = new VRTTaintBlock("tainted_ore_magnesium_few");
    public static final Block TAINTED_ORE_SILVER = new VRTTaintBlock("tainted_ore_silver_full");
    public static final Block MOSTLY_TAINTED_ORE_SILVER = new VRTTaintBlock("tainted_ore_silver_most");
    public static final Block PARTIALLY_TAINTED_ORE_SILVER = new VRTTaintBlock("tainted_ore_silver_some");
    public static final Block SLIGHTLY_TAINTED_ORE_SILVER = new VRTTaintBlock("tainted_ore_silver_few");
    public static final Block TAINTED_ORE_THORIUM = new VRTTaintBlock("tainted_ore_thorium_full");
    public static final Block MOSTLY_TAINTED_ORE_THORIUM = new VRTTaintBlock("tainted_ore_thorium_most");
    public static final Block PARTIALLY_TAINTED_ORE_THORIUM = new VRTTaintBlock("tainted_ore_thorium_some");
    public static final Block SLIGHTLY_TAINTED_ORE_THORIUM = new VRTTaintBlock("tainted_ore_thorium_few");
    public static final Block TAINTED_ORE_TIN = new VRTTaintBlock("tainted_ore_tin_full");
    public static final Block MOSTLY_TAINTED_ORE_TIN = new VRTTaintBlock("tainted_ore_tin_most");
    public static final Block PARTIALLY_TAINTED_ORE_TIN = new VRTTaintBlock("tainted_ore_tin_some");
    public static final Block SLIGHTLY_TAINTED_ORE_TIN = new VRTTaintBlock("tainted_ore_tin_few");
    public static final Block TAINTED_ORE_URANIUM = new VRTTaintBlock("tainted_ore_uranium_full");
    public static final Block MOSTLY_TAINTED_ORE_URANIUM = new VRTTaintBlock("tainted_ore_uranium_most");
    public static final Block PARTIALLY_TAINTED_ORE_URANIUM = new VRTTaintBlock("tainted_ore_uranium_some");
    public static final Block SLIGHTLY_TAINTED_ORE_URANIUM = new VRTTaintBlock("tainted_ore_uranium_few");
    public static final Block TAINTED_ORE_CERTUS = new VRTTaintBlock("tainted_ore_certus_full");
    public static final Block MOSTLY_TAINTED_ORE_CERTUS = new VRTTaintBlock("tainted_ore_certus_most");
    public static final Block PARTIALLY_TAINTED_ORE_CERTUS = new VRTTaintBlock("tainted_ore_certus_some");
    public static final Block SLIGHTLY_TAINTED_ORE_CERTUS = new VRTTaintBlock("tainted_ore_certus_few");
    public static final Block TAINTED_ORE_CHARGED_CERTUS = new VRTTaintBlock("tainted_ore_charged_certus_full");
    public static final Block MOSTLY_TAINTED_ORE_CHARGED_CERTUS = new VRTTaintBlock("tainted_ore_charged_certus_most");
    public static final Block PARTIALLY_TAINTED_ORE_CHARGED_CERTUS = new VRTTaintBlock("tainted_ore_charged_certus_some");
    public static final Block SLIGHTLY_TAINTED_ORE_CHARGED_CERTUS = new VRTTaintBlock("tainted_ore_charged_certus_few");
    public static final Block TAINTED_ORE_COAL = new VRTTaintBlock("tainted_ore_coal_full");
    public static final Block MOSTLY_TAINTED_ORE_COAL = new VRTTaintBlock("tainted_ore_coal_most");
    public static final Block PARTIALLY_TAINTED_ORE_COAL = new VRTTaintBlock("tainted_ore_coal_some");
    public static final Block SLIGHTLY_TAINTED_ORE_COAL = new VRTTaintBlock("tainted_ore_coal_few");
    public static final Block TAINTED_ORE_DIAMOND = new VRTTaintBlock("tainted_ore_diamond_full");
    public static final Block MOSTLY_TAINTED_ORE_DIAMOND = new VRTTaintBlock("tainted_ore_diamond_most");
    public static final Block PARTIALLY_TAINTED_ORE_DIAMOND = new VRTTaintBlock("tainted_ore_diamond_some");
    public static final Block SLIGHTLY_TAINTED_ORE_DIAMOND = new VRTTaintBlock("tainted_ore_diamond_few");
    public static final Block TAINTED_ORE_EMERALD = new VRTTaintBlock("tainted_ore_emerald_full");
    public static final Block MOSTLY_TAINTED_ORE_EMERALD = new VRTTaintBlock("tainted_ore_emerald_most");
    public static final Block PARTIALLY_TAINTED_ORE_EMERALD = new VRTTaintBlock("tainted_ore_emerald_some");
    public static final Block SLIGHTLY_TAINTED_ORE_EMERALD = new VRTTaintBlock("tainted_ore_emerald_few");
    public static final Block TAINTED_ORE_LAPIS = new VRTTaintBlock("tainted_ore_lapis_full");
    public static final Block MOSTLY_TAINTED_ORE_LAPIS = new VRTTaintBlock("tainted_ore_lapis_most");
    public static final Block PARTIALLY_TAINTED_ORE_LAPIS = new VRTTaintBlock("tainted_ore_lapis_some");
    public static final Block SLIGHTLY_TAINTED_ORE_LAPIS = new VRTTaintBlock("tainted_ore_lapis_few");
    public static final Block TAINTED_ORE_REDSTONE = new VRTTaintBlock("tainted_ore_redstone_full");
    public static final Block MOSTLY_TAINTED_ORE_REDSTONE = new VRTTaintBlock("tainted_ore_redstone_most");
    public static final Block PARTIALLY_TAINTED_ORE_REDSTONE = new VRTTaintBlock("tainted_ore_redstone_some");
    public static final Block SLIGHTLY_TAINTED_ORE_REDSTONE = new VRTTaintBlock("tainted_ore_redstone_few");
    public static final Block TAINTED_ORE_RUBY = new VRTTaintBlock("tainted_ore_ruby_full");
    public static final Block MOSTLY_TAINTED_ORE_RUBY = new VRTTaintBlock("tainted_ore_ruby_most");
    public static final Block PARTIALLY_TAINTED_ORE_RUBY = new VRTTaintBlock("tainted_ore_ruby_some");
    public static final Block SLIGHTLY_TAINTED_ORE_RUBY = new VRTTaintBlock("tainted_ore_ruby_few");
    public static final Block TAINTED_ORE_SAPPHIRE = new VRTTaintBlock("tainted_ore_sapphire_full");
    public static final Block MOSTLY_TAINTED_ORE_SAPPHIRE = new VRTTaintBlock("tainted_ore_sapphire_most");
    public static final Block PARTIALLY_TAINTED_ORE_SAPPHIRE = new VRTTaintBlock("tainted_ore_sapphire_some");
    public static final Block SLIGHTLY_TAINTED_ORE_SAPPHIRE = new VRTTaintBlock("tainted_ore_sapphire_few");

    public static final Hashtable<String, List<Block>> TAINTED_BLOCKS = new Hashtable<String, List<Block>>() {{
        put("tainted_andesite", Arrays.asList(SLIGHTLY_TAINTED_ANDESITE, PARTIALLY_TAINTED_ANDESITE, MOSTLY_TAINTED_ANDESITE, TAINTED_ANDESITE));
        put("tainted_clay", Arrays.asList(SLIGHTLY_TAINTED_CLAY, PARTIALLY_TAINTED_CLAY, MOSTLY_TAINTED_CLAY, TAINTED_CLAY));
        put("tainted_cobblestone", Arrays.asList(SLIGHTLY_TAINTED_COBBLESTONE, PARTIALLY_TAINTED_COBBLESTONE, MOSTLY_TAINTED_COBBLESTONE, TAINTED_COBBLESTONE));
        put("tainted_diorite", Arrays.asList(SLIGHTLY_TAINTED_DIORITE, PARTIALLY_TAINTED_DIORITE, MOSTLY_TAINTED_DIORITE, TAINTED_DIORITE));
        put("tainted_dirt", Arrays.asList(SLIGHTLY_TAINTED_DIRT, PARTIALLY_TAINTED_DIRT, MOSTLY_TAINTED_DIRT, TAINTED_DIRT));
        put("tainted_stone", Arrays.asList(SLIGHTLY_TAINTED_STONE, PARTIALLY_TAINTED_STONE, MOSTLY_TAINTED_STONE, TAINTED_STONE));
        put("tainted_granite", Arrays.asList(SLIGHTLY_TAINTED_GRANITE, PARTIALLY_TAINTED_GRANITE, MOSTLY_TAINTED_GRANITE, TAINTED_GRANITE));
        put("tainted_gravel", Arrays.asList(SLIGHTLY_TAINTED_GRAVEL, PARTIALLY_TAINTED_GRAVEL, MOSTLY_TAINTED_GRAVEL, TAINTED_GRAVEL));
        put("tainted_sand", Arrays.asList(SLIGHTLY_TAINTED_SAND, PARTIALLY_TAINTED_SAND, MOSTLY_TAINTED_SAND, TAINTED_SAND));
        put("tainted_sandstone", Arrays.asList(SLIGHTLY_TAINTED_SANDSTONE, PARTIALLY_TAINTED_SANDSTONE, MOSTLY_TAINTED_SANDSTONE, TAINTED_SANDSTONE));
        put("tainted_stone_bricks", Arrays.asList(SLIGHTLY_TAINTED_STONE_BRICKS, PARTIALLY_TAINTED_STONE_BRICKS, MOSTLY_TAINTED_STONE_BRICKS, TAINTED_STONE_BRICKS));
        put("tainted_ore_bauxite", Arrays.asList(SLIGHTLY_TAINTED_ORE_BAUXITE, PARTIALLY_TAINTED_ORE_BAUXITE, MOSTLY_TAINTED_ORE_BAUXITE, TAINTED_ORE_BAUXITE));
        put("tainted_ore_boron", Arrays.asList(SLIGHTLY_TAINTED_ORE_BORON, PARTIALLY_TAINTED_ORE_BORON, MOSTLY_TAINTED_ORE_BORON, TAINTED_ORE_BORON));
        put("tainted_ore_copper", Arrays.asList(SLIGHTLY_TAINTED_ORE_COPPER, PARTIALLY_TAINTED_ORE_COPPER, MOSTLY_TAINTED_ORE_COPPER, TAINTED_ORE_COPPER));
        put("tainted_ore_galena", Arrays.asList(SLIGHTLY_TAINTED_ORE_GALENA, PARTIALLY_TAINTED_ORE_GALENA, MOSTLY_TAINTED_ORE_GALENA, TAINTED_ORE_GALENA));
        put("tainted_ore_gold", Arrays.asList(SLIGHTLY_TAINTED_ORE_GOLD, PARTIALLY_TAINTED_ORE_GOLD, MOSTLY_TAINTED_ORE_GOLD, TAINTED_ORE_GOLD));
        put("tainted_ore_iridium", Arrays.asList(SLIGHTLY_TAINTED_ORE_IRIDIUM, PARTIALLY_TAINTED_ORE_IRIDIUM, MOSTLY_TAINTED_ORE_IRIDIUM, TAINTED_ORE_IRIDIUM));
        put("tainted_ore_iron", Arrays.asList(SLIGHTLY_TAINTED_ORE_IRON, PARTIALLY_TAINTED_ORE_IRON, MOSTLY_TAINTED_ORE_IRON, TAINTED_ORE_IRON));
        put("tainted_ore_lead", Arrays.asList(SLIGHTLY_TAINTED_ORE_LEAD, PARTIALLY_TAINTED_ORE_LEAD, MOSTLY_TAINTED_ORE_LEAD, TAINTED_ORE_LEAD));
        put("tainted_ore_lithium", Arrays.asList(SLIGHTLY_TAINTED_ORE_LITHIUM, PARTIALLY_TAINTED_ORE_LITHIUM, MOSTLY_TAINTED_ORE_LITHIUM, TAINTED_ORE_LITHIUM));
        put("tainted_ore_nickel", Arrays.asList(SLIGHTLY_TAINTED_ORE_NICKEL, PARTIALLY_TAINTED_ORE_NICKEL, MOSTLY_TAINTED_ORE_NICKEL, TAINTED_ORE_NICKEL));
        put("tainted_ore_magnesium", Arrays.asList(SLIGHTLY_TAINTED_ORE_MAGNESIUM, PARTIALLY_TAINTED_ORE_MAGNESIUM, MOSTLY_TAINTED_ORE_MAGNESIUM, TAINTED_ORE_MAGNESIUM));
        put("tainted_ore_silver", Arrays.asList(SLIGHTLY_TAINTED_ORE_SILVER, PARTIALLY_TAINTED_ORE_SILVER, MOSTLY_TAINTED_ORE_SILVER, TAINTED_ORE_SILVER));
        put("tainted_ore_thorium", Arrays.asList(SLIGHTLY_TAINTED_ORE_THORIUM, PARTIALLY_TAINTED_ORE_THORIUM, MOSTLY_TAINTED_ORE_THORIUM, TAINTED_ORE_THORIUM));
        put("tainted_ore_tin", Arrays.asList(SLIGHTLY_TAINTED_ORE_TIN, PARTIALLY_TAINTED_ORE_TIN, MOSTLY_TAINTED_ORE_TIN, TAINTED_ORE_TIN));
        put("tainted_ore_uranium", Arrays.asList(SLIGHTLY_TAINTED_ORE_URANIUM, PARTIALLY_TAINTED_ORE_URANIUM, MOSTLY_TAINTED_ORE_URANIUM, TAINTED_ORE_URANIUM));
        put("tainted_ore_certus", Arrays.asList(SLIGHTLY_TAINTED_ORE_CERTUS, PARTIALLY_TAINTED_ORE_CERTUS, MOSTLY_TAINTED_ORE_CERTUS, TAINTED_ORE_CERTUS));
        put("tainted_ore_charged_certus", Arrays.asList(SLIGHTLY_TAINTED_ORE_CHARGED_CERTUS, PARTIALLY_TAINTED_ORE_CHARGED_CERTUS, MOSTLY_TAINTED_ORE_CHARGED_CERTUS, TAINTED_ORE_CHARGED_CERTUS));
        put("tainted_ore_coal", Arrays.asList(SLIGHTLY_TAINTED_ORE_COAL, PARTIALLY_TAINTED_ORE_COAL, MOSTLY_TAINTED_ORE_COAL, TAINTED_ORE_COAL));
        put("tainted_ore_diamond", Arrays.asList(SLIGHTLY_TAINTED_ORE_DIAMOND, PARTIALLY_TAINTED_ORE_DIAMOND, MOSTLY_TAINTED_ORE_DIAMOND, TAINTED_ORE_DIAMOND));
        put("tainted_ore_emerald", Arrays.asList(SLIGHTLY_TAINTED_ORE_EMERALD, PARTIALLY_TAINTED_ORE_EMERALD, MOSTLY_TAINTED_ORE_EMERALD, TAINTED_ORE_EMERALD));
        put("tainted_ore_lapis", Arrays.asList(SLIGHTLY_TAINTED_ORE_LAPIS, PARTIALLY_TAINTED_ORE_LAPIS, MOSTLY_TAINTED_ORE_LAPIS, TAINTED_ORE_LAPIS));
        put("tainted_ore_redstone", Arrays.asList(SLIGHTLY_TAINTED_ORE_REDSTONE, PARTIALLY_TAINTED_ORE_REDSTONE, MOSTLY_TAINTED_ORE_REDSTONE, TAINTED_ORE_REDSTONE));
        put("tainted_ore_ruby", Arrays.asList(SLIGHTLY_TAINTED_ORE_RUBY, PARTIALLY_TAINTED_ORE_RUBY, MOSTLY_TAINTED_ORE_RUBY, TAINTED_ORE_RUBY));
        put("tainted_ore_sapphire", Arrays.asList(SLIGHTLY_TAINTED_ORE_SAPPHIRE, PARTIALLY_TAINTED_ORE_SAPPHIRE, MOSTLY_TAINTED_ORE_SAPPHIRE, TAINTED_ORE_SAPPHIRE));
    }};

    public static final Hashtable<Block, IBlockState> defaultBlocks = new Hashtable<Block, IBlockState>() {{
        put(SLIGHTLY_TAINTED_ANDESITE, Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE));
        put(SLIGHTLY_TAINTED_COBBLESTONE, Blocks.COBBLESTONE.getDefaultState());
        put(SLIGHTLY_TAINTED_CLAY, Blocks.CLAY.getDefaultState());
        put(SLIGHTLY_TAINTED_DIORITE, Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.DIORITE));
        put(SLIGHTLY_TAINTED_DIRT, Blocks.DIRT.getDefaultState());
        put(SLIGHTLY_TAINTED_GRANITE, Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE));
        put(SLIGHTLY_TAINTED_GRAVEL, Blocks.GRAVEL.getDefaultState());
        put(SLIGHTLY_TAINTED_SAND, Blocks.SAND.getDefaultState());
        put(SLIGHTLY_TAINTED_SANDSTONE, Blocks.SANDSTONE.getDefaultState());
        put(SLIGHTLY_TAINTED_STONE, Blocks.STONE.getDefaultState());
        put(SLIGHTLY_TAINTED_STONE_BRICKS, Blocks.STONEBRICK.getDefaultState().withProperty(BlockStoneBrick.VARIANT, BlockStoneBrick.EnumType.CRACKED));
        put(SLIGHTLY_TAINTED_ORE_BAUXITE, TROre(4));
        put(SLIGHTLY_TAINTED_ORE_BORON, NCOre(5));
        put(SLIGHTLY_TAINTED_ORE_COPPER, TFOre(0));
        put(SLIGHTLY_TAINTED_ORE_GALENA, TROre(0));
        put(SLIGHTLY_TAINTED_ORE_GOLD, Blocks.GOLD_ORE.getDefaultState());
        put(SLIGHTLY_TAINTED_ORE_IRIDIUM, TROre(1));
        put(SLIGHTLY_TAINTED_ORE_IRON, Blocks.IRON_ORE.getDefaultState());
        put(SLIGHTLY_TAINTED_ORE_LEAD, TFOre(3));
        put(SLIGHTLY_TAINTED_ORE_LITHIUM, NCOre(6));
        put(SLIGHTLY_TAINTED_ORE_NICKEL, TFOre(5));
        put(SLIGHTLY_TAINTED_ORE_MAGNESIUM, NCOre(7));
        put(SLIGHTLY_TAINTED_ORE_SILVER, TFOre(2));
        put(SLIGHTLY_TAINTED_ORE_THORIUM, NCOre(3));
        put(SLIGHTLY_TAINTED_ORE_TIN, TFOre(1));
        put(SLIGHTLY_TAINTED_ORE_URANIUM, NCOre(4));
        put(SLIGHTLY_TAINTED_ORE_CERTUS, AEApi.instance().definitions().blocks().quartzOre().maybeBlock().get().getDefaultState());
        put(SLIGHTLY_TAINTED_ORE_CHARGED_CERTUS, AEApi.instance().definitions().blocks().quartzOreCharged().maybeBlock().get().getDefaultState());
        put(SLIGHTLY_TAINTED_ORE_COAL, Blocks.COAL_ORE.getDefaultState());
        put(SLIGHTLY_TAINTED_ORE_DIAMOND, Blocks.DIAMOND_ORE.getDefaultState());
        put(SLIGHTLY_TAINTED_ORE_EMERALD, Blocks.EMERALD_ORE.getDefaultState());
        put(SLIGHTLY_TAINTED_ORE_LAPIS, Blocks.LAPIS_BLOCK.getDefaultState());
        put(SLIGHTLY_TAINTED_ORE_REDSTONE, Blocks.REDSTONE_ORE.getDefaultState());
        put(SLIGHTLY_TAINTED_ORE_RUBY, TROre(2));
        put(SLIGHTLY_TAINTED_ORE_SAPPHIRE, TROre(3));
    }};

    private static IBlockState TFOre(int meta) {
        return TFBlocks.blockOre.getDefaultState().withProperty(
                BlockOre.VARIANT, (BlockOre.Type) BlockOre.VARIANT.getAllowedValues().toArray()[meta]
        );
    }

    private static IBlockState TROre(int meta) {
        return ModBlocks.ORE.getDefaultState().withProperty(
                (IProperty) ModBlocks.ORE.getDefaultState().getPropertyKeys().iterator().next(), (String) ModBlocks.ORE.getDefaultState().getPropertyKeys().iterator().next().getAllowedValues().toArray()[meta]
        );
    }

    private static IBlockState NCOre(int meta) {
        return NCBlocks.ore.getDefaultState().withProperty(
                (IProperty) NCBlocks.ore.getDefaultState().getPropertyKeys().stream().iterator().next(), (MetaEnums.OreType) NCBlocks.ore.getDefaultState().getPropertyKeys().stream().iterator().next().getAllowedValues().toArray()[meta]
        );
    }
}
