package me.bluemonster.elgems.items;

import me.bluemonster.elgems.reference.Names;
import me.bluemonster.elgems.utility.BlockPos;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * @author bluemonster122 <boo122333@gmail.com>
 */
public class GemFire extends ModItem
{
    public static final String name = Names.Items.GEMS[2];

    public GemFire()
    {
        super(name);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float px, float py, float pz)
    {
        ForgeDirection direction;
        BlockPos pos = new BlockPos(x, y, z);

        switch (side)
        {
            case 0: //bottom
                direction = ForgeDirection.DOWN;
                return doFire(pos, direction, itemStack, world, side, player);
            case 1: //top
                direction = ForgeDirection.UP;
                return doFire(pos, direction, itemStack, world, side, player);
            case 2: //north
                direction = ForgeDirection.NORTH;
                return doFire(pos, direction, itemStack, world, side, player);
            case 3: //south
                direction = ForgeDirection.SOUTH;
                return doFire(pos, direction, itemStack, world, side, player);
            case 4: //west
                direction = ForgeDirection.WEST;
                return doFire(pos, direction, itemStack, world, side, player);
            case 5: //east
                direction = ForgeDirection.EAST;
                return doFire(pos, direction, itemStack, world, side, player);
            default:
                return false;
        }
    }

    /**
     * This method checks to see if the block you want to turn into fire is air, and if it is then it does.
     *
     * @param pos       of block clicked
     * @param direction from block fire going
     * @param stack     should be FireGemses
     * @param world     current world
     * @param side      of block clicked
     * @param player    holding stack in world
     * @return true if fire, false if not.
     */
    private boolean doFire(BlockPos pos, ForgeDirection direction, ItemStack stack, World world, int side, EntityPlayer player)
    {
        BlockPos newPos = new BlockPos(pos.x + direction.offsetX, pos.y + direction.offsetY, pos.z + direction.offsetZ);

        if ((world.isAirBlock(newPos.x, newPos.y, newPos.z)) && ((!player.canPlayerEdit(newPos.x, newPos.y, newPos.z, side, stack)) || (!player.canPlayerEdit(pos.x, pos.y, pos.z, side, stack))))
        {
            return false;
        } else if (!world.isRemote)
        {
            world.setBlock(newPos.x, newPos.y, newPos.z, Blocks.fire);
            stack.stackSize--;
            return true;
        } else return false;
    }
}
