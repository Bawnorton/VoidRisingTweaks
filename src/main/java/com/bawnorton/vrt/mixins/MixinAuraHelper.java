package com.bawnorton.vrt.mixins;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLLog;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import thaumcraft.api.aura.AuraHelper;

@Mixin(AuraHelper.class)
public abstract class MixinAuraHelper {

    /**
     * @author Bawnorton
     */
    @Overwrite
    public static float drainFlux(World world, BlockPos pos, float amount, boolean simulate) {
        return amount;
    }
}
