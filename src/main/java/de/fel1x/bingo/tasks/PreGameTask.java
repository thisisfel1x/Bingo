package de.fel1x.bingo.tasks;

import com.destroystokyo.paper.Title;
import de.fel1x.bingo.Bingo;
import de.fel1x.bingo.gamehandler.Gamestate;
import de.fel1x.bingo.objects.BingoPlayer;
import de.fel1x.bingo.objects.BingoTeam;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.FallingBlock;
import org.bukkit.util.Vector;

import java.util.Random;

public class PreGameTask implements IBingoTask {

    Bingo bingo = Bingo.getInstance();
    int taskId = 0;
    int timer = 3;

    boolean isRunning = false;

    Random random = new Random();

    @Override
    public void start() {

        if (!isRunning) {

            isRunning = true;
            bingo.getGamestateHandler().setGamestate(Gamestate.PREGAME);

            bingo.getData().getPlayers().forEach(player -> {

                BingoPlayer bingoPlayer = new BingoPlayer(player);
                if (bingoPlayer.getTeam() == null) {
                    for (BingoTeam bingoTeam : BingoTeam.values()) {
                        if (bingoTeam.getTeamPlayers().size() < bingoTeam.getTeamSize()) {
                            bingoPlayer.setTeam(bingoTeam);
                            player.sendMessage(bingo.getPrefix() + "§7Du wurdest zu Team "
                                    + bingoTeam.getName() + " zugewiesen");
                            bingo.getBingoScoreboard().setGameScoreboard(player);
                            break;
                        }
                    }
                }

            });

            taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(bingo, () -> {

                switch (timer) {

                    case 3:
                    case 2:
                    case 1:

                        Bukkit.broadcastMessage(bingo.getPrefix() + "§7Das Spiel startet in §e"
                                + ((timer == 1) ? "einer Sekunde" : timer + " Sekunden"));

                        bingo.getData().getPlayers().forEach(player -> {

                            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 0.75f);
                            player.sendTitle(Title.builder()
                                    .title(((timer == 3) ? "§a§l" : ((timer == 2) ? "§e§l" : "§c§l")) + timer)
                                    .fadeIn(0).stay(20).fadeOut(0).build());

                            player.getInventory().clear();

                        });

                        break;

                    case 0:
                        Bukkit.broadcastMessage(bingo.getPrefix() + "§e§lDas Spiel beginnt!");
                        Bukkit.getScheduler().cancelTasks(bingo);

                        bingo.getGamestateHandler().setGamestate(Gamestate.INGAME);

                        bingo.getData().getPlayers().forEach(player -> {

                            player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1.5f, 1.25f);
                            player.sendTitle(Title.builder()
                                    .title("§a§lGO").fadeIn(0).stay(40).fadeOut(10).build());

                            int x = random.nextInt(20) * (random.nextBoolean() ? -1 : 1);
                            int z = random.nextInt(20) * (random.nextBoolean() ? -1 : 1);

                            player.setVelocity(player.getVelocity().setY(10)
                                    .setX(x).setZ(z));

                            player.setGameMode(GameMode.SURVIVAL);

                        });

                        bingo.getWorldGenerator().getBlocks().forEach(block -> {

                            float x = -2.0F + (float) (Math.random() * 4.0D + 1.0D);
                            float y = -3.0F + (float) (Math.random() * 6.0D + 1.0D);
                            float z = -2.0F + (float) (Math.random() * 4.0D + 1.0D);

                            FallingBlock fallingBlock = block.getWorld().spawnFallingBlock(block.getLocation(), block.getBlockData());
                            bingo.getFallingGlassBlocks().add(fallingBlock);

                            fallingBlock.setVelocity(new Vector(x, y, z));
                            fallingBlock.setDropItem(false);

                            block.setType(Material.AIR);

                        });


                        Bukkit.getWorlds().get(0).getBlockAt(0, 120, 0).setType(Material.AIR);

                        bingo.startTimerByClass(GameTask.class);

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
