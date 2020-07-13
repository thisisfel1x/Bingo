package de.fel1x.bingo.scenarios;

import de.fel1x.bingo.Bingo;
import de.fel1x.bingo.Data;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.FallingBlock;
import org.bukkit.material.MaterialData;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class AnvilRain implements IBingoScenario {

    Bingo bingo = Bingo.getInstance();
    Data data = bingo.getData();

    Random random = new Random();

    @Override
    public void execute() {

        data.getPlayers().forEach(player -> {

            int toGo = random.nextInt(5) + 15;

            new BukkitRunnable() {

                int timer = 0;

                @Override
                public void run() {

                    for (int i = 0; i < toGo; i++) {

                        Location currentLocation = player.getLocation();

                        int x = (random.nextInt(7)) * ((random.nextBoolean()) ? 1 : -1);
                        int z = (random.nextInt(7)) * ((random.nextBoolean()) ? 1 : -1);
                        Block blockToChange = currentLocation.add(x, 25, z).getBlock();

                        if (blockToChange.getType() != Material.AIR && blockToChange.getType() != Material.CAVE_AIR)
                            continue;

                        FallingBlock fallingBlock = blockToChange.getLocation().getWorld().spawnFallingBlock(blockToChange.getLocation(),
                                new MaterialData(Material.ANVIL));

                        bingo.getFallingAnvils().add(fallingBlock);

                    }

                    if (timer == 10) {
                        this.cancel();
                    }

                    timer++;

                }
            }.runTaskTimer(bingo, 0L, 10L);

        });

    }

    @Override
    public String getName() {
        return "Anvil Rain";
    }

    @Override
    public Material getDisplayMaterial() {
        return Material.ANVIL;
    }
}
