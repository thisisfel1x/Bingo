package de.fel1x.bingo.listener.player;

import com.destroystokyo.paper.event.server.PaperServerListPingEvent;
import de.fel1x.bingo.Bingo;
import de.fel1x.bingo.Data;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ServerPingListener implements Listener {

    Bingo bingo;
    Data data;

    public ServerPingListener(Bingo bingo) {
        this.bingo = bingo;
        this.data = bingo.getData();
        bingo.getPluginManager().registerEvents(this, bingo);
    }

    @EventHandler
    public void on(PaperServerListPingEvent event) {

        event.setVersion("[fel1xProxy] Please use 1.15.2!");

    }

}
