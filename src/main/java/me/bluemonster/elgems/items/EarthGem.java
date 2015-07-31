package me.bluemonster.elgems.items;

import me.bluemonster.elgems.reference.Names;
import me.bluemonster.elgems.utility.BlockPos;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * @author bluemonster122 <boo122333@gmail.com>
 */
public class EarthGem extends ModItem
{
    public static final String name = Names.Items.GEMS[3];

    public EarthGem()
    {
        super(name);
    }

    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float px, float py, float pz)
    {
        BlockPos pos = new BlockPos(x, y, z);

        if (!player.canPlayerEdit(x, y, z, side, itemStack))
            return false;
        else
            return makeDirt(itemStack, world, pos);
    }

    private boolean makeDirt(ItemStack itemStack, World world, BlockPos pos)
    {
        if (!world.isRemote && world.getBlock(pos.x, pos.y, pos.z).getMaterial().equals(Material.rock))
        {
            world.setBlock(pos.x, pos.y, pos.z, Blocks.dirt);
            itemStack.stackSize--;
        }
        return false;
    }
}
