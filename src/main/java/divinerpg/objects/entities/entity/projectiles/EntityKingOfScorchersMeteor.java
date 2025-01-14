package divinerpg.objects.entities.entity.projectiles;

import java.util.List;

import divinerpg.objects.entities.assets.render.projectiles.RenderKingofScorchersMeteor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityKingOfScorchersMeteor extends EntityThrowable {

    public EntityKingOfScorchersMeteor(World par1World) {
        super(par1World);
    }

    public EntityKingOfScorchersMeteor(World par1World, EntityLivingBase e) {
        super(par1World, e);
    }

    public EntityKingOfScorchersMeteor(World par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    @SideOnly(Side.CLIENT)
    public static void renderMe() {
        RenderingRegistry.registerEntityRenderingHandler(EntityKingOfScorchersMeteor.class,
                manager -> new RenderKingofScorchersMeteor(manager, 1f));
    }

    @Override
    public float getGravityVelocity() {
        return 0;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (!world.isRemote) {
            if (this.ticksExisted > 200)
                this.setDead();
            List<Entity> l = this.world.getEntitiesWithinAABB(EntityPlayer.class, this.getEntityBoundingBox());
            if (l.size() > 0) {
                this.world.createExplosion(this, posX, posY, posZ, 3.0F, false);
                this.setDead();
            }
        }
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if (!world.isRemote) {
            if (result.entityHit != null) {
                this.world.createExplosion(result.entityHit, posX, posY, posZ, 3.0F, false);
                this.setDead();
            } else {
                this.motionX = this.motionY = this.motionZ = 0;
            }
        }
    }
}