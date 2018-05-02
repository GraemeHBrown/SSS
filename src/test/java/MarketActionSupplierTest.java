import com.graemehbrown.simplestockmarket.Action.DividendAction;
import com.graemehbrown.simplestockmarket.Action.MarketAction;
import com.graemehbrown.simplestockmarket.Action.PERatioAction;
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
}
