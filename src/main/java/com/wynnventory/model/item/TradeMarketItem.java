package com.wynnventory.model.item;

import com.wynntils.core.components.Models;
import com.wynntils.models.items.items.game.GearItem;
import com.wynntils.models.items.items.game.IngredientItem;
import com.wynntils.models.trademarket.type.TradeMarketPriceInfo;
import com.wynntils.utils.mc.McUtils;
import com.wynnventory.WynnventoryMod;
import com.wynnventory.util.TradeMarketPriceParser;
import net.minecraft.world.item.ItemStack;

import java.util.Optional;

public class TradeMarketItem {
    private Object item;
    private SimplifiedGearItem simplifiedGearItem;
    private SimplifiedIngredientItem simplifiedIngredientItem;
    private int listingPrice;
    private int amount;
    private String playerName;
    private String modVersion;

    public TradeMarketItem(GearItem item, int listingPrice, int amount) {
        this.item = new SimplifiedGearItem(item);
        this.listingPrice = listingPrice;
        this.amount = amount;
        this.playerName = McUtils.playerName();
        this.modVersion = WynnventoryMod.WYNNVENTORY_VERSION;
    }

    public TradeMarketItem(IngredientItem item, int listingPrice, int amount) {
        this.item = new SimplifiedIngredientItem(item);
        this.listingPrice = listingPrice;
        this.amount = amount;
        this.playerName = McUtils.playerName();
        this.modVersion = WynnventoryMod.WYNNVENTORY_VERSION;
    }

    public static TradeMarketItem createTradeMarketItem(ItemStack item) {
        Optional<GearItem> gearItemOptional = Models.Item.asWynnItem(item, GearItem.class);
        if(gearItemOptional.isPresent()) {
            GearItem gearItem = gearItemOptional.get();
            TradeMarketPriceInfo priceInfo = TradeMarketPriceParser.calculateItemPriceInfo(item);

            if (priceInfo != TradeMarketPriceInfo.EMPTY) {
                return new TradeMarketItem(gearItem, priceInfo.price(), priceInfo.amount());
            }
        }
        Optional<IngredientItem> ingredientItemOptional = Models.Item.asWynnItem(item, IngredientItem.class);
        if (ingredientItemOptional.isPresent()) {
            IngredientItem ingredientItem = ingredientItemOptional.get();
            TradeMarketPriceInfo priceInfo = TradeMarketPriceParser.calculateItemPriceInfo(item);

            if (priceInfo != TradeMarketPriceInfo.EMPTY) {
                return new TradeMarketItem(ingredientItem, priceInfo.price(), priceInfo.amount());
            }
        }

        return null;
    }

    public int getListingPrice() {
        return listingPrice;
    }

    public int getAmount() {
        return amount;
    }
    public Object getItem() {
        return item;
    }

    public String getPlayerName() { return playerName; }

    public String getModVersion() { return modVersion; }
}
