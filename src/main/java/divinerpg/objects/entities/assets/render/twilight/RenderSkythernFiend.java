package divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.twilight.ModelSkythernFiend;
import divinerpg.objects.entities.entity.twilight.SkythernFiend;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderSkythernFiend extends RenderLiving<SkythernFiend> {

    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/skythern_fiend.png");

    public RenderSkythernFiend(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelSkythernFiend(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(SkythernFiend entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<SkythernFiend> {
        @Override
        public Render<? super SkythernFiend> createRenderFor(RenderManager manager) {
            return new RenderSkythernFiend(manager, new ModelSkythernFiend(), 0);
        }
    }
}