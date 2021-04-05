//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package thaumcraft.common.blocks.world.taint;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
import thaumcraft.api.aura.AuraHelper;
import thaumcraft.api.blocks.BlocksTC;
import thaumcraft.api.internal.WeightedRandomLoot;
import thaumcraft.api.potions.PotionFluxTaint;
import thaumcraft.common.blocks.BlockTC;
import thaumcraft.common.config.ConfigItems;
import thaumcraft.common.entities.EntityFallingTaint;
import thaumcraft.common.entities.monster.tainted.EntityTaintSwarm;
import thaumcraft.common.lib.SoundsTC;
import thaumcraft.common.lib.utils.EntityUtils;
import thaumcraft.common.lib.utils.Utils;

public class BlockTaint extends BlockTC implements ITaintBlock {
    static Random r = new Random(System.currentTimeMillis());
    static ArrayList<WeightedRandomLoot> pdrops = null;

    public BlockTaint(String name) {
        super(ThaumcraftMaterials.MATERIAL_TAINT, name);
        this.setHardness(10.0F);
        this.setResistance(100.0F);
        this.setSoundType(SoundsTC.GORE);
        this.setTickRandomly(true);
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

    public void die(World world, BlockPos pos, IBlockState state) {
        if (state.getBlock() == BlocksTC.taintRock) {
            world.setBlockState(pos, BlocksTC.stonePorous.getDefaultState());
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

    public void updateTick(World world, BlockPos pos, IBlockState state, Random random) {
        if (!world.isRemote) {
            if (!TaintHelper.isNearTaintSeed(world, pos) && random.nextInt(10) == 0) {
                this.die(world, pos, state);
                return;
            }

            if (state.getBlock() == BlocksTC.taintRock) {
                TaintHelper.spreadFibres(world, pos);
            }

            if (state.getBlock() == BlocksTC.taintCrust) {
                new Random(pos.toLong());
                if (this.tryToFall(world, pos, pos)) {
                    return;
                }

                if (world.isAirBlock(pos.up())) {
                    boolean doIt = true;
                    EnumFacing dir = EnumFacing.HORIZONTALS[random.nextInt(4)];

                    for(int a = 1; a < 4; ++a) {
                        if (!world.isAirBlock(pos.offset(dir).down(a))) {
                            doIt = false;
                            break;
                        }

                        if (world.getBlockState(pos.down(a)).getBlock() != this) {
                            doIt = false;
                            break;
                        }
                    }

                    if (doIt && this.tryToFall(world, pos, pos.offset(dir))) {
                        return;
                    }
                }
            } else if (state.getBlock() == BlocksTC.taintGeyser) {
                if ((double)world.rand.nextFloat() < 0.2D && world.isAnyPlayerWithinRangeAt((double)((float)pos.getX() + 0.5F), (double)((float)pos.getY() + 0.5F), (double)((float)pos.getZ() + 0.5F), 32.0D) && EntityUtils.getEntitiesInRange(world, pos, (Entity)null, EntityTaintSwarm.class, 32.0D).isEmpty()) {
                    Entity e = new EntityTaintSwarm(world);
                    e.setLocationAndAngles((double)((float)pos.getX() + 0.5F), (double)((float)pos.getY() + 1.25F), (double)((float)pos.getZ() + 0.5F), (float)world.rand.nextInt(360), 0.0F);
                    world.spawnEntity(e);
                } else if (AuraHelper.getFlux(world, pos) < 2.0F) {
                    AuraHelper.polluteAura(world, pos, 0.25F, true);
                }
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
                worldIn.playSound((EntityPlayer)null, pos, SoundEvents.BLOCK_CHORUS_FLOWER_DEATH, SoundCategory.BLOCKS, 0.1F, 0.9F + worldIn.rand.nextFloat() * 0.2F);
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
        } else if (l == BlocksTC.fluxGoo && (Integer)bs.getValue(BlockFluidFinite.LEVEL) >= 4) {
            return false;
        } else if (l != Blocks.FIRE && l != BlocksTC.taintFibre) {
            if (l.isReplaceable(world, pos)) {
                return true;
            } else {
                return bs.getMaterial() == Material.WATER ? true : bs.getMaterial() == Material.LAVA;
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
                        EntityFallingTaint entityfalling = new EntityFallingTaint(world, (double)((float)pos2.getX() + 0.5F), (double)((float)pos2.getY() + 0.5F), (double)((float)pos2.getZ() + 0.5F), world.getBlockState(pos), pos);
                        world.spawnEntity(entityfalling);
                        return true;
                    }
                } else {
                    world.setBlockToAir(pos);

                    BlockPos p2;
                    for(p2 = new BlockPos(pos2); canFallBelow(world, p2.down()) && p2.getY() > 0; p2 = p2.down()) {
                    }

                    if (p2.getY() > 0) {
                        world.setBlockState(p2, BlocksTC.taintCrust.getDefaultState());
                    }
                }
            }

            return false;
        }
    }

    public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        if (state.getBlock() == this && state.getBlock() == BlocksTC.taintRock) {
            int rr = r.nextInt(15) + fortune;
            if (rr > 13) {
                List<ItemStack> ret = new ArrayList();
                ret.add(ConfigItems.FLUX_CRYSTAL.copy());
                return ret;
            }
        }

        return super.getDrops(world, pos, state, fortune);
    }

    protected boolean canSilkHarvest() {
        return false;
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemById(0);
    }
}
