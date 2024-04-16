package org.mines.address.port.driven;

import org.mines.address.domain.model.People;

import java.util.Collection;

public interface PeopleRepositoryPort {

    People insert(People people);

    Collection<People> selectAll();

    Collection<People> selectByAge(int age);
    Collection<People> selectByName(String name);
    Collection<People> selectByFirstname(String firstname);
}
