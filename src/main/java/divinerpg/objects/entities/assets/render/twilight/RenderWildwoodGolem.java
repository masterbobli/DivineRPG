package divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.twilight.ModelTwilightGolem;
import divinerpg.objects.entities.entity.twilight.WildwoodGolem;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderWildwoodGolem extends RenderLiving<WildwoodGolem> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/wildwood_golem.png");

    public RenderWildwoodGolem(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelTwilightGolem(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(WildwoodGolem entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<WildwoodGolem> {
        @Override
        public Render<? super WildwoodGolem> createRenderFor(RenderManager manager) {
            return new RenderWildwoodGolem(manager, new ModelTwilightGolem(), 0);
        }
    }
}