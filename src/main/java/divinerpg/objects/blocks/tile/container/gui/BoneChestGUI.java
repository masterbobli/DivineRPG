package divinerpg.objects.blocks.tile.container.gui;

import divinerpg.Reference;
import divinerpg.objects.blocks.tile.container.ContainerModChest;
import divinerpg.objects.blocks.tile.entity.TileEntityModChest;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class BoneChestGUI extends GuiContainer {
    private static final ResourceLocation GUI_BONE_CHEST = new ResourceLocation(
            Reference.MODID + ":textures/gui/bone_chest_gui.png");
    private final InventoryPlayer playerInventory;
    private final TileEntityModChest te;

    public BoneChestGUI(InventoryPlayer playerInventory, TileEntityModChest chestInventory, EntityPlayer player) {
        super(new ContainerModChest(playerInventory, chestInventory, player));
        this.playerInventory = playerInventory;
        this.te = chestInventory;

        this.ySize = 168;
        this.xSize = 176;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String tileName = this.te.getDisplayName().getUnformattedComponentText();
        this.fontRenderer.drawString(tileName, (this.xSize / 2 - this.fontRenderer.getStringWidth(tileName) / 2) + 0, 6,
                16777215);
        this.fontRenderer.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 94,
                16777215);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1, 1, 1, 1);
        this.mc.getTextureManager().bindTexture(GUI_BONE_CHEST);
        drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
    }
}
