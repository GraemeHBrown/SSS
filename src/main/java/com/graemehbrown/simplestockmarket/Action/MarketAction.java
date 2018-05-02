package com.graemehbrown.simplestockmarket.Action;

import com.graemehbrown.simplestockmarket.exception.SimpleStockException;

public abstract class MarketAction {


    MarketAction() {
    }

    public abstract String doAction() throws SimpleStockException;
}
