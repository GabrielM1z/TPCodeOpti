package org.address.infrastructure;

import org.address.infrastructure.config.PersistenceTestConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mines.address.domain.model.Address;
import org.mines.address.domain.model.Restorant;
import org.mines.address.port.driven.AddressRepositoryPort;
import org.mines.address.port.driven.RestorantRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@TestExecutionListeners({SqlScriptsTestExecutionListener.class, TransactionalTestExecutionListener.class, DependencyInjectionTestExecutionListener.class})
@ContextConfiguration(classes = {PersistenceTestConfig.class})
@Sql(scripts = {"/data/clear.sql", "/data/restorant.sql"})
class RestorantRepositoryAdapterTest {


    @Autowired
    private RestorantRepositoryPort restorantRepositoryPort;

    @Test
    void insert() {

        String name = "dartagnan";
        String category = "classique";
        int rate = 3;

        Restorant restorant = Restorant.RestorantBuilder.aRestorant()
                .withCategory(category)
                .withName(name)
                .withRate(rate)
                .build();

        Restorant persisted = restorantRepositoryPort.insert(restorant);

        assertNotNull(persisted.id());
        assertEquals(name, persisted.name());
        assertEquals(category, persisted.category());

    }

    @Test
    void selectAll() {

        Collection<Restorant> listRestorant = restorantRepositoryPort.selectAll();

        assertNotNull(listRestorant);
        assertFalse(listRestorant.isEmpty());
        assertEquals(3, listRestorant.size());

        assertEquals(List.of("louis blanc", "mcdo", "bk"), listRestorant.stream().map(Restorant::name).collect(Collectors.toList()));

    }

    @Test
    void selectByCategory() {
    }

    @Test
    void selectByRate() {
    }

    @Test
    void selectByMeanAge() {
    }
}