package com.bawnorton.vrt.events;

import com.bawnorton.vrt.Global;
import com.bawnorton.vrt.addons.blocks.BlockInfo;
import com.bawnorton.vrt.addons.entities.EntityCrawler;
import net.minecraft.block.Block;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import thaumcraft.common.entities.EntityFluxRift;

import java.util.Random;

import static com.bawnorton.vrt.Global.rifts;
import static com.bawnorton.vrt.addons.blocks.VRTBlockInit.BLOCKS;

@Mod.EventBusSubscriber
public class PlayerEvents {

    private static Random r = new Random(System.currentTimeMillis());

    @SubscribeEvent
    public static void onBlockPlace(BlockEvent.PlaceEvent event) {
        Block block = event.getPlacedBlock().getBlock();
        BlockPos pos = event.getBlockSnapshot().getPos();
        Chunk chunk = event.getWorld().getChunk(pos);
        if (BLOCKS.contains(block)) {
            Global.blocks.put(pos, new BlockInfo(block, pos, chunk));
        }
    }

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        Block block = event.getState().getBlock();
        BlockPos pos = event.getPos();
        if (BLOCKS.contains(block)) {
            Global.blocks.remove(pos);
        }
    }

    public static int spawnRate = 200;
    private static int rate = 0;

    @SubscribeEvent
    public static void playerTick(TickEvent.PlayerTickEvent event) {
        if(rifts.size() <= 0) return;
        if(rate <= spawnRate) {
        	rate++;
        	return;
        }
        rate = 0;
        MinecraftServer server = event.player.getServer();
        if(server == null) return;
        WorldServer world = server.getWorld(event.player.dimension);
        EntityFluxRift rift = rifts.get(r.nextInt(rifts.size()));
        if(rift.isDead) {
            rifts.remove(rift);
            return;
        }
        EntityCrawler crawler = new EntityCrawler(world);
        int xOffset = r.nextInt(6) - 3; 
        int zOffset = r.nextInt(6) - 3; 
        crawler.setLocationAndAngles(rift.posX + xOffset, rift.posY + 1, rift.posZ + zOffset, 0.0F, 0.0F);
        world.spawnEntity(crawler);
    }
}
