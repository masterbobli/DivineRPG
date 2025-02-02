package divinerpg.objects.entities.entity.vanilla;

import divinerpg.objects.entities.entity.EntityDivineRPGTameable;
import divinerpg.objects.entities.entity.IAttackTimer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class Smelter extends EntityDivineRPGTameable implements IAttackTimer {
    private static final DataParameter<Integer> ATTACK_TIMER = EntityDataManager.<Integer>createKey(Smelter.class,
            DataSerializers.VARINT);

    public Smelter(World worldIn) {
        super(worldIn);
        this.setSize(1.5F, 3.5F);
        this.isImmuneToFire = true;
    }

    public Smelter(World worldIn, EntityPlayer player) {
        this(worldIn);
        setTamedBy(player);
    }

    @Override
    public float getEyeHeight() {
        return 3.2F;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(120.0D);
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        dataManager.register(ATTACK_TIMER, Integer.valueOf(0));
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (getAttackTimer() > 0) {
            this.dataManager.set(ATTACK_TIMER, Integer.valueOf(getAttackTimer() - 1));
        }
    }

    @Override
    public int getAttackTimer() {
        return this.dataManager.get(ATTACK_TIMER).intValue();
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        ItemStack itemstack = player.getHeldItem(hand);

        if (this.isTamed()) {
            if (!itemstack.isEmpty() && itemstack.getItem() == Items.FLINT && this.getHealth() < 20.0D) {
                if (!player.capabilities.isCreativeMode) {
                    itemstack.shrink(1);
                }
                this.heal(4.0F);
                return true;
            }
        } else {
            setTamedBy(player);
            this.playTameEffect(true);
        }

        return super.processInteract(player, hand);
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        boolean attack = entity.attackEntityFrom(DamageSource.causeMobDamage(this), 7.0F);
        if (attack) {
            entity.addVelocity(-MathHelper.sin(this.rotationYaw * (float) Math.PI / 180.0F), 0.1D,
                    MathHelper.cos(this.rotationYaw * (float) Math.PI / 180.0F));
            entity.setFire(5);
            this.dataManager.set(ATTACK_TIMER, Integer.valueOf(10));
        }
        return attack;
    }

    @Override
    public EntityAgeable createChild(EntityAgeable var1) {
        return null;
    }
}
