package me.bluemonster.elgems.creativetabs;

import me.bluemonster.elgems.reference.Names;
import me.bluemonster.elgems.registry.ModRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * @author bluemonster122 <boo122333@gmail.com>
 */
public class EGCreativetabs
{
    public static final CreativeTabs GTAB = new CreativeTabs(Names.ModInfo.MOD_ID)
    {
        @Override
        public Item getTabIconItem()
        {
            return ModRegistry.plain_gem;
        }
    };
}
