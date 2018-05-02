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

public class WeightedStockPriceActionTest {
    private List<Trade> testTrades = new ArrayList<>();
    private WeightedStockPriceAction wspAction;

    @Before
    public void before() {
        Stock testStock = new Stock("TEA", StockType.COMMON, 0, 0, 100);
        Trade testTrade = new Trade(testStock, Calendar.getInstance().getTime(), 10, TradeIndicator.BUY, 20);
        Trade testTrade2 = new Trade(testStock, Calendar.getInstance().getTime(), 5, TradeIndicator.BUY, 5);
        testTrades.add(testTrade);
        testTrades.add(testTrade2);
        wspAction = new WeightedStockPriceAction();

    }

    @Test
    public void calculateVolumeWeightedStockPriceReturnsPriceForListOfTrades() {
        assertEquals(2, testTrades.size());
        Double vwsp = wspAction.calculateVolumeWeightedStockPrice(testTrades);
        assertEquals(15.0, vwsp, 0.01);
    }
}
