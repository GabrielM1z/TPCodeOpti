package org.mines.address.port.driven;

import org.mines.address.domain.model.Restorant;

import java.util.Collection;

public interface RestorantRepositoryPort {

    Restorant insert(Restorant restorant);

    Collection<Restorant> selectAll();

    Collection<Restorant> selectByCategory(String category);
    Collection<Restorant> selectByRate(int rate);
    Collection<Restorant> selectByMeanAge(int age);
}
