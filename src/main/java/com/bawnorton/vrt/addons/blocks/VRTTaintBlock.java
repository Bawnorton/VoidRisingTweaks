//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.bawnorton.vrt.addons.blocks;

import java.util.Random;

import com.bawnorton.vrt.VoidRisingTweaks;

import com.bawnorton.vrt.addons.VRTHasModel;
import net.minecraft.block.*;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidFinite;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import thaumcraft.api.ThaumcraftMaterials;
import thaumcraft.api.blocks.BlocksTC;
import thaumcraft.api.potions.PotionFluxTaint;
import thaumcraft.common.blocks.world.taint.BlockTaintFibre;
import thaumcraft.common.blocks.world.taint.ITaintBlock;
import thaumcraft.common.blocks.world.taint.TaintHelper;
import thaumcraft.common.entities.EntityFallingTaint;
import thaumcraft.common.lib.SoundsTC;
import thaumcraft.common.lib.utils.Utils;

import static com.bawnorton.vrt.addons.blocks.VRTBlockInit.*;
import static com.bawnorton.vrt.addons.items.VRTItemInit.ITEMS;

public class VRTTaintBlock extends VRTBlockTC implements ITaintBlock, VRTHasModel {

    static Random r = new Random(System.currentTimeMillis());

    public VRTTaintBlock(String name) {
        super(ThaumcraftMaterials.MATERIAL_TAINT, name);
        this.setHardness(10.0F);
        this.setResistance(100.0F);
        this.setSoundType(SoundsTC.GORE);
        this.setTickRandomly(true);
        BLOCKS.add(this);
        ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }
    @Override
    public void registerModels() {
        VoidRisingTweaks.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

    public SoundType getSoundType() {
        return SoundsTC.GORE;
    }

    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
        return BlockFaceShape.UNDEFINED;
    }

    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return MapColor.PURPLE;
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    public void die(World world, BlockPos pos, IBlockState blockState) {
        IBlockState defaultState = defaultBlocks.getOrDefault(blockState.getBlock(), new Block(Material.AIR).getDefaultState());
        world.setBlockState(pos, defaultState);
    }

    public void updateTick(World world, BlockPos pos, IBlockState state, Random random) {
        if (!world.isRemote) {
            if (!TaintHelper.isNearTaintSeed(world, pos) && random.nextInt(10) == 0) {
                this.die(world, pos, state);
                return;
            }
            else {
                TaintHelper.spreadFibres(world, pos);
            }
        }
    }

    public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
        return true;
    }

    public void onEntityWalk(World world, BlockPos pos, Entity entity) {
        if (!world.isRemote && entity instanceof EntityLivingBase && !((EntityLivingBase)entity).isEntityUndead() && world.rand.nextInt(250) == 0) {
            ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(PotionFluxTaint.instance, 200, 0, false, true));
        }

    }

    public boolean eventReceived(IBlockState state, World worldIn, BlockPos pos, int eventID, int eventParam) {
        if (eventID == 1) {
            if (worldIn.isRemote) {
                worldIn.playSound(null, pos, SoundEvents.BLOCK_CHORUS_FLOWER_DEATH, SoundCategory.BLOCKS, 0.1F, 0.9F + worldIn.rand.nextFloat() * 0.2F);
            }

            return true;
        } else {
            return super.eventReceived(state, worldIn, pos, eventID, eventParam);
        }
    }

    public static boolean canFallBelow(World world, BlockPos pos) {
        IBlockState bs = world.getBlockState(pos);
        Block l = bs.getBlock();

        for(int xx = -1; xx <= 1; ++xx) {
            for(int zz = -1; zz <= 1; ++zz) {
                for(int yy = -1; yy <= 1; ++yy) {
                    if (Utils.isWoodLog(world, pos.add(xx, yy, zz))) {
                        return false;
                    }
                }
            }
        }
            if (l.isAir(bs, world, pos)) {
                return true;
            } else if (l == BlocksTC.fluxGoo && bs.getValue(BlockFluidFinite.LEVEL) >= 4) {
                return false;
            } else if (l != Blocks.FIRE && l != BlocksTC.taintFibre) {
                if (l.isReplaceable(world, pos)) {
                    return true;
                } else {
                    return bs.getMaterial() == Material.WATER || bs.getMaterial() == Material.LAVA;
                }
            } else {
                return true;
            }
    }

    private boolean tryToFall(World world, BlockPos pos, BlockPos pos2) {
        if (!BlockTaintFibre.isOnlyAdjacentToTaint(world, pos)) {
            return false;
        } else {
            if (canFallBelow(world, pos2.down()) && pos2.getY() >= 0) {
                byte b0 = 32;
                if (world.isAreaLoaded(pos2.add(-b0, -b0, -b0), pos2.add(b0, b0, b0))) {
                    if (!world.isRemote) {
                        EntityFallingTaint entityfalling = new EntityFallingTaint(world, ((float)pos2.getX() + 0.5F), ((float)pos2.getY() + 0.5F), ((float)pos2.getZ() + 0.5F), world.getBlockState(pos), pos);
                        world.spawnEntity(entityfalling);
                        return true;
                    }
                } else {
                    world.setBlockToAir(pos);

                    BlockPos p2;
                    for(p2 = new BlockPos(pos2); canFallBelow(world, p2.down()) && p2.getY() > 0; p2 = p2.down());
                    if (p2.getY() > 0) {
                        world.setBlockState(p2, BlocksTC.taintCrust.getDefaultState());
                    }
                }
            }

            return false;
        }
    }


    public int damageDropped(IBlockState state) {
        return 0;
    }

    public IBlockState getStateFromMeta() {
        return this.getDefaultState();
    }

    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this);
    }
}