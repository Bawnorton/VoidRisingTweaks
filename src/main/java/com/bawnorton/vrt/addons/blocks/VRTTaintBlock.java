//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.bawnorton.vrt.addons.blocks;

import com.bawnorton.vrt.Global;
import com.bawnorton.vrt.VoidRisingTweaks;
import com.bawnorton.vrt.addons.VRTHasModel;
import nc.radiation.RadiationHelper;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import thaumcraft.api.ThaumcraftMaterials;
import thaumcraft.api.potions.PotionFluxTaint;
import thaumcraft.common.blocks.world.taint.TaintHelper;
import thaumcraft.common.lib.SoundsTC;

import java.util.*;

import static com.bawnorton.vrt.addons.blocks.VRTBlockInit.*;
import static com.bawnorton.vrt.addons.items.VRTItemInit.ITEMS;

public class VRTTaintBlock extends VRTBlockTC implements VRTHasModel {

    private static final Hashtable<IBlockState, Block> reverseDefault = new Hashtable<>();
    static Random r = new Random(System.currentTimeMillis());
    private boolean loaded = false;

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

    public int getStage() {
        int nextStage = 0;
        for (Block taintedBlock : TAINTED_BLOCKS.get(getName())) {
            if (taintedBlock == this) return nextStage;
            nextStage++;
        }
        return -1;
    }

    public Block setStage(int stage) {
        int nextStage = 0;
        for (Block taintedBlock : TAINTED_BLOCKS.get(getName())) {
            if (stage == nextStage) return taintedBlock;
            nextStage++;
        }
        return this;
    }

    public String getName() {
        String registryName = this.getRegistryName().getPath();
        return registryName.substring(0, registryName.lastIndexOf("_"));
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    public void updateVrtTick(World world, BlockPos pos) {
        if (!world.isRemote) {
            this.change(world, pos, !(RadiationHelper.getRadiationSource(world.getChunk(pos)).getRadiationLevel() > 0.001));
        }
    }

    public void change(World world, BlockPos pos, boolean grow) {
        if (!loaded) {
            for (Map.Entry<Block, IBlockState> entry : defaultBlocks.entrySet()) {
                reverseDefault.put(entry.getValue(), entry.getKey());
            }
            reverseDefault.put(Blocks.GRASS.getDefaultState(), SLIGHTLY_TAINTED_DIRT);
            loaded = true;
        }
        if (BLOCKS.contains(this)) {
            boolean toRemove = false;
            if (!grow) {
                if (this.getStage() == 0) {
                    IBlockState state = defaultBlocks.get(this);
                    world.setBlockState(pos, state);
                    toRemove = true;
                } else {
                    IBlockState state = this.setStage(this.getStage() - 1).getDefaultState();
                    world.setBlockState(pos, state);
                    Global.blocks.replace(pos, new BlockInfo(state.getBlock(), pos, world.getChunk(pos)));
                }
            } else {
                if (this.getStage() == 3) {
                    toRemove = true;
                } else {
                    IBlockState state = this.setStage(this.getStage() + 1).getDefaultState();
                    world.setBlockState(pos, state);
                    Global.blocks.replace(pos, new BlockInfo(state.getBlock(), pos, world.getChunk(pos)));
                }
            }
            Chunk chunk = world.getChunk(pos);
            List<BlockPos> neighbours = Global.blocks.get(pos).getNeighbours();
            for (BlockPos neighbourPos : neighbours) {
                Block block = world.getBlockState(neighbourPos).getBlock();
                if (block.getDefaultState().getMaterial().isLiquid() || block.isAir(block.getDefaultState(), world, neighbourPos))
                    continue;
                if (grow) {
                    TaintHelper.spreadFibres(world, neighbourPos);
                    if (block instanceof VRTTaintBlock) {
                        VRTTaintBlock taintBlock = (VRTTaintBlock) block;
                        if (taintBlock.getStage() == 3) {
                            Global.blocks.remove(neighbourPos);
                            continue;
                        }
                        Block toReplace = TAINTED_BLOCKS.get(taintBlock.getName()).get(taintBlock.getStage() + 1);
                        BlockInfo blockInfo = new BlockInfo(toReplace, neighbourPos, chunk);
                        if (!blockInfo.hasHigher()) continue;
                        world.setBlockState(pos, toReplace.getDefaultState());
                        Global.blocks.put(neighbourPos, blockInfo);
                    } else {
                        Block toReplace = reverseDefault.get(world.getBlockState(neighbourPos));
                        if (toReplace == null) continue;
                        world.setBlockState(neighbourPos, toReplace.getDefaultState());
                        Global.blocks.put(neighbourPos, new BlockInfo(toReplace, neighbourPos, chunk));
                    }
                } else {
                    if (!(block instanceof VRTTaintBlock)) continue;
                    VRTTaintBlock taintBlock = (VRTTaintBlock) block;
                    if (taintBlock.getStage() == 0) {
                        IBlockState state = defaultBlocks.get(taintBlock);
                        world.setBlockState(neighbourPos, state);
                        Global.blocks.remove(neighbourPos);
                        continue;
                    }
                    Block toReplace = TAINTED_BLOCKS.get(taintBlock.getName()).get(taintBlock.getStage() - 1);
                    if (toReplace == null) continue;
                    world.setBlockState(neighbourPos, toReplace.getDefaultState());
                    Global.blocks.put(neighbourPos, new BlockInfo(block, neighbourPos, chunk));
                }
            }
            if (toRemove) {
                Global.blocks.remove(pos);
            }
        }
    }


    public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        if (state.getBlock() == this) {
            List<ItemStack> drops = new ArrayList<>();
            drops.add(new ItemBlock(TAINTED_BLOCKS.get(((VRTTaintBlock)state.getBlock()).getName()).get(3)).getDefaultInstance());
            return drops;
        }

        return super.getDrops(world, pos, state, fortune);
    }

    public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
        return true;
    }

    public void onEntityWalk(World world, BlockPos pos, Entity entity) {
        if (!world.isRemote && entity instanceof EntityLivingBase && !((EntityLivingBase) entity).isEntityUndead() && world.rand.nextInt(250) == 0) {
            ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(PotionFluxTaint.instance, 200, 0, false, true));
        }

    }

    public int damageDropped(IBlockState state) {
        return 0;
    }
}