package org.jglrxavpok.mods.weapons;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.ICraftingHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "xavpoksWeapons", name = "xavpok's Weapons", version = "0.0.1")



@NetworkMod(clientSideRequired=true, serverSideRequired=true,

clientPacketHandlerSpec = @SidedPacketHandler(channels = {"mfWeapons" }, packetHandler = ClientPacketHandler.class),

serverPacketHandlerSpec = @SidedPacketHandler(channels = {"mfWeapons" }, packetHandler = ServerPacketHandler.class))


public class ModWeapons
{
	
	public static class CraftHandler implements ICraftingHandler
	{

		@Override
		public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix)
		{
		}

		@Override
		public void onSmelting(EntityPlayer player, ItemStack item)
		{}
		
	}
	
	
	 @Instance("xavpoksWeapons")
	 public static ModWeapons modInstance;
	 @SidedProxy(clientSide="org.jglrxavpok.mods.weapons.ClientProxy", serverSide="org.jglrxavpok.mods.weapons.CommonProxy")
	 public static CommonProxy proxy;
		
	public static final WeaponsGuiHandler guiHandler = new WeaponsGuiHandler();
	public ItemFlameThrower	flameThrower;
	public CreativeTabs mfWeapons = new MfWeaponsCreativeTab("mfWeaponsTab");
	public ItemMfArmors	pyroMask;
	
	static EnumArmorMaterial mfArmors = EnumHelper.addArmorMaterial("MfArmors", 20, new int[]{1, 8, 4, 2}, 15);
	
	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
		proxy.registerRenderThings();
		NetworkRegistry.instance().registerGuiHandler(this, guiHandler);
		GameRegistry.registerCraftingHandler(new CraftHandler());
		MinecraftForge.EVENT_BUS.register(this);
		
		
		pyroMask = (ItemMfArmors) new ItemMfArmors(2151, mfArmors, 0,0).setUnlocalizedName("pyroMask").func_111206_d("xavpoksweapons:pyroMask");
		pyroMask.setCreativeTab(mfWeapons);
		flameThrower = (ItemFlameThrower) new ItemFlameThrower(2152).setUnlocalizedName("flameThrower");

		EntityRegistry.registerGlobalEntityID(EntityFlameThrowable.class, "flameThrowable", EntityRegistry.findGlobalUniqueEntityId());
		
		EntityRegistry.registerGlobalEntityID(EntityKnocker.class, "knocker", EntityRegistry.findGlobalUniqueEntityId());
		
		GameRegistry.registerItem(flameThrower, "flameThrower");
		GameRegistry.registerItem(pyroMask, "pyroMask");
	}

	@EventHandler
	public void PreInit(FMLPreInitializationEvent event)
	{
	}

	

	@EventHandler
	public void PostInit(FMLPostInitializationEvent event)
	{
	}
	
}