package divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.twilight.ModelSoulFiend;
import divinerpg.objects.entities.entity.twilight.SoulFiend;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderSoulFiend extends RenderLiving<SoulFiend> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/soul_fiend.png");

    public RenderSoulFiend(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelSoulFiend(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(SoulFiend entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<SoulFiend> {
        @Override
        public Render<? super SoulFiend> createRenderFor(RenderManager manager) {
            return new RenderSoulFiend(manager, new ModelSoulFiend(), 0);
        }
    }
}