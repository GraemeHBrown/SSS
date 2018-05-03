package com.graemehbrown.simplestockmarket;

import com.graemehbrown.simplestockmarket.Action.MarketAction;
import com.graemehbrown.simplestockmarket.Model.Stock;
import com.graemehbrown.simplestockmarket.Model.StockType;
import com.graemehbrown.simplestockmarket.Repository.DataRepository;
import com.graemehbrown.simplestockmarket.exception.SimpleStockException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    private static DataRepository dataRepository = DataRepository.getInstance();

    public static void main(String[] args) {
        populateStockData();

        do {
            try {
                int input = displayOptionsMenu();

                if (input == 6) {
                    System.out.println("You have quit the program\r\n");
                    return;
                } else {
                    MarketActionType actionType = MarketActionType.getMarketAction(input);
                    MarketActionSupplier actionSupplier = new MarketActionSupplier();
                    MarketAction actionToUndertake = actionSupplier.supplyAction(actionType);
                    String result = actionToUndertake.doAction();
                    printResult(result);
                }
            } catch (SimpleStockException e) {
                System.out.println(e.getMessage());
            }

        } while (true);

    }

    private static void populateStockData() {
        dataRepository.addStock(new Stock("TEA", StockType.COMMON, 0, 0, 100));
        dataRepository.addStock(new Stock("POP", StockType.COMMON, 8, 0, 100));
        dataRepository.addStock(new Stock("ALE", StockType.COMMON, 23, 0, 60));
        dataRepository.addStock(new Stock("GIN", StockType.PREFERRED, 8, 2, 100));
        dataRepository.addStock(new Stock("JOE", StockType.COMMON, 13, 0, 250));
    }

    public static int displayOptionsMenu() throws SimpleStockException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Simple Stock Market - Command Line Application");
        System.out.println("----------------------------------------------");
        System.out.println("Menu Options:");
        System.out.println("1. Calculate dividend yield for stock");
        System.out.println("2. Calculate P/E ratio for stock");
        System.out.println("3. Record a trade");
        System.out.println("4. Calculate volume weighted stock price for trades");
        System.out.println("5. Calculate GBCE index");
        System.out.println("6. Exit the program");
        System.out.println("");
        System.out.print("Please select an option from 1-5\r\n");

        try {
            int input = Integer.parseInt(br.readLine().trim());
            if (input < 1 || input > 6) {
                throw new SimpleStockException("Error - value entered outside range.");
            }
            return input;
        } catch (IOException | NumberFormatException e) {
            throw new SimpleStockException("Error - incorrect input format.");
        }
    }

    private static void printResult(String result) {
        System.out.println("-------------------------------------");
        System.out.println(result);
        System.out.println("-------------------------------------");
        System.out.println("");
    }


}

//convert to enum then use switchtosupplier with enum as key in map


