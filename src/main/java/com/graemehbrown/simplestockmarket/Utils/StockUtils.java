package com.graemehbrown.simplestockmarket.Utils;

import com.graemehbrown.simplestockmarket.Model.Stock;
import com.graemehbrown.simplestockmarket.Repository.DataRepository;
import com.graemehbrown.simplestockmarket.exception.SimpleStockException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StockUtils {
    private static DataRepository dataRepository = DataRepository.getInstance();

    public static Stock getStockFromSymbol() throws SimpleStockException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter stock symbol.\r\n");
        Stock stock;
        try {
            String stockSymbol = br.readLine().trim();
            stock = dataRepository.getStock(stockSymbol);
            if (stock == null) {
                throw new SimpleStockException("Error - Stock not found");
            }
        } catch (IOException e) {
            throw new SimpleStockException("Error - Stock not found");
        }
        return stock;
    }

    public static Double getPrice() throws SimpleStockException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter price.\r\n");
        Double price;
        try {
            price = Double.parseDouble(br.readLine().trim());
            if(price==0.00){
                throw new SimpleStockException("Error - enter price greater than 0");
            }
        } catch (IOException | NumberFormatException e) {
            throw new SimpleStockException("Error - invalid price");
        }
        return price;
    }

}
