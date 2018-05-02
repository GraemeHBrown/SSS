import com.graemehbrown.simplestockmarket.Model.Stock;
import com.graemehbrown.simplestockmarket.Model.StockType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StockTest {
    private Stock testStock;

    @Before
    public void before() {
        testStock = new Stock("TEA", StockType.COMMON, 0, 0, 100);

    }

    @Test
    public void stockHasSymbol() {
        assertEquals("TEA", testStock.getSymbol());
    }

    @Test
    public void stockHasStockType() {
        assertEquals(StockType.COMMON, testStock.getType());
    }

    @Test
    public void stockHasLastDividendValue() {
        assertEquals(0, testStock.getLastDividend(), 2);
    }

    @Test
    public void stockHasFixedDividendValue() {
        assertEquals(0, testStock.getFixedDividend(),2);
    }

    @Test
    public void stockHasParValue() {
        assertEquals(100, testStock.getParValue(),2);
    }



}
