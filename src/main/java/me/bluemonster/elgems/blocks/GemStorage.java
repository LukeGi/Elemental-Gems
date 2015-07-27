package me.bluemonster.elgems.blocks;

import net.minecraft.block.material.Material;

/**
 * @author bluemonster122 <boo122333@gmail.com>
 */
public class GemStorage extends ModBlock
{
    public static final String[] names = { "plain_gem_block", "water_gem_block" };

    public GemStorage(String name)
    {
        super(Material.iron, name.equals("plain") ? names[0] : name.equals("water") ? names[1] : "");
    }
}
