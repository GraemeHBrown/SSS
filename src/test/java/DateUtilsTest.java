import com.graemehbrown.simplestockmarket.Utils.DateUtils;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class DateUtilsTest {

    @Test
    public void getBeginningOfRangeReturnsDatePriorToCurrentTimeByAmountSpecified() {
        Date startOfRange = DateUtils.getBeginningOfRange(15);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, -15);
        assertThat(startOfRange).isEqualToIgnoringSeconds(cal.getTime());
    }
}
