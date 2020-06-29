package de.fel1x.bingo.tasks;

import de.fel1x.bingo.Bingo;
import de.fel1x.bingo.gamehandler.Gamestate;
import org.bukkit.Bukkit;
import org.bukkit.Sound;

public class LobbyTask implements IBingoTask {

    Bingo bingo = Bingo.getInstance();
    int taskId = 0;
    int timer = 30;

    boolean isRunning = false;

    @Override
    public void start() {

        if (!isRunning) {

            isRunning = true;
            bingo.getGamestateHandler().setGamestate(Gamestate.LOBBY);

            taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(bingo, () -> {

                switch (timer) {

                    case 60:
                    case 50:
                    case 40:
                    case 30:
                    case 20:
                    case 10:
                    case 5:
                    case 4:
                    case 3:
                    case 2:
                    case 1:

                        Bukkit.broadcastMessage(bingo.getPrefix() + "§7Die Runde startet in §e"
                                + ((timer == 1) ? "einer Sekunde" : timer + " Sekunden"));

                        bingo.getData().getPlayers().forEach(player ->
                                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1, 0.75f));

                        break;

                    case 0:
                        Bukkit.broadcastMessage(bingo.getPrefix() + "§e§lDie Runde beginnt!");

                        bingo.startTimerByClass(PreGameTask.class);

                        break;

                }

                timer--;

            }, 0L, 20L);
        }

    }

    @Override
    public void stop() {

        if (isRunning) {

            isRunning = false;
            Bukkit.getScheduler().cancelTask(taskId);

            timer = 60;

        }

    }
}
