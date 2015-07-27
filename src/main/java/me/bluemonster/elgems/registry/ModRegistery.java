package me.bluemonster.elgems.registry;

import me.bluemonster.elgems.blocks.GemStorage;
import me.bluemonster.elgems.blocks.ModBlock;
import me.bluemonster.elgems.items.GemPlain;
import me.bluemonster.elgems.items.GemWater;
import me.bluemonster.elgems.items.HoeWater;
import me.bluemonster.elgems.items.ModItem;
import me.bluemonster.elgems.utility.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bluemonster122 <boo122333@gmail.com>
 */
public class ModRegistery
{
    public static List<Item> registerdItems = new ArrayList<>();
    public static List<Block> registerdBlocks = new ArrayList<>();

    public static void registerAll(){
        registerItems();
        registerBlocks();
        printLogs();
    }

    public static Item plain_gem;
    public static Item water_gem;
    public static Item water_hoe;

    private static void registerItems()
    {
        plain_gem = new GemPlain();
        water_gem = new GemWater();
        water_hoe = new HoeWater();
    }

    public static Block plain_gem_block;
    public static Block water_gem_block;

    private static void registerBlocks()
    {
        plain_gem_block = new GemStorage("plain");
        water_gem_block = new GemStorage("water");
    }

    private static void printLogs()
    {
        for (Item item : registerdItems){
            LogHelper.info("Successfully loaded " + ((ModItem)item).name);
        }
        for (Block block : registerdBlocks){
            LogHelper.info("Successfully loaded " + ((ModBlock)block).name);
        }
    }
}
