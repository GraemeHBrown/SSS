import com.graemehbrown.simplestockmarket.Model.Stock;
import com.graemehbrown.simplestockmarket.Model.StockType;
import com.graemehbrown.simplestockmarket.Model.Trade;
import com.graemehbrown.simplestockmarket.Model.TradeIndicator;
import com.graemehbrown.simplestockmarket.Repository.DataRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DataRepositoryTest {

    private static DataRepository dataRepository = DataRepository.getInstance();
    private Stock testStock;
    private Stock testStock2;
    private Trade testTrade;

    @Before
    public void before() {
        testStock = new Stock("TEA", StockType.COMMON, 0, 0, 100);
        testStock2 = new Stock("POP", StockType.COMMON, 16, 0, 100);
        testTrade = new Trade(testStock, Calendar.getInstance().getTime(), 23, TradeIndicator.BUY, 12.50);
        dataRepository.addStock(testStock);
    }

    @Test
    public void getStockReturnsStockForSymbol() {
        Stock foundStock = dataRepository.getStock(testStock.getSymbol());
        assertEquals("TEA", foundStock.getSymbol());
    }

    @Test
    public void addStockAddStockToStockList() {
        assertEquals(1, dataRepository.getStockList().size());
        dataRepository.addStock(testStock2);
        assertEquals(2, dataRepository.getStockList().size());
    }

    @Test
    public void addTradeAddsTradeToTradeList() {
        int tradeListSizeBefore = dataRepository.getTradeList().size();
        dataRepository.addTrade(testTrade);
        assertEquals(tradeListSizeBefore+1, dataRepository.getTradeList().size());
    }

    @Test
    public void getTradeListReturnsListOfTrades() {
        assertEquals(0, dataRepository.getTradeList().size());
        dataRepository.addTrade(testTrade);
        assertTrue(dataRepository.getTradeList().contains(testTrade));
    }

    @Test
    public void getStockListReturnsListOfStocks() {
        assertTrue(dataRepository.getStockList().contains(testStock));
    }


}
