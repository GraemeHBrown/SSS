import com.graemehbrown.simplestockmarket.Action.GBCEAction;
import com.graemehbrown.simplestockmarket.Action.WeightedStockPriceAction;
import com.graemehbrown.simplestockmarket.Model.Stock;
import com.graemehbrown.simplestockmarket.Model.StockType;
import com.graemehbrown.simplestockmarket.Model.Trade;
import com.graemehbrown.simplestockmarket.Model.TradeIndicator;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GBCEActionTest {
    private List<Trade> testTrades = new ArrayList<>();
    private GBCEAction gbceAction;

    @Before
    public void before() {
        Stock testStock = new Stock("TEA", StockType.COMMON, 0, 0, 100);
        Trade testTrade = new Trade(testStock, Calendar.getInstance().getTime(), 10, TradeIndicator.BUY, 20);
        Trade testTrade2 = new Trade(testStock, Calendar.getInstance().getTime(), 5, TradeIndicator.BUY, 5);
        testTrades.add(testTrade);
        testTrades.add(testTrade2);
        gbceAction = new GBCEAction();
    }

    @Test
    public void calculateGBCEForAllStocksReturnsIndex(){
         Double gbce =  gbceAction.calculateGBCEForAllStocks(testTrades);
            assertEquals(10.00, gbce, 0.01);
    }
}
