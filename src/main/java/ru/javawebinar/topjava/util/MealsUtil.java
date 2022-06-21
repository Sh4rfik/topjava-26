package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MealsUtil {

    public static List<MealTo> filteredByStreams(Collection<Meal> meals, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        Map<LocalDate, Integer> caloriesSumByDate = meals.stream()
                .collect(Collectors.groupingBy(Meal::getDate, Collectors.summingInt(Meal::getCalories)));
        return meals.stream()
                .filter(meal -> DateTimeUtil.isBetweenHalfOpen(meal.getDateTime().toLocalTime(), startTime, endTime))
                .map(meal -> new MealTo(meal.getId(), meal.getDateTime(),
                        meal.getDescription(),
                        meal.getCalories(),
                        caloriesSumByDate.get(meal.getDate()) > caloriesPerDay))
                .collect(Collectors.toList());
    }

    public static List<MealTo> filteredMealsTo(Collection<Meal> meal, int calories) {
        return filteredByStreams(meal, LocalTime.MIN, LocalTime.MAX, calories);
    }
}
