package divinerpg.objects.entities.assets.model.vanilla;

import org.lwjgl.opengl.GL11;

import divinerpg.objects.entities.entity.vanilla.JungleBat;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelJungleBat extends ModelBase {
	
    private ModelRenderer batHead;
    private ModelRenderer batBody;
    private ModelRenderer batRightWing;
    private ModelRenderer batLeftWing;
    private ModelRenderer batOuterRightWing;
    private ModelRenderer batOuterLeftWing;

    public ModelJungleBat() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.batHead = new ModelRenderer(this, 0, 0);
        this.batHead.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 6);
        ModelRenderer modelrenderer = new ModelRenderer(this, 24, 0);
        modelrenderer.addBox(-4.0F, -6.0F, -2.0F, 3, 4, 1);
        this.batHead.addChild(modelrenderer);
        ModelRenderer modelrenderer1 = new ModelRenderer(this, 24, 0);
        modelrenderer1.mirror = true;
        modelrenderer1.addBox(1.0F, -6.0F, -2.0F, 3, 4, 1);
        this.batHead.addChild(modelrenderer1);
        this.batBody = new ModelRenderer(this, 0, 16);
        this.batBody.addBox(-3.0F, 4.0F, -3.0F, 6, 12, 6);
        this.batBody.setTextureOffset(0, 34).addBox(-5.0F, 16.0F, 0.0F, 10, 6, 1);
        this.batRightWing = new ModelRenderer(this, 42, 0);
        this.batRightWing.addBox(-12.0F, 1.0F, 1.5F, 10, 16, 1);
        this.batOuterRightWing = new ModelRenderer(this, 24, 16);
        this.batOuterRightWing.setRotationPoint(-12.0F, 1.0F, 1.5F);
        this.batOuterRightWing.addBox(-8.0F, 1.0F, 0.0F, 8, 12, 1);
        this.batLeftWing = new ModelRenderer(this, 42, 0);
        this.batLeftWing.mirror = true;
        this.batLeftWing.addBox(2.0F, 1.0F, 1.5F, 10, 16, 1);
        this.batOuterLeftWing = new ModelRenderer(this, 24, 16);
        this.batOuterLeftWing.mirror = true;
        this.batOuterLeftWing.setRotationPoint(12.0F, 1.0F, 1.5F);
        this.batOuterLeftWing.addBox(0.0F, 1.0F, 0.0F, 8, 12, 1);
        this.batBody.addChild(this.batRightWing);
        this.batBody.addChild(this.batLeftWing);
        this.batRightWing.addChild(this.batOuterRightWing);
        this.batLeftWing.addChild(this.batOuterLeftWing);
    }

    public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
    	JungleBat entitybat = (JungleBat)par1Entity;
    	//EntityBat entitybat = (EntityBat)par1Entity;
        float f6;
        
        if (entitybat.getIsBatHanging()) {
            f6 = (180F / (float)Math.PI);
            GL11.glScaled(0.5, 0.5, 0.5);
            GL11.glTranslatef(0f, 2.5f, 0f);
            this.batHead.rotateAngleX = par6 / (180F / (float)Math.PI);
            this.batHead.rotateAngleY = (float)Math.PI - par5 / (180F / (float)Math.PI);
            this.batHead.rotateAngleZ = (float)Math.PI;
            this.batHead.setRotationPoint(0.0F, -2.0F, 0.0F);
            this.batRightWing.setRotationPoint(-3.0F, 0.0F, 3.0F);
            this.batLeftWing.setRotationPoint(3.0F, 0.0F, 3.0F);
            this.batBody.rotateAngleX = (float)Math.PI;
            this.batRightWing.rotateAngleX = -0.15707964F;
            this.batRightWing.rotateAngleY = -((float)Math.PI * 2F / 5F);
            this.batOuterRightWing.rotateAngleY = -1.7278761F;
            this.batLeftWing.rotateAngleX = this.batRightWing.rotateAngleX;
            this.batLeftWing.rotateAngleY = -this.batRightWing.rotateAngleY;
            this.batOuterLeftWing.rotateAngleY = -this.batOuterRightWing.rotateAngleY;
        } else {
            f6 = (180F / (float)Math.PI);
            GL11.glScaled(0.5, 0.5, 0.5);
            GL11.glTranslatef(0f, 1.75f, 0f);
            this.batHead.rotateAngleX = par6 / (180F / (float)Math.PI);
            this.batHead.rotateAngleY = par5 / (180F / (float)Math.PI);
            this.batHead.rotateAngleZ = 0.0F;
            this.batHead.setRotationPoint(0.0F, 0.0F, 0.0F);
            this.batRightWing.setRotationPoint(0.0F, 0.0F, 0.0F);
            this.batLeftWing.setRotationPoint(0.0F, 0.0F, 0.0F);
            this.batBody.rotateAngleX = ((float)Math.PI / 4F) + MathHelper.cos(par4 * 0.1F) * 0.15F;
            this.batBody.rotateAngleY = 0.0F;
            this.batRightWing.rotateAngleY = MathHelper.cos(par4 * 1.3F) * (float)Math.PI * 0.25F;
            this.batLeftWing.rotateAngleY = -this.batRightWing.rotateAngleY;
            this.batOuterRightWing.rotateAngleY = this.batRightWing.rotateAngleY * 0.5F;
            this.batOuterLeftWing.rotateAngleY = -this.batRightWing.rotateAngleY * 0.5F;
        }
        this.batHead.render(par7);
        this.batBody.render(par7);
    }
}