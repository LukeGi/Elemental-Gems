package me.bluemonster.elgems;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import me.bluemonster.elgems.items.Tools.PickFire;
import me.bluemonster.elgems.proxy.IProxy;
import me.bluemonster.elgems.reference.Refs;
import me.bluemonster.elgems.registry.ModRegistry;
import me.bluemonster.elgems.utility.LogHelper;

/**
 * @author bluemonster122 <boo122333@gmail.com>
 */

@Mod(modid = Refs.MOD_ID, name = Refs.MOD_NAME, version = Refs.VERSION)
public class ElementalGems
{
    @Instance(Refs.MOD_ID)
    public static ElementalGems instance;

    @SidedProxy(clientSide = Refs.CLIENT_PROXY, serverSide = Refs.SERVER_PROXY)
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        LogHelper.info(String.format("%s has finished pre-initializing.", Refs.MOD_NAME));
    }

    @EventHandler
    public void Init(FMLInitializationEvent event)
    {
        LogHelper.info(String.format("%s has finished initializing.", Refs.MOD_NAME));
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        LogHelper.info(String.format("%s has finished post-initializing.", Refs.MOD_NAME));
    }

}
