package divinerpg.objects.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import divinerpg.objects.entities.entity.vanilla.HellPig;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelPig;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderHellPig extends RenderLiving<HellPig> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation hellPigLoc = new ResourceLocation("divinerpg:textures/entity/hell_pig.png");
    ResourceLocation madHellPigLoc = new ResourceLocation("divinerpg:textures/entity/mad_hell_pig.png");
    ResourceLocation tamedHellPigLoc = new ResourceLocation("divinerpg:textures/entity/tamed_hell_pig.png");

    public RenderHellPig(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelPig(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(HellPig hellPig) {
        return hellPig.isTamed() ? tamedHellPigLoc : (hellPig.isAngry() ? madHellPigLoc : hellPigLoc);
    }

    public static class Factory implements IRenderFactory<HellPig> {
        @Override
        public Render<? super HellPig> createRenderFor(RenderManager manager) {
            return new RenderHellPig(manager, new ModelPig(), 0F);
        }
    }
}