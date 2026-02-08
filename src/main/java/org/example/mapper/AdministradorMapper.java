package org.example.mapper;

import org.example.model.Administrador;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdministradorMapper implements RowMapper<Administrador> {

    public Administrador map(ResultSet rs) throws SQLException {
        return new Administrador(
                rs.getLong("id"),
                rs.getString("login"),
                rs.getString("senha")
        );
    }
}