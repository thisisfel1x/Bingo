package de.fel1x.bingo.listener.block;

import de.fel1x.bingo.Bingo;
import org.bukkit.Material;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;

public class BlockTransformListener implements Listener {

    Bingo bingo;

    public BlockTransformListener(Bingo bingo) {
        this.bingo = bingo;
        bingo.getPluginManager().registerEvents(this, bingo);
    }

    @EventHandler
    public void on(EntityChangeBlockEvent event) {

        if (event.getEntity() instanceof FallingBlock
                && bingo.getBlocks().contains(event.getEntity())) {

            event.setCancelled(true);
            event.getBlock().setType(Material.AIR);
            bingo.getBlocks().remove(event.getEntity());

        }

    }

}
