package com.graemehbrown.simplestockmarket.Action;

import com.graemehbrown.simplestockmarket.Model.Stock;
import com.graemehbrown.simplestockmarket.Model.Trade;
import com.graemehbrown.simplestockmarket.Utils.StockUtils;
import com.graemehbrown.simplestockmarket.Utils.TradeUtils;
import com.graemehbrown.simplestockmarket.exception.SimpleStockException;
import org.assertj.core.util.VisibleForTesting;

import java.util.List;

public class WeightedStockPriceAction extends MarketAction {

    @Override
    public String doAction() throws SimpleStockException {
        String result = null;
        Stock foundStock = StockUtils.getStockFromSymbol();
        List<Trade> tradesForSelectedStockInTimeRange = TradeUtils.getTrades(foundStock, 15);
        if (tradesForSelectedStockInTimeRange == null || tradesForSelectedStockInTimeRange.isEmpty()) {
            result = "No trades recorded within specified time range.";
        } else {
            double vwsp = calculateVolumeWeightedStockPrice(tradesForSelectedStockInTimeRange);
            result = String.format("%.2f", vwsp);
        }

        return result;
    }

    @VisibleForTesting
    public double calculateVolumeWeightedStockPrice(List<Trade> trades) {
        double sumOfPriceAndQuantity = 0;
        int sumOfQuantity = 0;

        for (Trade trade : trades) {
            sumOfPriceAndQuantity += (trade.getPrice() * trade.getQuantityToBeTraded());
            sumOfQuantity += trade.getQuantityToBeTraded();
        }
        return sumOfPriceAndQuantity / sumOfQuantity;
    }
}
