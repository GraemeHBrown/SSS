package com.graemehbrown.simplestockmarket.Action;

import com.graemehbrown.simplestockmarket.Model.Trade;
import com.graemehbrown.simplestockmarket.Repository.DataRepository;
import org.assertj.core.util.VisibleForTesting;

import java.util.List;

public class GBCEAction extends MarketAction {
    private static DataRepository dataRepository = DataRepository.getInstance();

    @Override
    public String doAction() {
        String result;

        List<Trade> allTrades = dataRepository.getTradeList();
        if (allTrades == null || allTrades.isEmpty()) {
            result = "No trades recorded";
        } else {

            Double gbce = calculateGBCEForAllStocks(allTrades);
            result = String.format("%.2f", gbce);
        }
        return result;
    }

    @VisibleForTesting
    public double calculateGBCEForAllStocks(List<Trade> allTrades) {
        double total = 1;
        for (Trade trade : allTrades) {
            total *= trade.getPrice();
        }
        return Math.pow(total, (1D / allTrades.size()));
    }


}
