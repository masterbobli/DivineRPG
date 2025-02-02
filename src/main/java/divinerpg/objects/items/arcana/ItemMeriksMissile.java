package divinerpg.objects.items.arcana;

import java.util.List;

import javax.annotation.Nullable;

import divinerpg.capabilities.ArcanaProvider;
import divinerpg.capabilities.IArcana;
import divinerpg.objects.entities.entity.projectiles.EntityMerikMissile;
import divinerpg.objects.items.base.ItemMod;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.ModItems;
import divinerpg.registry.ModSounds;
import divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMeriksMissile extends ItemMod {
    public static final int MAX_USE_DURATION = 72000;

    public ItemMeriksMissile(String name) {
        super(name, DivineRPGTabs.ranged);
        this.maxStackSize = 1;
        this.setMaxDamage(-1);
        this.addPropertyOverride(new ResourceLocation("pull"), new IItemPropertyGetter() {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
                if (entityIn == null) {
                    return 0.0F;
                } else {
                    return !(entityIn.getActiveItemStack().getItem() instanceof ItemMeriksMissile) ? 0.0F :
                            (float) (MAX_USE_DURATION - entityIn.getItemInUseCount()) / 20.0F;
                }
            }
        });
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World world, EntityLivingBase entityLiving, int timeLeft) {
        if (stack.getItem() == ModItems.meriksMissile && entityLiving instanceof EntityPlayer) {
            float charge = (float) (MAX_USE_DURATION - timeLeft) / 20.0F;
            EntityPlayer player = (EntityPlayer) entityLiving;
            IArcana arcana = player.getCapability(ArcanaProvider.ARCANA_CAP, null);

            if (charge > 1.0) {
                charge = 1.0F;
            }
            float arcanaPoints = 50.0F * charge;

            if (arcana.getArcana() >= arcanaPoints && !world.isRemote) {
                if (charge < 0.2F)
                    return;

                float damage = MathHelper.clamp(charge * 25F, 8F, 25F);

                world.playSound(null, player.getPosition(), ModSounds.VETHEA_BOW, SoundCategory.MASTER, 1, 1);

                EntityMerikMissile bullet = new EntityMerikMissile(world, player, damage);
                bullet.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
                world.spawnEntity(bullet);
                arcana.consume(player, arcanaPoints);
            }
        }
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        player.setActiveHand(hand);
        return super.onItemRightClick(world, player, hand);
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return MAX_USE_DURATION;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        list.add("Explosive homing projectile");
        list.add(TooltipLocalizer.bowDam("8-25"));
        list.add(TooltipLocalizer.arcanaConsumed("10-50"));
        list.add(TooltipLocalizer.infiniteUses());
    }
}