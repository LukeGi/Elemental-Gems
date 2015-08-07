package me.bluemonster.elgems.items.Tools;

import me.bluemonster.elgems.reference.Names;
import me.bluemonster.elgems.utility.BlockPos;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

/**
 * @author bluemonster122 <boo122333@gmail.com>
 */
public class SwordWater extends ModItemTool
{
    public static final String name = Names.Items.WATER_SWORD;

    public SwordWater()
    {
        super(name, Names.Tools.SWORD, ToolMaterials.WATER);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity hit)
    {
        BlockPos pos = new BlockPos((int) Math.floor(hit.posX), (int) Math.floor(hit.posY), (int) Math.floor(hit.posZ));
        hit.setDead();
        player.worldObj.setBlock(pos.x, pos.y, pos.z, Blocks.air);
        player.worldObj.setBlock(pos.x, pos.y - 1, pos.z, Blocks.air);
        player.worldObj.setBlock(pos.x + 1, pos.y, pos.z, Blocks.flowing_water);
        player.worldObj.setBlock(pos.x + 1, pos.y - 1, pos.z, Blocks.air);
        player.worldObj.setBlock(pos.x, pos.y, pos.z + 1, Blocks.flowing_water);
        player.worldObj.setBlock(pos.x, pos.y - 1, pos.z + 1, Blocks.air);
        player.worldObj.setBlock(pos.x - 1, pos.y, pos.z, Blocks.flowing_water);
        player.worldObj.setBlock(pos.x - 1, pos.y - 1, pos.z, Blocks.air);
        player.worldObj.setBlock(pos.x, pos.y, pos.z - 1, Blocks.flowing_water);
        player.worldObj.setBlock(pos.x, pos.y - 1, pos.z - 1, Blocks.air);
        return true;
    }
}
