import com.graemehbrown.simplestockmarket.App;
import com.graemehbrown.simplestockmarket.Model.Stock;
import com.graemehbrown.simplestockmarket.Model.StockType;
import com.graemehbrown.simplestockmarket.Repository.DataRepository;
import com.graemehbrown.simplestockmarket.Utils.StockUtils;
import com.graemehbrown.simplestockmarket.exception.SimpleStockException;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertEquals;

public class StockUtilsTest {

    @Before
    public void before() {
        DataRepository dataRepository = DataRepository.getInstance();
        dataRepository.addStock(new Stock("TEA", StockType.COMMON, 0, 0, 100));
    }

    @Test
    public void getStockFromSymbolReturnsCorrectStockForInput() {
        String choice = "TEA";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(choice.getBytes()));
            Stock foundStock = StockUtils.getStockFromSymbol();
            assertEquals("TEA", foundStock.getSymbol());
        } catch (SimpleStockException e) {
            e.printStackTrace();
        } finally {
            System.setIn(stdin);
        }

    }

    @Test
    public void getStockFromSymbolThrowsExceptionOnInvalidSymbol() {
        String choice = "BEER";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(choice.getBytes()));
            assertThatThrownBy(StockUtils::getStockFromSymbol).isInstanceOf(SimpleStockException.class).hasMessageStartingWith("Error - Stock not found");
        } finally {
            System.setIn(stdin);
        }

    }

    @Test
    public void getStockFromSymbolThrowsExceptionWhenNoSymbolEntered() {
        String choice = " ";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(choice.getBytes()));
            assertThatThrownBy(StockUtils::getStockFromSymbol).isInstanceOf(SimpleStockException.class).hasMessageStartingWith("Error - Stock not found");
        } finally {
            System.setIn(stdin);
        }

    }

    @Test
    public void getPriceReturnsPriceEntered(){
        String choice = "23";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(choice.getBytes()));
            Double price = StockUtils.getPrice();
            assertEquals(Double.valueOf(choice), price);
        } catch (SimpleStockException e) {
            e.printStackTrace();
        } finally {
            System.setIn(stdin);
        }
    }

    @Test
    public void getPriceThrowsExceptionWhenNoPriceEntered(){
        String choice = " ";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(choice.getBytes()));
            assertThatThrownBy(StockUtils::getPrice).isInstanceOf(SimpleStockException.class).hasMessageStartingWith("Error - invalid price");
        } finally {
            System.setIn(stdin);
        }
    }

    @Test
    public void getPriceThrowsExceptionWhenZeroPriceEntered(){
        String choice = "0";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(choice.getBytes()));
            assertThatThrownBy(StockUtils::getPrice).isInstanceOf(SimpleStockException.class).hasMessageStartingWith("Error - enter price greater than 0");
        } finally {
            System.setIn(stdin);
        }
    }
}
