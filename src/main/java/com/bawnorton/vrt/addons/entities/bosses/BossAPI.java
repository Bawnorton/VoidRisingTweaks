package com.bawnorton.vrt.addons.entities.bosses;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.World;

public class BossAPI extends EntityMob {

    private final BossInfoServer bossInfo = (BossInfoServer)(new BossInfoServer(this.getDisplayName(), BossInfo.Color.PURPLE, BossInfo.Overlay.PROGRESS)).setDarkenSky(true);
    private static final DataParameter<Integer> INVULNERABILITY_TIME = EntityDataManager.createKey(BossAPI.class, DataSerializers.VARINT);
    public float scaleFactor;

    public BossAPI(World worldIn) {
        super(worldIn);
        this.scaleFactor = 4F;
        setSize(0.6F * scaleFactor, 1.95F * scaleFactor);
        this.bossInfo.setName(new TextComponentString("Test Boss"));
    }

    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(INVULNERABILITY_TIME, 0);
    }

    public int getInvulTime() {
        return this.dataManager.get(INVULNERABILITY_TIME);
    }
    public void setInvulTime(int time) {
        this.dataManager.set(INVULNERABILITY_TIME, time);
    }

    @Override
    protected void updateAITasks() {
        if(this.getInvulTime() > 0) {
            this.setInvulTime(this.getInvulTime() - 1);
        }
        super.updateAITasks();
        this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
    }

    @Override
    public void removeTrackingPlayer(EntityPlayerMP player) {
        super.removeTrackingPlayer(player);
        this.bossInfo.removePlayer(player);
    }

    @Override
    public void addTrackingPlayer(EntityPlayerMP player) {
        super.addTrackingPlayer(player);
        this.bossInfo.addPlayer(player);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(200D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10D);
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

    @Override
    public boolean isNonBoss() {
        return false;
    }
}
