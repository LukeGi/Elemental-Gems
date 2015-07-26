package me.bluemonster.elgems.items;

import cpw.mods.fml.common.registry.GameRegistry;
import me.bluemonster.elgems.ElementalGems;
import net.minecraft.item.Item;

/**
 * @author bluemonster122 <boo122333@gmail.com>
 */
public class GemPlain extends Item
{
    public static final String name = "plain_gem";

    public GemPlain(){
        GameRegistry.registerItem(this, name);
        setUnlocalizedName(ElementalGems.MODID + "_" + name);
        setTextureName(ElementalGems.MODID + ":" + name);
    }
}
