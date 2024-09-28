package com.wynnventory.model.item;

import com.wynntils.models.items.items.game.IngredientItem;

public class SimplifiedIngredientItem {
    private String name;
    private int level;
    private int rarity;

    public SimplifiedIngredientItem(IngredientItem item) {
        this.name = item.getName();
        this.level = item.getLevel();
        this.rarity = item.getQualityTier();
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getRarity() {
        return rarity;
    }

}

