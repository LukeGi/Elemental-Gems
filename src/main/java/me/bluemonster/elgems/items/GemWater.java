package me.bluemonster.elgems.items;

import me.bluemonster.elgems.reference.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.World;

import java.util.Random;

/**
 * @author bluemonster122 <boo122333@gmail.com>
 */
public class GemWater extends ModItem
{
    public static final String name = Names.Items.GEMS[1];

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
            world.setBlock(x, y, z, Blocks.flowing_water);
            Random random = new Random();
            if (random.nextInt(10) == 3)
            {
                world.setBlock(x + 1, y, z, Blocks.sand);
                world.setBlock(x - 1, y, z, Blocks.sand);
                world.setBlock(x, y, z - 1, Blocks.sand);
                world.setBlock(x, y, z + 1, Blocks.sand);
                world.setBlock(x + 1, y+1, z, Blocks.reeds);
                world.setBlock(x - 1, y+1, z, Blocks.reeds);
                world.setBlock(x, y+1, z - 1, Blocks.reeds);
                world.setBlock(x, y+1, z + 1, Blocks.reeds);
            }
            world.markBlockForUpdate(x, y, z);
            itemStack.stackSize--;
        }
        return true;
    }
}
