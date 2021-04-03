package com.bawnorton.vrt.addons.blocks;

import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class VRTBlockInit {
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block TAINT_SANDSTONE = new VRTTaintBlock("taint_sandstone");
    public static final Block TAINT_SAND = new VRTTaintBlock("taint_sand");
}
