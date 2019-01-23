package com.ekfet.common.date;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class DateMain {
  public static void main(String[] args) {

    DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-dd");
//    LocalDateTime localDateTime=LocalDateTime.now().format();
//    System.out.println(localDateTime.format(formatter));
  }
}
