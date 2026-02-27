package org.example.repository;

import org.example.mapper.DisciplinaMapper;
import org.example.model.Disciplina;
import org.example.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaRepository {
    private final ConnectionFactory connectionFactory;
    private final DisciplinaMapper mapper = new DisciplinaMapper();
    public DisciplinaRepository (ConnectionFactory connectionFactory){
        this.connectionFactory = connectionFactory;
    }
    public Long save(Disciplina disciplina){
        String sql = "INSERT INTO disciplina (disciplina) VALUES (?) RETURNING id";

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1, disciplina.getDisciplina());
            ResultSet rs = pstmt.executeQuery();

            return rs.next() ? rs.getLong("id") : null;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public Disciplina findById(long id){
        String sql = "SELECT * FROM disciplina WHERE id = ? ";

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();

            return rs.next() ? mapper.map(rs) : null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean update(Disciplina disciplina){
        String sql = "UPDATE disciplina SET disciplina = ? WHERE id = ?";

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, disciplina.getDisciplina());
            pstmt.setLong(1, disciplina.getId());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean deleteByID(long id){
        String sql = "DELETE FROM disciplina WHERE id = ?";

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, id);
            return  pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean deleteByDisciplina(String disciplina){
        String sql = "DELETE FROM disciplina WHERE disciplina = ?";

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, disciplina);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Disciplina findByDisciplina(String disciplina){
        String sql = "SELECT * FROM disciplina WHERE disciplina = ? LIMIT 1";

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, disciplina);
            ResultSet rs = pstmt.executeQuery();

            return rs.next() ? mapper.map(rs) : null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Disciplina> findAll() {
        String sql = "SELECT * FROM disciplina";
        List<Disciplina> disciplinas = new ArrayList<>();

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()){
                disciplinas.add(mapper.map(rs));
            }

            return disciplinas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
