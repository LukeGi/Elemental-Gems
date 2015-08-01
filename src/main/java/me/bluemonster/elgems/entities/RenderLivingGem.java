package me.bluemonster.elgems.entities;

import me.bluemonster.elgems.reference.Names;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

/**
 * @author bluemonster122 <boo122333@gmail.com>
 */
public class RenderLivingGem extends RenderLiving
{
    private static final ResourceLocation texture = AbstractClientPlayer.locationStevePng;

    protected ModelBiped modelEntity;

    public RenderLivingGem(ModelBase model, float f)
    {
        super(model, f);
        modelEntity = ((ModelBiped)mainModel);
    }

    public void renderLivingGem(EntityLivingGem entity, double x, double y, double z, float u, float v)
    {
        super.doRender(entity,x,y,z,u,v);
    }

    public void doRenderLiving(EntityLiving entityLiving, double x, double y, double z, float u, float v)
    {
        renderLivingGem((EntityLivingGem) entityLiving, x, y, z, u, v);
    }

    @Override
    public void doRender(Entity entity, double x, double y, double z, float u, float v)
    {
        renderLivingGem((EntityLivingGem)entity, x, y, z, u, v);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return texture;
    }
}
