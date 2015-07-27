package me.bluemonster.elgems.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import me.bluemonster.elgems.ElementalGems;
import me.bluemonster.elgems.creativetabs.EGCreativetabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * @author bluemonster122 <boo122333@gmail.com>
 */
public class ModBlock extends Block
{

    protected ModBlock(Material material, String name)
    {
        super(material);
        setBlockName(ElementalGems.MODID + "_" + name);
        setBlockTextureName(ElementalGems.MODID + ":" + name);
        setCreativeTab(EGCreativetabs.GTAB);
        GameRegistry.registerBlock(this, name);
    }
}
