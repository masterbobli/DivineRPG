package divinerpg.objects.entities.entity.projectiles;

import java.util.ArrayList;
import java.util.List;

import divinerpg.objects.entities.assets.render.projectiles.RenderCorruptedBullet;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityCorruptedBullet extends EntityThrowable {
    public static float damage = 10.0F;
    private List<Entity> toExcludeList = new ArrayList<>();

    @SideOnly(Side.CLIENT)
    public static void renderMe() {
        RenderingRegistry.registerEntityRenderingHandler(EntityCorruptedBullet.class,
                manager -> new RenderCorruptedBullet(manager, 1f));
    }

    public EntityCorruptedBullet(World var1) {
        super(var1);
    }

    public EntityCorruptedBullet(World var1, EntityLivingBase var2) {
        super(var1, var2);

        Vec3d vector = var2.getLookVec().scale(1.5);
        this.setPosition(posX + vector.x, posY + vector.y, posZ + vector.z);
    }

    public EntityCorruptedBullet(World var1, double var2, double var4, double var6) {
        super(var1, var2, var4, var6);
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if (result.entityHit != null) {
            if (!this.toExcludeList.contains(result.entityHit))
                result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), damage);
            List<Entity> surrounding = this.world.getEntitiesWithinAABBExcludingEntity(this,
                    this.getEntityBoundingBox().expand(1, 1, 1));
            for (Entity e : surrounding) {
                if (e instanceof EntityCorruptedBullet)
                    ((EntityCorruptedBullet) e).toExcludeList.add(result.entityHit);
            }
        }

        if (!this.world.isRemote) {
            this.setDead();
        }
    }
}