package com.wynnventory.model.item;

import com.wynntils.models.gear.type.GearInfo;
import com.wynntils.models.ingredients.type.IngredientInfo;

import java.time.Instant;

public class TradeMarketItemPriceHolder {
    private TradeMarketItemPriceInfo priceInfo;
    private final GearInfo gearInfo;
    private final IngredientInfo ingInfo;
    private final Instant timestamp;

    public TradeMarketItemPriceHolder(TradeMarketItemPriceInfo priceInfo, GearInfo info) {
        this.priceInfo = priceInfo;
        this.gearInfo = info;
        this.ingInfo = null;
        this.timestamp = Instant.now();
    }

    public TradeMarketItemPriceHolder(TradeMarketItemPriceInfo priceInfo, IngredientInfo info) {
        this.priceInfo = priceInfo;
        this.ingInfo = info;
        this.gearInfo = null;
        this.timestamp = Instant.now();
    }

    public void setPriceInfo(TradeMarketItemPriceInfo priceInfo) {
        this.priceInfo = priceInfo;
    }

    public GearInfo getGInfo() {
        return gearInfo;
    }
    public IngredientInfo getIInfo() {
        return ingInfo;
    }

    public TradeMarketItemPriceInfo getPriceInfo() {
        return priceInfo;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public boolean isPriceExpired(long minutes) {
        Instant now = Instant.now();
        return now.isAfter(timestamp.plusSeconds(minutes * 60));
    }
}
