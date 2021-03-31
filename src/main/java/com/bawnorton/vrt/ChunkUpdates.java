package com.bawnorton.vrt;

import nc.capability.radiation.source.IRadiationSource;
import nc.radiation.RadiationHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.ChunkProviderServer;
import net.minecraftforge.event.world.ChunkWatchEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.spongepowered.asm.mixin.Mixin;
import thaumcraft.api.aura.AuraHelper;


import java.util.Collection;
import java.util.Random;

import static nc.config.NCConfig.radiation_world_chunks_per_tick;

public class ChunkUpdates {

    private static final Random RAND = new Random();

    @SubscribeEvent
    public void getChunkRadiation(TickEvent.WorldTickEvent event) {
        WorldServer world = (WorldServer) event.world;
        ChunkProviderServer chunkProvider = world.getChunkProvider();
        Collection<Chunk> loadedChunks = chunkProvider.getLoadedChunks();
        int chunkArrSize = loadedChunks.size();
        int chunkStart = RAND.nextInt(chunkArrSize + 1);
        int chunksPerTick = Math.min(radiation_world_chunks_per_tick, chunkArrSize);
        BlockPos randomOffsetPos = newRandomOffsetPos(world);
        Chunk[] chunkArray = loadedChunks.toArray(new Chunk[chunkArrSize]);
        if(chunkArrSize > 0) {
            for (int i = chunkStart; i < chunkStart + chunksPerTick; i++) {
                Chunk chunk = chunkArray[i % chunkArrSize];
                if (!chunk.isLoaded()) {
                    continue;
                }
                IRadiationSource chunkSource = RadiationHelper.getRadiationSource(chunk);
                if (chunkSource == null) {
                    continue;
                }
                double currentRad = chunkSource.getRadiationLevel();
                changeBiome(chunk, currentRad, randomOffsetPos);
            }
        }
    }

    @SubscribeEvent
    public void genFlux(ChunkWatchEvent.Watch event) {
        try {
            Chunk chunk = event.getChunkInstance();
            World world = chunk.getWorld();
            BlockPos pos = chunk.getPos().getBlock(8, 128, 8);
            if(AuraHelper.getFlux(world, pos) <= 500.0F) {
                AuraHelper.polluteAura(world, pos, 600.0F, false);
            }
        } catch(NullPointerException e) {
            System.out.println("Overloaded");
        }
    }

    public void changeBiome(Chunk chunk, double rads, BlockPos targetBlock) {
        int inChunkX = targetBlock.getX() & 15;
        int inChunkZ = targetBlock.getZ() & 15;
        if(rads <= 0.5) {
            chunk.getBiomeArray()[inChunkZ << 4 | inChunkX] = 21;
        }
    }



    private static BlockPos newRandomOffsetPos(World world) {
        return new BlockPos(RAND.nextInt(16), RAND.nextInt(world.getHeight()), RAND.nextInt(16));
    }
}
