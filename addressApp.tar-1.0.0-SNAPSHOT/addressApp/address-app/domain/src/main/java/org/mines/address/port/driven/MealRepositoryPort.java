package org.mines.address.port.driven;

import org.mines.address.domain.model.Meal;

import java.util.Collection;

public interface MealRepositoryPort {
    Meal insert(Meal meal);

    Collection<Meal> selectAll();

    Collection<Meal> selectByAge(int age);

    Collection<Meal> selectByCategory(String category);

}
