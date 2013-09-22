package org.jglrxavpok.mods.weapons;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.TickType;

public class ClientTickHandler extends ServerTickHandler
{


	private ResourceLocation mask = new ResourceLocation("xavpoksweapons", "textures/blur/pyroMaskOverlay.png");
	private EntityPlayerSP	player;
	
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) 
	{
		final Minecraft minecraft = FMLClientHandler.instance().getClient();
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData)
	{
		final Minecraft minecraft = FMLClientHandler.instance().getClient();
		if(type.equals(EnumSet.of(TickType.CLIENT)))
		{
			
			player = minecraft.thePlayer;
		}
		if (type.equals(EnumSet.of(TickType.RENDER)))
		{
			if(player != null)
			{
				if(minecraft.gameSettings.thirdPersonView == 0 && minecraft.currentScreen == null)
				if(player.getCurrentArmor(3) != null && player.getCurrentArmor(3).itemID == ModWeapons.modInstance.pyroMask.itemID)
					renderTextureOverlay(mask,1f);
			}
		}
	}

	public static void renderTextureOverlay(ResourceLocation s, float f)
	{
		Minecraft minecraft = FMLClientHandler.instance().getClient();
		ScaledResolution scaledresolution = new ScaledResolution(minecraft.gameSettings, minecraft.displayWidth, minecraft.displayHeight);
		int i = scaledresolution.getScaledWidth();
		int j = scaledresolution.getScaledHeight();
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(false);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, f);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		minecraft.renderEngine.func_110577_a(s);
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV(0.0D, j, -90D, 0.0D, 1.0D);
		tessellator.addVertexWithUV(i, j, -90D, 1.0D, 1.0D);
		tessellator.addVertexWithUV(i, 0.0D, -90D, 1.0D, 0.0D);
		tessellator.addVertexWithUV(0.0D, 0.0D, -90D, 0.0D, 0.0D);
		tessellator.draw();
		GL11.glDepthMask(true);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, f);
	}
	
	@Override
	public EnumSet<TickType> ticks() 
	{
		return EnumSet.of(TickType.RENDER, TickType.CLIENT);
	}

	@Override
	public String getLabel() 
	{
		return "TickClientHandler";
	}
}