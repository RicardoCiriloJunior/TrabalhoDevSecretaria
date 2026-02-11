package org.example.repository;

import org.example.mapper.NotasMapper;
import org.example.model.Notas;
import org.example.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NotasRepository {
    private final ConnectionFactory connectionFactory;
    private final NotasMapper mapper = new NotasMapper();

    public NotasRepository (ConnectionFactory connectionFactory) {this.connectionFactory = connectionFactory;}

    public Long save (Notas Notas) {
        String sql = "INSERT INTO notas (nota, ano, matricula, id_disciplina) VALUES (?, ?, ?, ?) RETURNING id";

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement (sql)){

            pstmt.setDouble(1, Notas.getNota ());
            pstmt.setInt (2, Notas.getAno ());
            pstmt.setLong (3, Notas.getMatricula ());
            pstmt.setLong (4, Notas.getId_disciplina ());
            ResultSet rs = pstmt.executeQuery();

            return rs.next() ? rs.getLong("id") : null;
        } catch (SQLException e) {
            throw new RuntimeException (e);
        }
    }

    public Notas findById(long id){
        String sql = "SELECT * FROM notas WHERE id = ? ";

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong (1, id);
            ResultSet rs = pstmt.executeQuery();

            return rs.next() ? mapper.map(rs) : null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteById(long id){
        String sql = "DELETE FROM notas WHERE id = ?";

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, id);
            return  pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Notas> findAll() {
        String sql = "SELECT * FROM notas";
        List<Notas> Notas = new ArrayList<> ();

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()){
                Notas.add(mapper.map(rs));
            }

            return Notas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
