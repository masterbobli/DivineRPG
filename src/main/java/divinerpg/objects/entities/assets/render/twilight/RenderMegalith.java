package divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.twilight.ModelMegalith;
import divinerpg.objects.entities.entity.twilight.Megalith;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderMegalith extends RenderLiving<Megalith> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/Megalith.png");

    public RenderMegalith(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelMegalith(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(Megalith entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<Megalith> {
        @Override
        public Render<? super Megalith> createRenderFor(RenderManager manager) {
            return new RenderMegalith(manager, new ModelMegalith(), 0);
        }
    }
}