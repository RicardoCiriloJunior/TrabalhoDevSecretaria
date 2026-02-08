package org.example.mapper;

import org.example.model.Professor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfessorMapper implements RowMapper<Professor> {

    public Professor map(ResultSet rs) throws SQLException {
        return new Professor(
                rs.getLong("id"),
                rs.getLong("id_disciplina"),
                rs.getString("usuario"),
                rs.getString("nome"),
                rs.getString("senha")
        );
    }
}