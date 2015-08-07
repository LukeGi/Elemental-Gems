package me.bluemonster.elgems.utility;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import java.util.Random;

/**
 * @author bluemonster122 <boo122333@gmail.com>
 */
public class MethodHelper
{
    public static boolean spawnItemEntity(World world, ItemStack stack, int x, int y, int z)
    {
        Random rand = world.rand;
        if (stack != null && stack.getItem() != null)
        {
            float f = rand.nextFloat() * 0.8F + 0.1F;
            float f1 = rand.nextFloat() * 0.8F + 0.1F;
            float f2 = rand.nextFloat() * 0.8F + 0.1F;

            while (stack.stackSize > 0)
            {
                int j1 = rand.nextInt(21) + 10;

                if (j1 > stack.stackSize)
                {
                    j1 = stack.stackSize;
                }

                stack.stackSize -= j1;
                EntityItem entityitem = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1), (double) ((float) z + f2), new ItemStack(stack.getItem(), j1, stack.getItemDamage()));

                if (stack.hasTagCompound())
                {
                    entityitem.getEntityItem().setTagCompound((NBTTagCompound) stack.getTagCompound().copy());
                }

                float f3 = 0.05F;
                entityitem.motionX = (double) ((float) rand.nextGaussian() * f3);
                entityitem.motionY = (double) ((float) rand.nextGaussian() * f3 + 0.2F);
                entityitem.motionZ = (double) ((float) rand.nextGaussian() * f3);
                world.spawnEntityInWorld(entityitem);
            }
            return true;
        }
        return false;
    }
}
