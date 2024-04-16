package org.mines.address.domain.service;

import org.junit.jupiter.api.Test;
import org.mines.address.domain.model.People;
import org.mines.address.domain.model.Restorant;
import org.mines.address.port.driven.PeopleRepositoryPort;
import org.mines.address.port.driven.RestorantRepositoryPort;
import org.mines.address.port.driving.PeopleUseCase;
import org.mines.address.port.driving.RestorantUseCase;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class PeopleServiceTest {
    @Mock
    private PeopleRepositoryPort peopleRepositoryPort;

    @Mock
    private PeopleUseCase peopleUseCase;

    @InjectMocks
    private PeopleService peopleService = new PeopleService(peopleRepositoryPort);


    @Test
    void shouldSaveAPeople() {
        // GIVEN
        UUID id = UUID.randomUUID();
        String firstname = "GabRIIIIIIIIIIIIIIIIIELLLLLLLLLLLLL";
        String name = "Maaaaaaaaaaaaaartineeeeeeeeeeeeeeeeeeeez";
        int age = 23;

        People persisted = People.PeopleBuilder.aPeople()
                .withId(id)
                .withFirstName(firstname)
                .withName(name)
                .withAge(age)
                .build();
        when(peopleRepositoryPort.insert(any())).thenReturn(persisted);

        // WHEN
        People people = peopleUseCase.save(People.PeopleBuilder.aPeople()
                .withFirstName(firstname)
                .withName(name)
                .withAge(age)
                .build());

        // THEN
        assertEquals(persisted.id(), people.id());
    }
}
