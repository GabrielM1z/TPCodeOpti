package org.mines.address.domain.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mines.address.domain.model.Meal;
import org.mines.address.domain.model.People;
import org.mines.address.domain.model.Restorant;
import org.mines.address.port.driven.MealRepositoryPort;
import org.mines.address.port.driven.RestorantRepositoryPort;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MealServiceTest {

    @Mock
    private MealRepositoryPort mealRepositoryPort;

    @InjectMocks
    private MealService mealService = new MealService(mealRepositoryPort);


@Test
    void shouldSaveAMeal(){
        UUID id = UUID.randomUUID();
        int heure = 12;
        Restorant restorant = Restorant.RestorantBuilder.aRestorant()
                .withId(UUID.randomUUID())
                .withCategory("fastfood")
                .withName("kfc")
                .withRate(1)
                .build();
        People people = People.PeopleBuilder.aPeople()
                .withId(UUID.randomUUID())
                .withName("Pascual")
                .withFirstName("Damien")
                .withAge(6)
                .build();

        Meal persisted = Meal.MealBuilder.aMeal()
                .withId(id)
                .withHeure(heure)
                .withRestorant(restorant)
                .withPeople(people)
                .build();
        when(mealRepositoryPort.insert(any())).thenReturn(persisted);

        Meal meal = mealService.save(Meal.MealBuilder.aMeal()
                .withHeure(heure)
                .withRestorant(restorant)
                .withPeople(people)
                .build());

        // THEN
        assertEquals(persisted.id(), meal.id());
    }
}
