package me.bluemonster.elgems.items;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.bluemonster.elgems.creativetabs.EGCreativetabs;
import me.bluemonster.elgems.reference.Reference;
import me.bluemonster.elgems.registry.ModRegistry;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * @author bluemonster122 <boo122333@gmail.com>
 */
public class ModItem extends Item
{
    public String name;

    public ModItem(String name){
        this.name = name;
        setUnlocalizedName(this.name);
        setTextureName(this.name);
        setCreativeTab(EGCreativetabs.GTAB);
        GameRegistry.registerItem(this, this.name);
        ModRegistry.registeredItems.add(this);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
