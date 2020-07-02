package de.fel1x.bingo.listener.player;

import de.fel1x.bingo.Bingo;
import de.fel1x.bingo.Data;
import de.fel1x.bingo.gamehandler.Gamestate;
import de.fel1x.bingo.objects.BingoPlayer;
import de.fel1x.bingo.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    Bingo bingo;
    Data data;

    public ChatListener(Bingo bingo) {
        this.bingo = bingo;
        this.data = bingo.getData();
        bingo.getPluginManager().registerEvents(this, bingo);
    }

    @EventHandler
    public void on(AsyncPlayerChatEvent event) {

        Player player = event.getPlayer();
        BingoPlayer bingoPlayer = new BingoPlayer(player);
        Gamestate gamestate = bingo.getGamestateHandler().getGamestate();

        if (gamestate.equals(Gamestate.LOBBY) || gamestate.equals(Gamestate.IDLE)) {

            ChatColor chatColor;

            try {
                chatColor = Utils.getChatColor(bingoPlayer.getTeam().getColor());
            } catch (Exception ignored) {
                chatColor = ChatColor.GRAY;
            }

            event.setFormat(chatColor + player.getName() + " §8» §f" + event.getMessage());
        } else {

            if (data.getSpectators().contains(player)) {

                event.setCancelled(true);
                data.getSpectators().forEach(spectator -> spectator.sendMessage("§7§o" + player.getName() + " §8» §f" + event.getMessage()));

            } else if (data.getPlayers().contains(player)) {
                if (!event.getMessage().startsWith("@a ") && !event.getMessage().startsWith("@all ")) {
                    bingoPlayer.getTeam().getTeamPlayers().forEach(teamplayer -> {

                        event.setCancelled(true);
                        teamplayer.sendMessage(player.getDisplayName() + " §8» §f" + event.getMessage());

                    });

                } else {

                    String message = event.getMessage();
                    String[] split = null;

                    if(message.startsWith("@a ")) {
                        split = message.split("@a ");
                    } else if(message.startsWith("@all ")) {
                        split = message.split("@all ");
                    }

                    if(split != null) event.setFormat("§7[@all] " + player.getDisplayName() + " §8» §f" + split[1]);
                }

            }

        }

    }

}
