package divinerpg.proxy;

import javax.annotation.Nullable;

import divinerpg.objects.blocks.tile.container.ContainerAltarOfCorruption;
import divinerpg.objects.blocks.tile.container.ContainerModChest;
import divinerpg.objects.blocks.tile.container.ContainerModFurnace;
import divinerpg.objects.blocks.tile.container.gui.AltarOfCorruptionGUI;
import divinerpg.objects.blocks.tile.container.gui.ArcaniumExtractorGUI;
import divinerpg.objects.blocks.tile.container.gui.BoneChestGUI;
import divinerpg.objects.blocks.tile.container.gui.CoalstoneFurnaceGUI;
import divinerpg.objects.blocks.tile.container.gui.DemonFurnaceGUI;
import divinerpg.objects.blocks.tile.container.gui.EdenChestGUI;
import divinerpg.objects.blocks.tile.container.gui.FrostedChestGUI;
import divinerpg.objects.blocks.tile.container.gui.GreenlightFurnaceGUI;
import divinerpg.objects.blocks.tile.container.gui.MoltenFurnaceGUI;
import divinerpg.objects.blocks.tile.container.gui.MoonlightFurnaceGUI;
import divinerpg.objects.blocks.tile.container.gui.OceanfireFurnaceGUI;
import divinerpg.objects.blocks.tile.container.gui.PresentBoxGUI;
import divinerpg.objects.blocks.tile.container.gui.WhitefireFurnaceGUI;
import divinerpg.objects.blocks.tile.entity.TileEntityAltarOfCorruption;
import divinerpg.objects.blocks.tile.entity.TileEntityBoneChest;
import divinerpg.objects.blocks.tile.entity.TileEntityEdenChest;
import divinerpg.objects.blocks.tile.entity.TileEntityFrostedChest;
import divinerpg.objects.blocks.tile.entity.TileEntityModChest;
import divinerpg.objects.blocks.tile.entity.TileEntityModFurnace;
import divinerpg.objects.blocks.tile.entity.TileEntityPresentBox;
import divinerpg.objects.entities.container.gui.GuiCaptainMerik;
import divinerpg.objects.entities.container.gui.GuiDatticon;
import divinerpg.objects.entities.container.gui.GuiJackOMan;
import divinerpg.objects.entities.container.gui.GuiLeorna;
import divinerpg.objects.entities.container.gui.GuiLivestockMerchant;
import divinerpg.objects.entities.container.gui.GuiLordVatticus;
import divinerpg.objects.entities.container.gui.GuiTheHunger;
import divinerpg.objects.entities.container.gui.GuiWarGeneral;
import divinerpg.objects.entities.container.gui.GuiWorkshopMerchant;
import divinerpg.objects.entities.container.gui.GuiWorkshopTinkerer;
import divinerpg.objects.entities.container.gui.GuiZelus;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerMerchant;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GUIHandler implements IGuiHandler {
    public static final int COALSTONE_FURNACE_GUI_ID = 0;
    public static final int MOLTEN_FURNACE_GUI_ID = 1;
    public static final int OCEANFIRE_FURNACE_GUI_ID = 2;
    public static final int WHITEFIRE_FURNACE_GUI_ID = 3;
    public static final int DEMON_FURNACE_GUI_ID = 4;
    public static final int FROSTED_CHEST_GUI_ID = 5;
    public static final int WORKSHOP_MERCHANT_GUI_ID = 6;
    public static final int WORKSHOP_TINKERER_GUI_ID = 7;
    public static final int JACK_O_MAN_GUI_ID = 8;
    public static final int LIVESTOCK_MERCHANT_GUI_ID = 9;
    public static final int THE_HUNGER_GUI_ID = 10;
    public static final int PRESENT_BOX_GUI_ID = 11;
    public static final int BONE_CHEST_GUI_ID = 12;
    public static final int ALTAR_OF_CORRUPTION_GUI_ID = 13;
    public static final int EDEN_CHEST_GUI_ID = 14;
    public static final int CAPTAIN_MERIK_GUI_ID = 15;
    public static final int DATTICON_GUI_ID = 16;
    public static final int LEORNA_GUI_ID = 17;
    public static final int VATICUS_GUI_ID = 18;
    public static final int WAR_GENERAL_GUI_ID = 19;
    public static final int ZELUS_GUI_ID = 20;
    public static final int GREENLIGHT_FURNACE_GUI_ID = 21;
    public static final int MOONLIGHT_FURNACE_GUI_ID = 22;
    public static final int ARCANIUM_EXTRACTOR_GUI_ID = 23;

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == COALSTONE_FURNACE_GUI_ID) {
            return new CoalstoneFurnaceGUI(player.inventory,
                    (TileEntityModFurnace) world.getTileEntity(new BlockPos(x, y, z)));
        } else if (ID == MOLTEN_FURNACE_GUI_ID) {
            return new MoltenFurnaceGUI(player.inventory,
                    (TileEntityModFurnace) world.getTileEntity(new BlockPos(x, y, z)));
        } else if (ID == OCEANFIRE_FURNACE_GUI_ID) {
            return new OceanfireFurnaceGUI(player.inventory,
                    (TileEntityModFurnace) world.getTileEntity(new BlockPos(x, y, z)));
        } else if (ID == WHITEFIRE_FURNACE_GUI_ID) {
            return new WhitefireFurnaceGUI(player.inventory,
                    (TileEntityModFurnace) world.getTileEntity(new BlockPos(x, y, z)));
        } else if (ID == DEMON_FURNACE_GUI_ID) {
            return new DemonFurnaceGUI(player.inventory,
                    (TileEntityModFurnace) world.getTileEntity(new BlockPos(x, y, z)));
        } else if (ID == FROSTED_CHEST_GUI_ID) {
            return new FrostedChestGUI(player.inventory,
                    (TileEntityFrostedChest) world.getTileEntity(new BlockPos(x, y, z)), player);
        } else if (ID == WORKSHOP_MERCHANT_GUI_ID) {
            return new GuiWorkshopMerchant(player.inventory, (IMerchant) world.getEntityByID(x), world);
        } else if (ID == WORKSHOP_TINKERER_GUI_ID) {
            return new GuiWorkshopTinkerer(player.inventory, (IMerchant) world.getEntityByID(x), world);
        } else if (ID == JACK_O_MAN_GUI_ID) {
            return new GuiJackOMan(player.inventory, (IMerchant) world.getEntityByID(x), world);
        } else if (ID == LIVESTOCK_MERCHANT_GUI_ID) {
            return new GuiLivestockMerchant(player.inventory, (IMerchant) world.getEntityByID(x), world);
        } else if (ID == THE_HUNGER_GUI_ID) {
            return new GuiTheHunger(player.inventory, (IMerchant) world.getEntityByID(x), world);
        } else if (ID == PRESENT_BOX_GUI_ID) {
            return new PresentBoxGUI(player.inventory,
                    (TileEntityPresentBox) world.getTileEntity(new BlockPos(x, y, z)), player);
        } else if (ID == BONE_CHEST_GUI_ID) {
            return new BoneChestGUI(player.inventory, (TileEntityBoneChest) world.getTileEntity(new BlockPos(x, y, z)),
                    player);
        } else if (ID == ALTAR_OF_CORRUPTION_GUI_ID) {
            return new AltarOfCorruptionGUI(player.inventory, world,
                    (TileEntityAltarOfCorruption) world.getTileEntity(new BlockPos(x, y, z)));
        } else if (ID == EDEN_CHEST_GUI_ID) {
            return new EdenChestGUI(player.inventory, (TileEntityEdenChest) world.getTileEntity(new BlockPos(x, y, z)),
                    player);
        } else if (ID == CAPTAIN_MERIK_GUI_ID) {
            return new GuiCaptainMerik(player.inventory, (IMerchant) world.getEntityByID(x), world);
        } else if (ID == DATTICON_GUI_ID) {
            return new GuiDatticon(player.inventory, (IMerchant) world.getEntityByID(x), world);
        } else if (ID == LEORNA_GUI_ID) {
            return new GuiLeorna(player.inventory, (IMerchant) world.getEntityByID(x), world);
        } else if (ID == VATICUS_GUI_ID) {
            return new GuiLordVatticus(player.inventory, (IMerchant) world.getEntityByID(x), world);
        } else if (ID == WAR_GENERAL_GUI_ID) {
            return new GuiWarGeneral(player.inventory, (IMerchant) world.getEntityByID(x), world);
        } else if (ID == ZELUS_GUI_ID) {
            return new GuiZelus(player.inventory, (IMerchant) world.getEntityByID(x), world);
        } else if (ID == GREENLIGHT_FURNACE_GUI_ID) {
            return new GreenlightFurnaceGUI(player.inventory,
                    (TileEntityModFurnace) world.getTileEntity(new BlockPos(x, y, z)));
        } else if (ID == MOONLIGHT_FURNACE_GUI_ID) {
            return new MoonlightFurnaceGUI(player.inventory,
                    (TileEntityModFurnace) world.getTileEntity(new BlockPos(x, y, z)));
        } else if (ID == ARCANIUM_EXTRACTOR_GUI_ID) {
            return new ArcaniumExtractorGUI(player.inventory,
                    (TileEntityModFurnace) world.getTileEntity(new BlockPos(x, y, z)));
        }
        return null;
    }

    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == COALSTONE_FURNACE_GUI_ID || ID == MOLTEN_FURNACE_GUI_ID || ID == OCEANFIRE_FURNACE_GUI_ID
                || ID == WHITEFIRE_FURNACE_GUI_ID || ID == DEMON_FURNACE_GUI_ID || ID == GREENLIGHT_FURNACE_GUI_ID
                || ID == MOONLIGHT_FURNACE_GUI_ID || ID == ARCANIUM_EXTRACTOR_GUI_ID) {
            return new ContainerModFurnace(player.inventory,
                    (TileEntityModFurnace) world.getTileEntity(new BlockPos(x, y, z)));
        } else if (ID == FROSTED_CHEST_GUI_ID || ID == PRESENT_BOX_GUI_ID || ID == BONE_CHEST_GUI_ID
                || ID == EDEN_CHEST_GUI_ID) {
            return new ContainerModChest(player.inventory,
                    (TileEntityModChest) world.getTileEntity(new BlockPos(x, y, z)), player);
        } else if (ID == WORKSHOP_MERCHANT_GUI_ID || ID == WORKSHOP_TINKERER_GUI_ID || ID == JACK_O_MAN_GUI_ID
                || ID == LIVESTOCK_MERCHANT_GUI_ID || ID == CAPTAIN_MERIK_GUI_ID || ID == DATTICON_GUI_ID
                || ID == LEORNA_GUI_ID || ID == VATICUS_GUI_ID || ID == WAR_GENERAL_GUI_ID || ID == ZELUS_GUI_ID
                || ID == THE_HUNGER_GUI_ID) {
            return new ContainerMerchant(player.inventory, (IMerchant) world.getEntityByID(x), world);
        } else if (ID == ALTAR_OF_CORRUPTION_GUI_ID) {
            return new ContainerAltarOfCorruption(player.inventory, world, new BlockPos(x, y, z));
        }
        return null;
    }
}
