package me.bluemonster.elgems.registry;

import me.bluemonster.elgems.blocks.GemStorage;
import me.bluemonster.elgems.blocks.ModBlock;
import me.bluemonster.elgems.entities.EntityHandler;
import me.bluemonster.elgems.entities.EntityLivingGem;
import me.bluemonster.elgems.items.*;
import me.bluemonster.elgems.items.Tools.HoeWater;
import me.bluemonster.elgems.items.Tools.PickEarth;
import me.bluemonster.elgems.items.Tools.SwordWater;
import me.bluemonster.elgems.reference.Names;
import me.bluemonster.elgems.utility.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bluemonster122 <boo122333@gmail.com>
 */
public class ModRegistry
{
    public static List<Item> registeredItems = new ArrayList<Item>();
    public static List<Block> registeredBlocks = new ArrayList<Block>();

    public static void registerAll(){
        registerItems();
        registerBlocks();
        registerEntities();
        printLogs();
    }

    public static Item plain_gem;
    public static Item water_gem;
    public static Item fire_gem;
    public static Item earth_gem;
    public static Item living_gem;
    public static Item water_hoe;
    public static Item water_sword;
    public static Item earth_pick;

    private static void registerItems()
    {
        plain_gem = new Gem(Names.Items.GEMS[0]);
        water_gem = new Gem(Names.Items.GEMS[1]);
        fire_gem = new Gem(Names.Items.GEMS[2]);
        earth_gem = new Gem(Names.Items.GEMS[3]);
        living_gem = new Gem(Names.Items.GEMS[4]);
        water_hoe = new HoeWater();
        water_sword = new SwordWater();
        earth_pick = new PickEarth();
    }

    public static Block[] gemStorage = new Block[Names.Items.GEMS.length];

    private static void registerBlocks(){
        Names.Blocks.genNames();
        for (int i = 0; i < Names.Blocks.GEM_STORAGE.length; i++)
        {
            gemStorage[i] = new GemStorage(Names.Blocks.GEM_STORAGE[i]);
        }
    }

    private static void registerEntities(){
        EntityHandler.registerEntities(EntityLivingGem.class, "Living Gem");
    }

    private static void printLogs()
    {
        for (Item item : registeredItems){
            LogHelper.info("Successfully loaded " + ((ModItem)item).name);
        }
        for (Block block : registeredBlocks){
            LogHelper.info("Successfully loaded " + ((ModBlock)block).name);
        }
    }
}
