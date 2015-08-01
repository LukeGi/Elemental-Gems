package me.bluemonster.elgems.items;

import me.bluemonster.elgems.entities.EntityLivingGem;
import me.bluemonster.elgems.reference.Names;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

/**
 * @author bluemonster122 <boo122333@gmail.com>
 */
public class GemLiving extends ModItem
{
    public static final String name = Names.Items.GEMS[4];

    public GemLiving()
    {
        super(name);
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
        if (!world.isRemote)
        {
            EntityLivingGem entity = new EntityLivingGem(world);
            entity.setTamed(true);
            EntityLiving entityliving = entity;
            entity.setLocationAndAngles(x + hitX, y + 1, z + hitZ, MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
            entityliving.rotationYawHead = entityliving.rotationYaw;
            entityliving.renderYawOffset = entityliving.rotationYaw;
            world.spawnEntityInWorld(entity);
            entityliving.playLivingSound();
            stack.stackSize--;
            return true;
        } else return false;
    }
}
