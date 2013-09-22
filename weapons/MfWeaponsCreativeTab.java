package org.jglrxavpok.mods.weapons;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class MfWeaponsCreativeTab extends CreativeTabs
{

	public MfWeaponsCreativeTab(String label)
	{
		super(label);
	}
	
	@Override
	public ItemStack getIconItemStack()
	{
		return new ItemStack(ModWeapons.modInstance.flameThrower);
	}

}
