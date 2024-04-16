package org.mines.address.domain.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mines.address.domain.model.Address;
import org.mines.address.domain.model.Restorant;
import org.mines.address.domain.model.Town;
import org.mines.address.port.driven.AddressRepositoryPort;
import org.mines.address.port.driven.RestorantRepositoryPort;
import org.mines.address.port.driving.RestorantUseCase;
import org.mines.address.port.driving.TownUseCase;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RestorantServiceTest {

    @Mock
    private RestorantRepositoryPort restorantRepositoryPort;


    @InjectMocks
    private RestorantService restorantService = new RestorantService(restorantRepositoryPort);

    @Test
    void shouldSaveARestorant() {
        // GIVEN
        UUID id = UUID.randomUUID();
        String category = "fastfood";
        String name = "bk";
        int rate = 1;

        Restorant persisted = Restorant.RestorantBuilder.aRestorant()
                .withId(id)
                .withCategory(category)
                .withName(name)
                .withRate(rate)
                .build();
        when(restorantRepositoryPort.insert(any())).thenReturn(persisted);

        // WHEN
        Restorant restorant = restorantService.save(Restorant.RestorantBuilder.aRestorant()
                .withCategory(category)
                .withName(name)
                .withRate(rate)
                .build());

        // THEN
        assertEquals(persisted.id(), restorant.id());
    }


    @Test
    void shouldNotSaveARestorant() {
        // GIVEN
        UUID id = UUID.randomUUID();
        String category = "fastfood";
        int rate = 1;

        // THEN
        assertThrows(IllegalArgumentException.class, () -> restorantService.save(Restorant.RestorantBuilder.aRestorant()
                .withCategory(category)
                .withName(null)
                .withRate(rate)
                .build()));

        verifyNoInteractions(restorantRepositoryPort);
    }
}
