package de.fel1x.bingo.scenarios;

import de.fel1x.bingo.Bingo;
import de.fel1x.bingo.Data;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.FallingBlock;
import org.bukkit.material.MaterialData;

import java.util.Random;

public class AnvilRain implements IBingoScenario {

    Bingo bingo = Bingo.getInstance();
    Data data = bingo.getData();

    Random random = new Random();

    @Override
    public void execute() {

        data.getPlayers().forEach(player -> {

            int toGo = random.nextInt(5) + 15;

            for (int i = 0; i < toGo; i++) {

                Location currentLocation = player.getLocation();

                int x = (random.nextInt(7)) * ((random.nextBoolean()) ? 1 : -1);
                int z = (random.nextInt(7)) * ((random.nextBoolean()) ? 1 : -1);
                Block blockToChange = currentLocation.add(x, 25, z).getBlock();

                if (blockToChange.getType() != Material.AIR && blockToChange.getType() != Material.CAVE_AIR) continue;

                FallingBlock fallingBlock = blockToChange.getLocation().getWorld().spawnFallingBlock(blockToChange.getLocation(),
                        new MaterialData(Material.ANVIL));

                this.bingo.getFallingAnvils().add(fallingBlock);

            }

        });

    }

    @Override
    public String getName() {
        return "Anvil Rain";
    }
}
