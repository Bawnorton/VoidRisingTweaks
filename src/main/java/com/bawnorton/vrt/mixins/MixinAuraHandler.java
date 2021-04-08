package com.bawnorton.vrt.mixins;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import thaumcraft.common.world.aura.AuraHandler;

import static thaumcraft.common.world.aura.AuraHandler.addVis;


@Mixin(AuraHandler.class)
public abstract class MixinAuraHandler {

    /**
     * @author Bawnorton
     */
    @Overwrite(remap = false)
    public static float drainFlux(World world, BlockPos pos, float amount, boolean simulate) {
        addVis(world, pos, amount / 100);
        return amount;
    }
}
