package de.fel1x.bingo.listener.player;

import com.destroystokyo.paper.Title;
import de.fel1x.bingo.Bingo;
import de.fel1x.bingo.events.BingoItemUnlockEvent;
import de.fel1x.bingo.objects.BingoPlayer;
import de.fel1x.bingo.objects.BingoTeam;
import de.fel1x.bingo.tasks.EndingTask;
import de.fel1x.bingo.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.FireworkEffect;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;
import java.util.Random;

public class BingoItemListener implements Listener {

    Bingo bingo;
    int timer = 0;

    Random random = new Random();

    public BingoItemListener(Bingo bingo) {
        this.bingo = bingo;
        bingo.getPluginManager().registerEvents(this, bingo);
    }

    @EventHandler
    public void on(BingoItemUnlockEvent event) {

        BingoTeam bingoTeam = event.getTeam();
        boolean allDone = Arrays.stream(bingoTeam.getDoneItems()).allMatch(val -> val);

        if (allDone) {

            bingo.startTimerByClass(EndingTask.class);

            Bukkit.broadcastMessage(bingo.getPrefix() + Utils.getChatColor(bingoTeam.getColor()) + "Team " + bingoTeam.getName()
                    + " §7hat alle Items gefunden und somit die Runde gewonnen!");

            Bukkit.getOnlinePlayers().forEach(player -> {
                BingoPlayer bingoPlayer = new BingoPlayer(player);

                player.sendTitle(Title.builder()
                        .title(Utils.getChatColor(bingoTeam.getColor()) + "§lTeam " + bingoTeam.getName())
                        .subtitle("§7hat das Spiel gewonnen")
                        .fadeIn(10)
                        .stay(40)
                        .fadeOut(10)
                        .build());

                if ((bingoPlayer.isPlayer() && !bingoPlayer.getTeam().equals(event.getTeam())) || bingoPlayer.isSpectator()) {
                    player.teleport(event.getPlayer());
                    if (bingoPlayer.isSpectator()) {
                        Bukkit.getOnlinePlayers().forEach(onlinePlayer -> onlinePlayer.showPlayer(bingo, onlinePlayer));
                    }
                }

                player.playSound(player.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_LAUNCH, 2, 0.5f);

                player.setFoodLevel(20);
                player.setHealth(20);

                player.getInventory().clear();
                player.getInventory().setArmorContents(null);

                player.setHealth(20);
                player.setFoodLevel(20);

                new BukkitRunnable() {
                    @Override
                    public void run() {

                        for (int i = 0; i < 3; i++) {
                            Firework firework = (Firework) player.getWorld().spawnEntity(player.getLocation(), EntityType.FIREWORK);
                            FireworkEffect effect = FireworkEffect.builder().
                                    with(FireworkEffect.Type.values()[random.nextInt(FireworkEffect.Type.values().length)])
                                    .withColor(bingoTeam.getColor())
                                    .build();

                            FireworkMeta meta = firework.getFireworkMeta();
                            meta.setPower(2);
                            meta.addEffect(effect);
                            firework.setFireworkMeta(meta);
                        }

                        if (timer == 10) {
                            this.cancel();
                        }

                        timer++;
                    }
                }.runTaskTimer(bingo, 0L, 10L);
            });
        }
    }
}
