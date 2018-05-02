package com.graemehbrown.simplestockmarket.Repository;

import com.graemehbrown.simplestockmarket.Model.Stock;
import com.graemehbrown.simplestockmarket.Model.Trade;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataRepository {

    private static DataRepository instance = null;

    public static DataRepository getInstance() {
        if (instance == null) {
            instance = new DataRepository();
        }
        return instance;
    }

    private List<Stock> stockList = new ArrayList<>();
    private List<Trade> tradeList = new ArrayList<>();

    public Stock getStock(String stockSymbol) {
        return stockList.stream().filter(stock -> stock.getSymbol().equals(stockSymbol)).findFirst().orElse(null);
    }

    public void addStock(Stock stockToAdd) {
        stockList.add(stockToAdd);
    }

    public void addTrade(Trade tradeToAdd){
        tradeList.add(tradeToAdd);
    }

    public List<Trade> getTradeList(){
        return this.tradeList;
    }

    public List<Stock> getStockList(){
        return this.stockList;
    }

    public List<Trade> getAllTradesForStock(String stockSymbol) {
         return tradeList.stream().filter(trade -> trade.getStock().getSymbol().equals(stockSymbol)).collect(Collectors.toList());
    }
}
