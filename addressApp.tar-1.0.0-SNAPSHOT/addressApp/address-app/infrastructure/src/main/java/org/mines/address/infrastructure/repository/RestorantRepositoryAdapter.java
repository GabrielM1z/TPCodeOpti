package org.mines.address.infrastructure.repository;

import org.mines.address.domain.model.Address;
import org.mines.address.domain.model.Restorant;
import org.mines.address.port.driven.RestorantRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Objects;
import java.util.UUID;

@Repository
public class RestorantRepositoryAdapter implements RestorantRepositoryPort {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public RestorantRepositoryAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Restorant insert(Restorant restorant) {
        final SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(Objects.requireNonNull(jdbcTemplate.getDataSource())).withTableName("restorant");
        final UUID uuid = UUID.randomUUID();

        final SqlParameterSource in = new MapSqlParameterSource()
                .addValue("uuid", uuid)
                .addValue("name", restorant.name())
                .addValue("category", restorant.category())
                .addValue("rate", restorant.rate());

        simpleJdbcInsert.execute(in);

        return Restorant.RestorantBuilder.aRestorant()
                .withId(uuid)
                .withName(restorant.name())
                .withCategory(restorant.category())
                .withRate(restorant.rate())
                .build();
    }

    @Override
    public Collection<Restorant> selectAll() {
        String sql = "select uuid,name,rate,category from restorant";
        return jdbcTemplate.query(sql, new RestorantRowMapper());
    }

    @Override
    public Collection<Restorant> selectByCategory(String category) {
        return null;
    }

    @Override
    public Collection<Restorant> selectByRate(int rate) {
        return null;
    }

    @Override
    public Collection<Restorant> selectByMeanAge(int age) {
        return null;
    }
}
