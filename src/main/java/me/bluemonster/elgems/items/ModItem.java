package me.bluemonster.elgems.items;

import cpw.mods.fml.common.registry.GameRegistry;
import me.bluemonster.elgems.ElementalGems;
import net.minecraft.item.Item;

/**
 * @author bluemonster122 <boo122333@gmail.com>
 */
public class ModItem extends Item
{
    public ModItem(String name){
        setUnlocalizedName(ElementalGems.MODID + "_" + name);
        setTextureName(ElementalGems.MODID + ":" + name);
        setCreativeTab(ElementalGems.GTAB);
        GameRegistry.registerItem(this, name);
    }
}
