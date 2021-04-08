package com.bawnorton.vrt.events;

import com.bawnorton.vrt.addons.blocks.VRTTaintBlock;
import com.bawnorton.vrt.handler.ChunkHandler;
import com.bawnorton.vrt.handler.TaintBlock;
import net.minecraft.block.Block;
import net.minecraft.client.multiplayer.ChunkProviderClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
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

    Random r = new Random(System.currentTimeMillis());
    public static int tickSpeed = 200;

    @SubscribeEvent
    public void updateTaintBlocks(TickEvent.WorldTickEvent event) {
        if(r.nextInt(tickSpeed + 1) == tickSpeed) {
            if(ChunkHandler.blocks.size() == 0) return;
            TaintBlock block = ChunkHandler.blocks.get(r.nextInt(ChunkHandler.blocks.size()));
            VRTTaintBlock taintBlock = (VRTTaintBlock) block.block;
            taintBlock.updateTick(block.chunk.getWorld(), block.pos, block.block.getDefaultState(), r);
        }
    }

    @SubscribeEvent
    public void addTaintBlocks(TickEvent.PlayerTickEvent event) {
        if(r.nextInt(tickSpeed + 1) == tickSpeed) {
            EntityPlayer player = event.player;
            int playerChunkX = player.chunkCoordX;
            int playerChunkZ = player.chunkCoordZ;
            if(player.world.isRemote) return;
            WorldServer world = player.getServer().getWorld(player.dimension);
            int[] offset = {-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,9,10};
            for(int offx: offset) {
                for (int offz : offset) {
                    Chunk chunk = new Chunk(world, playerChunkX + offx, playerChunkZ + offz);
                    if(!chunk.isLoaded() || ChunkHandler.chunks.contains(chunk)) return;
                    ChunkHandler.chunks.add(chunk);
                    if(ChunkHandler.chunks.size() > 100) ChunkHandler.chunks.remove(0);
                    int x = chunk.x << 4;
                    int z = chunk.z << 4;
                    for(int xx = x; xx < x + 16; xx++) {
                        for(int zz = z; zz < z + 16; zz++) {
                            for(int yy = 0; yy < 256; yy++) {
                                BlockPos pos = new BlockPos(xx, yy, zz);
                                Block block = world.getBlockState(pos).getBlock();
                                if(BLOCKS.contains(block)) {
                                    ChunkHandler.blocks.add(new TaintBlock(block, pos, chunk));
                                }
                            }
                        }
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
