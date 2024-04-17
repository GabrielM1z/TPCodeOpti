package org.mines.address.port.driving;

import org.mines.address.domain.model.Meal;
import org.mines.address.domain.model.People;
import org.mines.address.domain.model.Restorant;

import java.util.Collection;

public interface RestorantUseCase {

    Restorant save(Restorant restorant);

    Collection<Restorant> findAll();

    Collection<Restorant> findByCategory(String category);
    Collection<Restorant> findByRate(int rate);

    Collection<Restorant> findByMeanAge(int age);


}