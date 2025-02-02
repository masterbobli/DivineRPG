package divinerpg.objects.entities.entity.twilight;

import divinerpg.Reference;
import divinerpg.enums.BulletType;
import divinerpg.objects.entities.entity.EntityDivineRPGBoss;
import divinerpg.objects.entities.entity.projectiles.EntityTwilightDemonShot;
import divinerpg.registry.ModSounds;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class TwilightDemon extends EntityDivineRPGBoss {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID,
            "entities/twilight/twilight_demon");
    int shooting;

    public TwilightDemon(World worldIn) {
        super(worldIn);
        this.setSize(2.0F, 4.0F);
    }

    @Override
    public float getEyeHeight() {
        return 3.5F;
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 40.0F, 50));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1600);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(30);
    }

    @Override
    public int getTotalArmorValue() {
        return 10;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (!this.world.isRemote) {
            if (this.ticksExisted % 160 == 0)
                this.shooting = 100;
            this.setAttackTarget(this.world.getNearestAttackablePlayer(this, 40.0D, 40.0D));
            if (this.getAttackTarget() != null && this.shooting > 0) {
                double tx = this.getAttackTarget().posX - this.posX;
                double ty = this.getAttackTarget().getEntityBoundingBox().minY - this.posY - 2;
                double tz = this.getAttackTarget().posZ - this.posZ;
                double angle = Math.atan(-(tx) / (tz));
                EntityTwilightDemonShot e = new EntityTwilightDemonShot(this.world, this, this.rand.nextInt(50) == 0 ?
                        BulletType.TWILIGHT_DEMON_RED_SHOT : BulletType.TWILIGHT_DEMON_BLACK_SHOT);
                e.posZ += Math.sin(angle);
                e.posX += Math.cos(angle);
                e.shoot(tx - Math.cos(angle), ty, tz - Math.sin(angle), 1.6f, 0);
                this.world.spawnEntity(e);

                EntityTwilightDemonShot e1 = new EntityTwilightDemonShot(this.world, this, this.rand.nextInt(50) == 0 ?
                        BulletType.TWILIGHT_DEMON_RED_SHOT : BulletType.TWILIGHT_DEMON_BLACK_SHOT);
                e1.posZ -= Math.sin(angle);
                e1.posX -= Math.cos(angle);
                e1.shoot(tx + Math.cos(angle), ty, tz + Math.sin(angle), 1.6f, 0);
                this.world.spawnEntity(e1);
            }
            if (this.shooting > 0) {
                this.shooting--;
            }
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.INSECT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.INSECT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }
}
