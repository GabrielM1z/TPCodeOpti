package org.mines.address.domain.service;

import org.mines.address.domain.model.Meal;
import org.mines.address.domain.model.People;
import org.mines.address.domain.model.Restorant;
import org.mines.address.port.driven.MealRepositoryPort;
import org.mines.address.port.driven.RestorantRepositoryPort;
import org.mines.address.port.driving.MealUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;


public class MealService implements MealUseCase {

    @Autowired
    private MealRepositoryPort mealRepositoryPort;

    public MealService(MealRepositoryPort mealRepositoryPort) {
        this.mealRepositoryPort = mealRepositoryPort;
    }


    @Override
    public Meal save(Meal meal) {
        if (meal.heure() < 0) {
            throw new IllegalArgumentException("hour must be positif number");
        } else if (meal.restorant() == null) {
            throw new IllegalArgumentException("Restorant must be linked");
        } else if (meal.people() == null) {
            throw new IllegalArgumentException("People must be linked");
        }

        return mealRepositoryPort.insert(meal);
    }

    @Override
    public Collection<Meal> findByPeople(People people) {
        return null;
    }

    @Override
    public Collection<Meal> findByRestorant(Restorant restorant) {
        return mealRepositoryPort.selectAll().stream().filter(meal -> meal.restorant() == restorant).collect(Collectors.toCollection(ArrayList::new));
    }
}
