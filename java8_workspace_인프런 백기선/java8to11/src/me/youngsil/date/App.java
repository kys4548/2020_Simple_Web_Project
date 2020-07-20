package me.youngsil.date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 기계가 알아들을 수 있는 시간 형식
 */
public class App {

    public static void main(String[] args) throws InterruptedException {
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime());


        //값을 변경할 수 있다는 것은 멀티스레드 환경에서는 잘 못쓴다.
        //날짜시간 다 가지고있는데 클래스명이 애매하다.
        Thread.sleep(3000);
        Date after3Second = new Date();
        System.out.println(after3Second);
        after3Second.setTime(date.getTime());
        System.out.println(after3Second);

        //타입 세이프하지 않는다.
        //int형만 받을 수 있지만 7을 사용하면 8월이 된다.
        new GregorianCalendar(2020, 7, 1);
        new GregorianCalendar(2020, Calendar.AUGUST, 1);

    }
}
