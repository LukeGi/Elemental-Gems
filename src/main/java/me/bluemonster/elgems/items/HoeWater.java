package me.bluemonster.elgems.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * @author bluemonster122 <boo122333@gmail.com>
 */
public class HoeWater extends ModItem
{
    public static final String name = "water_hoe";

    public HoeWater()
    {
        super(name);
        this.setMaxDamage(5);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float px, float py, float pz)
    {
        if (!player.canPlayerEdit(x, y, z, side, itemStack)) return false;

        boolean canHoe = true;

        for (int ox = -4; ox < 4; ox++)
            for (int oz = -4; oz < 4; oz++)
            {
                int nx = ox + x;
                int nz = oz + z;
                if (!player.canPlayerEdit(nx, y, nz, side, itemStack))
                    canHoe = false;
            }

        if (canHoe)
        {
            superHoeActivate(x, y, z, world);
            itemStack.damageItem(1, player);
        }

        return canHoe;
    }

    private void superHoeActivate(int x, int y, int z, World world)
    {
        for (int i = -4; i <= 4; i++)
        {
            for (int j = -4; j <= 4; j++)
            {
                int nx = x + i, nz = z + j;
                if (world.getBlock(nx, y, nz) == Blocks.grass || world.getBlock(nx, y,nz) == Blocks.dirt)
                {
                    if (i == 0 && j == 0)
                    {
                        world.setBlock(nx, y, nz, Blocks.flowing_water);
                        world.markBlockForUpdate(nx, y, nz);
                    } else
                    {
                        world.setBlock(nx, y, nz, Blocks.farmland);
                    }
                }
            }
        }
    }
}
