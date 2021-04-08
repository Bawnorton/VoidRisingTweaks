package com.bawnorton.vrt.events;

import com.bawnorton.vrt.handler.ChunkHandler;
import com.bawnorton.vrt.handler.TaintBlock;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static com.bawnorton.vrt.addons.blocks.VRTBlockInit.BLOCKS;

@Mod.EventBusSubscriber
public class PlayerEvents {

    @SubscribeEvent
    public static void onBlockPlace(BlockEvent.PlaceEvent event) {
        Block block = event.getPlacedBlock().getBlock();
        BlockPos pos = event.getBlockSnapshot().getPos();
        Chunk chunk = event.getWorld().getChunk(pos);
        if (BLOCKS.contains(block)) {
            ChunkHandler.blocks.add(new TaintBlock(block, pos, chunk));
        }
    }

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        Block block = event.getState().getBlock();
        BlockPos pos = event.getPos();
        Chunk chunk = event.getWorld().getChunk(pos);
        if (BLOCKS.contains(block)) {
            ChunkHandler.blocks.remove(new TaintBlock(block, pos, chunk));
        }
    }
}
