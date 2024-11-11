package dev.lpa;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class Main {
  
  public static void main(String[] args) {
    
    LocalDate today= LocalDate.now();
    System.out.println(today); // yyyy-MM-dd, ISO
    
    LocalDate Fives5 = LocalDate.of(2022, 5, 5);
    System.out.println(Fives5);
    
    LocalDate May5th = LocalDate.of(2022, Month.MAY, 5);
    System.out.println(May5th);
    
    LocalDate Day125 = LocalDate.ofYearDay(2022, 125);
    System.out.println(Day125);
    
    LocalDate May5 = LocalDate.parse("2022-05-05");
    System.out.println(May5);
    
    System.out.println(May5.getYear());
    System.out.println(May5.getMonth());
    
    System.out.println(May5.getMonthValue());
    
    System.out.println(May5.getDayOfMonth());
    System.out.println(May5.getDayOfWeek());
    System.out.println(May5.getDayOfYear());
    System.out.println();
    
    System.out.println(May5.get(ChronoField.YEAR));
    System.out.println(May5.get(ChronoField.MONTH_OF_YEAR));
    System.out.println(May5.get(ChronoField.DAY_OF_MONTH));
    System.out.println(May5.get(ChronoField.DAY_OF_YEAR));
    
    // return copies with field changed since object is immutable
    System.out.println(May5.withYear(2000));
    System.out.println(May5.withMonth(3));
    System.out.println(May5.withDayOfMonth(4));
    System.out.println(May5.withDayOfYear(126));
    System.out.println(May5);
    System.out.println(May5.with(ChronoField.DAY_OF_YEAR, 126));
    System.out.println();
//    .minus methods mirror .plus methods
    System.out.println(May5.plusYears(1));
    System.out.println(May5.plusMonths(12));
    System.out.println(May5.plusDays(365));
    System.out.println(May5.plusWeeks(52));
    System.out.println(May5.plus(365, ChronoUnit.DAYS));
    System.out.println();
  }
}
