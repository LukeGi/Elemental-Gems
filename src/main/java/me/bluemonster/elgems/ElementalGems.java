package me.bluemonster.elgems;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import me.bluemonster.elgems.proxy.IProxy;
import me.bluemonster.elgems.reference.Reference;
import me.bluemonster.elgems.registry.ModRegistry;
import me.bluemonster.elgems.utility.LogHelper;

/**
 * @author bluemonster122 <boo122333@gmail.com>
 */

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class ElementalGems
{
    @Instance(Reference.MOD_ID)
    public static ElementalGems instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
    public static IProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ModRegistry.registerAll();
        LogHelper.info(String.format("%s has finished pre-initializing.", Reference.MOD_NAME));
    }

    @EventHandler
    public void Init(FMLInitializationEvent event)
    {
        LogHelper.info(String.format("%s has finished initializing.", Reference.MOD_NAME));
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        LogHelper.info(String.format("%s has finished post-initializing.", Reference.MOD_NAME));
    }

}
