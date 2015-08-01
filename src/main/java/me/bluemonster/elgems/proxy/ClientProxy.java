package me.bluemonster.elgems.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import me.bluemonster.elgems.entities.EntityLivingGem;
import me.bluemonster.elgems.entities.RenderLivingGem;
import net.minecraft.client.model.ModelBiped;

/**
 * @author bluemonster122 <boo122333@gmail.com>
 */
public class ClientProxy extends CommonProxy
{
    public void registerRenders(){
        RenderingRegistry.registerEntityRenderingHandler(EntityLivingGem.class, new RenderLivingGem(new ModelBiped(), 0.3F));
    }

}
