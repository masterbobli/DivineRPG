package divinerpg.objects.entities.assets.render.iceika;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.iceika.ModelRollum;
import divinerpg.objects.entities.entity.iceika.Rollum;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderRollum extends RenderLiving<Rollum> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/rollum.png");

    public RenderRollum(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelRollum(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(Rollum entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<Rollum> {
        @Override
        public Render<? super Rollum> createRenderFor(RenderManager manager) {
            return new RenderRollum(manager, new ModelRollum(), 0F);
        }
    }
}