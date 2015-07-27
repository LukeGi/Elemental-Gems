package me.bluemonster.elgems.creativetabs;

import me.bluemonster.elgems.ElementalGems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

/**
 * @author bluemonster122 <boo122333@gmail.com>
 */
public class EGCreativetabs
{
    public static final CreativeTabs GTAB = new CreativeTabs(ElementalGems.MODID)
    {
        @Override
        public Item getTabIconItem()
        {
            return Items.emerald;
        }
    };
}
