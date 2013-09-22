package org.jglrxavpok.mods.weapons;

import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class ClientProxy extends CommonProxy
{

    @Override

    public void registerRenderThings()
    {
		TickRegistry.registerTickHandler(new ClientTickHandler(), Side.CLIENT);
		RenderingRegistry.registerEntityRenderingHandler(EntityFlameThrowable.class, new RenderFlameThrowable(0.5f));
		RenderingRegistry.registerEntityRenderingHandler(EntityKnocker.class, new RenderKnocker());
    }
}
