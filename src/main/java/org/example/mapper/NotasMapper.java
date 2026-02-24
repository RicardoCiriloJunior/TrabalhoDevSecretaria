package org.example.mapper;

import org.example.model.Notas;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NotasMapper implements RowMapper<Notas> {

    public Notas map(ResultSet rs) throws SQLException {
        return new Notas(
                rs.getLong("id"),
                rs.getLong("id_disciplina"),
                rs.getString("matricula"),
                rs.getInt("ano"),
                rs.getDouble("nota")
        );
    }
}