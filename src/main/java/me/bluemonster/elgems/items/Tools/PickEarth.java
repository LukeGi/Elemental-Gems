package me.bluemonster.elgems.items.Tools;

import me.bluemonster.elgems.reference.Names;
import me.bluemonster.elgems.utility.BlockPos;
import me.bluemonster.elgems.utility.MethodHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * @author bluemonster122 <boo122333@gmail.com>
 */
public class PickEarth extends ModItemTool
{
    public static final String name = Names.Items.EARTH_PICK;

    public PickEarth()
    {
        super(name, Names.Tools.PICK, ToolMaterials.EARTH);
    }

    public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int x, int y, int z, EntityLivingBase entityLivingBase)
    {
        BlockPos pos = new BlockPos(x, y, z);
        if (!world.isRemote)
        {
            if (entityLivingBase instanceof EntityPlayer)
            {
                EntityPlayer player = (EntityPlayer) entityLivingBase;
                if (player.canPlayerEdit(x, y, z, 0, itemStack))
                    return doSpecialBlockBreak(itemStack, world, pos, player);
            } else return doSpecialBlockBreak(itemStack, world, pos, entityLivingBase);
        }
        return false;
    }

    private boolean doSpecialBlockBreak(ItemStack itemStack, World world, BlockPos pos, EntityLivingBase entity)
    {
        for (int i = -1; i <= 1; i++)
        {
            dropBlockSetBlock(world, Blocks.air, pos.x, pos.y + i, pos.z);
            itemStack.damageItem(1, entity);
        }
        return true;
    }

    @Override
    public float func_150893_a(ItemStack p_150893_1_, Block p_150893_2_)
    {
        return p_150893_2_.getMaterial() != Material.iron && p_150893_2_.getMaterial() != Material.anvil && p_150893_2_.getMaterial() != Material.rock ? super.func_150893_a(p_150893_1_, p_150893_2_) : this.efficiencyOnProperMaterial;
    }

    private boolean dropBlockSetBlock(World world, Block block, int x, int y, int z)
    {
        if (world.getBlock(x, y, z).getMaterial().equals(Material.rock))
        {
            world.getBlock(x, y, z).dropBlockAsItem(world, x, y, z, 0, 0);
            world.setBlock(x, y, z, block);
            return true;
        } else return false;
    }
}
