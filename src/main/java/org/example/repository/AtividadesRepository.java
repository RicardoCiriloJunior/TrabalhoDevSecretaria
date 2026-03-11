package org.example.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.example.mapper.AtividadesMapper;
import org.example.model.Atividades;
import org.example.model.Notas;
import org.example.util.ConnectionFactory;

public class AtividadesRepository {
    private final ConnectionFactory connectionFactory;
    private final AtividadesMapper mapper = new AtividadesMapper();

    public AtividadesRepository(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public Long save(Atividades atividade) {
        String sql = "INSERT INTO atividades (matr_aluno, id_disciplina, titulo, descricao, status, data_entrega, data_criacao) " +
                "VALUES (?,?,?,?,?,?,?) RETURNING id";

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, atividade.getMatrAluno());
            pstmt.setLong(2, atividade.getIdDisciplina());
            pstmt.setString(3, atividade.getTitulo());
            pstmt.setString(4, atividade.getDescricao());
            pstmt.setString(5, atividade.getStatus());
            pstmt.setDate(6, Date.valueOf (atividade.getDataEntrega()));
            pstmt.setDate(7, Date.valueOf (atividade.getDataCriacao()));

            ResultSet rs = pstmt.executeQuery();
            return rs.next() ? rs.getLong("id") : null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Atividades> findByMatr_aluno(String matricula) {
        String sql = "SELECT * FROM atividades WHERE matr_aluno = ?";
        List<Atividades> atividades = new ArrayList<> ();

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, matricula);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                atividades.add(mapper.map(rs));
            }
            return atividades;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Atividades findById(long id){
        String sql = "SELECT * FROM atividades WHERE id = ?";

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();

            return rs.next() ? mapper.map(rs) : null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(Atividades atividade) {
        String sql = "UPDATE atividades SET matr_aluno=?, id_disciplina=?, titulo=?, descricao=?, status=?, data_entrega=?, data_criacao=? " +
                "WHERE id = ?";

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, atividade.getMatrAluno());
            pstmt.setLong(2, atividade.getIdDisciplina());
            pstmt.setString(3, atividade.getTitulo());
            pstmt.setString(4, atividade.getDescricao());
            pstmt.setString(5, atividade.getStatus());
            pstmt.setDate(6, Date.valueOf (atividade.getDataEntrega()) );
            pstmt.setDate(7, Date.valueOf ( atividade.getDataCriacao()));
            pstmt.setLong(8, atividade.getId());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteByID(long id) {
        String sql = "DELETE FROM atividades WHERE id = ?";

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Atividades> findAll() {
        String sql = "SELECT * FROM atividades";
        List<Atividades> atividades = new ArrayList<>();

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                atividades.add(mapper.map(rs));
            }
            return atividades;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Atividades> findByMatricula(String matricula) {
        String sql = "SELECT * FROM atividades WHERE matr_aluno = ?";
        List<Atividades> atividades = new ArrayList<>();

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                atividades.add(mapper.map(rs));
            }
            return atividades;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}