package divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.twilight.ModelSoulStealer;
import divinerpg.objects.entities.entity.twilight.SoulStealer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderSoulStealer extends RenderLiving<SoulStealer> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/soul_stealer.png");

    public RenderSoulStealer(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelSoulStealer(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(SoulStealer entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<SoulStealer> {
        @Override
        public Render<? super SoulStealer> createRenderFor(RenderManager manager) {
            return new RenderSoulStealer(manager, new ModelSoulStealer(), 0);
        }
    }
}