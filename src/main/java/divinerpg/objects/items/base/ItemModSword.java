package divinerpg.objects.items.base;

import java.util.List;

import javax.annotation.Nullable;

import divinerpg.Reference;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.ModItems;
import divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemModSword extends ItemSword  {

    private ToolMaterial material;

    public ItemModSword(ToolMaterial material, String name) {
        super(material);
        this.material = material;
        setRegistryName(Reference.MODID, name);
        setUnlocalizedName(name);
        setCreativeTab(DivineRPGTabs.swords);

        ModItems.ITEMS.add(this);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand handIn) {
        if (canUseSpecialEffect(player))
            this.useSpecialEffect(world, player);
        return super.onItemRightClick(world, player, handIn);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        if (canUseSpecialEffect(player))
            this.useSpecialEffect(player.world, player);
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack item, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        list.add(TooltipLocalizer.meleeDam(material.getAttackDamage() + 5));
        addAdditionalInformation(list);
        if (item.getMaxDamage() > 0) {
            list.add(TooltipLocalizer.usesRemaining(item.getMaxDamage() - item.getItemDamage()));
        } else {
            list.add(TooltipLocalizer.infiniteUses());
        }
    }

    protected boolean canUseSpecialEffect(EntityPlayer player) {
        return false;
    }

    protected void useSpecialEffect(World world, EntityPlayer player) {
    }

    protected void addAdditionalInformation(List<String> list) {
    }
}