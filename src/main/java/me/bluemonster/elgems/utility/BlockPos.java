package me.bluemonster.elgems.utility;

/**
 * @author bluemonster122 <boo122333@gmail.com>
 */
public class BlockPos
{
    public int x, y, z;

    public BlockPos(int x, int y, int z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int getZ()
    {
        return z;
    }
}
