package org.jglrxavpok.mods.weapons;

import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class CommonProxy
{

	public void registerRenderThings()
	{
		TickRegistry.registerTickHandler(new ServerTickHandler(), Side.SERVER);
	};
}
