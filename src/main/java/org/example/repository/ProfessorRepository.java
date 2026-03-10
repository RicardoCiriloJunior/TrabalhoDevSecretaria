package org.example.repository;

import org.example.mapper.ProfessorMapper;
import org.example.model.Aluno;
import org.example.model.Professor;
import org.example.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorRepository {
    private final ConnectionFactory connectionFactory;
    private final ProfessorMapper mapper = new ProfessorMapper();

    public ProfessorRepository (ConnectionFactory connectionFactory) {this.connectionFactory = connectionFactory;}

    public boolean update(Professor professor){
        String sql = "UPDATE professor SET nome = ?, email = ?, senha = ?, id_disciplina = ?, cpf= ? WHERE id = ?";

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString (1, professor.getNome ());
            pstmt.setString (2, professor.getEmail ());
            pstmt.setString (3, professor.getSenha ());
            pstmt.setLong(4, professor.getId_disciplina ());
            pstmt.setLong(5,professor.getCpf ());
            pstmt.setLong (6, professor.getId ());


            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Long save (Professor professor) {
        String sql = "INSERT INTO professor (nome, senha, email, id_disciplina, cpf) VALUES (?, ?, ?, ?, ?) RETURNING id";

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement (sql)){

            pstmt.setString(1, professor.getNome ());
            pstmt.setString (2, professor.getSenha ());
            pstmt.setString (3, professor.getEmail ());
            pstmt.setLong (4, professor.getId_disciplina ());
            pstmt.setLong (5, professor.getCpf ());
            ResultSet rs = pstmt.executeQuery();

            return rs.next() ? rs.getLong("id") : null;
        } catch (SQLException e) {
            throw new RuntimeException (e);
        }
    }

    public Professor findById(long id){
        String sql = "SELECT * FROM professor WHERE id = ? ";

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong (1, id);
            ResultSet rs = pstmt.executeQuery();

            return rs.next() ? mapper.map(rs) : null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Professor findByDisciplina(long idDisciplina){
        String sql = "SELECT * FROM professor WHERE id_disciplina = ? ";

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong (1, idDisciplina);
            ResultSet rs = pstmt.executeQuery();

            return rs.next() ? mapper.map(rs) : null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Professor findByNome(String nome){
        String sql = "SELECT * FROM professor WHERE nome = ? ";

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString (1, nome);
            ResultSet rs = pstmt.executeQuery();

            return rs.next() ? mapper.map(rs) : null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteById(long id){
        String sql = "DELETE FROM professor WHERE id = ?";

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, id);
            return  pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Professor findByEmail (String email){
        String sql = "SELECT * FROM professor WHERE email = ? LIMIT 1";

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            return rs.next() ? mapper.map(rs) : null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Professor findByCpf (long cpf){
        String sql = "SELECT * FROM professor WHERE cpf = ? LIMIT 1";

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, cpf);
            ResultSet rs = pstmt.executeQuery();

            return rs.next() ? mapper.map(rs) : null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Professor> findAll() {
        String sql = "SELECT * FROM professor";
        List<Professor> professor = new ArrayList<> ();

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()){
                professor.add(mapper.map(rs));
            }

            return professor;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Professor findByLogin (String email, String senha){
        String sql = "SELECT * FROM professor WHERE email = ? AND senha = ? LIMIT 1";

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            pstmt.setString(2, senha);
            ResultSet rs = pstmt.executeQuery();

            return rs.next() ? mapper.map(rs) : null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int countProfessor() {
        String sql = "SELECT COUNT(*) FROM professor";

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            if (rs.next()) {
                return rs.getInt(1);
            }

            return 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Professor> buscarProfessor(String busca) {

        String sql = """
        SELECT p.* FROM professor p
        JOIN disciplina d ON p.id_disciplina = d.id
        WHERE p.email ILIKE ?
           OR p.nome ILIKE ?
           OR d.disciplina ILIKE ?
        """;

        List<Professor> lista = new ArrayList<>();

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            String termo = "%" + busca + "%";

            pstmt.setString(1, termo);
            pstmt.setString(2, termo);
            pstmt.setString(3, termo);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Professor professor = mapper.map(rs);
                lista.add(professor);
            }

            return lista;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
