package com.bawnorton.vrt.modify;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class VRTBlockInit {
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block TAINT_SANDSTONE = new VRTBlockBase("taint_sandstone", Material.GLASS);
}
