package me.bluemonster.elgems.items;

import me.bluemonster.elgems.reference.Names;
import me.bluemonster.elgems.utility.BlockPos;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * @author bluemonster122 <boo122333@gmail.com>
 */
public class PickEarth extends ModItem
{
    public static final String name = Names.Items.EARTH_PICK;
    private float efficiencyOnProperMaterial;

    public PickEarth()
    {
        super(name);
        setMaxDamage(950);
        setMaxStackSize(1);
        setHarvestLevel(Names.Tools.PICK, 100);
        this.efficiencyOnProperMaterial = 8f;
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
            world.getBlock(pos.x, pos.y + i, pos.z).dropBlockAsItem(world, pos.x, pos.y, pos.z, 0, 0);
            world.setBlockToAir(pos.x, pos.y + i, pos.z);
            itemStack.damageItem(1, entity);
        }
        return true;
    }

    @Override
    public float func_150893_a(ItemStack p_150893_1_, Block p_150893_2_)
    {
        return p_150893_2_.getMaterial() != Material.iron && p_150893_2_.getMaterial() != Material.anvil && p_150893_2_.getMaterial() != Material.rock ? super.func_150893_a(p_150893_1_, p_150893_2_) : this.efficiencyOnProperMaterial;
    }
}
