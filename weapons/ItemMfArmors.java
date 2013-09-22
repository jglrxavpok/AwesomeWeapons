package org.jglrxavpok.mods.weapons;

import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemMfArmors extends ItemArmor
{
	public ItemMfArmors(int id, EnumArmorMaterial armorMaterial, int type, int layer)
	{
		super(id, armorMaterial, type, layer);
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
	{
		if(stack.itemID == ModWeapons.modInstance.pyroMask.itemID)
		{
			return "xavpoksWeapons:textures/models/armor/pyroMask.png";
		}
		return "missing";
	}
}