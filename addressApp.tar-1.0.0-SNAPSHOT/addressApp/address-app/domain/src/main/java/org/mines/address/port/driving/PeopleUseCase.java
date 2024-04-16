package org.mines.address.port.driving;

import org.mines.address.domain.model.People;
import org.mines.address.domain.model.Restorant;

import java.util.Collection;

public interface PeopleUseCase {

    People save(People people);

    Collection<People> findByAge(int age);
    Collection<People> findByName(String name);
    Collection<People> findByFirstname(String firstname);
}
