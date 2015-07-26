package me.bluemonster.elgems.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * @author bluemonster122 <boo122333@gmail.com>
 */
public class GemWater extends ModItem
{
    public static final String name = "water_gem";

    public GemWater()
    {
        super(name);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float px, float py, float pz)
    {
        if (!player.canPlayerEdit(x, y, z, side, itemStack))
            return false; //returns false if the player doesn't have permission to edit the block.

        if (!world.isRemote) //!isRemote = server
        {
            world.setBlock(x,y,z, Blocks.flowing_water);
            world.markBlockForUpdate(x,y,z);
            itemStack.stackSize--;
        }
        return true;
    }
}
