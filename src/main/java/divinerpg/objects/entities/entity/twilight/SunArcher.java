package divinerpg.objects.entities.entity.twilight;

import divinerpg.Reference;
import divinerpg.enums.ArrowType;
import divinerpg.objects.entities.entity.EntityDivineRPGMob;
import divinerpg.objects.entities.entity.projectiles.EntityDivineArrow;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class SunArcher extends EntityDivineRPGMob implements IRangedAttackMob {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/twilight/sun_archer");

    public SunArcher(World worldIn) {
        super(worldIn);
        this.setSize(0.8F, 2.2F);
    }

    @Override
    public float getEyeHeight() {
        return 2.0F;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(60);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(9);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        addAttackingAI();
        this.tasks.addTask(0, new EntityAIAttackRanged(this, 0.27F, 50, 10));
    }

    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEFINED;
    }

    @Override
    public boolean isValidLightLevel() {
        return true;
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase target, float f) {
        this.world
                .spawnEntity(new EntityDivineArrow(this.world, ArrowType.SUN_ARCHER_ARROW, this, target, 1.6F, 12.0F));
    }

    @Override
    public void setSwingingArms(boolean swingingArms) {
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_ZOMBIE_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_ZOMBIE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_ZOMBIE_DEATH;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }
}