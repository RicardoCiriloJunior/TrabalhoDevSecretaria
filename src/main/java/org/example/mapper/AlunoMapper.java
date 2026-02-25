package org.example.mapper;

import org.example.model.Aluno;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AlunoMapper implements RowMapper<Aluno> {

    public Aluno map(ResultSet rs) throws SQLException {
        return new Aluno(
                rs.getString("matricula"),
                rs.getString("nome"),
                rs.getString("senha"),
                rs.getString("email")
        );
    }
}