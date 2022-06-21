package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MealRepositoryInMemory implements mealCrud {

    private Map<Integer, Meal> meals = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger();


    {
        save(new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500));
        save(new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000));
        save(new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500));
        save(new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100));
        save(new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000));
        save(new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500));
        save(new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 410));
    }

    @Override
    public Meal save(Meal meal) {
        if (meal.getId() == null) {
            meal.setId(counter.incrementAndGet());
            meals.put(meal.getId(), meal);
        } else if (meals.containsKey(meal.getId())) {
            meals.replace(meal.getId(), meal);
        } else {
            meals.put(counter.incrementAndGet(), meal);
        }
        return meals.get(meal.getId());
    }

    @Override
    public void delete(int id) {
        meals.remove(id);
    }

    @Override
    public Meal get(int id) {
        return meals.get(id);
    }

    @Override
    public Collection<Meal> getAll() {
        return meals.values();
    }
}
