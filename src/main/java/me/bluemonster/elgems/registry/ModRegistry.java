package me.bluemonster.elgems.registry;

import me.bluemonster.elgems.blocks.GemStorage;
import me.bluemonster.elgems.blocks.ModBlock;
import me.bluemonster.elgems.items.*;
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
    public static List<Item> registeredItems = new ArrayList<>();
    public static List<Block> registeredBlocks = new ArrayList<>();

    public static void registerAll(){
        registerItems();
        registerBlocks();
        printLogs();
    }

    public static Item plain_gem;
    public static Item water_gem;
    public static Item fire_gem;
    public static Item water_hoe;

    private static void registerItems()
    {
        plain_gem = new GemPlain();
        water_gem = new GemWater();
        fire_gem = new GemFire();
        water_hoe = new HoeWater();
    }

    public static Block plain_gem_block;
    public static Block water_gem_block;
    public static Block fire_gem_block;

    private static void registerBlocks()
    {
        plain_gem_block = new GemStorage(Names.Blocks.PLAIN);
        water_gem_block = new GemStorage(Names.Blocks.WATER);
        fire_gem_block = new GemStorage(Names.Blocks.FIRE);
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
