package org.mines.address.port.driving;

import org.mines.address.domain.model.Meal;
import org.mines.address.domain.model.People;
import org.mines.address.domain.model.Restorant;

import java.util.Collection;

public interface MealUseCase {

    Meal save(Meal meal);

    Collection<Meal> findByPeople(People people);
    Collection<Meal> findByRestorant(Restorant restorant);


}
