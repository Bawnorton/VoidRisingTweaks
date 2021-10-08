package com.bawnorton.vrt.addons.blocks;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.Chunk;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlockInfo {
    private final List<BlockPos> neighbours = new ArrayList<>();
    public BlockPos pos;
    public Block block;
    public Chunk chunk;
    private boolean defined = false;
    private Random r = new Random(System.currentTimeMillis());

    public BlockInfo(Block block, BlockPos pos, Chunk chunk) {
        this.pos = pos;
        this.block = block;
        this.chunk = chunk;
    }

    public BlockPos getNeighbour() {
        return neighbours.get(r.nextInt(neighbours.size()));
    }

    public List<BlockPos> getNeighbours() {
        setNeighbours();
        return neighbours;
    }

    public boolean hasHigher() {
        setNeighbours();
        for (BlockPos pos : neighbours) {
            Block blk = chunk.getBlockState(pos).getBlock();
            if (!(blk instanceof VRTTaintBlock)) continue;
            VRTTaintBlock block = (VRTTaintBlock) blk;
            if (block.getStage() < ((VRTTaintBlock) this.block).getStage()) {
                return true;
            }
        }
        return false;
    }

    private void setNeighbours() {
        if(defined) return;
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                for (int z = -1; z < 2; z++) {
                    if (x == 0 && y == 0 && z == 0) continue;
                    neighbours.add(new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ() + z));
                }
            }
        }
        defined = true;
    }

    @Override
    public String toString() {
        return "TaintBlock{" +
                "pos=" + pos +
                ", block=" + block +
                '}';
    }
}
