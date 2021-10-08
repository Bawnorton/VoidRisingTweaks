package com.bawnorton.vrt.addons.items;

import com.bawnorton.vrt.addons.entities.bosses.BossBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.Random;

public class BossSummonItem extends VRTItemBase {
    Random r = new Random(System.currentTimeMillis());
    public static float scale = 1F;
    public BossSummonItem(String name) {
        super(name);
        this.setMaxDamage(1);
        this.setMaxStackSize(1);
    }
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack item = playerIn.getHeldItem(handIn);
        Vec3d aim = playerIn.getLookVec();
        scale = r.nextFloat() * 9F + 1F;
        BossBase boss = new BossBase(worldIn);
        boss.setPositionAndRotation(playerIn.posX + aim.x * 1.5D, playerIn.posY + aim.y * 1.5D, playerIn.posZ + aim.z * 1.5D, -playerIn.rotationYaw, 0F);
        if(!worldIn.isRemote) {
            worldIn.spawnEntity(boss);
        }
        item.damageItem(2, playerIn);
        return new ActionResult<>(EnumActionResult.SUCCESS, item);
    }
}
