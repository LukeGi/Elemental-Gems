package me.bluemonster.elgems.reference;

/**
 * @author bluemonster122 <boo122333@gmail.com>
 */
public class Names
{
    public static final class Blocks
    {
        public static final String PLAIN = "plain_gem_block";
        public static final String WATER = "water_gem_block";
        public static final String FIRE = "fire_gem_block";
        public static final String EARTH = "earth_gem_block";
    }

    public static final class Items
    {
        public static final String[] GEMS = {
                "plain_gem",
                "water_gem",
                "fire_gem",
                "earth_gem",
        };
        public static final String WATER_HOE = "water_hoe";
    }

    public static final class Tools
    {
        public static final String AXE = "AXE";
        public static final String HOE = "HOE";
        public static final String PICK = "PICK";
        public static final String SHOVEL = "SHOVEL";
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
