import com.graemehbrown.simplestockmarket.App;
import com.graemehbrown.simplestockmarket.exception.SimpleStockException;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertEquals;

public class AppTest {

    @Test
    public void enterringPositiveNumberOutsideRangeRaisesExceptionWithCorrectMessage() {
        String choice = "77";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(choice.getBytes()));
            assertThatThrownBy(App::displayOptionsMenu).isInstanceOf(SimpleStockException.class).hasMessageStartingWith("Error - value entered outside range.");
        } finally {
            System.setIn(stdin);
        }
    }

    @Test
    public void enterringNegativeNumberOutsideRangeRaisesExceptionWithCorrectMessage() {
        String choice = "-5";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(choice.getBytes()));
            assertThatThrownBy(App::displayOptionsMenu).isInstanceOf(SimpleStockException.class).hasMessageStartingWith("Error - value entered outside range.");
        } finally {
            System.setIn(stdin);
        }
    }

    @Test
    public void enterringEmptyStringInDisplayOptionsMenuRaisesCustomExceptionWithMessage() {
        String choice = " ";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(choice.getBytes()));
            assertThatThrownBy(App::displayOptionsMenu).isInstanceOf(SimpleStockException.class).hasMessageStartingWith("Error - incorrect input format.");
        } finally {
            System.setIn(stdin);
        }
    }

    @Test
    public void notEnterringANumberRaisesCustomExceptionWithMessage() {
        String choice = "Z";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(choice.getBytes()));
            assertThatThrownBy(App::displayOptionsMenu).isInstanceOf(SimpleStockException.class).hasMessageStartingWith("Error - incorrect input format.");
        } finally {
            System.setIn(stdin);
        }
    }

    @Test
    public void displayOptionsMenuReturnsCorrectIntReflectingCLIinputOfOne() {
        String choice = "1";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(choice.getBytes()));
            int selection = App.displayOptionsMenu();
            assertEquals(1, selection);
        } catch (SimpleStockException e) {
            e.printStackTrace();
        } finally {
            System.setIn(stdin);
        }
    }

    @Test
    public void displayOptionsMenuReturnsCorrectIntReflectingCLIinputOfTwo() {
        String choice = "2";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(choice.getBytes()));
            int selection = App.displayOptionsMenu();
            assertEquals(2, selection);
        } catch (SimpleStockException e) {
            e.printStackTrace();
        } finally {
            System.setIn(stdin);
        }
    }

    @Test
    public void displayOptionsMenuReturnsCorrectIntReflectingCLIinputOfThree() {
        String choice = "3";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(choice.getBytes()));
            int selection = App.displayOptionsMenu();
            assertEquals(3, selection);
        } catch (SimpleStockException e) {
            e.printStackTrace();
        } finally {
            System.setIn(stdin);
        }
    }

    @Test
    public void displayOptionsMenuReturnsCorrectIntReflectingCLIinputOfFour() {
        String choice = "4";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(choice.getBytes()));
            int selection = App.displayOptionsMenu();
            assertEquals(4, selection);
        } catch (SimpleStockException e) {
            e.printStackTrace();
        } finally {
            System.setIn(stdin);
        }
    }

    @Test
    public void displayOptionsMenuReturnsCorrectIntReflectingCLIinputOfFive() {
        String choice = "5";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(choice.getBytes()));
            int selection = App.displayOptionsMenu();
            assertEquals(5, selection);
        } catch (SimpleStockException e) {
            e.printStackTrace();
        } finally {
            System.setIn(stdin);
        }
    }

    @Test
    public void displayOptionsMenuReturnsCorrectIntReflectingCLIinputOfSix() {
        String choice = "6";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(choice.getBytes()));
            int selection = App.displayOptionsMenu();
            assertEquals(6, selection);
        } catch (SimpleStockException e) {
            e.printStackTrace();
        } finally {
            System.setIn(stdin);
        }
    }

}
