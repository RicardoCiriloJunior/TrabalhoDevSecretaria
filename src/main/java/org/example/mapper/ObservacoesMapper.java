package org.example.mapper;

import org.example.model.Observacoes;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ObservacoesMapper implements RowMapper<Observacoes> {

    public Observacoes map(ResultSet rs) throws SQLException {
        return new Observacoes(
                rs.getLong("id"),
                rs.getLong("id_professor"),
                rs.getLong("id_disciplina"),
                rs.getString("matricula"),
                rs.getString("ano")
        );
    }
}