package com.graemehbrown.simplestockmarket.Action;

import com.graemehbrown.simplestockmarket.Model.Stock;
import com.graemehbrown.simplestockmarket.Model.Trade;
import com.graemehbrown.simplestockmarket.Model.TradeIndicator;
import com.graemehbrown.simplestockmarket.Repository.DataRepository;
import com.graemehbrown.simplestockmarket.Utils.StockUtils;
import com.graemehbrown.simplestockmarket.Utils.TradeUtils;
import com.graemehbrown.simplestockmarket.exception.SimpleStockException;

import java.util.Calendar;

public class RecordTradeAction extends MarketAction {
    private static DataRepository dataRepository = DataRepository.getInstance();

    @Override
    public String doAction() throws SimpleStockException {
        Stock stockToTrade = StockUtils.getStockFromSymbol();
        TradeIndicator indicator = TradeUtils.getTradeIndicator();
        int quantityToBeTraded = TradeUtils.getQuantityToBeTraded();
        Double price = StockUtils.getPrice();
        Trade tradeToAdd = new Trade(stockToTrade, Calendar.getInstance().getTime(), quantityToBeTraded, indicator, price);
        dataRepository.addTrade(tradeToAdd);
        return tradeToAdd.toString();
    }

}
