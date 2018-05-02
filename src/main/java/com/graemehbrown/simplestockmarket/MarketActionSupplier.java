package com.graemehbrown.simplestockmarket;

import com.graemehbrown.simplestockmarket.Action.*;
import com.graemehbrown.simplestockmarket.exception.SimpleStockException;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class MarketActionSupplier {

    private static final Map<MarketActionType, Supplier<MarketAction>> MARKET_ACTION_SUPPLIER;

    static {
        final Map<MarketActionType, Supplier<MarketAction>>
                actions = new HashMap<>();
        actions.put(MarketActionType.DIVIDEND_YIELD, DividendAction::new);
        actions.put(MarketActionType.PE_RATIO, PERatioAction::new);
        actions.put(MarketActionType.RECORD_TRADE, RecordTradeAction::new);
        actions.put(MarketActionType.WEIGHTED_STOCK_PRICE, WeightedStockPriceAction::new);
        actions.put(MarketActionType.GBCE, GBCEAction::new);
        MARKET_ACTION_SUPPLIER = Collections.unmodifiableMap(actions);
    }

    public MarketAction supplyAction(MarketActionType type) {
        Supplier<MarketAction> action = MARKET_ACTION_SUPPLIER.get(type);

        if (action != null) {
            return action.get();
        } else {
            throw new IllegalArgumentException("Invalid action type: "
                    + type);
        }

    }
}
