package com.bawnorton.vrt.mixins;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import thaumcraft.common.world.aura.AuraHandler;


@Mixin(AuraHandler.class)
public abstract class MixinAuraHandler {

    /**
     * @author Bawnorton
     */
    @Overwrite
    public static float drainFlux(World world, BlockPos pos, float amount, boolean simulate) {
        return amount;
    }
}
