package de.fel1x.bingo.scenarios;

import de.fel1x.bingo.Bingo;
import de.fel1x.bingo.Data;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class RandomPotionEffect implements IBingoScenario {

    Bingo bingo = Bingo.getInstance();
    Data data = bingo.getData();

    Random random = new Random();

    @Override
    public void execute() {

        PotionEffectType[] potionEffectTypes = PotionEffectType.values();

        data.getPlayers().forEach(player -> {

            // Adds a random PotionEffect to all Players
            player.addPotionEffect(new PotionEffect(potionEffectTypes[random.nextInt(potionEffectTypes.length)],
                    (random.nextInt(30) + 45) * 20, random.nextInt(2)));

            player.sendMessage(bingo.getPrefix() + "§7Du hast einen §ezufälligen Effekt §7erhalten!");
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 0.5f);

        });

    }

    @Override
    public String getName() {
        return "Random Potion Effect";
    }

    @Override
    public Material getDisplayMaterial() {
        return Material.POTION;
    }
}
