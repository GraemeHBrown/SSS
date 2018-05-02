import com.graemehbrown.simplestockmarket.Model.Stock;
import com.graemehbrown.simplestockmarket.Model.StockType;
import com.graemehbrown.simplestockmarket.Model.Trade;
import com.graemehbrown.simplestockmarket.Model.TradeIndicator;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

public class TradeTest {
    Trade testTrade;


    @Before
    public void before(){
        Stock testStock = new Stock("TEA", StockType.COMMON, 0, 0, 100);

        testTrade = new Trade(testStock, Calendar.getInstance().getTime(), 23, TradeIndicator.BUY, 12.50);

    }

    @Test
    public void tradeHasStock(){
        assertEquals("TEA", testTrade.getStock().getSymbol());
    }

    @Test
    public void tradeHasQuantityToBeTraded(){
        assertEquals(23, testTrade.getQuantityToBeTraded());
    }

    @Test
    public void tradeHasTradeIndicator(){
        assertEquals(TradeIndicator.BUY, testTrade.getTradeIndicator());
    }

    @Test
    public void tradeHasPrice(){
        assertEquals(12.50, testTrade.getPrice(), 0.01);
    }
}
