package me.bluemonster.elgems.entities;

import cpw.mods.fml.common.registry.EntityRegistry;
import me.bluemonster.elgems.ElementalGems;
import net.minecraft.entity.EntityList;

import java.util.Random;

/**
 * @author bluemonster122 <boo122333@gmail.com>
 */
public class EntityHandler
{
    public static void registerEntities(Class entityClass, String name)
    {
        int entityId = EntityRegistry.findGlobalUniqueEntityId();
        long x = name.hashCode();
        Random random = new Random(x);
        int mainColor = random.nextInt() * 16777215;
        int subColor = random.nextInt() * 16777215;

        EntityRegistry.registerGlobalEntityID(entityClass, name, entityId);
        EntityRegistry.registerModEntity(entityClass, name, entityId, ElementalGems.instance, 64, 1, true);
        EntityList.entityEggs.put(Integer.valueOf(entityId), new EntityList.EntityEggInfo(entityId, mainColor, subColor));
    }
}
