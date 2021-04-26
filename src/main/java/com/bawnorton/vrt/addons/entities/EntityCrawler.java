package com.bawnorton.vrt.addons.entities;

import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityCrawler extends EntityCaveSpider {

    public EntityCrawler(World worldIn) {
        super(worldIn);
        this.setSize(1F, 1F);
        this.setAIMoveSpeed(10F);
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
