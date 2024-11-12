package dev.lpa;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

public class ZonedDateTimeMain {
  
  public static void main(String[] args) {
    
    System.setProperty("user.timezone", "America/Los_Angeles"); // set user timezone AT START
    Locale.setDefault(Locale.US);
//    System.setProperty("user.timezone", "UTC"); // difference to printing Instant.now() is the z
//    System.setProperty("user.timezone", "GMT"); // difference to UTC < 1s, appears the same
    System.out.println(ZoneId.systemDefault());
    
    System.out.println("Number of TZs = " + ZoneId.getAvailableZoneIds().size());
    ZoneId.getAvailableZoneIds().stream()
//      .filter(s -> s.startsWith("Australia"))
//      .filter(s -> s.startsWith("America/N"))
      .filter(s -> s.startsWith("US"))
//      .filter(s -> s.startsWith("Europe"))
      .sorted()
      .map(ZoneId::of)
      .forEach(z -> System.out.println(z.getId() + ": " + z.getRules()));
    
    Set<String> jdk8Zones = ZoneId.getAvailableZoneIds();
    String[] alternate = TimeZone.getAvailableIDs();  // only use for legacy code
    Set<String> oldway = new HashSet<>(Set.of(alternate));

//    jdk8Zones.removeAll(oldway);
//    System.out.println(jdk8Zones);
    
    oldway.removeAll(jdk8Zones);
    System.out.println(oldway);
    ZoneId bet = ZoneId.of("BET", ZoneId.SHORT_IDS);
    System.out.println(bet);
    
    LocalDateTime now = LocalDateTime.now();
    System.out.println(now);
    
    Instant instantNow = Instant.now();
    System.out.println(instantNow);
    
    // 279. Instant, ZonedDateTime, Duration, Period and ChronoUnit.between
    for (ZoneId z : List.of(
      ZoneId.of("Australia/Sydney"),
      ZoneId.of("Europe/Paris"),
      ZoneId.of("America/New_York"),
      ZoneId.of("America/Los_Angeles")
    )) {
      DateTimeFormatter zoneFormat = DateTimeFormatter.ofPattern("z:zzzz"); // timezone for date
      System.out.println(z);
      System.out.println("\t" + instantNow.atZone(z).format(zoneFormat));
      System.out.println("\t" + z.getRules().getDaylightSavings(instantNow));
      System.out.println("\t" + z.getRules().isDaylightSavings(instantNow));
    }
    
    Instant dobInstant = Instant.parse("2020-01-01T08:01:00Z");
    LocalDateTime dob =
      LocalDateTime.ofInstant(dobInstant, ZoneId.systemDefault());
    System.out.println("Your kid's birthdate, LA time: "
                         + dob.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
    
    ZonedDateTime dobSydney =
      ZonedDateTime.ofInstant(dobInstant, ZoneId.of("Australia/Sydney"));
    System.out.println("Your kid's birthdate, Sydney time: " + dobSydney.format(
      DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
    
    ZonedDateTime dobHere = dobSydney.withZoneSameInstant(ZoneId.systemDefault());
    System.out.println("Your kid's birthdate, Here Time = " + dobHere.format(
      DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
    
    ZonedDateTime firstOfMonth = ZonedDateTime.now()
                                   .with(TemporalAdjusters.firstDayOfMonth());
    System.out.printf("First of next Month = %tD %n", firstOfMonth);
    
  }
}
