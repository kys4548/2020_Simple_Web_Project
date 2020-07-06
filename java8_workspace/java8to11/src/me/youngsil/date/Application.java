package me.youngsil.date;

import jdk.dynalink.beans.MissingMemberHandlerFactory;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Application {

    public static void main(String[] args) throws InterruptedException {

        Date start = new Date();
        long time = start.getTime();
        System.out.println(start + " " + time);

        Thread.sleep(100);

        Date end = new Date();
        System.out.println(end + " " + end.getTime());
        end.setTime(start.getTime());

        /**
         * date Class의 단점
         * 1. date인데 날짜 시간을 가지고 있다는게 명확하지 않다.
         * 2. 1970년대의 시간을 시작 기준점으로 한다.
         * 3. 값이 변경될 위험이 있다. (mutable 하다 => 멀티쓰레드 환경에서 안전하지 않다.)
         */


       Calendar c = new GregorianCalendar(1994, 3, 24);
       c.add(Calendar.DAY_OF_YEAR, 1);
       System.out.println(c.getTime() + " " + c.getTime().getTime());

        /**
         * calender Class의 단점
         * 1. 월에 3을 넣으면 4월이 된다.
         * 2. type safe 하지 못하다. month에 100을 넣어도 가능하다.
         * 3. calender에서 getTime을 하면 Date객체가 나온다.
         * 4. 값이 변경될 위험이 있다.
         */


        /**
         * 기계용 시간
         */
        System.out.println("================================================\n");

        Instant instant = Instant.now();// 기준시 UTC
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("Asia/Seoul"));
        System.out.println(instant + "      " + zonedDateTime);


        /**
         * 사용자용 시간
         */

        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime myBirthDay = LocalDateTime.of(1994, 3, 24, 8, 53, 0);
        ZonedDateTime change = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        change.toLocalDateTime();
        localDateTime.atZone(ZoneId.systemDefault());


        // localDateTime -> ZoneDateTime, Instant
        localDateTime.atZone(ZoneId.of("Asia/Seoul"));
        localDateTime.toInstant(ZoneOffset.UTC);

        // ZoneDateTime -> localDateTime, Instant
        change.toLocalDateTime();
        change.toInstant();


        /**
         * 날짜와 기간
         * Period는 사람용,
         * Duration은 기계용
         *
         */

        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = LocalDate.of(2020, 8, 13);
        Period between = Period.between(localDate1, localDate2);
        System.out.println(between.getMonths() + " " +between.getDays());


        /**
         * format
         */
        System.out.println(localDateTime.format(DateTimeFormatter.ISO_TIME));
    }
}