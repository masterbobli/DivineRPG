package divinerpg.objects.blocks.tile.container.gui;

import divinerpg.Reference;
import divinerpg.objects.blocks.tile.container.ContainerModChest;
import divinerpg.objects.blocks.tile.entity.TileEntityModChest;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

/**
 * Created by LiteWolf101 on Feb /01/2019
 */
public class PresentBoxGUI extends GuiContainer {
    private static final ResourceLocation GUI_PRESENT_BOX = new ResourceLocation(
            Reference.MODID + ":textures/gui/present_box_gui.png");
    private final InventoryPlayer playerInventory;
    private final TileEntityModChest te;

    public PresentBoxGUI(InventoryPlayer playerInventory, TileEntityModChest chestInventory, EntityPlayer player) {
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
                704255);
        this.fontRenderer.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 94,
                704255);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1, 1, 1, 1);
        this.mc.getTextureManager().bindTexture(GUI_PRESENT_BOX);
        drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
    }
}
