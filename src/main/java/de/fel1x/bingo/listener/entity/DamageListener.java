package de.fel1x.bingo.listener.entity;

import de.fel1x.bingo.Bingo;
import de.fel1x.bingo.gamehandler.Gamestate;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageListener implements Listener {

    Bingo bingo;

    public DamageListener(Bingo bingo) {
        this.bingo = bingo;
        bingo.getPluginManager().registerEvents(this, bingo);
    }

    @EventHandler
    public void on(EntityDamageByEntityEvent event) {

        Gamestate gamestate = bingo.getGamestateHandler().getGamestate();

        if (!gamestate.equals(Gamestate.INGAME)) {
            event.setCancelled(true);
        } else {
            if (event.getDamager() instanceof Player
                    && event.getEntity() instanceof Player) {
                event.setCancelled(true);
            }
        }

    }

    @EventHandler
    public void on(EntityDamageEvent event) {

        Gamestate gamestate = bingo.getGamestateHandler().getGamestate();

        if (!gamestate.equals(Gamestate.INGAME)) {
            event.setCancelled(true);
        } else {
            if (event.getCause().equals(EntityDamageEvent.DamageCause.FALL)) {
                event.setCancelled(true);
            }
        }

    }

}
