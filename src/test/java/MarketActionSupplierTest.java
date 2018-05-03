import com.graemehbrown.simplestockmarket.Action.*;
import com.graemehbrown.simplestockmarket.App;
import com.graemehbrown.simplestockmarket.MarketActionSupplier;
import com.graemehbrown.simplestockmarket.MarketActionType;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertEquals;

public class MarketActionSupplierTest {
    MarketActionSupplier supplier;

    @Before
    public void setup() {
        supplier = new MarketActionSupplier();
    }

    @Test
    public void providingInvalidMarketActionTypeThrowsException() {
        MarketActionType invalidType = MarketActionType.TEST;
        assertThatThrownBy(() -> {
            supplier.supplyAction(invalidType);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageStartingWith("Invalid action type: "
                + invalidType);

    }

    @Test
    public void supplyActionMethodReturnsDividendActionWhenCorrectTypePassedIn(){
        MarketActionType validType = MarketActionType.DIVIDEND_YIELD;
        MarketAction foundAction = supplier.supplyAction(validType);
        assertEquals(DividendAction.class, foundAction.getClass());
    }

    @Test
    public void supplyActionMethodReturnsPERatioActionWhenCorrectTypePassedIn(){
        MarketActionType validType = MarketActionType.PE_RATIO;
        MarketAction foundAction = supplier.supplyAction(validType);
        assertEquals(PERatioAction.class, foundAction.getClass());
    }

    @Test
    public void supplyActionMethodReturnsRecordTradeActionWhenCorrectTypePassedIn(){
        MarketActionType validType = MarketActionType.RECORD_TRADE;
        MarketAction foundAction = supplier.supplyAction(validType);
        assertEquals(RecordTradeAction.class, foundAction.getClass());
    }

    @Test
    public void supplyActionMethodReturnsWeightedStockPriceActionWhenCorrectTypePassedIn(){
        MarketActionType validType = MarketActionType.WEIGHTED_STOCK_PRICE;
        MarketAction foundAction = supplier.supplyAction(validType);
        assertEquals(WeightedStockPriceAction.class, foundAction.getClass());
    }

    @Test
    public void supplyActionMethodReturnsGBCEActionWhenCorrectTypePassedIn(){
        MarketActionType validType = MarketActionType.GBCE;
        MarketAction foundAction = supplier.supplyAction(validType);
        assertEquals(GBCEAction.class, foundAction.getClass());
    }

}
