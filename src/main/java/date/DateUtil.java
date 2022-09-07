package date;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.IsoFields;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class DateUtil {
    
    public static void main(String [] args) {
        determineDayOfWeek();
    }
    
    public static void determineDayOfWeek() {
        LocalDate today = LocalDate.now();

        System.out.println( today.getDayOfWeek() );             // SUNDAY
        System.out.println( today.getDayOfWeek().getValue() );  // 7
    }
    
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

    public static void foo2() {
        // 2022-04-01 00:00:00
        long startTime = 1648742400;
        LocalDateTime ldt = convert2LocalDateTime(startTime);
        
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");
        
        String str = ldt.format(df);
        System.out.println(str);
    }
    
    
    public static void genKey() {
        // 2022-03-28 00:00:00
        long startTime = 1648396800;
        
        // 2022-03-28 00:00:08
        long startTime2 = 1648396808;
        
        // 2022-04-02 00:00:00
        long middleTime = 1648828800;
        
        // 2022-04-03 23:59:59
        long endTime = 1649001599;
        
        long l1 = startTime / (60 * 60 * 24 * 7);
        System.out.println(l1);
        
        long l11 = startTime2 / (60 * 60 * 24 * 7);
        System.out.println(l11);
        
        long l2 = middleTime / (60 * 60 * 24 * 7);
        System.out.println(l2);
        
        long l3 = endTime / (60 * 60 * 24 * 7);
        System.out.println(l3);
        
        
        LocalDate ld1 = convert2LocalDate(startTime);
        System.out.println(ld1.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR));
        
        LocalDate ld2 = convert2LocalDate(startTime2);
        System.out.println(ld2.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR));
        
        LocalDate ld3 = convert2LocalDate(middleTime);
        System.out.println(ld3.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR));
        
        LocalDate ld4 = convert2LocalDate(endTime);
        System.out.println(ld4.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR));
    }
    
    public static void epodDayTest() {
        LocalDate d = LocalDate.ofEpochDay(19088);
        System.out.println(d);
        
        String str = d.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        System.out.println(str);
        
        LocalDate ld1 = LocalDate.of(2022, 4, 1);
        LocalDate ld2 = LocalDate.of(2022, 4, 6);
        System.out.println(ld1.toEpochDay());
        System.out.println(ld2.toEpochDay());
    }
    
    public static void localDate2LocalDateTime() {
        LocalDate date = LocalDate.parse("2022-04-01");
        LocalDateTime localDateTime1 = date.atStartOfDay();
        LocalDateTime localDateTime2 = date.atTime(23, 59, 59);
        System.out.println(localDateTime1);
        System.out.println(localDateTime2);

        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime1.atZone(zone).toInstant();
        Instant instant2 = localDateTime2.atZone(zone).toInstant();
        long result = instant.toEpochMilli();
        System.out.println(instant.getEpochSecond());
        long result2 = instant2.toEpochMilli();
        System.out.println(instant2.getEpochSecond());
        System.out.println(result);
        System.out.println(result2);
    }
    
    public static void getLast3Weeks() {
        // 202151  202201
        LocalDate date = LocalDate.parse("2022-01-03");
        int weekNum = date.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
        System.out.println(weekNum);
        
        int weekNum2 = date.get(IsoFields.WEEK_BASED_YEAR);
        System.out.println(weekNum2);
    }
    
    public static void ensureWeek() {
        LocalDate ld = LocalDate.parse("2022-03-10");
        int weekNum = ld.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
        System.out.println(weekNum);
        
        int weekNum2 = ld.get(IsoFields.WEEK_BASED_YEAR);
        System.out.println(weekNum2);
        
        String result = String.format("%s%s", ld.get(IsoFields.WEEK_BASED_YEAR), ld.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR));
        System.out.println(result);
    }
    
    
    public static void testTz() {
        Set<String> sets = ZoneId.getAvailableZoneIds();
        System.out.println(sets);
        
        String tzOffset = ZonedDateTime.now(ZoneId.of("Asia/Shanghai")).getOffset().toString();
        System.out.println(tzOffset);
    }
    
    
    public static void sameWeek() {
        LocalDate start = LocalDate.parse("2022-04-15");
        LocalDate middle = LocalDate.parse("2022-01-10");
        LocalDate end = LocalDate.parse("2022-01-02");
        
        System.out.println(start.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR));
        System.out.println(middle.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR));
        System.out.println(end.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR));
        
        boolean result = false;
        if (start.getDayOfWeek().equals(DayOfWeek.MONDAY) && end.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            if (start.get(IsoFields.WEEK_BASED_YEAR) == end.get(IsoFields.WEEK_BASED_YEAR)
                    && start.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR) == end.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR)) {
                result = true;
            }
        }
        
        System.out.println(result);
    }
    
    public static void foo() {
        LocalDate start = LocalDate.parse("2022-04-18");
        LocalDate before = start.minus(10, ChronoUnit.DAYS);
        System.out.println(before);
        
        LocalDate before2 = start.minus(20, ChronoUnit.WEEKS);
        System.out.println(before2);
        
        LocalDate before3 = start.minus(13, ChronoUnit.MONTHS);
        System.out.println(before3);
    }
    
    
    public static void foo3() {
        String str0 = "rank:week:calorie:202207";
        String str1 = "rank:week:calorie:202208";
        String str2 = "rank:week:calorie:202208";
        String str3 = "rank:week:calorie:202209";
        System.out.println(str1.compareTo(str0));
        System.out.println(str1.compareTo(str2));
        System.out.println(str1.compareTo(str3));
        
       String [] str = str3.split(":");
       System.out.println(str[str.length -1]);
    }
    
    public static void foo4() {
        long l11 = 1650556800; // 2022-04-22 00:00:00
        long l12 = 1650643199; // 2022-04-22 23:59:59
        System.out.println(l11 / 60 / 60 / 24);
        System.out.println(l12 / 60 / 60 / 24);
        
        
        long time = 1650587624;
        long nowDay = time / 60 / 60 / 24;
        
        
        int day = (int)TimeUnit.SECONDS.toDays(time);
        System.out.println(day);
        
        LocalDate now = LocalDate.ofEpochDay(nowDay);
        LocalDate epochBase = LocalDate.ofEpochDay(0);

        System.out.println("Days: " + ChronoUnit.DAYS.between(epochBase, now));
        System.out.println("Weeks: " + ChronoUnit.WEEKS.between(epochBase, now));
        System.out.println("Months: " + ChronoUnit.MONTHS.between(epochBase, now));
        System.out.println("Years: " + ChronoUnit.YEARS.between(epochBase, now));
        
        
//      long time = 1650587624;
        long startSecond = 1650556800;
        long t1 = time / 60 / 60 / 24;
        System.out.println(t1);    // =====> day
        System.out.println("===========================");    // =====> day
        long start1 = t1 * 60 * 60 * 24;
        System.out.println("开始时间:" + start1);
        System.out.println("===========================");    // =====> day
        System.out.println(t1/7);  // =====> week
        Instant instant = Instant.ofEpochSecond(time);
        ZoneId zone = ZoneId.systemDefault();
        LocalDate ld1 = instant.atZone(zone).toLocalDate();
        System.out.println(ld1.toEpochDay());
    }
    
    public static void foo11() {
        System.out.println(ZoneId.getAvailableZoneIds());
        
        long time = 1650607200;
        ZoneId zone = ZoneId.of("Japan");
        
        
        Instant instant = Instant.ofEpochSecond(time);
        LocalDate ld = instant.atZone(zone).toLocalDate();
        LocalDateTime localDateTime1 = ld.atStartOfDay();
        LocalDateTime localDateTime2 = ld.atTime(23, 59, 59);

        Instant instant2 = localDateTime1.atZone(zone).toInstant();
        Instant instant3 = localDateTime2.atZone(zone).toInstant();
        
        long start = instant2.getEpochSecond();
        long end = instant3.getEpochSecond();
        System.out.println(start);
        System.out.println(end);
    }
    
    public static void foo10 () {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate ld = LocalDate.parse("20220411",formatter);
        System.out.println(ld);
        System.out.println("202204".substring(0,4));
    }
    
    public static void foo9() {
        long time = 1650556800;
        System.out.println(ZoneId.getAvailableZoneIds());
        ZoneId zone = ZoneId.of("Africa/Nairobi");
        Instant instant = Instant.ofEpochSecond(time);
        LocalDate ld1 = instant.atZone(zone).toLocalDate();
        System.out.println(ld1);
    }
    
    public static void foo8() {
        LocalDate start = LocalDate.parse("2022-04-22");
        System.out.println(start.toEpochDay());
    }
    
    public static void foo7() {
        long l1 = 1650556800; // 2022-04-22 00:00:00
        long l2 = 1650643199; // 2022-04-22 23:59:59
        System.out.println((l2 - l1) / 60 / 60);
        
        long l3 = 1650211200; // 2022-04-18 00:00:00
        long l4 = 1650815999; // 2022-04-24 23:59:59
        System.out.println((l4 - l3) / 60 / 60 / 24);
    }
    
    public static void foo6() {
        LocalDate now = LocalDate.now();
        LocalDateTime localDateTime1 = now.atStartOfDay();
        LocalDateTime localDateTime2 = now.atTime(23, 59, 59);
        System.out.println(localDateTime1.toEpochSecond(ZoneOffset.UTC));
        System.out.println(localDateTime2.toEpochSecond(ZoneOffset.UTC));
        
        System.out.println(now.toEpochDay() * 24 * 60 * 60);
        System.out.println((now.toEpochDay() + 1) * 24 * 60 * 60 -1);
    }
    
    
    public static void foo5() {
        System.out.println(1 * 86400);
        
        long start1 = 19104;
        LocalDate epoch = LocalDate.ofEpochDay(19104);
        System.out.println(start1 * 86400);
        System.out.println((start1 + 1) * 86400 - 1);
        
        System.out.println(System.currentTimeMillis() / 1000);
        
        
        
        
        LocalDateTime localDateTime1 = epoch.atStartOfDay();
        LocalDateTime localDateTime2 = epoch.atTime(23, 59, 59);
        
        long epochSeconds = (localDateTime2.getLong(ChronoField.EPOCH_DAY) * 86400000) + localDateTime2.getLong(ChronoField.MILLI_OF_DAY);
        System.out.println(epochSeconds);
        
        
//        long start1 = 19104;
//        System.out.println(start1 * 86400);
//        // 一天有86400 秒
//        System.out.println(24 * 60 * 60);
//        
//        System.currentTimeMillis();
//        
//        LocalDate epochBase = LocalDate.ofEpochDay(0);
//        
//        long start = ChronoUnit.SECONDS.between(epochBase, epoch);
//        System.out.println(start);    // =====> day
//        
//        long t = start1 * 24 * 60 * 60;
//        System.out.println(t);    // =====> day
    }
    
    public static void main222(String [] args) {
        genKey();
        
        
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
