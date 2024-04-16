package org.mines.address.domain.service;

import org.mines.address.domain.model.People;
import org.mines.address.domain.model.Restorant;
import org.mines.address.port.driven.PeopleRepositoryPort;
import org.mines.address.port.driven.RestorantRepositoryPort;
import org.mines.address.port.driving.PeopleUseCase;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class PeopleService implements PeopleUseCase {

    @Autowired
    private PeopleRepositoryPort peopleRepositoryPort;

    public PeopleService(PeopleRepositoryPort peopleRepositoryPort) {
        this.peopleRepositoryPort = peopleRepositoryPort;
    }

    @Override
    public People save(People people) {
        if (people.name() == null) {
            throw new IllegalArgumentException("name is required");
        } else if (people.age() < 0) {
            throw new IllegalArgumentException("age must be positive");
        } else if (people.firstName() == null) {
            throw new IllegalArgumentException("firstname is required");
        }

        return peopleRepositoryPort.insert(people);
    }

    @Override
    public Collection<People> findByAge(int age) {
        return peopleRepositoryPort.selectByAge(age);
    }

    @Override
    public Collection<People> findByName(String name) {
        return peopleRepositoryPort.selectByName(name);
    }

    @Override
    public Collection<People> findByFirstname(String firstname) {
        return peopleRepositoryPort.selectByFirstname(firstname);
    }

}
