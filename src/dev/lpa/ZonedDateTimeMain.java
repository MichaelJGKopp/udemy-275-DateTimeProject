package dev.lpa;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;

public class ZonedDateTimeMain {
  
  public static void main(String[] args) {
    
    System.setProperty("user.timezone", "America/Los_Angeles"); // set user timezone AT START
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
  }
}
