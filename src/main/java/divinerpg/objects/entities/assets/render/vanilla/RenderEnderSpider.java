package divinerpg.objects.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vanilla.ModelEnderSpider;
import divinerpg.objects.entities.entity.vanilla.EnderSpider;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderEnderSpider extends RenderLiving<EnderSpider> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/ender_spider.png");

    public RenderEnderSpider(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelEnderSpider(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EnderSpider entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EnderSpider> {
        @Override
        public Render<? super EnderSpider> createRenderFor(RenderManager manager) {
            return new RenderEnderSpider(manager, new ModelEnderSpider(), 0F);
        }
    }
}