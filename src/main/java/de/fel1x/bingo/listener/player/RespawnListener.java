package de.fel1x.bingo.listener.player;

import de.fel1x.bingo.Bingo;
import de.fel1x.bingo.gamehandler.Gamestate;
import de.fel1x.bingo.objects.BingoPlayer;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class RespawnListener implements Listener {

    Bingo bingo;

    public RespawnListener(Bingo bingo) {
        this.bingo = bingo;
        bingo.getPluginManager().registerEvents(this, bingo);
    }

    @EventHandler
    public void on(PlayerRespawnEvent event) {

        Player player = event.getPlayer();

        BingoPlayer bingoPlayer = new BingoPlayer(player);
        Gamestate gamestate = bingo.getGamestateHandler().getGamestate();

        if (!gamestate.equals(Gamestate.INGAME)) {
            event.setRespawnLocation(new Location(player.getWorld(), 0.5, 121, 0.5));
        } else {
            event.setRespawnLocation(player.getLocation());
        }

    }

}
