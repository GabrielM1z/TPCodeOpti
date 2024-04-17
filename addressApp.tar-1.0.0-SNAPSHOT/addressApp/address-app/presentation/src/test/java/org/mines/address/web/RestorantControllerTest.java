package org.mines.address.web;

import org.junit.jupiter.api.Test;
import org.mines.address.domain.model.Address;
import org.mines.address.domain.model.Restorant;
import org.mines.address.domain.model.Town;
import org.mines.address.port.driving.RestorantUseCase;
import org.mines.address.port.driving.TownUseCase;
import org.mines.address.web.config.WebTestConfig;
import org.mines.address.web.controller.RestorantController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.when;

@SpringBootTest(classes = RestorantController.class)
@AutoConfigureMockMvc
@Import(WebTestConfig.class)
public class RestorantControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RestorantUseCase restorantUseCase;

    @Test
    void shouldGetAll() throws Exception {

        // When
        when(restorantUseCase.findAll()).thenReturn(List.of());

        mockMvc.perform(MockMvcRequestBuilders.get("/restorant")
                    .accept(MediaType.APPLICATION_JSON)
                    .contentType(MediaType.APPLICATION_JSON)
            ).andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Restorant"));


    }


    // Map from restorant API to town domain
    private org.mines.address.domain.model.Restorant map(org.mines.address.api.model.Restorant restorant) {
        return org.mines.address.domain.model.Restorant.RestorantBuilder.aRestorant()
                .withName(restorant.getName())
                .withRate(restorant.getRate().intValue())
                .withCategory(restorant.getCategory())
                .build();
    }

    // Map from town domain to town API
    private org.mines.address.api.model.Restorant map(org.mines.address.domain.model.Restorant restorant) {
        org.mines.address.api.model.Restorant apiRestorant = new org.mines.address.api.model.Restorant();
        apiRestorant.setId(restorant.id().toString());
        apiRestorant.setName(restorant.name());
        apiRestorant.setPostCode(String.valueOf(town.postCode()));

        return apiTown;
    }

    // Map from API address to domain Address
    private org.mines.address.domain.model.Address map(UUID townId, org.mines.address.api.model.Address address) {
        return Address.AddressBuilder.anAddress()
                .withNumber(address.getNumber().intValue())
                .withStreet(address.getStreet())
                .withTown(org.mines.address.domain.model.Town.TownBuilder.aTown().withId(townId).build())
                .build();
    }

    // Map from domain Address to API address
    private org.mines.address.api.model.Address map(org.mines.address.domain.model.Address address) {
        org.mines.address.api.model.Address apiAddress = new org.mines.address.api.model.Address();
        apiAddress.setNumber((long) address.number());
        apiAddress.setStreet(address.street());

        return apiAddress;
    }
}
