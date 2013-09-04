package skully.fma.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;


public class EntityKunaiEnder extends EntityThrowable {

    public EntityKunaiEnder(World par1World) {
        super(par1World);
    }

    public EntityKunaiEnder(World par1World, EntityLivingBase par2EntityLiving) {
        super(par1World, par2EntityLiving);
    }

    @SideOnly(Side.CLIENT)
    public EntityKunaiEnder(World par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    @Override
    protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
        for(int i = 0; i < 32; ++i) {
            this.worldObj.spawnParticle("portal", this.posX, this.posY + this.rand.nextDouble() * 2.0D, this.posZ,
                    this.rand.nextGaussian(), 0.0D, this.rand.nextGaussian());
        }

        if(!this.worldObj.isRemote) {
            if(this.getThrower() != null && this.getThrower() instanceof EntityPlayerMP) {
                EntityPlayerMP entityplayermp = (EntityPlayerMP)this.getThrower();

                if(!entityplayermp.playerNetServerHandler.connectionClosed && entityplayermp.worldObj == this.worldObj) {
                    EnderTeleportEvent event = new EnderTeleportEvent(entityplayermp, this.posX, this.posY, this.posZ, 5.0F);
                    if(!MinecraftForge.EVENT_BUS.post(event)) {
                        if(this.getThrower().isRiding()) {
                            this.getThrower().mountEntity((Entity)null);
                        }

                        this.getThrower().setPositionAndUpdate(event.targetX, event.targetY, event.targetZ);
                        this.getThrower().fallDistance = 0.0F;
                    }
                }
            }

            this.setDead();
        }
    }
}
