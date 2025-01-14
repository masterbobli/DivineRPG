package divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.twilight.ModelSoulSpider;
import divinerpg.objects.entities.entity.twilight.SoulSpider;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderSoulSpider extends RenderLiving<SoulSpider> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/soul_spider.png");

    public RenderSoulSpider(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelSoulSpider(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(SoulSpider entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<SoulSpider> {
        @Override
        public Render<? super SoulSpider> createRenderFor(RenderManager manager) {
            return new RenderSoulSpider(manager, new ModelSoulSpider(), 0);
        }
    }
}