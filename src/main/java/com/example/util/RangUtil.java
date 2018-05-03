package com.example.util;

import java.util.Collection;
import java.util.HashSet;


public class RangUtil {

  public static long HOUR_MILLIS = 60 * 60 * 1000L;
  public static long DAY_MILLIS = 24 * HOUR_MILLIS;

  private RangUtil() {}

  public static Collection<Long> rangLong(long inclusiveStart, long exclusiveEnd, long step) {
    HashSet<Long> res = new HashSet<>();
    while (inclusiveStart < exclusiveEnd) {
      res.add(inclusiveStart);
      inclusiveStart += step;
    }
    return res;
  }
}
