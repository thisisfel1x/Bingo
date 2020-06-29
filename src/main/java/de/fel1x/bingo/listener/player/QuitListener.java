package de.fel1x.bingo.listener.player;

import de.fel1x.bingo.Bingo;
import de.fel1x.bingo.gamehandler.Gamestate;
import de.fel1x.bingo.objects.BingoPlayer;
import de.fel1x.bingo.objects.BingoTeam;
import de.fel1x.bingo.tasks.IdleTask;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {

    Bingo bingo;

    public QuitListener(Bingo bingo) {
        this.bingo = bingo;
        bingo.getPluginManager().registerEvents(this, bingo);
    }

    @EventHandler
    public void on(PlayerQuitEvent event) {

        Player player = event.getPlayer();

        BingoPlayer bingoPlayer = new BingoPlayer(player);
        Gamestate gamestate = bingo.getGamestateHandler().getGamestate();

        bingoPlayer.cleanupOnQuit();
        event.setQuitMessage(null);

        int neededPlayers = (BingoTeam.RED.getTeamSize() * 2) - bingo.getData().getPlayers().size();

        switch (gamestate) {

            case IDLE:
            case LOBBY:

                event.setQuitMessage(bingo.getPrefix() + "§a" + player.getName() + " §7hat das Spiel verlassen");

                break;


        }

        if (bingo.getData().getPlayers().size() < neededPlayers
                && gamestate.equals(Gamestate.LOBBY)) {

            bingo.startTimerByClass(IdleTask.class);

        }


    }

}
