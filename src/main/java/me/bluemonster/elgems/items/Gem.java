package me.bluemonster.elgems.items;

import me.bluemonster.elgems.entities.EntityLivingGem;
import me.bluemonster.elgems.reference.Names;
import me.bluemonster.elgems.utility.BlockPos;
import me.bluemonster.elgems.utility.Tools;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.Random;

/**
 * @author bluemonster122 <boo122333@gmail.com>
 */
public class Gem extends ModItem
{
    public String TYPE;

    public Gem(String name)
    {
        super(name);
        TYPE = name;
    }

    /**
     * This method loops though the gems and excecutes the correct method for each gem.
     *
     * @return true if anything happens
     */
    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hx, float hy, float hz)
    {
        if (TYPE.equals(Names.Items.GEMS[1]))
            return WaterGem(stack, player, world, x, y, z, side, hx, hy, hz, this);
        else if (TYPE.equals(Names.Items.GEMS[2]))
            return FireGem(stack, player, world, x, y, z, side, hx, hy, hz, this);
        else if (TYPE.equals(Names.Items.GEMS[3]))
            return EarthGem(stack, player, world, x, y, z, side, hx, hy, hz, this);
        else if (TYPE.equals(Names.Items.GEMS[4]))
            return LivingGem(stack, player, world, x, y, z, side, hx, hy, hz, this); //this is being called for all gems
        else
            return super.onItemUse(stack, player, world, x, y, z, side, hx, hy, hz);
    }

    public boolean WaterGem(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hx, float hy, float hz, Gem gem)
    {
        if (!player.canPlayerEdit(x, y, z, side, stack))
            return false; //returns false if the player doesn't have permission to edit the block.
        else
        {
            if (!world.isRemote) //!isRemote = server
            {
                dropBlockSetBlock(world, Blocks.flowing_water, x, y, z, 2);

                if (world.rand.nextInt(10) == 3)
                {
                    for (int i = -1; i <= 1; i++)
                    {
                        for (int j = -1; j <= 1; j++)
                        {
                            if ((i == 0 && j == 1) || (i == 0 && j == -1) || (i == 1 && j == 0) || (i == -1 && j == 0))
                            {
                                if (dropBlockSetBlock(world, Blocks.sand, x + i, y, z + j, 2))
                                    dropBlockSetBlock(world, Blocks.reeds, x + i, y + 1, z + j, 2);
                            }
                        }
                    }
                }
                world.markBlockForUpdate(x, y, z);
                stack.stackSize--;
            }
            return true;
        }
    }

    public boolean FireGem(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hx, float hy, float hz, Gem gem)
    {
        ForgeDirection direction = Tools.getDirectionFromSide(side);
        BlockPos pos = new BlockPos(x, y, z);
        return 0 <= side && side <= 5 ? doFire(pos, direction, stack, world, side, player) : false;
    }

    public boolean EarthGem(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hx, float hy, float hz, Gem gem)
    {
        {
            BlockPos pos = new BlockPos(x, y, z);
            if (!player.canPlayerEdit(x, y, z, side, stack))
                return false;
            else
                return makeDirt(stack, world, pos, side);
        }
    }

    public boolean LivingGem(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hx, float hy, float hz, Gem gem)

    {
        if (!world.isRemote)
        {
            EntityLivingGem entity = new EntityLivingGem(world);
            entity.setTamed(true);
            entity.setLocationAndAngles(x + hx, y + 1, z + hz, MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
            entity.rotationYawHead = entity.rotationYaw;
            entity.renderYawOffset = entity.rotationYaw;
            world.spawnEntityInWorld(entity);
            entity.playLivingSound();
            stack.stackSize--;
            return true;
        } else return false;
    }

    /**
     * This method checks to see if the block you want to turn into fire is air, and if it is then it does.
     *
     * @param pos       of block clicked
     * @param direction from block fire going
     * @param stack     should be Fire gemses
     * @param world     current world
     * @param side      of block clicked
     * @param player    holding stack in world
     * @return true if fire, false if not.
     */
    private boolean doFire(BlockPos pos, ForgeDirection direction, ItemStack stack, World world, int side, EntityPlayer player)
    {
        BlockPos newPos = new BlockPos(pos.x + direction.offsetX, pos.y + direction.offsetY, pos.z + direction.offsetZ);
        Random random = world.rand;
        if ((world.isAirBlock(newPos.x, newPos.y, newPos.z)) && ((!player.canPlayerEdit(newPos.x, newPos.y, newPos.z, side, stack)) || (!player.canPlayerEdit(pos.x, pos.y, pos.z, side, stack))))
        {
            return false;
        } else if (!world.isRemote)
        {
            world.setBlock(newPos.x, newPos.y, newPos.z, random.nextInt(15) == 1 ? Blocks.flowing_lava : Blocks.fire);
            stack.stackSize--;
            return true;
        } else return false;
    }

    /**
     * This method makes the block you clicked on dirt
     *
     * @param itemStack should be Earth gemses
     * @param world     world that the current plater is in
     * @param pos       position in world
     * @param side      the side that was clicked
     * @return true if sucessful
     */
    private boolean makeDirt(ItemStack itemStack, World world, BlockPos pos, int side)
    {
        if (!world.isRemote && world.getBlock(pos.x, pos.y, pos.z).getHarvestLevel(0) <= 2)
        {
            world.setBlock(pos.x, pos.y, pos.z, Blocks.dirt);
            itemStack.stackSize--;
            return true;
        } else return false;
    }

    private boolean dropBlockSetBlock(World world, Block block, int x, int y, int z, int mininglevel)
    {
        if (world.getBlock(x, y, z).getHarvestLevel(0) <= mininglevel)
        {
            world.getBlock(x, y, z).dropBlockAsItem(world, x, y, z, 0, 0);
            world.setBlock(x, y, z, block);
            return true;
        } else return false;
    }
}
