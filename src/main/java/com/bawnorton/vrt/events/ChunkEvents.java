package com.bawnorton.vrt.events;

import com.bawnorton.vrt.Global;
import com.bawnorton.vrt.addons.blocks.BlockInfo;
import com.bawnorton.vrt.addons.blocks.VRTTaintBlock;
import nc.radiation.RadiationHelper;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.ChunkProviderServer;
import net.minecraftforge.event.world.ChunkWatchEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import thaumcraft.api.aura.AuraHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.bawnorton.vrt.addons.blocks.VRTBlockInit.BLOCKS;

public class ChunkEvents {

    public static int tickSpeed = 0;
    Random r = new Random(System.currentTimeMillis());

    @SubscribeEvent
    public void updateTaintBlocks(TickEvent.WorldTickEvent event) {
        if (r.nextInt(tickSpeed + 1) == tickSpeed) {
            if (Global.blocks.size() == 0) return;
            BlockInfo block = new ArrayList<>(Global.blocks.values()).get(r.nextInt(Global.blocks.size()));
            VRTTaintBlock taintBlock = (VRTTaintBlock) block.block;
            taintBlock.updateVrtTick(block.chunk.getWorld(), block.pos);
        }
        WorldServer world = (WorldServer) event.world;
        ChunkProviderServer chunkProvider = world.getChunkProvider();
        List<Chunk> chunkList = new ArrayList<>(chunkProvider.getLoadedChunks());
        for (Chunk chunk : chunkList) {
            if (!Global.blocks.containsChunk(chunk) && RadiationHelper.getRadiationSource(chunk).getRadiationLevel() > 0.001) {
                int chunkX = chunk.x << 4;
                int chunkZ = chunk.z << 4;
                for (int y = 256; y > 1; y--) {
                    BlockPos pos = new BlockPos(8 + chunkX, y, 8 + chunkZ);
                    Block block = world.getBlockState(pos).getBlock();
                    if (BLOCKS.contains(block)) {
                        Global.blocks.put(pos, new BlockInfo(block, pos, chunk));
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void genFlux(ChunkWatchEvent.Watch event) {
        World world = event.getPlayer().getServerWorld();
        Chunk chunk = event.getChunkInstance();
        if (chunk == null) return;
        BlockPos pos = chunk.getPos().getBlock(8, 128, 8);
        float chunkFlux = AuraHelper.getFlux(world, pos);
        if (chunkFlux <= 600.0F) {
            AuraHelper.polluteAura(world, pos, 600.0F - chunkFlux, false);
        }
    }
}
