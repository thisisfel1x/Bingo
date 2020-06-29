package de.fel1x.bingo;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Data {

    private List<Player> players;
    private List<Player> spectators;

    public Data() {

        players = new ArrayList<>();
        spectators = new ArrayList<>();

    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Player> getSpectators() {
        return spectators;
    }
}
