package de.fel1x.bingo;

import de.fel1x.bingo.commands.BackpackCommand;
import de.fel1x.bingo.commands.ItemsCommand;
import de.fel1x.bingo.commands.SkipItemCommand;
import de.fel1x.bingo.gamehandler.GamestateHandler;
import de.fel1x.bingo.generation.ItemGenerator;
import de.fel1x.bingo.generation.Items;
import de.fel1x.bingo.listener.block.BlockBreakListener;
import de.fel1x.bingo.listener.block.BlockPlaceListener;
import de.fel1x.bingo.listener.block.BlockTransformListener;
import de.fel1x.bingo.listener.entity.DamageListener;
import de.fel1x.bingo.listener.entity.EntityTargetListener;
import de.fel1x.bingo.listener.player.*;
import de.fel1x.bingo.scenarios.IBingoScenario;
import de.fel1x.bingo.tasks.IBingoTask;
import de.fel1x.bingo.tasks.IdleTask;
import de.fel1x.bingo.utils.scoreboard.BingoScoreboard;
import de.fel1x.bingo.utils.world.WorldGenerator;
import fr.minuskube.inv.InventoryManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections.Reflections;

import java.util.ArrayList;

public final class Bingo extends JavaPlugin {

    public static Bingo instance;
    ArrayList<Entity> fallingGlassBlocks, fallingAnvils;
    private String prefix = "§6§lBingo §8● §r";

    private PluginManager pluginManager;
    private Data data;
    private Items items;
    private GamestateHandler gamestateHandler;
    private ItemGenerator itemGenerator;
    private InventoryManager inventoryManager;
    private WorldGenerator worldGenerator;
    private BingoScoreboard bingoScoreboard;

    private IBingoTask bingoTask;

    public static Bingo getInstance() {
        return instance;
    }

    @Override
    public void onLoad() {

        instance = this;

    }

    @Override
    public void onEnable() {

        Bukkit.getConsoleSender().sendMessage(this.prefix + "§6Trying to load Bingo");

        fallingGlassBlocks = new ArrayList<>();
        fallingAnvils = new ArrayList<>();

        pluginManager = Bukkit.getPluginManager();

        data = new Data();
        items = new Items();
        gamestateHandler = new GamestateHandler();
        itemGenerator = new ItemGenerator();

        bingoScoreboard = new BingoScoreboard();

        inventoryManager = new InventoryManager(this);
        inventoryManager.init();

        this.registerListener();
        this.registerCommands();

        worldGenerator = new WorldGenerator();

        bingoTask = new IdleTask();
        bingoTask.start();

        Bukkit.getConsoleSender().sendMessage(this.prefix + "§aThe plugin was successfully enabled!");

    }

    @Override
    public void onDisable() {

        Bukkit.getConsoleSender().sendMessage(this.prefix + "§cThe plugin was successfully disabled!");

    }

    private void registerCommands() {

        new ItemsCommand(this);
        new BackpackCommand(this);
        new SkipItemCommand(this);

    }

    private void registerListener() {

        // PLAYER
        new JoinListener(this);
        new QuitListener(this);
        new PickupListener(this);
        new InteractListener(this);
        new BingoItemListener(this);
        new InventoryClickListener(this);
        new FoodListener(this);
        new DeathListener(this);
        new RespawnListener(this);
        new ChatListener(this);
        new ServerPingListener(this);
        new BucketListener(this);

        // BLOCK
        new BlockTransformListener(this);
        new BlockBreakListener(this);
        new BlockPlaceListener(this);

        // ENTITY
        new DamageListener(this);
        new EntityTargetListener(this);

    }

    public void startTimerByClass(Class<?> clazz) {

        this.getBingoTask().stop();

        try {
            if (!(clazz.newInstance() instanceof IBingoTask)) {
                return;
            }

            this.setBingoTask((IBingoTask) clazz.newInstance());
            this.getBingoTask().start();

        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Class<? extends IBingoScenario>> startRandomScenario() {

        Reflections reflections = new Reflections("de.fel1x.bingo.scenarios");
        return new ArrayList<>(reflections.getSubTypesOf(IBingoScenario.class));

    }

    public String getPrefix() {
        return prefix;
    }

    public Data getData() {
        return data;
    }

    public Items getItems() {
        return items;
    }

    public GamestateHandler getGamestateHandler() {
        return gamestateHandler;
    }

    public ItemGenerator getItemGenerator() {
        return itemGenerator;
    }

    public PluginManager getPluginManager() {
        return pluginManager;
    }

    public InventoryManager getInventoryManager() {
        return inventoryManager;
    }

    public IBingoTask getBingoTask() {
        return bingoTask;
    }

    public void setBingoTask(IBingoTask bingoTask) {
        this.bingoTask = bingoTask;
    }

    public WorldGenerator getWorldGenerator() {
        return worldGenerator;
    }

    public ArrayList<Entity> getFallingGlassBlocks() {
        return fallingGlassBlocks;
    }

    public BingoScoreboard getBingoScoreboard() {
        return bingoScoreboard;
    }

    public ArrayList<Entity> getFallingAnvils() {
        return fallingAnvils;
    }
}
