package org.jglrxavpok.mods.weapons;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderKnocker extends Render
{

	@Override
	public void doRender(Entity entity, double d0, double d1, double d2, float f, float f1)
	{

	}

	@Override
	protected ResourceLocation func_110775_a(Entity entity)
	{
		return TextureMap.field_110575_b;
	}

}
