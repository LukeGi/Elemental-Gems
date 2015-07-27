package me.bluemonster.elgems.creativetabs;

import me.bluemonster.elgems.reference.Reference;
import me.bluemonster.elgems.registry.ModRegistery;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * @author bluemonster122 <boo122333@gmail.com>
 */
public class EGCreativetabs
{
    public static final CreativeTabs GTAB = new CreativeTabs(Reference.MOD_ID)
    {
        @Override
        public Item getTabIconItem()
        {
            return ModRegistery.plain_gem;
        }
    };
}
