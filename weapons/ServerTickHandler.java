package org.jglrxavpok.mods.weapons;

import java.util.ArrayList;
import java.util.EnumSet;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ServerTickHandler implements ITickHandler
{
	public void tickStart(EnumSet<TickType> type, Object... tickData)
	{
		if (type.equals(EnumSet.of(TickType.PLAYER)))
		{
			onPlayerTick((EntityPlayer)tickData[0]);
		}
	}

	public void tickEnd(EnumSet<TickType> type, Object... tickData)
	{
		onTickInGame();
	}

	public void onTickInGame()
	{
		
	}

	public EnumSet<TickType> ticks()
	{
		return EnumSet.of(TickType.PLAYER, TickType.SERVER);
	}
	
	@Override
	public String getLabel() 
	{
		return null;
	}

	public void onPlayerTick(EntityPlayer player)
	{
	   
	}
	

}