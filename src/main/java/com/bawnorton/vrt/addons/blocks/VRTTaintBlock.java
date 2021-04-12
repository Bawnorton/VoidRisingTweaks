//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.bawnorton.vrt.addons.blocks;

import com.bawnorton.vrt.VoidRisingTweaks;
import com.bawnorton.vrt.addons.VRTHasModel;
import com.bawnorton.vrt.handler.BlockInfo;
import com.bawnorton.vrt.handler.ChunkHandler;
import nc.radiation.RadiationHelper;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
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
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.fluids.BlockFluidFinite;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import thaumcraft.api.ThaumcraftMaterials;
import thaumcraft.api.blocks.BlocksTC;
import thaumcraft.api.potions.PotionFluxTaint;
import thaumcraft.common.blocks.world.taint.BlockTaintFibre;
import thaumcraft.common.blocks.world.taint.TaintHelper;
import thaumcraft.common.entities.EntityFallingTaint;
import thaumcraft.common.lib.SoundsTC;
import thaumcraft.common.lib.utils.Utils;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Random;

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

    public static boolean canFallBelow(World world, BlockPos pos) {
        IBlockState bs = world.getBlockState(pos);
        Block l = bs.getBlock();

        for (int xx = -1; xx <= 1; ++xx) {
            for (int zz = -1; zz <= 1; ++zz) {
                for (int yy = -1; yy <= 1; ++yy) {
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
        for(Block taintedBlock: TAINTED_BLOCKS.get(getName())) {
            if(stage == nextStage) return taintedBlock;
            nextStage ++;
        }
        return this;
    }

    public String getName() {
        String registryName = this.getRegistryName().getPath();
        return registryName.substring(0, registryName.lastIndexOf("_"));
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
            if(!grow) {
                if(this.getStage() == 0) {
                    IBlockState state = defaultBlocks.get(this);
                    world.setBlockState(pos, state);
                    toRemove = true;
                } else {
                    IBlockState state = this.setStage(this.getStage() - 1).getDefaultState();
                    world.setBlockState(pos, state);
                    ChunkHandler.blocks.replace(pos, new BlockInfo(state.getBlock(), pos, world.getChunk(pos)));
                }
            }
            else {
                if(this.getStage() == 3) {
                    toRemove = true;
                } else {
                    IBlockState state = this.setStage(this.getStage() + 1).getDefaultState();
                    world.setBlockState(pos, state);
                    ChunkHandler.blocks.replace(pos, new BlockInfo(state.getBlock(), pos, world.getChunk(pos)));
                }
            }
            Chunk chunk = world.getChunk(pos);
            List<BlockPos> neighbours = ChunkHandler.blocks.get(pos).getNeighbours();
            for (BlockPos neighbourPos : neighbours) {
                Block block = world.getBlockState(neighbourPos).getBlock();
                if(block.getDefaultState().getMaterial().isLiquid() || block.isAir(block.getDefaultState(), world, neighbourPos)) continue;
                if (grow) {
                    TaintHelper.spreadFibres(world, neighbourPos);
                    if (block instanceof VRTTaintBlock) {
                        VRTTaintBlock taintBlock = (VRTTaintBlock) block;
                        if(taintBlock.getStage() == 3) {
                            ChunkHandler.blocks.remove(neighbourPos);
                            continue;
                        }
                        Block toReplace = TAINTED_BLOCKS.get(taintBlock.getName()).get(taintBlock.getStage() + 1);
                        BlockInfo blockInfo = new BlockInfo(toReplace, neighbourPos, chunk);
                        if(!blockInfo.hasHigher()) continue;
                        world.setBlockState(pos, toReplace.getDefaultState());
                        ChunkHandler.blocks.put(neighbourPos, blockInfo);
                    } else {
                        Block toReplace = reverseDefault.get(world.getBlockState(neighbourPos));
                        if(toReplace == null) continue;
                        world.setBlockState(neighbourPos, toReplace.getDefaultState());
                        ChunkHandler.blocks.put(neighbourPos, new BlockInfo(toReplace, neighbourPos, chunk));
                    }
                } else {
                    if (!(block instanceof VRTTaintBlock)) continue;
                    VRTTaintBlock taintBlock = (VRTTaintBlock) block;
                    if(taintBlock.getStage() == 0) {
                        IBlockState state = defaultBlocks.get(taintBlock);
                        world.setBlockState(neighbourPos, state);
                        ChunkHandler.blocks.remove(neighbourPos);
                        continue;
                    }
                    Block toReplace = TAINTED_BLOCKS.get(taintBlock.getName()).get(taintBlock.getStage() - 1);
                    if(toReplace == null) continue;
                    world.setBlockState(neighbourPos, toReplace.getDefaultState());
                    ChunkHandler.blocks.put(neighbourPos, new BlockInfo(block, neighbourPos, chunk));
                }
            }
            if(toRemove) {
                ChunkHandler.blocks.remove(pos);
            }
        }
    }

    public void updateVrtTick(World world, BlockPos pos) {
        if (!world.isRemote) {
            this.change(world, pos, !(RadiationHelper.getRadiationSource(world.getChunk(pos)).getRadiationLevel() > 0.001));
        }
    }

    public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
        return true;
    }

    public void onEntityWalk(World world, BlockPos pos, Entity entity) {
        if (!world.isRemote && entity instanceof EntityLivingBase && !((EntityLivingBase) entity).isEntityUndead() && world.rand.nextInt(250) == 0) {
            ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(PotionFluxTaint.instance, 200, 0, false, true));
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

    private boolean tryToFall(World world, BlockPos pos, BlockPos pos2) {
        if (!BlockTaintFibre.isOnlyAdjacentToTaint(world, pos)) {
            return false;
        } else {
            if (canFallBelow(world, pos2.down()) && pos2.getY() >= 0) {
                byte b0 = 32;
                if (world.isAreaLoaded(pos2.add(-b0, -b0, -b0), pos2.add(b0, b0, b0))) {
                    if (!world.isRemote) {
                        EntityFallingTaint entityfalling = new EntityFallingTaint(world, ((float) pos2.getX() + 0.5F), ((float) pos2.getY() + 0.5F), ((float) pos2.getZ() + 0.5F), world.getBlockState(pos), pos);
                        world.spawnEntity(entityfalling);
                        return true;
                    }
                } else {
                    world.setBlockToAir(pos);

                    BlockPos p2;
                    for (p2 = new BlockPos(pos2); canFallBelow(world, p2.down()) && p2.getY() > 0; p2 = p2.down()) ;
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