package divinerpg.objects.entities.entity.vanilla;

import javax.annotation.Nullable;

import divinerpg.Reference;
import divinerpg.objects.entities.entity.EntityDivineRPGMob;
import divinerpg.registry.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Kobblin extends EntityDivineRPGMob {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/vanilla/kobblin");
    private static final DataParameter<Boolean> PROVOKED = EntityDataManager.<Boolean>createKey(Kobblin.class,
            DataSerializers.BOOLEAN);

    public Kobblin(World worldIn) {
        super(worldIn);
        this.setSize(0.75F, 1F);
    }

    @Override
    public float getEyeHeight() {
        return 0.9F;
    }

    @Override
    public void entityInit() {
        super.entityInit();
        dataManager.register(PROVOKED, Boolean.valueOf(false));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(35.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(7.0D);
    }

    public boolean needsSpecialAI() {
        return true;
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 1;
    }

    @Override
    public void addVelocity(double x, double y, double z) {
        if (this.getProvoked())
            super.addVelocity(x, y, z);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (!getProvoked()) {
            this.renderYawOffset = 0;
            EntityPlayer player = this.world.getNearestAttackablePlayer(this, 4.0D, 4.0D);
            if (player != null) {
                this.setProvoked(player);
                this.motionY = 0.6;
            }
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound tag) {
        super.writeEntityToNBT(tag);
        tag.setBoolean("Provoked", this.getProvoked());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound tag) {
        super.readEntityFromNBT(tag);
        if (tag.getBoolean("Provoked"))
            setProvoked(null);
    }

    public boolean getProvoked() {
        return dataManager.get(PROVOKED).booleanValue();
    }

    @Nullable
    public void setProvoked(EntityPlayer player) {
        dataManager.set(PROVOKED, Boolean.valueOf(true));
        addBasicAI();
        addAttackingAI();
        if (player != null && !player.capabilities.isCreativeMode) {
            this.setAttackTarget(player);
        }
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        Entity entity = source.getTrueSource();
        if (entity instanceof EntityPlayer && !getProvoked()) {
            EntityPlayer player = (EntityPlayer) entity;
            this.setProvoked(player);
            this.motionY = 0.6;
        }
        return super.attackEntityFrom(source, amount);
    }

    @Override
    protected boolean isValidLightLevel() {
        return true;
    }

    @Override
    protected void playStepSound(BlockPos pos, Block blockIn) {
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.KOBBLIN;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.KOBBLIN;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }

    @Override
    public boolean getCanSpawnHere() {
        return world.provider.getDimension() == 0
                && this.world.getBlockState(getPosition().down()).getBlock() == Blocks.GRASS
                && this.world.getBlockState(getPosition().down(2)).getBlock() != Blocks.AIR && super.getCanSpawnHere();
    }
}
