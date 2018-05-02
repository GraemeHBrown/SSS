package com.graemehbrown.simplestockmarket.Utils;

import com.graemehbrown.simplestockmarket.Model.Stock;
import com.graemehbrown.simplestockmarket.Model.Trade;
import com.graemehbrown.simplestockmarket.Model.TradeIndicator;
import com.graemehbrown.simplestockmarket.Repository.DataRepository;
import com.graemehbrown.simplestockmarket.exception.SimpleStockException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TradeUtils {
    private static DataRepository dataRepository = DataRepository.getInstance();

    public static TradeIndicator getTradeIndicator() throws SimpleStockException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter trade type: 'buy' or 'sell'\r\n");
        TradeIndicator type = null;

        String tradeType;
        try {
            tradeType = br.readLine().trim();
            type = TradeIndicator.valueOf(tradeType.toUpperCase());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            throw new SimpleStockException("Error - please enter only 'buy' or 'sell'");
        }
        return type;

    }

    public static int getQuantityToBeTraded() throws SimpleStockException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter quantity to be traded");
        String quantity;
        int result = 0;

        try {
            quantity = br.readLine().trim();
            result = Integer.parseInt(quantity);
            if (result <= 0) {
                throw new SimpleStockException("Error - quantity must be greater than 0");
            }

        } catch (NumberFormatException e) {
            throw new SimpleStockException("Error - not a number");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<Trade> getTrades(Stock selectedStock, int durationInMinutesToCalculate) {
        List<Trade> tradesWithinTimeRange = new ArrayList<>();
        Date beginningOfRange = DateUtils.getBeginningOfRange(durationInMinutesToCalculate);
        List<Trade> allTradesForStock = dataRepository.getAllTradesForStock(selectedStock.getSymbol());
        for (Trade trade : allTradesForStock) {
            if (trade.getTimestamp().after(beginningOfRange)) {
                tradesWithinTimeRange.add(trade);
            }
        }
        return tradesWithinTimeRange;
    }

}


