package me.youngsil.date;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class RobotDate {

    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant); // 기준시 UTC, GMT, 영국 어딘가
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        System.out.println(zonedDateTime);


        Instant now = Instant.now();
        Instant plus = now.plus(10, ChronoUnit.SECONDS);
        Duration between = Duration.between(now, plus);
        System.out.println("between.getSeconds() = " + between.getSeconds());
    }
}
