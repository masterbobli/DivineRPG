package divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.twilight.ModelGreenfeet;
import divinerpg.objects.entities.entity.twilight.Greenfeet;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderGreenfeet extends RenderLiving<Greenfeet> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/greenfeet.png");

    public RenderGreenfeet(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelGreenfeet(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(Greenfeet entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<Greenfeet> {
        @Override
        public Render<? super Greenfeet> createRenderFor(RenderManager manager) {
            return new RenderGreenfeet(manager, new ModelGreenfeet(), 0);
        }
    }
}