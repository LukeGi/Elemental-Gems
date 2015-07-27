package me.bluemonster.elgems.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import me.bluemonster.elgems.creativetabs.EGCreativetabs;
import me.bluemonster.elgems.reference.Reference;
import me.bluemonster.elgems.registry.ModRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * @author bluemonster122 <boo122333@gmail.com>
 */
public class ModBlock extends Block
{
    public String name;

    public ModBlock(Material material, String name)
    {
        super(material);
        this.name = name;
        setBlockName(Reference.MOD_ID + "_" + this.name);
        setBlockTextureName(Reference.MOD_ID + ":" + this.name);
        setCreativeTab(EGCreativetabs.GTAB);
        GameRegistry.registerBlock(this, this.name);
        ModRegistry.registeredBlocks.add(this);
    }
}
