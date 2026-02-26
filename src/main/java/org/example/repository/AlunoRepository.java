package org.example.repository;

import org.example.mapper.AlunoMapper;
import org.example.model.Aluno;
import org.example.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoRepository {
    private final ConnectionFactory connectionFactory;
    private final AlunoMapper mapper = new AlunoMapper ();

    public AlunoRepository (ConnectionFactory connectionFactory) {this.connectionFactory = connectionFactory;}

    public Long save (Aluno aluno) {
        String sql = "INSERT INTO aluno (matricula, nome, senha, email, cpf) VALUES (?, ?, ?, ?, ?) RETURNING matricula";

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement (sql)){

            pstmt.setString(1, aluno.getMatricula ());
            pstmt.setString (2, aluno.getNome ());
            pstmt.setString (3, aluno.getSenha ());
            pstmt.setString (4, aluno.getEmail ());
            pstmt.setLong (5, aluno.getCpf ());
            ResultSet rs = pstmt.executeQuery();

            return rs.next() ? rs.getLong("matricula") : null;
        } catch (SQLException e) {
            throw new RuntimeException (e);
        }
    }

    public Aluno findByMatricula(String matricula){
        String sql = "SELECT * FROM aluno WHERE matricula = ? ";

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString (1, matricula);
            ResultSet rs = pstmt.executeQuery();

            return rs.next() ? mapper.map(rs) : null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Aluno findByNome(String nome){
        String sql = "SELECT * FROM aluno WHERE nome = ? ";

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString (1, nome);
            ResultSet rs = pstmt.executeQuery();

            return rs.next() ? mapper.map(rs) : null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Aluno findByCpf(long cpf){
        String sql = "SELECT * FROM aluno WHERE cpf = ? ";

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong (1, cpf);
            ResultSet rs = pstmt.executeQuery();

            return rs.next() ? mapper.map(rs) : null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(Aluno aluno){
        String sql = "UPDATE aluno SET nome = ?, email = ?, senha = ?, recup_senha = ?, cpf = ? WHERE matricula = ?";

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString (1, aluno.getNome ());
            pstmt.setString (2, aluno.getEmail ());
            pstmt.setString (3, aluno.getSenha ());
            pstmt.setString (4, aluno.getRecSenha ());
            pstmt.setLong (5,aluno.getCpf());
            pstmt.setString(6, aluno.getMatricula ());



            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteByMatricula(String matricula){
        String sql = "DELETE FROM aluno WHERE matricula = ?";

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, matricula);
            return  pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Aluno findByEmail (String email){
        String sql = "SELECT * FROM aluno WHERE email = ? LIMIT 1";

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            return rs.next() ? mapper.map(rs) : null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Aluno findByLogin (String email, String senha){
        String sql = "SELECT * FROM aluno WHERE email = ? AND senha = ? LIMIT 1";

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

    public List<Aluno> findAll() {
        String sql = "SELECT * FROM aluno";
        List<Aluno> alunos = new ArrayList<> ();

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()){
                alunos.add(mapper.map(rs));
            }

            return alunos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
