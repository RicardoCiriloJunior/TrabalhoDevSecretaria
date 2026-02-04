package org.example.mapper;

import org.example.model.Disciplina;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DisciplinaMapper implements RowMapper<Disciplina> {

    public Disciplina map(ResultSet rs) throws SQLException {
        return new Disciplina(
                rs.getLong(("id")),
                rs.getString("disciplina")
        );
    }
}
