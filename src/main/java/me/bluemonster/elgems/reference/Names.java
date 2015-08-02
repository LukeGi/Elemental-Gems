package me.bluemonster.elgems.reference;

/**
 * @author bluemonster122 <boo122333@gmail.com>
 */
public class Names
{
    public static final class Blocks
    {
        public static String[] GEM_STORAGE = new String[Names.Items.GEMS.length];
        public static final String PLAIN = "plain_gem_block";
        public static final String WATER = "water_gem_block";
        public static final String FIRE = "fire_gem_block";
        public static final String EARTH = "earth_gem_block";

        public static void genNames()
        {
            for (int i = 0; i < Names.Items.GEMS.length; i++)
            {
                GEM_STORAGE[i] = Names.Items.GEMS[i] + "_block";
            }
        }
    }

    public static final class Items
    {
        public static final String[] GEMS = {
                "plain_gem",
                "water_gem",
                "fire_gem",
                "earth_gem",
                "living_gem",
        };
        public static final String WATER_HOE = "water_hoe";
        public static final String EARTH_PICK = "earth_pick";
        public static final String WATER_SWORD = "water_sword";
    }

    public static final class Tools
    {
        public static final String AXE = "axe";
        public static final String HOE = "HOE";
        public static final String PICK = "pickaxe";
        public static final String SHOVEL = "shovel";
        public static final String SWORD = "SWORD";
    }

    public static final class ModInfo
    {
        public static final String MOD_ID = "elgems";
        public static final String MOD_NAME = "Elemental Gems";
        public static final String VERSION = "1.7.10-1.0";
        public static final String CLIENT_PROXY = "me.bluemonster.elgems.proxy.ClientProxy";
        public static final String SERVER_PROXY = "me.bluemonster.elgems.proxy.ServerProxy";
    }
}
