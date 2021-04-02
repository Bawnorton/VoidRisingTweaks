package com.bawnorton.vrt.mixins;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.fml.common.FMLLog;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import thaumcraft.common.world.aura.AuraHandler;
import thaumcraft.common.world.biomes.BiomeHandler;

import java.util.Random;

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
