package jom.com.softserve.s6.task2;

import java.time.LocalDate;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;

public class MyUtils {
    public static String getDateAfterToday(int years, int months, int days) {
        return LocalDate.now()
                .plusYears(years)
                .plusMonths(months)
                .plusDays(days)
                .format(ISO_LOCAL_DATE);
    }
}
