package me.bluemonster.elgems;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import me.bluemonster.elgems.items.PickEarth;
import me.bluemonster.elgems.proxy.IProxy;
import me.bluemonster.elgems.reference.Names;
import me.bluemonster.elgems.registry.ModRegistry;
import me.bluemonster.elgems.utility.LogHelper;

/**
 * @author bluemonster122 <boo122333@gmail.com>
 */

@Mod(modid = Names.ModInfo.MOD_ID, name = Names.ModInfo.MOD_NAME, version = Names.ModInfo.VERSION)
public class ElementalGems
{
    @Instance(Names.ModInfo.MOD_ID)
    public static ElementalGems instance;

    @SidedProxy(clientSide = Names.ModInfo.CLIENT_PROXY, serverSide = Names.ModInfo.SERVER_PROXY)
    public static IProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ModRegistry.registerAll();
        LogHelper.info(String.format("%s has finished pre-initializing.", Names.ModInfo.MOD_NAME));
    }

    @EventHandler
    public void Init(FMLInitializationEvent event)
    {
        LogHelper.info(String.format("%s has finished initializing.", Names.ModInfo.MOD_NAME));
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        LogHelper.info(String.format("%s has finished post-initializing.", Names.ModInfo.MOD_NAME));
    }

}
