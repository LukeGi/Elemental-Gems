package me.bluemonster.elgems.items.Tools;

import me.bluemonster.elgems.reference.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Objects;

/**
 * @author bluemonster122 <boo122333@gmail.com>
 */
public class HoeWater extends ModItemTool
{
    public static final String name = Names.Items.WATER_HOE;

    public HoeWater()
    {
        super(name, Names.Tools.HOE, ToolMaterials.WATER);
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

        if (canHoe && !world.isRemote)
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
                if (((Objects.equals(world.getBlock(nx, y, nz), Blocks.grass)) || (Objects.equals(world.getBlock(nx, y, nz), Blocks.dirt))) && (world.isAirBlock(nx, y + 1, nz)))
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
