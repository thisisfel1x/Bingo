package de.fel1x.bingo.utils.scoreboard;

import de.fel1x.bingo.objects.BingoPlayer;
import de.fel1x.bingo.objects.BingoTeam;
import de.fel1x.bingo.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BingoScoreboard {

    String[] information = {

            "§7Information",
            "§7Sammle alle §c9 Items",
            "§7und §agewinne die Runde",
            "",
            "§8(§a§l/backpack§r§8)",
            "§8(§a§l/items§r§8)"

    };

    int counter = 0;
    int i;

    private Scoreboard gameScoreboard;
    private Objective objective;

    private Map<BingoTeam, Team> scoreboardTeams;
    private Team spectatorTeam;

    public BingoScoreboard() {

        scoreboardTeams = new HashMap<>();

        gameScoreboard = Bukkit.getScoreboardManager().getNewScoreboard();

        objective = gameScoreboard.registerNewObjective("dummy", "test", "§8» §bteamcrimx§lDE §8«");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        for (BingoTeam bingoTeam : BingoTeam.values()) {

            String color = Utils.getChatColor(bingoTeam.getColor()).toString();

            Team team = gameScoreboard.registerNewTeam("00" + counter + bingoTeam.getName());

            team.setPrefix(String.format("%s%s" + " §8| %s", color, bingoTeam.getName(), color));
            team.setDisplayName(color);
            team.setColor(Objects.requireNonNull(Utils.getChatColor(bingoTeam.getColor())));

            scoreboardTeams.put(bingoTeam, team);
            counter++;

        }

        spectatorTeam = gameScoreboard.registerNewTeam("00999Spectator");
        spectatorTeam.setPrefix("§7§oSpectator §r§8| §7");
        spectatorTeam.setDisplayName("§7");
        spectatorTeam.setColor(ChatColor.GRAY);

        for (int i = 1; i <= 6; i++) {
            Team top = gameScoreboard.registerNewTeam("top" + i);
            top.addEntry("§" + i);
            top.setPrefix(this.information[i - 1]);

            objective.getScore("§" + i).setScore(7 - i);

            objective.getScore("§a").setScore(0);
            objective.getScore("§c").setScore(9);

        }

    }

    public void setGameScoreboard(Player player) {

        BingoPlayer bingoPlayer = new BingoPlayer(player);
        BingoTeam bingoTeam = bingoPlayer.getTeam();

        if (!player.getScoreboard().equals(gameScoreboard)) {
            player.setScoreboard(gameScoreboard);
        }

        if (player.getScoreboard().equals(gameScoreboard)) {

            Team team = this.scoreboardTeams.get(bingoTeam);

            gameScoreboard.getTeams().forEach(scoreboardTeam -> {

                if (scoreboardTeam.hasEntry(player.getName())) {
                    scoreboardTeam.removeEntry(player.getName());
                }

            });

            if (bingoPlayer.isSpectator()) {
                this.spectatorTeam.addEntry(player.getName());
                player.setDisplayName(this.spectatorTeam.getDisplayName() + player.getName());
            } else {
                team.addEntry(player.getName());
                player.setDisplayName(team.getDisplayName() + player.getName());
            }

        }

    }

    public void handleJoin(Player player) {

        if (!player.getScoreboard().equals(gameScoreboard)) {
            player.setScoreboard(gameScoreboard);
            //BukkitCloudNetCloudPermissionsPlugin.getInstance().updateNameTags(player);
        }

        Bukkit.getOnlinePlayers().forEach(current -> {

            BingoPlayer bingoPlayer = new BingoPlayer(player);
            BingoTeam bingoTeam = bingoPlayer.getTeam();

            gameScoreboard.getTeams().forEach(scoreboardTeam -> {

                if (scoreboardTeam.hasEntry(player.getName())) {
                    scoreboardTeam.removeEntry(player.getName());
                }

            });

            if (bingoPlayer.isSpectator()) {
                this.spectatorTeam.addEntry(player.getName());
                player.setDisplayName(this.spectatorTeam.getDisplayName() + player.getName());
            }

            if (bingoTeam == null) return;

            Team team = this.scoreboardTeams.get(bingoTeam);

            team.addEntry(player.getName());
            player.setDisplayName(team.getDisplayName() + player.getName());

        });


    }

    public void handleQuit(Player player) {

        gameScoreboard.getTeams().forEach(scoreboardTeam -> {

            if (scoreboardTeam.hasEntry(player.getName())) {
                scoreboardTeam.removeEntry(player.getName());
            }

        });

    }

    public void updateIngameScoreboard(ArrayList<BingoTeam> sortedTeams) {

        for (int i = 1; i < 7; i++) {

            int finalI = i;
            Bukkit.getOnlinePlayers().forEach(player -> this.updateBoard(player, " ", "top" + finalI));
        }

        i = 1;

        sortedTeams.forEach(bingoTeam -> {

            if (bingoTeam.isEmpty()) return;

            int finalI = i;
            Bukkit.getOnlinePlayers().forEach(player -> this.updateBoard(player,
                    ((bingoTeam.getDoneItemsSize() == 0) ? "" : "§6§l#" + (finalI) + " §7| ")
                            + Utils.getChatColor(bingoTeam.getColor())
                            + bingoTeam.getName() + " §8(§a"
                            + bingoTeam.getDoneItemsSize() + "§7/§c9§8)",
                    "top" + (finalI)));
            i++;
        });
    }

    public void updateBoard(Player player, String value, String score) {

        if (player.getScoreboard().getTeam("top1") != null) {
            Objects.requireNonNull(player.getScoreboard().getTeam(score)).setPrefix(value);
        } else {
            setGameScoreboard(player);
            updateBoard(player, value, score);
        }

    }

}
