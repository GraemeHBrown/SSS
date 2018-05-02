import com.graemehbrown.simplestockmarket.Action.PERatioAction;
import com.graemehbrown.simplestockmarket.Model.Stock;
import com.graemehbrown.simplestockmarket.Model.StockType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PERatioActionTest {

    PERatioAction peAction;
    private Stock testStock1;
    private Stock testStock2;

    @Before
    public void before() {
        peAction = new PERatioAction();
        testStock1 = new Stock("TEA", StockType.COMMON, 0, 0, 100);
        testStock2 = new Stock("ALE", StockType.COMMON, 23, 0, 60);
    }

    @Test
    public void calculatePERatioProducesCorrectResultForInput() {
        Double result = peAction.calculatePERatio(testStock2, 12.0);
        assertEquals(0.52, result, 0.01);
    }

    @Test
    public void calculatePERatioProducesZeroWhenStockDoesNotHaveLastDividend() {
        Double result = peAction.calculatePERatio(testStock1, 12.0);
        assertEquals(0.00, result, 0.01);
    }

}
