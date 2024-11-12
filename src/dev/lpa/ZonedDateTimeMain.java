package dev.lpa;

import java.time.ZoneId;

public class ZonedDateTimeMain {
  
  public static void main(String[] args) {
    
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
  }
}
