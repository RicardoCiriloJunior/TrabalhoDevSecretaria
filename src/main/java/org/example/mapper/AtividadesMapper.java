package org.example.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.example.model.Atividades;

public class AtividadesMapper implements RowMapper<Atividades> {

    @Override
    public Atividades map(ResultSet rs) throws SQLException {
        return new Atividades(
                rs.getLong("id"),
                rs.getString("matr_aluno"),
                rs.getLong("id_disciplina"),
                rs.getString("titulo"),
                rs.getString("descricao"),
                rs.getString("status"),
                rs.getDate("data_entrega"),
                rs.getDate("data_criacao")
        );
    }
}