package com.graemehbrown.simplestockmarket.Model;

import java.util.Date;

public class Trade implements Comparable<Trade> {

    private Stock stock;

    private Date timestamp;

    private int quantityToBeTraded;

    private TradeIndicator type;

    private double price;

    public Trade(Stock stock, Date timestamp, int quantityToBeTraded, TradeIndicator type, double price) {
        super();
        this.stock = stock;
        this.timestamp = timestamp;
        this.quantityToBeTraded = quantityToBeTraded;
        this.type = type;
        this.price = price;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getQuantityToBeTraded() {
        return quantityToBeTraded;
    }

    public void setQuantityToBeTraded(int quantityToBeTraded) {
        this.quantityToBeTraded = quantityToBeTraded;
    }

    public TradeIndicator getTradeIndicator() {
        return type;
    }

    public void setTradeIndicator(TradeIndicator type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int compareTo(Trade trade) {
        return trade.getTimestamp().compareTo(this.timestamp);
    }

    public String toString(){
        return "Trade details: " + "Stock symbol: " + this.stock.getSymbol() + " Timestamp: "
                + this.timestamp + " Quantity to be traded: "
                + this.quantityToBeTraded + " Trade type: " + this.getTradeIndicator()
                + " Price: " + this.getPrice();
    }

}
