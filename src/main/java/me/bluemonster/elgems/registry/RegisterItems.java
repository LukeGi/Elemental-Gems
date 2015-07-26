package me.bluemonster.elgems.registry;

import me.bluemonster.elgems.items.GemPlain;
import net.minecraft.item.Item;

/**
 * @author bluemonster122 <boo122333@gmail.com>
 */
public class RegisterItems
{
    public static Item plain_gem;

    public static void init(){
        plain_gem = new GemPlain();
    }
}
