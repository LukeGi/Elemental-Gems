package me.bluemonster.elgems.entities;

import me.bluemonster.elgems.registry.ModRegistry;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

/**
 * @author bluemonster122 <boo122333@gmail.com>
 */
public class EntityLivingGem extends EntityTameable
{
    public EntityLivingGem(World world)
    {
        super(world);
        this.isImmuneToFire = true;
        setSize(0.8f, 1.8f);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIFollowOwner(this, 1D, 10F, 2F));
        this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(3, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAITargetNonTamed(this, EntityPig.class, 200, false));
    }

    @Override
    public EntityAgeable createChild(EntityAgeable p_90011_1_)
    {
        return null;
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(64D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.4D);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100D);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(10D);
    }

    public float getRenderSizeModifier()
    {
        return 0.3F;
    }

    @Override
    protected Item getDropItem()
    {
        return ModRegistry.plain_gem;
    }
}
