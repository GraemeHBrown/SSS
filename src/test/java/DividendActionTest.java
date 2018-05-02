import com.graemehbrown.simplestockmarket.Action.DividendAction;
import com.graemehbrown.simplestockmarket.Model.Stock;
import com.graemehbrown.simplestockmarket.Model.StockType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DividendActionTest {
    DividendAction testAction;
    Stock testStock1;
    Stock testStock2;
    Stock testStock3;
    Stock testStock4;
    Stock testStock5;


    @Before
    public void before() {
        testAction = new DividendAction();
        testStock1 = new Stock("TEA", StockType.COMMON, 0, 0, 100);
        testStock2 = new Stock("ALE", StockType.COMMON, 23, 0, 60);
        testStock3 = new Stock("GIN", StockType.PREFERRED, 8, 2, 100);
        testStock4 = new Stock("GIN", StockType.PREFERRED, 8, 0, 100);
        testStock5 = new Stock("GIN", StockType.PREFERRED, 8, 2, 0);
    }

    @Test
    public void calculateDividendProducesZeroWhenStockDoesNotHaveLastDividend() {
        Double result = testAction.calculateDividendYield(testStock1, 23.0);
        assertEquals(0.00, result, 0.01);
    }

    @Test
    public void calculateDividendProducesCorrectResultForInputOnCommonStockType() {
        Double result = testAction.calculateDividendYield(testStock2, 12.0);
        assertEquals(1.91, result, 0.01);
    }

    @Test
    public void calculateDividendProducesCorrectResultForPreferredStockType() {
        Double result = testAction.calculateDividendYield(testStock3, 12.0);
        assertEquals(16.66, result, 0.01);
    }

    @Test
    public void calculateDividendProducesZeroWhenPreferredStockDoesNotHaveFixedDividend() {
        Double result = testAction.calculateDividendYield(testStock4, 12.0);
        assertEquals(0.00, result, 0.01);
    }

    @Test
    public void calculateDividendProducesZeroWhenPreferredStockDoesNotHaveParValue() {
        Double result = testAction.calculateDividendYield(testStock5, 12.0);
        assertEquals(0.00, result, 0.01);
    }

}
