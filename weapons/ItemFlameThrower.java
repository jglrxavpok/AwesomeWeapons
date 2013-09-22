package org.jglrxavpok.mods.weapons;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class ItemFlameThrower extends Item
{

	private boolean	on;
	private Icon	icon;

	public ItemFlameThrower(int par1)
	{
		super(par1);
		setCreativeTab(ModWeapons.modInstance.mfWeapons);
		this.setMaxStackSize(1);
		this.setMaxDamage(1000);
	}
	
	public ItemStack onItemRightClick(ItemStack stack, World w, EntityPlayer player)
	{
		player.setItemInUse(stack, 720000);

		return stack;
	}
	
	public boolean canHarvestBlock(Block par1Block)
    {
        return false;
    }
	
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
	{
		return EnumAction.bow;
	}
	
	public Icon getIcon(ItemStack stack, int pass)
	{
		return icon;
	}
	
	public Icon getIconFromDamage(int d)
	{
		return icon;
	}
	
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
	{
		return 0.0f;
	}
	
	public boolean onEntitySwing(EntityLivingBase living, ItemStack stack)
	{
		if(stack.getItemDamage() < stack.getMaxDamage())
		{
			for(int j = 0;j<10;j++)
			{
				EntityKnocker flame = new EntityKnocker(living.worldObj, living);
				if (!living.worldObj.isRemote)
	            {
					living.worldObj.spawnEntityInWorld(flame);
	            }
			}
			stack.setItemDamage(stack.getItemDamage()+50);
		}

		return true;
	}
	
	public void registerIcons(IconRegister r)
	{
		icon = r.registerIcon("xavpoksweapons:flamethrower");
	}
	
	public void onUpdate(ItemStack stack, World w, Entity ent, int i, boolean flag)
	{
//		super.onUpdate(stack, w, ent, i, flag);
		if(((EntityPlayer)ent).getItemInUse() != null && ((EntityPlayer)ent).getItemInUse().itemID == ModWeapons.modInstance.flameThrower.itemID && flag)
		{
			if(stack.getItemDamage() < stack.getMaxDamage())
			{
				for(int j = 0;j<10;j++)
				{
					EntityFlameThrowable flame = new EntityFlameThrowable(w, (EntityPlayer)ent);
					if (!w.isRemote)
		            {
						w.spawnEntityInWorld(flame);
		            }
				}
				stack.setItemDamage(stack.getItemDamage()+4);
			}
		}
		else
		{
			if(stack.getItemDamage() > 0)
			{
				stack.setItemDamage(stack.getItemDamage()-5);
			}
		}
	}
	
	public void onPlayerStoppedUsing(ItemStack stack, World w, EntityPlayer player, int i)
	{
	}

}
