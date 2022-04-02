package date;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.IsoFields;
import java.time.temporal.TemporalAdjusters;

public class DateUtil {
    
    /**
     * 判断local date 是否是同一天
     */
    public static boolean isSameDay() {
        // 2022-04-01 00:00:00
        long startTime = 1648742400;
        // 2022-04-01 23:59:59
        long endTime = 1648828799;

        LocalDate ld1 = convert2LocalDate(startTime);
        LocalDate ld2 = convert2LocalDate(endTime);

        return ld1.isEqual(ld2);
    }
    
    /**
     * find date after 1 week in Java 8
     */
    public static LocalDate getDayNextWeek() {
        LocalDate currentDate = LocalDate.now();
        System.out.println("Current date: " + currentDate);
        // Adding one week to the current date
        LocalDate result = currentDate.plus(1, ChronoUnit.WEEKS);
        System.out.println("Day after one week: " + result);
        return result;
    }
    
    public static boolean isSameWeek() {
        // 2022-04-01 00:00:00
        long startTime = 1648742400;
        // 2021-04-05 23:59:59
//        long endTime = 1617638399;
        
        // 2022-04-03 23:59:59
        long endTime = 1649001599;
        
        // 2022-12-31 20:59:59  ==> 周六
        long t1 = 1672491599;
        // 2023-1-1 10:59:59    ==> 周日
        long t2 = 1672541999;
        
        // 2021-12-31 20:59:59  ==> 周五
        long t3 = 1640955599;
        // 2023-1-1 10:59:59    ==> 周四
        long t4 = 1672541999;

        LocalDate ld1 = convert2LocalDate(t3);
        LocalDate ld2 = convert2LocalDate(t4);
        
        int n = ld1.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
        System.out.println(n);
        
        int n2 = ld2.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
        System.out.println(n2);
        
        return n == n2;
    }
    
    public static LocalDateTime convert2LocalDateTime(long date) {
        Instant instant = Instant.ofEpochSecond(date);
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone);
    }
    
    public static LocalDate convert2LocalDate(long date) {
        Instant instant = Instant.ofEpochSecond(date);
        ZoneId zone = ZoneId.systemDefault();
        return instant.atZone(zone).toLocalDate();
    }

    public static long get24HourDaysBetween(LocalDateTime start, LocalDateTime end) {
        return Duration.between(start, end).toDays();
    }

    public static long getCalendarDaysBetween(LocalDateTime start, LocalDateTime end) {
        return ChronoUnit.DAYS.between(start, end);
    }

    public static void foo() {
        // 2022-04-01 00:00:00
        long startTime = 1648742400;
        LocalDateTime ldt = convert2LocalDateTime(startTime);
        
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");
        
        String str = ldt.format(df);
        System.out.println(str);
    }
    
    public static void main(String [] args) {
        foo();
        
        isSameWeek();
        
        
        // 2022-04-01 00:00:00
        long startTime = 1648742400;
        // 2022-04-01 23:59:59
        long endTime = 1648828799;
        
        
//        // 2022-03-28 00:00:01
//        long startTime = 1648396801;
//        // 2022-04-03 23:59:59
//        long endTime = 1649001599;
        
        // 2022-04-01 01:00:00
        long t1 = 1648746000L;
        
        // 2022-04-02 00:10:00
        long t2 = 1648829400L;
//        
//        LocalDateTime ldt1 = convert2LocalDateTime(t1);
//        LocalDateTime ldt2 = convert2LocalDateTime(t2);
        
//        System.out.println(get24HourDaysBetween(ldt1, ldt2));
//        System.out.println(getCalendarDaysBetween(ldt1, ldt2));
        
        LocalDate ld1 = convert2LocalDate(startTime);
        LocalDate ld2 = convert2LocalDate(endTime);
        
        System.out.println(ld1.isEqual(ld2));
        
        
        LocalDate lastDay = ld1.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDay.getDayOfMonth());
        
        
        System.out.println(ld2.toEpochDay() - ld1.toEpochDay());
    }
}
