package divinerpg.registry;

import divinerpg.Reference;
import divinerpg.client.render.*;
import divinerpg.objects.blocks.vanilla.BlockAyeracoBeam;
import divinerpg.objects.blocks.vanilla.BlockAyeracoSpawn;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(value=Side.CLIENT, modid=Reference.MODID)
public class ModModels {

    @SubscribeEvent
    public static void registerItemModels(ModelRegistryEvent event) {
        for (Item item : ModItems.ITEMS) {
            registerModel(item);
        }

        Item air = Item.getItemFromBlock(Blocks.AIR);
        for (Block block : ModBlocks.BLOCKS) {
            Item itemBlock = Item.getItemFromBlock(block);
            if(!itemBlock.equals(air)) {
                registerModel(itemBlock);
            }
        }

        registerTESRs();
    }

    public static void registerModel(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

    public static void registerTESRs() {
        /*
          This is more efficient than doing it during the loop, since we directly register them instead of checking if every single item is one of these.
          Still may be another way though
        */
        Item.getItemFromBlock(ModBlocks.boneChest).setTileEntityItemStackRenderer(new RenderItemBoneChest());
        Item.getItemFromBlock(ModBlocks.edenChest).setTileEntityItemStackRenderer(new RenderItemEdenChest());
        Item.getItemFromBlock(ModBlocks.frostedChest).setTileEntityItemStackRenderer(new RenderItemFrostedChest());
        Item.getItemFromBlock(ModBlocks.presentBox).setTileEntityItemStackRenderer(new RenderItemPresentBox());
        Item.getItemFromBlock(ModBlocks.demonFurnace).setTileEntityItemStackRenderer(new RenderItemDemonFurnace());
        Item.getItemFromBlock(ModBlocks.arcaniumExtractor).setTileEntityItemStackRenderer(new RenderItemArcaniumExtractor());
        Item.getItemFromBlock(ModBlocks.dramixAltar).setTileEntityItemStackRenderer(new RenderItemDramixAltar());
        Item.getItemFromBlock(ModBlocks.parasectaAltar).setTileEntityItemStackRenderer(new RenderItemParasectaAltar());
        Item.getItemFromBlock(ModBlocks.frostedChest).setTileEntityItemStackRenderer(new RenderItemFrostedChest());
        Item.getItemFromBlock(ModBlocks.ancientEntityStatue).setTileEntityItemStackRenderer(new RenderItemStatue());
        Item.getItemFromBlock(ModBlocks.ayeracoStatue).setTileEntityItemStackRenderer(new RenderItemStatue());
        Item.getItemFromBlock(ModBlocks.densosStatue).setTileEntityItemStackRenderer(new RenderItemStatue());
        Item.getItemFromBlock(ModBlocks.dramixStatue).setTileEntityItemStackRenderer(new RenderItemStatue());
        Item.getItemFromBlock(ModBlocks.eternalArcherStatue).setTileEntityItemStackRenderer(new RenderItemStatue());
        Item.getItemFromBlock(ModBlocks.karotStatue).setTileEntityItemStackRenderer(new RenderItemStatue());
        Item.getItemFromBlock(ModBlocks.kingOfScorchersStatue).setTileEntityItemStackRenderer(new RenderItemStatue());
        Item.getItemFromBlock(ModBlocks.parasectaStatue).setTileEntityItemStackRenderer(new RenderItemStatue());
        Item.getItemFromBlock(ModBlocks.soulFiendStatue).setTileEntityItemStackRenderer(new RenderItemStatue());
        Item.getItemFromBlock(ModBlocks.reyvorStatue).setTileEntityItemStackRenderer(new RenderItemStatue());
        Item.getItemFromBlock(ModBlocks.theWatcherStatue).setTileEntityItemStackRenderer(new RenderItemStatue());
        Item.getItemFromBlock(ModBlocks.twilightDemonStatue).setTileEntityItemStackRenderer(new RenderItemStatue());
        Item.getItemFromBlock(ModBlocks.vamacheronStatue).setTileEntityItemStackRenderer(new RenderItemStatue());
    }


}