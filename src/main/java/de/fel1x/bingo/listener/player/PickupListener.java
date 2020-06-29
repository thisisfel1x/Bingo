package de.fel1x.bingo.listener.player;

import de.fel1x.bingo.Bingo;
import de.fel1x.bingo.events.BingoItemUnlockEvent;
import de.fel1x.bingo.gamehandler.Gamestate;
import de.fel1x.bingo.objects.BingoPlayer;
import de.fel1x.bingo.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;

public class PickupListener implements Listener {

    Bingo bingo;

    public PickupListener(Bingo bingo) {
        this.bingo = bingo;
        bingo.getPluginManager().registerEvents(this, bingo);
    }

    @EventHandler
    public void on(EntityPickupItemEvent event) {

        if (!(event.getEntity() instanceof Player)) return;

        Player player = (Player) event.getEntity();
        BingoPlayer bingoPlayer = new BingoPlayer(player);

        Gamestate gamestate = bingo.getGamestateHandler().getGamestate();

        if (gamestate.equals(Gamestate.INGAME)) {
            if (!bingoPlayer.isPlayer()) {
                event.setCancelled(true);
                return;
            }

            if (bingoPlayer.getTeam() == null) {
                return;
            }

            bingo.getItemGenerator().getPossibleItems().values().forEach(bingoItem -> {
                if (bingoItem.getMaterial().equals(event.getItem().getItemStack().getType())) {
                    int unlock = bingo.getItemGenerator().getPossibleItems().inverse().get(bingoItem);
                    Boolean[] array = bingoPlayer.getTeam().getDoneItems();

                    if (!array[unlock]) {
                        array[unlock] = true;

                        bingoPlayer.getTeam().setDoneItems(array);
                        bingoPlayer.getTeam().increaseByOne();

                        Bukkit.broadcastMessage(bingo.getPrefix() + "§a" + player.getDisplayName() + " §8("
                                + Utils.getChatColor(bingoPlayer.getTeam().getColor())
                                + "Team " + bingoPlayer.getTeam().getName() + "§8)"
                                + " §7hat das Item §b§l"
                                + event.getItem().getItemStack().getType().name().replace('_', ' ') + " §7gefunden! §8(§a"
                                + bingoPlayer.getTeam().getDoneItemsSize() + "§7/§c9§8)");

                        Bukkit.getServer().getPluginManager().callEvent(new BingoItemUnlockEvent(player, bingoPlayer.getTeam(), bingoItem));
                    }
                }
            });
        } else {
            event.setCancelled(true);
        }


    }

}
