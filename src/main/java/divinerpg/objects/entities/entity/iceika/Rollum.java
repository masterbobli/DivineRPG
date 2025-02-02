package divinerpg.objects.entities.entity.iceika;

import divinerpg.Reference;
import divinerpg.objects.entities.entity.EntityDivineRPGMob;
import divinerpg.registry.ModSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class Rollum extends EntityDivineRPGMob {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/iceika/rollum");

    public Rollum(World worldIn) {
        super(worldIn);
        setSize(1.2F, 2.0F);
    }

    @Override
    public float getEyeHeight() {
        return 1.4F;
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        addAttackingAI();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(180.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.27D / 1.2D);
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        super.attackEntityAsMob(entity);
        entity.addVelocity(this.motionX * 3.0D, 0.3D, this.motionZ * 3.0D);
        return true;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.ROLLUM;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.ROLLUM_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.ROLLUM_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }
}
