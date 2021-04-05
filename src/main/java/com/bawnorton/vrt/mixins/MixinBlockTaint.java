package com.bawnorton.vrt.mixins;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import thaumcraft.api.blocks.BlocksTC;
import thaumcraft.common.blocks.world.taint.BlockTaint;

@Mixin(BlockTaint.class)
public abstract class MixinBlockTaint {
    /**
     * @author Bawnorton
     */
    @Overwrite(remap = false)
    public void die(World world, BlockPos pos, IBlockState state) {
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
