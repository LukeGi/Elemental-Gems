package me.bluemonster.elgems.items;

import cpw.mods.fml.common.registry.GameRegistry;
import me.bluemonster.elgems.creativetabs.EGCreativetabs;
import me.bluemonster.elgems.reference.Reference;
import me.bluemonster.elgems.registry.ModRegistry;
import net.minecraft.item.Item;

/**
 * @author bluemonster122 <boo122333@gmail.com>
 */
public class ModItem extends Item
{
    public String name;

    public ModItem(String name){
        this.name = name;
        setUnlocalizedName(Reference.MOD_ID + "_" + this.name);
        setTextureName(Reference.MOD_ID + ":" + this.name);
        setCreativeTab(EGCreativetabs.GTAB);
        GameRegistry.registerItem(this, this.name);
        ModRegistry.registeredItems.add(this);
    }
}
