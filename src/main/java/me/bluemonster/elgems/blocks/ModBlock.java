package me.bluemonster.elgems.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.bluemonster.elgems.creativetabs.EGCreativetabs;
import me.bluemonster.elgems.reference.Names;
import me.bluemonster.elgems.registry.ModRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

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
        setBlockName(this.name);
        setBlockTextureName(this.name);
        setCreativeTab(EGCreativetabs.GTAB);
        GameRegistry.registerBlock(this, this.name);
        ModRegistry.registeredBlocks.add(this);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Names.ModInfo.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
