package org.jglrxavpok.mods.weapons;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityFlameThrowable extends EntityThrowable
{

	private double startX, startY, startZ;
	private EntityLivingBase	thrower;
	
	public EntityFlameThrowable(World par1World, EntityLivingBase par2EntityLivingBase)
	{
		super(par1World);
		this.thrower = par2EntityLivingBase;
		setSize(0.2f,0.2f);
		this.setLocationAndAngles(par2EntityLivingBase.posX, par2EntityLivingBase.posY + (double)par2EntityLivingBase.getEyeHeight(), par2EntityLivingBase.posZ, par2EntityLivingBase.rotationYaw, par2EntityLivingBase.rotationPitch);
		this.rotationYaw += rand.nextInt(5)-2.5;
		this.rotationPitch += rand.nextInt(5)-2.5;
		this.posX -= (double)(MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
		this.posY -= 0.10000000149011612D;
		this.posZ -= (double)(MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
		this.setPosition(this.posX, this.posY, this.posZ);
		this.yOffset = 0.0F;
		float f = 0.4F;
		this.motionX = (double)(-MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI) * f);
		this.motionZ = (double)(MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI) * f);
		this.motionY = (double)(-MathHelper.sin((this.rotationPitch + this.func_70183_g()) / 180.0F * (float)Math.PI) * f);
		this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, this.func_70182_d(), 2.0F);
		this.startX = posX;
		this.startY = posY;
		this.startZ = posZ;
		
	}

	public boolean canBeCollidedWith()
	{
		return true;
	}

	public float getCollisionBorderSize()
	{
		return 1.0F;
	}
	    
	@Override
	protected void onImpact(MovingObjectPosition mop)
	{
		if(this.isEntityAlive())
        {
			if(mop.typeOfHit == EnumMovingObjectType.ENTITY)
            {
                if (!mop.entityHit.isImmuneToFire() && mop.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, thrower), 5.0F))
                {
                    mop.entityHit.setFire(5);
                }
            }
            else if(mop.typeOfHit == EnumMovingObjectType.TILE)
            {
                int i = mop.blockX;
                int j = mop.blockY;
                int k = mop.blockZ;

                switch (mop.sideHit)
                {
                    case 0:
                        --j;
                        break;
                    case 1:
                        ++j;
                        break;
                    case 2:
                        --k;
                        break;
                    case 3:
                        ++k;
                        break;
                    case 4:
                        --i;
                        break;
                    case 5:
                        ++i;
                }

                if (this.worldObj.isAirBlock(i, j, k))
                {
                    this.worldObj.setBlock(i, j, k, Block.fire.blockID);
                }
                this.setDead();
            }

        }
	}
	
	public void onUpdate()
	{
		if(this.isEntityAlive())
		super.onUpdate();
		worldObj.spawnParticle("smoke", posX, posY, posZ, 0, 0.01, 0);
		if(this.isEntityAlive())

		if(Maths.dist((float)startX, (float)startY, (float)startZ, (float)posX, (float)posY, (float)posZ) > 3)
		{
			setDead();
		}
	}

}
