package com.graemehbrown.simplestockmarket.Action;

import com.graemehbrown.simplestockmarket.Model.Stock;
import com.graemehbrown.simplestockmarket.Model.StockType;
import com.graemehbrown.simplestockmarket.Utils.StockUtils;
import com.graemehbrown.simplestockmarket.exception.SimpleStockException;
import org.assertj.core.util.VisibleForTesting;

public class DividendAction extends MarketAction {

    public DividendAction() {
    }

    public String doAction() throws SimpleStockException {
        Stock foundStock = StockUtils.getStockFromSymbol();
        Double price = StockUtils.getPrice();
        Double result = calculateDividendYield(foundStock, price);
        String formattedResult = String.format("%.2f", result);
        return formattedResult;
    }

    @VisibleForTesting
    public Double calculateDividendYield(Stock foundStock, Double price) {
        Double result;
        if (foundStock.getType().equals(StockType.PREFERRED)) {
            result = (foundStock.getFixedDividend() * foundStock.getParValue()) / price;
        } else {
            result = foundStock.getLastDividend() / price;
        }
        return result;

    }

}
