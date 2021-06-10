package com.bawnorton.vrt.addons.entities;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityCrawler extends EntityCaveSpider {

    public EntityCrawler(World worldIn) {
        super(worldIn);
        this.setSize(2.8F, 1.8F);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5D);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return super.getAmbientSound();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return super.getHurtSound(damageSourceIn);
    }

    @Override
    protected SoundEvent getDeathSound() {
        return super.getDeathSound();
    }

}
