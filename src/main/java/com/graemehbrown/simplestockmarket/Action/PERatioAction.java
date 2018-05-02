package com.graemehbrown.simplestockmarket.Action;

import com.graemehbrown.simplestockmarket.Model.Stock;
import com.graemehbrown.simplestockmarket.Utils.StockUtils;
import com.graemehbrown.simplestockmarket.exception.SimpleStockException;
import org.assertj.core.util.VisibleForTesting;

public class PERatioAction extends MarketAction {

    @Override
    public String doAction() throws SimpleStockException {

        Stock foundStock = StockUtils.getStockFromSymbol();
        Double price = StockUtils.getPrice();
        Double result = calculatePERatio(foundStock, price);

        String formattedResult = String.format("%.2f", result);
        return formattedResult;
    }

    @VisibleForTesting
    public Double calculatePERatio(Stock foundStock, Double price) {
        Double result;
        Double dividend = foundStock.getLastDividend();
        if (dividend == 0.00) {
            result = 0.00;
        } else {
            result = price / dividend;
        }

        return result;
    }

}
