package com.bawnorton.vrt.handler;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.Chunk;

public class TaintBlock {
    public BlockPos pos;
    public Block block;
    public Chunk chunk;

    public TaintBlock(Block block, BlockPos pos, Chunk chunk) {
        this.pos = pos;
        this.block = block;
        this.chunk = chunk;
    }
}
