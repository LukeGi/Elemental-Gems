package me.bluemonster.elgems.utility;

import net.minecraftforge.common.util.ForgeDirection;

/**
 * @author bluemonster122 <boo122333@gmail.com>
 */
public class Tools
{
    public static ForgeDirection getDirectionFromSide(int side)
    {
        switch (side)
        {
            case 0: //bottom
                return ForgeDirection.DOWN;
            case 1: //top
                return ForgeDirection.UP;
            case 2: //north
                return ForgeDirection.NORTH;
            case 3: //south
                return ForgeDirection.SOUTH;
            case 4: //west
                return ForgeDirection.WEST;
            case 5: //east
                return ForgeDirection.EAST;
            default:
                LogHelper.warn("direction was not found, side is not in range of 0-5");
                return null;
        }
    }
}
