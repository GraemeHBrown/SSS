package com.graemehbrown.simplestockmarket;

public enum MarketActionType {

    DIVIDEND_YIELD(1), PE_RATIO(2), RECORD_TRADE(3), WEIGHTED_STOCK_PRICE(4), GBCE(5), TEST(6);


    private final int value;

    MarketActionType(int value) {
        this.value = value;
    }

    public static MarketActionType getMarketAction(int index) {
        for (MarketActionType action : MarketActionType.values()) {
            if (action.value == index) return action;
        }
        throw new IllegalArgumentException("Season");
    }


}
