package divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.twilight.ModelCadillion;
import divinerpg.objects.entities.entity.twilight.WildwoodCadillion;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderWildwoodCadillion extends RenderLiving<WildwoodCadillion> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/wildwood_cadillion.png");

    public RenderWildwoodCadillion(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelCadillion(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(WildwoodCadillion entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<WildwoodCadillion> {
        @Override
        public Render<? super WildwoodCadillion> createRenderFor(RenderManager manager) {
            return new RenderWildwoodCadillion(manager, new ModelCadillion(), 0);
        }
    }
}