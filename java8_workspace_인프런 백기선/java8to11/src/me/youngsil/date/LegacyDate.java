package me.youngsil.date;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.GregorianCalendar;

public class LegacyDate {

    public static void main(String[] args) {
        Date date = new Date();
        Instant instant = date.toInstant();
        Date from = Date.from(instant);

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        ZonedDateTime zonedDateTime = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault());

        zonedDateTime.toLocalDateTime();

        GregorianCalendar.from(zonedDateTime);

        System.out.println(ZoneId.systemDefault());

        Instant now = Instant.now();
        System.out.println("now = " + now);
        ZonedDateTime zonedDateTime1 = now.atZone(ZoneId.systemDefault());

        LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();

        System.out.println(zonedDateTime);
        System.out.println("localDateTime = " + localDateTime);


        LocalDateTime plus = localDateTime.plus(10, ChronoUnit.DAYS);
        

    }
}
