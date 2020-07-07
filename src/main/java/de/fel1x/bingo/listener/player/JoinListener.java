package de.fel1x.bingo.listener.player;

import de.fel1x.bingo.Bingo;
import de.fel1x.bingo.gamehandler.Gamestate;
import de.fel1x.bingo.objects.BingoPlayer;
import de.fel1x.bingo.objects.BingoTeam;
import de.fel1x.bingo.tasks.LobbyTask;
import de.fel1x.bingo.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    Bingo bingo;

    public JoinListener(Bingo bingo) {
        this.bingo = bingo;
        bingo.getPluginManager().registerEvents(this, bingo);
    }

    @EventHandler
    public void on(PlayerJoinEvent event) {

        Player player = event.getPlayer();

        BingoPlayer bingoPlayer = new BingoPlayer(player);
        Gamestate gamestate = bingo.getGamestateHandler().getGamestate();

        bingoPlayer.cleanupOnJoin();
        event.setJoinMessage(null);

        int neededPlayers = (BingoTeam.RED.getTeamSize() * 2) - bingo.getData().getPlayers().size();

        switch (gamestate) {

            case IDLE:
            case LOBBY:

                bingoPlayer.addToPlayers();
                event.setJoinMessage(bingo.getPrefix() + "§a" + player.getDisplayName() + " §7hat das Spiel betreten");

                player.getInventory().setItem(0, new ItemBuilder(Material.RED_BED)
                        .setName("§8» §a§lWähle dein Team").toItemStack());

                player.teleport(new Location(Bukkit.getWorlds().get(0), 0.5, 121, 0.5));

                break;

            case INGAME:
                bingoPlayer.addToSpectators();
                bingoPlayer.activateSpectatorMode();

                break;

        }

        if (bingo.getData().getPlayers().size() >= neededPlayers
                && gamestate.equals(Gamestate.IDLE)) {

            bingo.startTimerByClass(LobbyTask.class);

        }

    }
}
