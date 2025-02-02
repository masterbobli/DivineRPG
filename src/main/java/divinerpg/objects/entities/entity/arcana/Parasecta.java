package divinerpg.objects.entities.entity.arcana;

import divinerpg.Reference;
import divinerpg.objects.entities.entity.EntityDivineRPGBoss;
import divinerpg.registry.ModSounds;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.BossInfo.Color;
import net.minecraft.world.World;

public class Parasecta extends EntityDivineRPGBoss {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/arcana/parasecta");
    private BlockPos currentFlightTarget;

    public Parasecta(World world) {
        super(world);
        this.setSize(1.3F, 3F);
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
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1000.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(16.0D);
    }

    @Override
    public Color getBarColor() {
        return Color.YELLOW;
    }

    @Override
    protected float getSoundVolume() {
        return 0.1F;
    }

    @Override
    protected float getSoundPitch() {
        return super.getSoundPitch() * 0.95F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return this.rand.nextInt(4) != 0 ? null : ModSounds.PARASECTA;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource s) {
        return ModSounds.PARASECTA_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.PARASECTA_HURT;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        this.motionY *= 0.6000000238418579D;
    }

    @Override
    protected void updateAITasks() {
        super.updateAITasks();

        if (this.getAttackTarget() != null) {
            int x = (int) this.getAttackTarget().posX;
            int y = (int) this.getAttackTarget().posY;
            int z = (int) this.getAttackTarget().posZ;
            this.currentFlightTarget = new BlockPos(x, y, z);
        }

        this.motionY = 0;

        if (this.currentFlightTarget != null) {
            double x = this.currentFlightTarget.getX() - this.posX;
            double y = this.currentFlightTarget.getY() - this.posY;
            double z = this.currentFlightTarget.getZ() - this.posZ;

            if (Math.signum(x) != 0 || Math.signum(y) != 0 || Math.signum(z) != 0) {
                this.motionX += (Math.signum(x) * 0.5D - this.motionX) * 0.10000000149011612D;
                this.motionY += (Math.signum(y) * 1.699999988079071D - this.motionY) * 0.10000000149011612D;
                this.motionZ += (Math.signum(z) * 0.5D - this.motionZ) * 0.10000000149011612D;
                float var7 = (float) (Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
                float var8 = MathHelper.wrapDegrees(var7 - this.rotationYaw);
                this.moveForward = 0.5F;
                this.rotationYaw += var8;
            }
        }
    }

    @Override
    public void fall(float distance, float damageMultiplier) {
    }

    @Override
    protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos) {
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }
}