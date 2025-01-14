package divinerpg.objects.items.arcana;

import java.util.List;

import divinerpg.capabilities.ArcanaProvider;
import divinerpg.capabilities.IArcana;
import divinerpg.objects.items.base.ItemModSword;
import divinerpg.utils.ToolMaterialMod;
import divinerpg.utils.TooltipLocalizer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemArcaniteBlade extends ItemModSword {

    public ItemArcaniteBlade() {
        super(ToolMaterialMod.ArcaniteBlade, "arcanite_blade");
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        IArcana arcana = player.getCapability(ArcanaProvider.ARCANA_CAP, null);
        if (!player.world.isRemote && arcana.getArcana() >= 12)
            arcana.consume(player, 12);
        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public void addAdditionalInformation(List list) {
        list.add(TooltipLocalizer.arcanaConsumed(12));
    }
}