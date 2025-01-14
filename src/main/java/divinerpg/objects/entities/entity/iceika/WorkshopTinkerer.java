package divinerpg.objects.entities.entity.iceika;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.entity.EntityDivineRPGVillager;
import divinerpg.objects.entities.entity.InfiniteTrade;
import divinerpg.proxy.GUIHandler;
import divinerpg.registry.ModItems;
import divinerpg.utils.MessageLocalizer;
import divinerpg.utils.Utils;

public class WorkshopTinkerer extends EntityDivineRPGVillager {
    private static final String[] MESSAGE = { "message.merchant.ho", "message.merchant.out", "message.merchant.in",
            "message.merchant.burr" };

    public WorkshopTinkerer(World worldIn) {
        super(worldIn);
        this.setSize(1.0F, 2.0F);
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        if (!this.world.isRemote) {
            player.openGui(DivineRPG.instance, GUIHandler.WORKSHOP_TINKERER_GUI_ID, this.world, getEntityId(), 0, 0);
            CriteriaTriggers.VILLAGER_TRADE.trigger((EntityPlayerMP) player, this, ItemStack.EMPTY);
        }
        return super.processInteract(player, hand);
    }

    @Override
    public void extraInteract(EntityPlayer player) {
        player.sendMessage(Utils.getChatComponent(MessageLocalizer.normal("entity.workshop_tinkerer.name")
                + ": " + MessageLocalizer.normal(MESSAGE[rand.nextInt(4)])));
    }

    @Override
    public void addRecipies(MerchantRecipeList list) {
        list.addAll(getAllRecipies());
    }

    public static List<MerchantRecipe> getAllRecipies(){
        ArrayList<MerchantRecipe> list = new ArrayList<>();
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 1), new ItemStack(ModItems.shuriken, 16, 0),
                new ItemStack(ModItems.snowflakeShuriken, 16, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 4), new ItemStack(ModItems.serenadeStriker, 1, 0),
                new ItemStack(ModItems.serenadeOfIce, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 7), new ItemStack(ModItems.slimeSword, 1, 0),
                new ItemStack(ModItems.glacierSword, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 12), new ItemStack(ModItems.shadowBow, 1, 0),
                new ItemStack(ModItems.icicleBow, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 6), new ItemStack(ModItems.massivence, 1, 0),
                new ItemStack(ModItems.frossivence, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 12), new ItemStack(ModItems.crabclawCannon, 1, 0),
                new ItemStack(ModItems.frostclawCannon, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 12), new ItemStack(ModItems.frostCannon, 1, 0),
                new ItemStack(ModItems.fractiteCannon, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 15), new ItemStack(ModItems.frostSword, 1, 0),
                new ItemStack(ModItems.frostkingSword, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 18), new ItemStack(ModItems.soundOfMusic, 1, 0),
                new ItemStack(ModItems.soundOfCarols, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 25), new ItemStack(ModItems.enderSword, 1, 0),
                new ItemStack(ModItems.enderice, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 30), new ItemStack(ModItems.bluefireBow, 1, 0),
                new ItemStack(ModItems.snowstormBow, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 45), new ItemStack(ModItems.bedrockMaul, 1, 0),
                new ItemStack(ModItems.frozenMaul, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 40), new ItemStack(ModItems.divineSword, 1, 0),
                new ItemStack(ModItems.icineSword, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 15), new ItemStack(ModItems.sandslash, 1, 0),
                new ItemStack(ModItems.snowSlash, 1, 0)));
        return list;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return null;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return null;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return null;
    }
}
