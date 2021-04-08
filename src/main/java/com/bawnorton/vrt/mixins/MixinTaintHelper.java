package com.bawnorton.vrt.mixins;

import com.bawnorton.vrt.handler.TaintBlock;
import com.bawnorton.vrt.handler.ChunkHandler;
import nc.radiation.RadiationHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import thaumcraft.api.ThaumcraftMaterials;
import thaumcraft.api.aura.AuraHelper;
import thaumcraft.api.blocks.BlocksTC;
import thaumcraft.common.blocks.IBlockFacing;
import thaumcraft.common.blocks.world.taint.BlockTaintFibre;
import thaumcraft.common.blocks.world.taint.BlockTaintLog;
import thaumcraft.common.blocks.world.taint.TaintHelper;
import thaumcraft.common.config.ModConfig;
import thaumcraft.common.entities.monster.tainted.EntityTaintSeed;
import thaumcraft.common.lib.utils.BlockUtils;
import thaumcraft.common.lib.utils.Utils;
import thaumcraft.common.world.aura.AuraHandler;

import java.util.Hashtable;
import java.util.Map;

import static com.bawnorton.vrt.addons.blocks.VRTBlockInit.*;
import static thaumcraft.common.blocks.world.taint.TaintHelper.isAtTaintSeedEdge;

@Mixin(TaintHelper.class)
public abstract class MixinTaintHelper {

    /**
     * @author Bawnorton
     */
    @Overwrite(remap = false)
    public static void spreadFibres(World world, BlockPos pos, boolean ignore) {
        if (ignore || !ModConfig.CONFIG_MISC.wussMode) {
            float mod = 0.001F + AuraHandler.getFluxSaturation(world, pos) * 2.0F;
            if (ignore || world.rand.nextFloat() <= ModConfig.CONFIG_WORLD.taintSpreadRate / 100.0F * mod) {
                if (RadiationHelper.getRadiationSource(world.getChunk(pos)).getRadiationLevel() < 0.001) {
                    int xx = pos.getX() + world.rand.nextInt(3) - 1;
                    int yy = pos.getY() + world.rand.nextInt(3) - 1;
                    int zz = pos.getZ() + world.rand.nextInt(3) - 1;
                    BlockPos t = new BlockPos(xx, yy, zz);
                    IBlockState bs = world.getBlockState(t);
                    Block bl = bs.getBlock();
                    if (t.equals(pos)) {
                       if (BLOCKS.contains(bl)) {
                           String registryName = bl.getRegistryName().getPath();
                           String blockName = registryName.substring(0, registryName.lastIndexOf("_"));
                           int nextStage = 0;
                           for (Block taintedBlock : TAINTED_BLOCKS.get(blockName)) {
                               nextStage++;
                               if (taintedBlock == bl) break;
                           }
                           if (nextStage == 4) return;
                           IBlockState state = TAINTED_BLOCKS.get(blockName).get(nextStage).getDefaultState();
                           world.setBlockState(pos, state);
                       }
                       return;
                    }

                    Material bm = bs.getMaterial();
                    float bh = bs.getBlockHardness(world, t);
                    if (bh < 0.0F || bh > 10.0F) {
                        return;
                    }
                    if (!bs.getBlock().isLeaves(bs, world, t) && !bm.isLiquid() && (world.isAirBlock(t) || bs.getBlock().isReplaceable(world, t) || bs.getBlock() instanceof BlockFlower || bs.getBlock() instanceof IPlantable) && BlockUtils.isAdjacentToSolidBlock(world, t) && !BlockTaintFibre.isOnlyAdjacentToTaint(world, t)) {
                        world.setBlockState(t, BlocksTC.taintFibre.getDefaultState());
                        world.addBlockEvent(t, BlocksTC.taintFibre, 1, 0);
                        AuraHelper.drainFlux(world, t, 0.01F, false);
                        return;
                    }

                    EntityTaintSeed e;
                    if (bs.getBlock().isLeaves(bs, world, t)) {
                        EnumFacing face;
                        if ((double) world.rand.nextFloat() < 0.6D && (face = BlockUtils.getFaceBlockTouching(world, t, BlocksTC.taintLog)) != null) {
                            world.setBlockState(t, BlocksTC.taintFeature.getDefaultState().withProperty(IBlockFacing.FACING, face.getOpposite()));
                        } else {
                            world.setBlockState(t, BlocksTC.taintFibre.getDefaultState());
                            world.addBlockEvent(t, BlocksTC.taintFibre, 1, 0);
                            AuraHelper.drainFlux(world, t, 0.01F, false);
                        }

                        return;
                    }

                    if (BlockTaintFibre.isHemmedByTaint(world, t) && bs.getBlockHardness(world, t) < 5.0F) {
                        Hashtable<IBlockState, Block> taintBlocks = new Hashtable<>();
                        for (Map.Entry<Block, IBlockState> entry : defaultBlocks.entrySet()) {
                            taintBlocks.put(entry.getValue(), entry.getKey());
                        }
                        taintBlocks.put(Blocks.GRASS.getDefaultState(), SLIGHTLY_TAINTED_DIRT);
                        Block taintBlock = taintBlocks.get(bs);
                        if (taintBlock != null) {
                            world.setBlockState(t, taintBlock.getDefaultState());
                            world.addBlockEvent(t, taintBlock, 1, 0);
                            ChunkHandler.blocks.add(new TaintBlock(taintBlock, t, world.getChunk(pos)));
                        } else if (Utils.isWoodLog(world, t) && bs.getMaterial() != ThaumcraftMaterials.MATERIAL_TAINT) {
                            world.setBlockState(t, BlocksTC.taintLog.getDefaultState().withProperty(BlockTaintLog.AXIS, BlockUtils.getBlockAxis(world, t)));
                        } else if(bm == Material.WOOD) {
                            world.setBlockState(t, BlocksTC.taintCrust.getDefaultState());
                            world.addBlockEvent(t, BlocksTC.taintCrust, 1 ,0);
                            AuraHelper.drainFlux(world, t, 0.01F, false);
                        }
                        AuraHelper.drainFlux(world, t, 0.01F, false);
                    }

                    if ((bm == ThaumcraftMaterials.MATERIAL_TAINT) && world.isAirBlock(t.up()) && AuraHelper.getFlux(world, t) >= 5.0F && (double) world.rand.nextFloat() < (double) (ModConfig.CONFIG_WORLD.taintSpreadRate / 100.0F) * 0.33D && isAtTaintSeedEdge(world, t)) {
                        e = new EntityTaintSeed(world);
                        e.setLocationAndAngles(((float) t.getX() + 0.5F), t.up().getY(), ((float) t.getZ() + 0.5F), (float) world.rand.nextInt(360), 0.0F);
                        if (e.getCanSpawnHere()) {
                            AuraHelper.drainFlux(world, t, 5.0F, false);
                            world.spawnEntity(e);
                        }
                    }
                }

            }
        }
    }

}
