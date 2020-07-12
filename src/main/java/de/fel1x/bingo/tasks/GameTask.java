package de.fel1x.bingo.tasks;

import de.fel1x.bingo.Bingo;
import de.fel1x.bingo.gamehandler.Gamestate;
import de.fel1x.bingo.objects.BingoTeam;
import de.fel1x.bingo.scenarios.IBingoScenario;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class GameTask implements IBingoTask {

    Bingo bingo = Bingo.getInstance();
    int taskId = 0;
    int timer = 0;

    boolean isRunning = false;

    BossBar bossBar;

    Random random = new Random();
    int eventTimer = random.nextInt(120) + 60;
    double timeToGo = eventTimer;

    @Override
    public void start() {

        bossBar = bingo.getServer().createBossBar(String.format("§7Nächstes Event in §e%s Sekunden", eventTimer),
                BarColor.GREEN, BarStyle.SEGMENTED_20, BarFlag.DARKEN_SKY);
        bossBar.removeFlag(BarFlag.DARKEN_SKY);

        Bukkit.getOnlinePlayers().forEach(player -> bossBar.addPlayer(player));

        if (!isRunning) {

            isRunning = true;
            bingo.getGamestateHandler().setGamestate(Gamestate.INGAME);

            taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(bingo, () -> {

                bossBar.setColor(this.getColor(eventTimer));
                bossBar.setProgress(eventTimer / timeToGo);
                if(eventTimer > 0) {
                    bossBar.setTitle(String.format("§7Nächstes Event in §e%s", ((eventTimer == 1) ? "einer Sekunde" :
                            ((eventTimer <= 60) ? eventTimer + " Sekunden" :
                                    String.format("%02d:%02d", eventTimer / 60, eventTimer % 60)))));
                }

                Bukkit.getOnlinePlayers().forEach(player -> player.sendActionBar("§7Vergangene Zeit: §e§l" + this.formatSeconds(timer)));

                if (eventTimer == 0) {
                    eventTimer = random.nextInt(120) + 60;
                    timeToGo = eventTimer;

                    try {
                        IBingoScenario bingoScenario = bingo.startRandomScenario().get(random.nextInt(bingo.startRandomScenario().size())).newInstance();
                        bingoScenario.execute();
                        bossBar.setTitle("§7Event §8» §a§l" + bingoScenario.getName());
                    } catch (InstantiationException | IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }

                timer++;
                eventTimer--;

                bingo.getBingoScoreboard().updateIngameScoreboard(this.getTopTeams());

            }, 0L, 20L);
        }

    }

    @Override
    public void stop() {

        if (isRunning) {

            isRunning = false;
            Bukkit.getScheduler().cancelTask(taskId);

        }

    }

    public ArrayList<BingoTeam> getTopTeams() {

        ArrayList<BingoTeam> teams = new ArrayList<>(Arrays.asList(BingoTeam.values()));

        teams.sort((o1, o2) -> {

            int i1 = o1.getDoneItemsSize();
            int i2 = o2.getDoneItemsSize();

            if (i1 > i2) {
                return 1;
            } else if (i1 < i2) {
                return -1;
            }

            return 0;

        });

        Collections.reverse(teams);

        return teams;

    }

    private String formatSeconds(int timeInSeconds) {
        int secondsLeft = timeInSeconds % 3600 % 60;
        int minutes = (int) Math.floor(timeInSeconds % 3600D / 60D);
        int hours = (int) Math.floor(timeInSeconds / 3600D);
        int days = (int) Math.floor(timeInSeconds / 3600D * 24D);

        String HH = ((hours < 10) ? "0" : "") + hours;
        String MM = ((minutes < 10) ? "0" : "") + minutes;
        String SS = ((secondsLeft < 10) ? "0" : "") + secondsLeft;

        return MM + ":" + SS;
    }

    private BarColor getColor(int progress) {

        double fraction = progress / timeToGo;

        if (fraction > 0.66) {
            return BarColor.GREEN;
        } else if (fraction > 0.33) {
            return BarColor.YELLOW;
        } else {
            return BarColor.RED;
        }

    }

    public BossBar getBossBar() {
        return bossBar;
    }
}
