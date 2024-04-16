package org.mines.address.domain.service;

import org.mines.address.domain.model.Meal;
import org.mines.address.domain.model.People;
import org.mines.address.domain.model.Restorant;
import org.mines.address.port.driven.AddressRepositoryPort;
import org.mines.address.port.driven.RestorantRepositoryPort;
import org.mines.address.port.driving.RestorantUseCase;
import org.mines.address.port.driving.TownUseCase;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class RestorantService implements RestorantUseCase {

    @Autowired
    private RestorantRepositoryPort restorantRepositoryPort;

    public RestorantService(RestorantRepositoryPort restorantRepositoryPort) {
        this.restorantRepositoryPort = restorantRepositoryPort;
    }
    @Override
    public Restorant save(Restorant restorant) {
        if (restorant.name() == null) {
            throw new IllegalArgumentException("name is required");
        } else if (restorant.rate() < 0 || restorant.rate() > 5) {
            throw new IllegalArgumentException("rate must be between 0 and 5");
        } else if (restorant.category() == null) {
            throw new IllegalArgumentException("invalid number");
        }

        return restorantRepositoryPort.insert(restorant);
    }

    @Override
    public Collection<Restorant> findByCategory(String category) {
        return restorantRepositoryPort.selectByCategory(category);
    }

    @Override
    public Collection<Restorant> findByRate(int rate) {
        return restorantRepositoryPort.selectAll().stream().filter(restorant -> restorant.rate() == rate).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Collection<Restorant> findByMeanAge(int age) {
        return restorantRepositoryPort.selectByMeanAge(age);
    }


}
