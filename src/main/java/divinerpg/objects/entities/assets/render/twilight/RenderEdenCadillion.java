package divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.twilight.ModelCadillion;
import divinerpg.objects.entities.entity.twilight.EdenCadillion;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderEdenCadillion extends RenderLiving<EdenCadillion> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/eden_cadillion.png");

    public RenderEdenCadillion(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelCadillion(), 1F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EdenCadillion entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EdenCadillion> {
        @Override
        public Render<? super EdenCadillion> createRenderFor(RenderManager manager) {
            return new RenderEdenCadillion(manager, new ModelCadillion(), 0.5F);
        }
    }
}