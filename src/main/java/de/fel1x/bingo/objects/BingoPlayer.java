package de.fel1x.bingo.objects;

import de.fel1x.bingo.Bingo;
import de.fel1x.bingo.Data;
import de.fel1x.bingo.tasks.GameTask;
import de.fel1x.bingo.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BingoPlayer {

    Player player;

    Bingo bingo = Bingo.getInstance();
    Data data = Bingo.getInstance().getData();

    GameTask gameTask = new GameTask();

    public BingoPlayer(Player player) {
        this.player = player;
    }

    public void addToPlayers() {
        data.getPlayers().add(player);
    }

    public void removeFromPlayers() {
        data.getPlayers().remove(player);
    }

    public boolean isPlayer() {
        return data.getPlayers().contains(player);
    }

    public void addToSpectators() {
        data.getSpectators().add(player);
    }

    public void removeFromSpectators() {
        data.getSpectators().remove(player);
    }

    public boolean isSpectator() {
        return data.getSpectators().contains(player);
    }

    public void setScoreboardOnJoin() {
        this.bingo.getBingoScoreboard().handleJoin(player);
    }

    public void cleanupOnJoin() {

        player.getInventory().clear();
        player.getInventory().setArmorContents(null);

        player.setHealth(20);
        player.setFoodLevel(26);

        player.setLevel(0);
        player.setExp(0);

        player.setGameMode(GameMode.SURVIVAL);

        for (PotionEffect activePotionEffect : player.getActivePotionEffects()) {
            player.removePotionEffect(activePotionEffect.getType());
        }

        player.setPlayerListHeaderFooter("\n §8» §bteamcrimx§lDE §8« \n", "\n §aBingo\n ");

    }

    public void cleanupOnQuit() {

        bingo.getBingoScoreboard().handleQuit(player);

        data.getPlayers().remove(player);
        data.getSpectators().remove(player);

        player.getInventory().clear();
        player.getInventory().setArmorContents(null);

        player.setHealth(20);
        player.setFoodLevel(20);

        for (PotionEffect activePotionEffect : player.getActivePotionEffects()) {
            player.removePotionEffect(activePotionEffect.getType());
        }

        for (BingoTeam team : BingoTeam.values()) {
            team.getTeamPlayers().remove(player);
        }

    }

    public BingoTeam getTeam() {

        for (BingoTeam team : BingoTeam.values()) {

            if (team.getTeamPlayers().contains(player)) {
                return team;
            }

        }

        // PLAYER HAS NO TEAM
        return null;

    }

    public void setTeam(BingoTeam bingoTeam) {

        for (BingoTeam team : BingoTeam.values()) {
            team.getTeamPlayers().remove(player);
        }

        bingoTeam.getTeamPlayers().add(player);

    }

    public void activateSpectatorMode() {

        data.getPlayers().forEach(bingoPlayers -> bingoPlayers.hidePlayer(bingo, player));

        player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 0));
        player.setHealth(20);
        player.setFoodLevel(20);

        player.setGameMode(GameMode.SURVIVAL);
        player.setAllowFlight(true);
        player.setFlying(true);

        player.teleport(new Location(Bukkit.getWorlds().get(0), 0.5, 121, 0.5));

        player.getInventory().setItem(0, new ItemBuilder(Material.COMPASS).setName("§7Spieler beoabachten").toItemStack());

        gameTask.getBossBar().addPlayer(player);

    }
}
