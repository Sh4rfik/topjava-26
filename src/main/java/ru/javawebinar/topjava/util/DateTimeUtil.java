package ru.javawebinar.topjava.util;

import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static <T extends Comparable<T>> boolean isBetweenHalfOpen(T value, @Nullable T start, @Nullable T end) {
        if (value instanceof LocalDate) {
            assert start != null;
            assert end != null;
            return ((LocalDate) value).compareTo((LocalDate) start) >= 0 && ((LocalDate) value).compareTo((LocalDate) end) <= 0;
        } else if (value instanceof LocalTime) {
            assert start != null;
            assert end != null;
            return ((LocalTime) value).compareTo((LocalTime) start) >= 0 && ((LocalTime) value).compareTo((LocalTime) end) < 0;
        } else {
            return false;
        }
    }

    public static String toString(LocalDateTime ldt) {
        return ldt == null ? "" : ldt.format(DATE_TIME_FORMATTER);
    }

    @Nullable
    public static LocalDate parseLocalDateMin(@Nullable String str) {
        if (!StringUtils.hasLength(str)) {
            return null;
        } else {
            return LocalDate.parse(str);
        }
    }

    @Nullable
    public static LocalDate parseLocalDateMax(@Nullable String str) {
        if (!StringUtils.hasLength(str)) {
            return null;
        } else {
            return LocalDate.parse(str);
        }
    }

    @Nullable
    public static LocalTime parseLocalTimeMin(@Nullable String str) {
        if (!StringUtils.hasLength(str)) {
            return null;
        } else {
            return LocalTime.parse(str);
        }
    }

    @Nullable
    public static LocalTime parseLocalTimeMax(@Nullable String str) {
        if (!StringUtils.hasLength(str)) {
            return null;
        } else {
            return LocalTime.parse(str);
        }
    }
}

