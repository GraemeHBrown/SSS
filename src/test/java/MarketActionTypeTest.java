import com.graemehbrown.simplestockmarket.MarketActionType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MarketActionTypeTest {

    @Before
    public void setUp() {

    }

    @Test
    public void testInputtingOneReturnsDividendYieldAction() {
        MarketActionType action = MarketActionType.getMarketAction(1);
        assertEquals(MarketActionType.DIVIDEND_YIELD, action);
    }

    @Test
    public void testInputtingTwoReturnsPERatioAction() {
        MarketActionType action = MarketActionType.getMarketAction(2);
        assertEquals(MarketActionType.PE_RATIO, action);
    }

    @Test
    public void testInputtingThreeReturnsTradeRecordAction() {
        MarketActionType action = MarketActionType.getMarketAction(3);
        assertEquals(MarketActionType.RECORD_TRADE, action);
    }

    @Test
    public void testInputtingFourReturnsWeightedStockPriceAction() {
        MarketActionType action = MarketActionType.getMarketAction(4);
        assertEquals(MarketActionType.WEIGHTED_STOCK_PRICE, action);
    }

    @Test
    public void testInputtingFiveReturnsGBCEAction() {
        MarketActionType action = MarketActionType.getMarketAction(5);
        assertEquals(MarketActionType.GBCE, action);
    }
}
