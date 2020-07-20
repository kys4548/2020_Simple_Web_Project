package me.youngsil.date;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class HumanDate {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);

        LocalDateTime of = LocalDateTime.of(2020, 10, 15, 0, 0, 0);
        System.out.println(of);

        ZonedDateTime now1 = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(now1);


        System.out.println("=========================================");
        //기간을 표현하는 방법
        LocalDate today = LocalDate.now();
        System.out.println("today = " + today);
        LocalDate thisYearBirthday = LocalDate.of(2020,11,24);
        System.out.println("thisYearBirthday = " + thisYearBirthday);
        Period period = Period.between(today, thisYearBirthday);
        System.out.println(period.getDays());

        Period until = today.until(thisYearBirthday);
        System.out.println(until.getDays());


        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);


        //format
        DateTimeFormatter mm = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(ldt.format(DateTimeFormatter.ISO_WEEK_DATE));

        //parse
        LocalDate parse = LocalDate.parse("07/01/2020", mm);
        System.out.println("parse = " + parse);

    }
}
