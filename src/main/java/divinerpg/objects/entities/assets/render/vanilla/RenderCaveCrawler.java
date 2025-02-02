package divinerpg.objects.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vanilla.ModelCrawler;
import divinerpg.objects.entities.entity.vanilla.CaveCrawler;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderCaveCrawler extends RenderLiving<CaveCrawler> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/cave_crawler.png");

    public RenderCaveCrawler(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelCrawler(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(CaveCrawler entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<CaveCrawler> {
        @Override
        public Render<? super CaveCrawler> createRenderFor(RenderManager manager) {
            return new RenderCaveCrawler(manager, new ModelCrawler(), 0F);
        }
    }
}