package org.mines.address.web;

import org.junit.jupiter.api.Test;
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
        // Given

//        // When
//        when(restorantUseCase.findAll()).thenReturn(Optional.of(
//                Town.TownBuilder.aTown().withId(uuid).withName("some town").build()
//        ));
//
//        // Then
//        mockMvc.perform(MockMvcRequestBuilders.get("/town/%s".formatted(uuid.toString()))
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//                )
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("some town"));

    }
}
