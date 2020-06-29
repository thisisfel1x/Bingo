package de.fel1x.bingo.generation;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import de.fel1x.bingo.Bingo;
import de.fel1x.bingo.objects.BingoDifficulty;
import de.fel1x.bingo.objects.BingoItem;

import java.util.List;
import java.util.Random;

public class ItemGenerator {

    BiMap<Integer, BingoItem> possibleItems = HashBiMap.create();

    BingoDifficulty bingoDifficulty = BingoDifficulty.EASY;
    Bingo bingo = Bingo.getInstance();

    List<BingoItem> items;
    Random random;

    public ItemGenerator() {

        items = bingo.getItems().getItems();
        random = new Random();

        for (int i = 0; i < 9; i++) {

            this.generateNewItem(i);

        }

    }

    public BiMap<Integer, BingoItem> getPossibleItems() {
        return possibleItems;
    }

    public BingoItem generateNewItem(int finalI) {

        int possibility;
        BingoItem bingoItem;

        if (bingoDifficulty.equals(BingoDifficulty.NORMAL)) {

            possibility = random.nextInt(20);
            bingoItem = items.get(random.nextInt(items.size()));

            if (possibility <= 3) {
                while (bingoItem.getBingoDifficulty() != BingoDifficulty.HARDCORE) {
                    bingoItem = items.get(random.nextInt(items.size()));
                }
            } else if (possibility <= 10) {
                while (bingoItem.getBingoDifficulty() != BingoDifficulty.EASY) {
                    bingoItem = items.get(random.nextInt(items.size()));
                }
            } else {
                while (bingoItem.getBingoDifficulty() != BingoDifficulty.NORMAL) {
                    bingoItem = items.get(random.nextInt(items.size()));
                }
            }

        } else if (bingoDifficulty.equals(BingoDifficulty.HARDCORE)) {

            possibility = random.nextInt(20);
            bingoItem = items.get(random.nextInt(items.size()));
            if (possibility <= 3) {
                while (bingoItem.getBingoDifficulty() != BingoDifficulty.EASY) {
                    bingoItem = items.get(random.nextInt(items.size()));
                }
            } else if (possibility <= 10) {
                while (bingoItem.getBingoDifficulty() != BingoDifficulty.NORMAL) {
                    bingoItem = items.get(random.nextInt(items.size()));
                }
            } else {
                while (bingoItem.getBingoDifficulty() != BingoDifficulty.HARDCORE) {
                    bingoItem = items.get(random.nextInt(items.size()));
                }
            }

        } else {

            possibility = random.nextInt(20);
            bingoItem = items.get(random.nextInt(items.size()));

            if (possibility <= 3) {
                while (bingoItem.getBingoDifficulty() != BingoDifficulty.NORMAL) {
                    bingoItem = items.get(random.nextInt(items.size()));
                }
            } else {
                while (bingoItem.getBingoDifficulty() != BingoDifficulty.EASY) {
                    bingoItem = items.get(random.nextInt(items.size()));
                }
            }
        }

        items.remove(bingoItem);

        String name = bingoItem.getMaterial().name();
        this.possibleItems.put(finalI, bingoItem);

        if (name.contains("glass") || name.contains("wool")) {
            items.stream().filter(item -> item.getMaterial().name().contains(name)).forEach(items::remove);
        }

        return bingoItem;

    }
}
