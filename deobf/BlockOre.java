//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package techreborn.blocks;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import prospector.shootingstar.ShootingStar;
import prospector.shootingstar.model.ModelCompound;
import reborncore.common.blocks.PropertyString;
import reborncore.common.registration.RebornRegistry;
import reborncore.common.registration.impl.ConfigRegistry;
import reborncore.common.util.ArrayUtils;
import reborncore.common.util.OreDrop;
import reborncore.common.util.StringUtils;
import techreborn.events.TRRecipeHandler;
import techreborn.init.ModBlocks;
import techreborn.items.ingredients.ItemDusts;
import techreborn.items.ingredients.ItemGems;
import techreborn.utils.TechRebornCreativeTab;
import techreborn.world.config.IOreNameProvider;

@RebornRegistry(
    modID = "techreborn"
)
public class BlockOre extends Block implements IOreNameProvider {
    public static final String[] ores = new String[]{"galena", "iridium", "ruby", "sapphire", "bauxite", "pyrite", "cinnabar", "sphalerite", "tungsten", "sheldonite", "peridot", "sodalite", "lead", "silver"};
    public static List<String> oreNamesList;
    public static final PropertyString VARIANTS;
    @ConfigRegistry(
        config = "misc",
        category = "blocks",
        key = "rubyMinQuatity",
        comment = "Minimum quantity of Ruby gems per Ruby ore"
    )
    public static int rubyMinQuatity;
    @ConfigRegistry(
        config = "misc",
        category = "blocks",
        key = "rubyMaxQuantity",
        comment = "Maximum quantity of Ruby gems per Ruby ore"
    )
    public static int rubyMaxQuantity;
    @ConfigRegistry(
        config = "misc",
        category = "blocks",
        key = "sapphireMinQuantity",
        comment = "Minimum quantity of Sapphire gems per Sapphire ore"
    )
    public static int sapphireMinQuantity;
    @ConfigRegistry(
        config = "misc",
        category = "blocks",
        key = "sapphireMaxQuantity",
        comment = "Maximum quantity of Sapphire gems per Sapphire ore"
    )
    public static int sapphireMaxQuantity;
    @ConfigRegistry(
        config = "misc",
        category = "blocks",
        key = "pyriteMinQuatity",
        comment = "Minimum quantity of Pyrite dust per Pyrite ore"
    )
    public static int pyriteMinQuatity;
    @ConfigRegistry(
        config = "misc",
        category = "blocks",
        key = "pyriteMaxQuantity",
        comment = "Maximum quantity of Pyrite dust per Pyrite ore"
    )
    public static int pyriteMaxQuantity;
    @ConfigRegistry(
        config = "misc",
        category = "blocks",
        key = "sodaliteMinQuatity",
        comment = "Minimum quantity of Sodalite dust per Sodalite ore"
    )
    public static int sodaliteMinQuatity;
    @ConfigRegistry(
        config = "misc",
        category = "blocks",
        key = "sodaliteMaxQuantity",
        comment = "Maximum quantity of Sodalite dust per Sodalite ore"
    )
    public static int sodaliteMaxQuantity;
    @ConfigRegistry(
        config = "misc",
        category = "blocks",
        key = "cinnabarMinQuatity",
        comment = "Minimum quantity of Cinnabar dust per Cinnabar ore"
    )
    public static int cinnabarMinQuatity;
    @ConfigRegistry(
        config = "misc",
        category = "blocks",
        key = "cinnabarMaxQuantity",
        comment = "Maximum quantity of Cinnabar dust per Cinnabar ore"
    )
    public static int cinnabarMaxQuantity;
    @ConfigRegistry(
        config = "misc",
        category = "blocks",
        key = "sphaleriteMinQuatity",
        comment = "Minimum quantity of Sphalerite dust per Sphalerite ore"
    )
    public static int sphaleriteMinQuatity;
    @ConfigRegistry(
        config = "misc",
        category = "blocks",
        key = "sphaleriteMaxQuantity",
        comment = "Maximum quantity of Sphalerite dust per Sphalerite ore"
    )
    public static int sphaleriteMaxQuantity;

    public BlockOre() {
        super(Material.ROCK);
        this.setCreativeTab(TechRebornCreativeTab.instance);
        this.setHardness(2.0F);
        this.setHarvestLevel("pickaxe", 2);
        this.setDefaultState(this.getStateFromMeta(0));

        for(int i = 0; i < ores.length; ++i) {
            ShootingStar.registerModel((new ModelCompound("techreborn", this, i, new IProperty[0])).setInvVariant("type=" + OreBlockStateManager.convert(ores[i])).setFileName("ores"));
        }

        TRRecipeHandler.hideEntry(this);
    }

    public static ItemStack getOreByName(String name, int count) {
        name = OreBlockStateManager.invert(name);

        for(int i = 0; i < ores.length; ++i) {
            if (ores[i].equalsIgnoreCase(name)) {
                return new ItemStack(ModBlocks.ORE, count, i);
            }
        }

        return BlockOre2.getOreByName(name, count);
    }

    public static ItemStack getOreByName(String name) {
        return getOreByName(name, 1);
    }

    public IBlockState getBlockStateFromName(String name) {
        name = OreBlockStateManager.invert(name);
        int index = -1;

        for(int i = 0; i < ores.length; ++i) {
            if (ores[i].equalsIgnoreCase(name)) {
                index = i;
                break;
            }
        }

        return index == -1 ? ModBlocks.ORE2.getBlockStateFromName(name) : this.getStateFromMeta(index);
    }

    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        String variant = (String)state.getValue(VARIANTS);
        int meta = this.getMetaFromState(state);
        Random random = new Random();
        OreDrop sphalerite;
        if (variant.equalsIgnoreCase("Ruby")) {
            sphalerite = new OreDrop(ItemGems.getGemByName("ruby", rubyMinQuatity), rubyMaxQuantity);
            drops.add(sphalerite.getDrops(fortune, random));
        } else if (variant.equalsIgnoreCase("Sapphire")) {
            sphalerite = new OreDrop(ItemGems.getGemByName("sapphire", sapphireMinQuantity), sapphireMaxQuantity);
            drops.add(sphalerite.getDrops(fortune, random));
        } else if (variant.equalsIgnoreCase("Pyrite")) {
            sphalerite = new OreDrop(ItemDusts.getDustByName("pyrite", pyriteMinQuatity), pyriteMaxQuantity);
            drops.add(sphalerite.getDrops(fortune, random));
        } else if (variant.equalsIgnoreCase("Sodalite")) {
            sphalerite = new OreDrop(ItemDusts.getDustByName("sodalite", sodaliteMinQuatity), sodaliteMaxQuantity);
            drops.add(sphalerite.getDrops(fortune, random));
        } else if (variant.equalsIgnoreCase("Cinnabar")) {
            sphalerite = new OreDrop(ItemDusts.getDustByName("cinnabar", cinnabarMinQuatity), cinnabarMaxQuantity);
            drops.add(sphalerite.getDrops(fortune, random));
        } else if (variant.equalsIgnoreCase("Sphalerite")) {
            sphalerite = new OreDrop(ItemDusts.getDustByName("sphalerite", sphaleriteMinQuatity), sphaleriteMaxQuantity);
            drops.add(sphalerite.getDrops(fortune, random));
        } else {
            drops.add(new ItemStack(Item.getItemFromBlock(this), 1, meta));
        }

    }

    protected boolean canSilkHarvest() {
        return true;
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(CreativeTabs creativeTabs, NonNullList<ItemStack> list) {
        for(int meta = 0; meta < ores.length; ++meta) {
            list.add(new ItemStack(this, 1, meta));
        }

    }

    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        return new ItemStack(this, 1, this.getMetaFromState(state));
    }

    public int damageDropped(IBlockState state) {
        return this.getMetaFromState(state);
    }

    public IBlockState getStateFromMeta(int meta) {
        if (meta > ores.length) {
            meta = 0;
        }

        return this.getBlockState().getBaseState().withProperty(VARIANTS, (Comparable)oreNamesList.get(meta));
    }

    public int getMetaFromState(IBlockState state) {
        return oreNamesList.indexOf(state.getValue(VARIANTS));
    }

    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[]{VARIANTS});
    }

    public String getUserLoclisedName(IBlockState state) {
        return StringUtils.toFirstCapital((String)oreNamesList.get(this.getMetaFromState(state)));
    }

    public static PropertyString getVarients() {
        if (OreBlockStateManager.endOreStone) {
            oreNamesList = (List)oreNamesList.stream().map(OreBlockStateManager::convert).collect(Collectors.toList());
            return new PropertyString("type", oreNamesList);
        } else {
            return new PropertyString("type", oreNamesList);
        }
    }

    static {
        oreNamesList = Lists.newArrayList(ArrayUtils.arrayToLowercase(ores));
        VARIANTS = getVarients();
        rubyMinQuatity = 1;
        rubyMaxQuantity = 2;
        sapphireMinQuantity = 1;
        sapphireMaxQuantity = 2;
        pyriteMinQuatity = 1;
        pyriteMaxQuantity = 2;
        sodaliteMinQuatity = 1;
        sodaliteMaxQuantity = 2;
        cinnabarMinQuatity = 1;
        cinnabarMaxQuantity = 2;
        sphaleriteMinQuatity = 1;
        sphaleriteMaxQuantity = 2;
    }
}
