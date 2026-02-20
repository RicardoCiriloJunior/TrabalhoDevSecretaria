package org.example.repository;

import org.example.mapper.ObservacoesMapper;
import org.example.model.Observacoes;
import org.example.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ObservacoesRepository {
    private final ConnectionFactory connectionFactory;
    private final ObservacoesMapper mapper = new ObservacoesMapper();

    public ObservacoesRepository (ConnectionFactory connectionFactory) {this.connectionFactory = connectionFactory;}

    public Long save (Observacoes Observacoes) {
        String sql = "INSERT INTO observacoes (observacao, id_prof, matricula, id_disciplina) VALUES (?, ?, ?, ?) RETURNING id";

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement (sql)){

            pstmt.setString(1, Observacoes.getObservacao ());
            pstmt.setLong (2, Observacoes.getId_professor ());
            pstmt.setLong (3, Observacoes.getMatricula ());
            pstmt.setLong (4, Observacoes.getId_disciplina ());
            ResultSet rs = pstmt.executeQuery();

            return rs.next() ? rs.getLong("id") : null;
        } catch (SQLException e) {
            throw new RuntimeException (e);
        }
    }

    public Observacoes findById(long id){
        String sql = "SELECT * FROM observacoes WHERE id = ? ";

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong (1, id);
            ResultSet rs = pstmt.executeQuery();

            return rs.next() ? mapper.map(rs) : null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Observacoes findByMatricula(String matricula){
        String sql = "SELECT * FROM observacoes WHERE matricula = ? ";

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString (1, matricula);
            ResultSet rs = pstmt.executeQuery();

            return rs.next() ? mapper.map(rs) : null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteById(long id){
        String sql = "DELETE FROM observacoes WHERE id = ?";

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, id);
            return  pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Observacoes> findAll() {
        String sql = "SELECT * FROM Observacoes";
        List<Observacoes> Observacoes = new ArrayList<> ();

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()){
                Observacoes.add(mapper.map(rs));
            }

            return Observacoes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
