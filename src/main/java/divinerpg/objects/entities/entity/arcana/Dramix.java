package divinerpg.objects.entities.entity.arcana;

import divinerpg.Reference;
import divinerpg.objects.entities.entity.EntityDivineRPGBoss;
import divinerpg.registry.ModSounds;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class Dramix extends EntityDivineRPGBoss {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/arcana/dramix");

    public Dramix(World world) {
        super(world);
        setSize(0.85f, 3);
        this.isImmuneToFire = true;
    }

    @Override
    public float getEyeHeight() {
        return 2.7F;
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        addAttackingAI();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1400.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(30.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1);
    }

    @Override
    public void onLivingUpdate() {
        if (this.ticksExisted % 600 < 300) {
            this.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 5, 0, true, false));
        }
        super.onLivingUpdate();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.DRAMIX;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource s) {
        return ModSounds.DRAMIX_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.DRAMIX_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }
}
