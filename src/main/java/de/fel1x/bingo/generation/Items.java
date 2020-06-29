package de.fel1x.bingo.generation;

import de.fel1x.bingo.objects.BingoDifficulty;
import de.fel1x.bingo.objects.BingoItem;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Items {

    private List<BingoItem> items = new ArrayList<>();

    public Items() {

        //FOOD
        items.add(new BingoItem(Material.APPLE, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.MUSHROOM_STEW, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.BREAD, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.PORKCHOP, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.COOKED_PORKCHOP, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.GOLDEN_APPLE, BingoDifficulty.NORMAL));
        items.add(new BingoItem(Material.ENCHANTED_GOLDEN_APPLE, BingoDifficulty.HARDCORE));
        items.add(new BingoItem(Material.CAKE, BingoDifficulty.NORMAL));
        items.add(new BingoItem(Material.SWEET_BERRIES, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.DRIED_KELP, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.SHEARS, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.PUMPKIN_PIE, BingoDifficulty.NORMAL));
        items.add(new BingoItem(Material.COOKIE, BingoDifficulty.HARDCORE));
        items.add(new BingoItem(Material.CARROT, BingoDifficulty.NORMAL));
        items.add(new BingoItem(Material.COOKED_MUTTON, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.MUTTON, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.RABBIT, BingoDifficulty.NORMAL));
        items.add(new BingoItem(Material.COOKED_RABBIT, BingoDifficulty.NORMAL));
        items.add(new BingoItem(Material.COD, BingoDifficulty.NORMAL));
        items.add(new BingoItem(Material.SALMON, BingoDifficulty.NORMAL));
        items.add(new BingoItem(Material.NAME_TAG, BingoDifficulty.HARDCORE));

        // TOOLS & WEAPONS
        items.add(new BingoItem(Material.DIAMOND_PICKAXE, BingoDifficulty.NORMAL));
        items.add(new BingoItem(Material.DIAMOND_AXE, BingoDifficulty.NORMAL));
        items.add(new BingoItem(Material.CLOCK, BingoDifficulty.NORMAL));
        items.add(new BingoItem(Material.IRON_SHOVEL, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.FLINT_AND_STEEL, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.NAME_TAG, BingoDifficulty.HARDCORE));
        items.add(new BingoItem(Material.COMPASS, BingoDifficulty.NORMAL));

        items.add(new BingoItem(Material.BOW, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.LEATHER_CHESTPLATE, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.DIAMOND_CHESTPLATE, BingoDifficulty.HARDCORE));
        items.add(new BingoItem(Material.GOLDEN_LEGGINGS, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.LEATHER_CHESTPLATE, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.LEATHER_BOOTS, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.LEATHER_LEGGINGS, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.LEATHER_HELMET, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.DIAMOND_SWORD, BingoDifficulty.EASY));

        // TRANSPORTATION
        items.add(new BingoItem(Material.POWERED_RAIL, BingoDifficulty.NORMAL));
        items.add(new BingoItem(Material.DETECTOR_RAIL, BingoDifficulty.NORMAL));
        items.add(new BingoItem(Material.RAIL, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.MINECART, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.CHEST_MINECART, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.CARROT_ON_A_STICK, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.OAK_BOAT, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.BIRCH_BOAT, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.JUNGLE_BOAT, BingoDifficulty.HARDCORE));
        items.add(new BingoItem(Material.ACACIA_BOAT, BingoDifficulty.HARDCORE));
        items.add(new BingoItem(Material.DARK_OAK_BOAT, BingoDifficulty.NORMAL));

        // REDSTONE
        items.add(new BingoItem(Material.NOTE_BLOCK, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.PISTON, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.STICKY_PISTON, BingoDifficulty.HARDCORE));
        items.add(new BingoItem(Material.TNT, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.TRIPWIRE_HOOK, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.OAK_PRESSURE_PLATE, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.BIRCH_PRESSURE_PLATE, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.REDSTONE_LAMP, BingoDifficulty.NORMAL));
        items.add(new BingoItem(Material.SPRUCE_FENCE_GATE, BingoDifficulty.NORMAL));
        items.add(new BingoItem(Material.REDSTONE_TORCH, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.OAK_TRAPDOOR, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.BIRCH_TRAPDOOR, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.JUNGLE_TRAPDOOR, BingoDifficulty.HARDCORE));
        items.add(new BingoItem(Material.REDSTONE_LAMP, BingoDifficulty.NORMAL));

        // DECORATION
        items.add(new BingoItem(Material.CHEST, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.IRON_DOOR, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.TRAPPED_CHEST, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.CRAFTING_TABLE, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.FURNACE, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.LADDER, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.CACTUS, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.JUKEBOX, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.GLASS, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.GLASS_PANE, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.POPPY, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.DANDELION, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.RED_TULIP, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.BLUE_ORCHID, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.AZURE_BLUET, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.ORANGE_TULIP, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.ORANGE_TULIP, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.WHITE_TULIP, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.PINK_TULIP, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.ALLIUM, BingoDifficulty.NORMAL));
        items.add(new BingoItem(Material.ENCHANTING_TABLE, BingoDifficulty.NORMAL));
        items.add(new BingoItem(Material.LILY_PAD, BingoDifficulty.NORMAL));
        items.add(new BingoItem(Material.ANVIL, BingoDifficulty.NORMAL));
        items.add(new BingoItem(Material.BROWN_MUSHROOM, BingoDifficulty.NORMAL));
        items.add(new BingoItem(Material.RED_MUSHROOM, BingoDifficulty.NORMAL));
        items.add(new BingoItem(Material.OAK_SIGN, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.BIRCH_SIGN, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.BIRCH_SIGN, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.WHITE_BED, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.RED_BED, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.YELLOW_BED, BingoDifficulty.NORMAL));
        items.add(new BingoItem(Material.GREEN_BED, BingoDifficulty.NORMAL));
        items.add(new BingoItem(Material.BLUE_BED, BingoDifficulty.NORMAL));
        items.add(new BingoItem(Material.PURPLE_BED, BingoDifficulty.NORMAL));
        items.add(new BingoItem(Material.ITEM_FRAME, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.FLOWER_POT, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.ARMOR_STAND, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.CAMPFIRE, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.BLAST_FURNACE, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.LOOM, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.FLETCHING_TABLE, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.STONECUTTER, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.LANTERN, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.PAINTING, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.ROSE_BUSH, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.PEONY, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.LILAC, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.ANVIL, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.SCAFFOLDING, BingoDifficulty.HARDCORE));
        items.add(new BingoItem(Material.COAL, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.CHARCOAL, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.DIAMOND, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.IRON_INGOT, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.GOLD_INGOT, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.STICK, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.BRICK, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.SNOWBALL, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.WHEAT_SEEDS, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.WHEAT, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.FLINT_AND_STEEL, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.FLINT, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.SUGAR_CANE, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.CLAY_BALL, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.PAPER, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.BOOK, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.BOOKSHELF, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.EGG, BingoDifficulty.EASY));

        // SOME RANDOM BLOCKS
        items.add(new BingoItem(Material.STONE, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.WATER_BUCKET, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.LAVA_BUCKET, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.MILK_BUCKET, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.COMPOSTER, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.SAND, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.SANDSTONE, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.SANDSTONE_SLAB, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.SANDSTONE_STAIRS, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.SANDSTONE_WALL, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.IRON_BLOCK, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.GOLD_BLOCK, BingoDifficulty.NORMAL));
        items.add(new BingoItem(Material.LAPIS_BLOCK, BingoDifficulty.NORMAL));
        items.add(new BingoItem(Material.COBBLESTONE, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.COBBLESTONE_WALL, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.COBBLESTONE_STAIRS, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.COBBLESTONE_SLAB, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.DIRT, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.GRANITE, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.POLISHED_GRANITE, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.ANDESITE, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.POLISHED_ANDESITE, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.ACACIA_LOG, BingoDifficulty.HARDCORE));
        items.add(new BingoItem(Material.BIRCH_LOG, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.DARK_OAK_LOG, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.JUNGLE_LOG, BingoDifficulty.HARDCORE));
        items.add(new BingoItem(Material.OAK_LOG, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.ACACIA_PLANKS, BingoDifficulty.HARDCORE));
        items.add(new BingoItem(Material.BIRCH_PLANKS, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.DARK_OAK_PLANKS, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.JUNGLE_PLANKS, BingoDifficulty.HARDCORE));
        items.add(new BingoItem(Material.OAK_PLANKS, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.ACACIA_SLAB, BingoDifficulty.HARDCORE));
        items.add(new BingoItem(Material.BIRCH_SLAB, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.DARK_OAK_SLAB, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.JUNGLE_SLAB, BingoDifficulty.HARDCORE));
        items.add(new BingoItem(Material.OAK_SLAB, BingoDifficulty.NORMAL));
        items.add(new BingoItem(Material.ACACIA_STAIRS, BingoDifficulty.HARDCORE));
        items.add(new BingoItem(Material.BIRCH_STAIRS, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.DARK_OAK_STAIRS, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.JUNGLE_STAIRS, BingoDifficulty.HARDCORE));

        items.add(new BingoItem(Material.ACACIA_FENCE, BingoDifficulty.HARDCORE));
        items.add(new BingoItem(Material.BIRCH_FENCE, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.DARK_OAK_FENCE, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.JUNGLE_FENCE, BingoDifficulty.HARDCORE));
        items.add(new BingoItem(Material.OAK_FENCE, BingoDifficulty.EASY));

        items.add(new BingoItem(Material.ACACIA_FENCE_GATE, BingoDifficulty.HARDCORE));
        items.add(new BingoItem(Material.BIRCH_FENCE_GATE, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.DARK_OAK_FENCE_GATE, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.JUNGLE_FENCE_GATE, BingoDifficulty.HARDCORE));
        items.add(new BingoItem(Material.OAK_FENCE_GATE, BingoDifficulty.EASY));

        items.add(new BingoItem(Material.JACK_O_LANTERN, BingoDifficulty.NORMAL));
        items.add(new BingoItem(Material.PUMPKIN, BingoDifficulty.NORMAL));
        items.add(new BingoItem(Material.CARVED_PUMPKIN, BingoDifficulty.NORMAL));
        items.add(new BingoItem(Material.NETHERRACK, BingoDifficulty.NORMAL));
        items.add(new BingoItem(Material.OBSIDIAN, BingoDifficulty.NORMAL));
        items.add(new BingoItem(Material.STONE_BRICKS, BingoDifficulty.NORMAL));

        items.add(new BingoItem(Material.OAK_SAPLING, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.SPRUCE_SAPLING, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.BIRCH_SAPLING, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.JUNGLE_SAPLING, BingoDifficulty.HARDCORE));
        items.add(new BingoItem(Material.ACACIA_SAPLING, BingoDifficulty.HARDCORE));
        items.add(new BingoItem(Material.DARK_OAK_SAPLING, BingoDifficulty.NORMAL));

        items.add(new BingoItem(Material.OAK_LEAVES, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.SPRUCE_LEAVES, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.BIRCH_LEAVES, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.JUNGLE_LEAVES, BingoDifficulty.HARDCORE));
        items.add(new BingoItem(Material.ACACIA_LEAVES, BingoDifficulty.HARDCORE));
        items.add(new BingoItem(Material.DARK_OAK_LEAVES, BingoDifficulty.NORMAL));


        // COLOR
        items.add(new BingoItem(Material.WHITE_WOOL, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.ORANGE_WOOL, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.PINK_WOOL, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.LIGHT_BLUE_WOOL, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.YELLOW_WOOL, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.LIGHT_GRAY_WOOL, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.PINK_WOOL, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.GRAY_WOOL, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.LIGHT_GRAY_WOOL, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.CYAN_WOOL, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.PURPLE_WOOL, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.BLUE_WOOL, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.BROWN_WOOL, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.GREEN_WOOL, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.RED_WOOL, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.BLACK_WOOL, BingoDifficulty.EASY));

        items.add(new BingoItem(Material.WHITE_STAINED_GLASS, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.ORANGE_STAINED_GLASS, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.PINK_STAINED_GLASS, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.LIGHT_BLUE_STAINED_GLASS, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.YELLOW_STAINED_GLASS, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.LIGHT_GRAY_STAINED_GLASS, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.PINK_STAINED_GLASS, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.GRAY_STAINED_GLASS, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.LIGHT_GRAY_STAINED_GLASS, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.CYAN_STAINED_GLASS, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.PURPLE_STAINED_GLASS, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.BLUE_STAINED_GLASS, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.BROWN_STAINED_GLASS, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.GREEN_STAINED_GLASS, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.RED_STAINED_GLASS, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.BLACK_STAINED_GLASS, BingoDifficulty.EASY));

        items.add(new BingoItem(Material.WHITE_CARPET, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.ORANGE_CARPET, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.PINK_CARPET, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.LIGHT_BLUE_CARPET, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.YELLOW_CARPET, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.LIGHT_GRAY_CARPET, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.PINK_CARPET, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.GRAY_CARPET, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.LIGHT_GRAY_CARPET, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.CYAN_CARPET, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.PURPLE_CARPET, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.BLUE_CARPET, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.BROWN_CARPET, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.GREEN_CARPET, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.RED_CARPET, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.BLACK_CARPET, BingoDifficulty.EASY));

        items.add(new BingoItem(Material.WHITE_DYE, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.ORANGE_DYE, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.PINK_DYE, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.LIGHT_BLUE_DYE, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.YELLOW_DYE, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.LIGHT_GRAY_DYE, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.PINK_DYE, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.GRAY_DYE, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.LIGHT_GRAY_DYE, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.CYAN_DYE, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.PURPLE_DYE, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.BLUE_DYE, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.BROWN_DYE, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.GREEN_DYE, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.RED_DYE, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.BLACK_DYE, BingoDifficulty.EASY));

        items.add(new BingoItem(Material.BONE_MEAL, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.BONE_BLOCK, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.BONE, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.MAP, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.GRAVEL, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.IRON_NUGGET, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.GOLD_NUGGET, BingoDifficulty.EASY));
        items.add(new BingoItem(Material.RABBIT_HIDE, BingoDifficulty.HARDCORE));

        for (int i = 0; i < 5; i++) {
            Collections.shuffle(items);
        }


    }

    public List<BingoItem> getItems() {
        return items;
    }
}
