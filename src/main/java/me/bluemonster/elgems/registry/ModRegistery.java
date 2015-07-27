package me.bluemonster.elgems.registry;

import me.bluemonster.elgems.items.GemPlain;
import me.bluemonster.elgems.items.GemWater;
import me.bluemonster.elgems.items.HoeWater;
import net.minecraft.item.Item;

/**
 * @author bluemonster122 <boo122333@gmail.com>
 */
public class ModRegistery
{
    public static Item plain_gem;
    public static Item water_gem;
    public static Item water_hoe;

    public static void registerItems()
    {
        plain_gem = new GemPlain();
        water_gem = new GemWater();
        water_hoe = new HoeWater();
    }

}
