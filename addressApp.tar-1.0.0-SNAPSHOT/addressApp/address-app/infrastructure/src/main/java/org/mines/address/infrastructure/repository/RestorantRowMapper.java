package org.mines.address.infrastructure.repository;

import org.mines.address.domain.model.Address;
import org.mines.address.domain.model.Restorant;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class RestorantRowMapper implements RowMapper<Restorant> {


    @Override
    public Restorant mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Restorant.RestorantBuilder.aRestorant()
                .withId(UUID.fromString(rs.getString("uuid")))
                .withRate(rs.getInt("rate"))
                .withName(rs.getString("name"))
                .withCategory(rs.getString("category"))
                .build();
    }
}
