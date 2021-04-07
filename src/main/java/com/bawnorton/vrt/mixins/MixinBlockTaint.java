package com.bawnorton.vrt.mixins;

import nc.radiation.RadiationHelper;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import thaumcraft.api.aura.AuraHelper;
import thaumcraft.api.blocks.BlocksTC;
import thaumcraft.common.blocks.world.taint.BlockTaint;
import thaumcraft.common.blocks.world.taint.TaintHelper;
import thaumcraft.common.entities.monster.tainted.EntityTaintSwarm;
import thaumcraft.common.lib.utils.EntityUtils;

import java.util.Random;


@Mixin(BlockTaint.class)
public abstract class MixinBlockTaint {

    /**
     * @author Bawnorton
     */
    @Overwrite(remap = false)
    public void die(World world, BlockPos pos, IBlockState state) {
        if(RadiationHelper.getRadiationSource(world.getChunk(pos)).getRadiationLevel() > 0.001) {
            if (state.getBlock() == BlocksTC.taintRock) {
                world.setBlockState(pos, Blocks.STONE.getDefaultState());
            } else if (state.getBlock() == BlocksTC.taintSoil) {
                world.setBlockState(pos, Blocks.DIRT.getDefaultState());
            } else if (state.getBlock() == BlocksTC.taintCrust) {
                world.setBlockState(pos, BlocksTC.fluxGoo.getDefaultState());
            } else if (state.getBlock() == BlocksTC.taintGeyser) {
                world.setBlockState(pos, BlocksTC.fluxGoo.getDefaultState());
            } else {
                world.setBlockToAir(pos);
            }
        }
    }
}
