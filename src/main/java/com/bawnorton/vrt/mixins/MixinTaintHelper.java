package com.bawnorton.vrt.mixins;

import com.bawnorton.vrt.addons.blocks.VRTTaintBlock;
import net.minecraft.block.*;
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

import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;
import java.util.stream.Collectors;

import static com.bawnorton.vrt.addons.blocks.VRTBlockInit.*;
import static thaumcraft.common.blocks.world.taint.TaintHelper.isAtTaintSeedEdge;
import static thaumcraft.common.blocks.world.taint.TaintHelper.isNearTaintSeed;

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
                if (isNearTaintSeed(world, pos)) {
                    int xx = pos.getX() + world.rand.nextInt(3) - 1;
                    int yy = pos.getY() + world.rand.nextInt(3) - 1;
                    int zz = pos.getZ() + world.rand.nextInt(3) - 1;
                    BlockPos t = new BlockPos(xx, yy, zz);
                    if (t.equals(pos)) {
                        return;
                    }

                    IBlockState bs = world.getBlockState(t);
                    Material bm = bs.getMaterial();
                    Block bl = bs.getBlock();
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
                        if ((double)world.rand.nextFloat() < 0.6D && (face = BlockUtils.getFaceBlockTouching(world, t, BlocksTC.taintLog)) != null) {
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
                        for(Map.Entry<Block, IBlockState> entry: defaultBlocks.entrySet()) {
                            taintBlocks.put(entry.getValue(), entry.getKey());
                        }
                        Block taintBlock = taintBlocks.get(bs);
                        if(taintBlock != null) {
                            world.setBlockState(t, taintBlock.getDefaultState());
                            world.addBlockEvent(t, taintBlock, 1, 0);
                        }
                        else if (Utils.isWoodLog(world, t) && bs.getMaterial() != ThaumcraftMaterials.MATERIAL_TAINT) {
                            world.setBlockState(t, BlocksTC.taintLog.getDefaultState().withProperty(BlockTaintLog.AXIS, BlockUtils.getBlockAxis(world, t)));
                        }
                        else if (bs.getBlock() == Blocks.RED_MUSHROOM_BLOCK || bs.getBlock() == Blocks.BROWN_MUSHROOM_BLOCK || bm == Material.GOURD || bm == Material.CACTUS || bm == Material.CORAL || bm == Material.SPONGE || bm == Material.WOOD) {
                            world.setBlockState(t, BlocksTC.taintCrust.getDefaultState());
                            world.addBlockEvent(t, BlocksTC.taintCrust, 1, 0);
                        }
                        else if (bm == Material.GROUND || bm == Material.GRASS) {
                            world.setBlockState(t, BlocksTC.taintSoil.getDefaultState());
                            world.addBlockEvent(t, BlocksTC.taintSoil, 1, 0);
                        }
                        AuraHelper.drainFlux(world, t, 0.01F, false);
                    }

                    if ((bs.getBlock() == BlocksTC.taintSoil || bs.getBlock() == BlocksTC.taintRock) && world.isAirBlock(t.up()) && AuraHelper.getFlux(world, t) >= 5.0F && (double)world.rand.nextFloat() < (double)(ModConfig.CONFIG_WORLD.taintSpreadRate / 100.0F) * 0.33D && isAtTaintSeedEdge(world, t)) {
                        e = new EntityTaintSeed(world);
                        e.setLocationAndAngles(((float)t.getX() + 0.5F), t.up().getY(), ((float)t.getZ() + 0.5F), (float)world.rand.nextInt(360), 0.0F);
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
