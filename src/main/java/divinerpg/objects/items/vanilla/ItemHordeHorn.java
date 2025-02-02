package divinerpg.objects.items.vanilla;

import divinerpg.objects.items.base.ItemMod;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.ModBlocks;
import divinerpg.registry.ModSounds;
import divinerpg.utils.log.Logging;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemHordeHorn extends ItemMod {

    public ItemHordeHorn(String name) {
        super(name);
        this.setMaxDamage(1);
        this.setMaxStackSize(1);
        this.setCreativeTab(DivineRPGTabs.spawner);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing,
            float hitX, float hitY, float hitZ) {
        ItemStack itemstack = player.getHeldItem(hand);
        if (world.provider.getDimension() != 1){

            if (!world.isRemote)
                Logging.message(player, TextFormatting.AQUA + "The Ayeraco Horde can only be spawned in The End");
        } else {
            pos = pos.add(facing.getFrontOffsetX(), facing.getFrontOffsetY(), facing.getFrontOffsetZ());
            if (world.getBlockState(pos) == Blocks.AIR.getDefaultState()) {
                world.playSound(null, pos, ModSounds.AYERACO_SPAWN, SoundCategory.MASTER, 20.0F, 1.0F);
                world.setBlockState(pos, ModBlocks.ayeracoSpawn.getDefaultState());

                if (!player.capabilities.isCreativeMode){
                    itemstack.shrink(1);
                }

                return EnumActionResult.SUCCESS;
            }
        }
        return EnumActionResult.FAIL;
    }
}