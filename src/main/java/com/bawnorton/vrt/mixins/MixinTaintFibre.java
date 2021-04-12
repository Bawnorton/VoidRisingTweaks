package com.bawnorton.vrt.mixins;

import nc.radiation.RadiationHelper;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import thaumcraft.common.blocks.world.taint.BlockTaintFibre;
import thaumcraft.common.blocks.world.taint.TaintHelper;

@Mixin(BlockTaintFibre.class)
public abstract class MixinTaintFibre {

    /**
     * @author Bawnorton
     */
    @Overwrite(remap = false)
    public void die(World world, BlockPos pos, IBlockState blockState) {
        if (RadiationHelper.getRadiationSource(world.getChunk(pos)).getRadiationLevel() > 0.001) {
            world.setBlockToAir(pos);
        } else {
            TaintHelper.spreadFibres(world, pos);
        }
    }
}
