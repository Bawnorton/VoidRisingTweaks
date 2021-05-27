package com.bawnorton.vrt.mixins;

import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
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

import java.util.Random;

import static thaumcraft.common.blocks.world.taint.TaintHelper.isAtTaintSeedEdge;

@Mixin(TaintHelper.class)
public abstract class MixinTaintHelper {

    private static final Random r = new Random();

    /**
     * @author Bawnorton
     */
    @Overwrite(remap = false)
    public static void spreadFibres(World world, BlockPos pos, boolean ignore) {
        if (ignore || !ModConfig.CONFIG_MISC.wussMode) {
            int xx = pos.getX() + world.rand.nextInt(3) - 1;
            int yy = pos.getY() + world.rand.nextInt(3) - 1;
            int zz = pos.getZ() + world.rand.nextInt(3) - 1;
            BlockPos t = new BlockPos(xx, yy, zz);
            IBlockState bs = world.getBlockState(t);
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
                if (Utils.isWoodLog(world, t) && bs.getMaterial() != ThaumcraftMaterials.MATERIAL_TAINT) {
                    world.setBlockState(t, BlocksTC.taintLog.getDefaultState().withProperty(BlockTaintLog.AXIS, BlockUtils.getBlockAxis(world, t)));
                } else if (bm == Material.WOOD) {
                    world.setBlockState(t, BlocksTC.taintCrust.getDefaultState());
                    world.addBlockEvent(t, BlocksTC.taintCrust, 1, 0);
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
