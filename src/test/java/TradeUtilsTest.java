import com.graemehbrown.simplestockmarket.Model.Stock;
import com.graemehbrown.simplestockmarket.Model.StockType;
import com.graemehbrown.simplestockmarket.Model.Trade;
import com.graemehbrown.simplestockmarket.Model.TradeIndicator;
import com.graemehbrown.simplestockmarket.Repository.DataRepository;
import com.graemehbrown.simplestockmarket.Utils.DateUtils;
import com.graemehbrown.simplestockmarket.Utils.TradeUtils;
import com.graemehbrown.simplestockmarket.exception.SimpleStockException;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TradeUtilsTest {
    private Stock testStock;
    private Trade testTrade;
    private DataRepository dataRepository;

    @Before
    public void before() {
        dataRepository = DataRepository.getInstance();
        testStock = new Stock("TEA", StockType.COMMON, 0, 0, 100);
        testTrade = new Trade(testStock, Calendar.getInstance().getTime(), 23, TradeIndicator.BUY, 12.50);
    }

    @Test
    public void getTradeIndicatorReturnsCorrectIndicatorBasedOnInput() {
        String choice = "buy";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(choice.getBytes()));
            TradeIndicator type = TradeUtils.getTradeIndicator();
            assertEquals(TradeIndicator.BUY, type);
        } catch (SimpleStockException e) {
            e.printStackTrace();
        } finally {
            System.setIn(stdin);
        }
    }

    @Test
    public void passingNoArgumentToGetTradeIndicatorThrowsException() {
        String choice = " ";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(choice.getBytes()));
            assertThatThrownBy(TradeUtils::getTradeIndicator).isInstanceOf(SimpleStockException.class).hasMessageStartingWith("Error - please enter only 'buy' or 'sell'");
        } finally {
            System.setIn(stdin);
        }
    }

    @Test
    public void passingWrongTypeOfArgumentToGetTradeIndicatorThrowsException() {
        String choice = "23";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(choice.getBytes()));
            assertThatThrownBy(TradeUtils::getTradeIndicator).isInstanceOf(SimpleStockException.class).hasMessageStartingWith("Error - please enter only 'buy' or 'sell'");
        } finally {
            System.setIn(stdin);
        }
    }

    @Test
    public void getQuantityToBeTradedReturnsQuantityEnteredAsAnInt() {
        String choice = "23";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(choice.getBytes()));
            int quantity = TradeUtils.getQuantityToBeTraded();
            assertEquals(23, quantity);
        } catch (SimpleStockException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getQuantityToBeTradedThrowsExceptionWhenNumberLessThanZeroEnterred() {
        String choice = "-2";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(choice.getBytes()));
            assertThatThrownBy(TradeUtils::getQuantityToBeTraded).isInstanceOf(SimpleStockException.class).hasMessageStartingWith("Error - quantity must be greater than 0");
        } finally {
            System.setIn(stdin);
        }
    }

    @Test
    public void getQuantityToBeTradedThrowsExceptionWhenANumberIsNotEntered() {
        String choice = "d";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(choice.getBytes()));
            assertThatThrownBy(TradeUtils::getQuantityToBeTraded).isInstanceOf(SimpleStockException.class).hasMessageStartingWith("Error - not a number");
        } finally {
            System.setIn(stdin);
        }
    }

    @Test
    public void getTradesReturnsListOfTrades() {
        dataRepository.addTrade(testTrade);
        List<Trade> trades = TradeUtils.getTrades(testStock, 15);
        assertTrue(trades.contains(testTrade));
    }

    @Test
    public void getTradesReturnsListOfTradesWithinSpecifiedTimeRange() {
        dataRepository.addTrade(testTrade);
        boolean isWithinRange = true;
        Date beginningOfRange = DateUtils.getBeginningOfRange(15);
        List<Trade> trades = TradeUtils.getTrades(testStock, 15);
        for (Trade trade : trades) {
            if (trade.getTimestamp().before(beginningOfRange)) {
                isWithinRange = false;
            }
        }
        assertTrue(isWithinRange);
    }


}
