package com.bawnorton.vrt.addons.blocks;

import net.minecraft.world.chunk.Chunk;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class BlockInfoMap<T, K> extends Hashtable<T, K> {

    List<Chunk> chunkList = new ArrayList<>();

    @Override
    public synchronized K put(T key, K value) {
        if (!chunkList.contains(((BlockInfo) value).chunk)) chunkList.add(((BlockInfo) value).chunk);
        return super.put(key, value);
    }

    public boolean containsChunk(Chunk chunk) {
        return chunkList.contains(chunk);
    }
}
