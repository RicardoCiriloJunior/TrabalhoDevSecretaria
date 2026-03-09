package org.example.repository;

import org.example.mapper.NotasMapper;
import org.example.model.Notas;
import org.example.model.Media;
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
    public Long save (Notas notas) {
        String sql = "INSERT INTO notas (nota,nota2, matricula, id_disciplina) VALUES (?, ?, ?) RETURNING id";

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement (sql)){

            pstmt.setDouble(1, notas.getNota ());
            pstmt.setDouble(2, notas.getNota2());
            pstmt.setString (3, notas.getMatricula ());
            pstmt.setLong (4, notas.getId_disciplina ());
            ResultSet rs = pstmt.executeQuery();

            return rs.next() ? rs.getLong("id") : null;
        } catch (SQLException e) {
            throw new RuntimeException (e);
        }
    }
    public List<Notas> findByMatricula(String matricula){
        String sql = "SELECT * FROM notas WHERE matricula = ? ";
        List<Notas> todasNotas = new ArrayList<>();

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString (1, matricula);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                todasNotas.add(mapper.map(rs));
            }

            return todasNotas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Notas findByMatriculaAndDisciplina(String matricula, long idDisciplna){
        String sql = "SELECT * FROM notas WHERE matricula = ? and id_disciplina = ?";

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString (1, matricula);
            pstmt.setLong(2, idDisciplna);
            ResultSet rs = pstmt.executeQuery();

            return rs.next() ? mapper.map(rs) : null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Notas> findByIdDisciplina(long idDisciplina){
        String sql = "SELECT * FROM notas WHERE id_discpilina = ? ";
        List<Notas> notas = new ArrayList<> ();

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong (1, idDisciplina);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                notas.add(mapper.map(rs));
            }

            return notas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteByMatricula(String matricula){
        String sql = "DELETE FROM notas WHERE matricula = ?";

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, matricula);
            return  pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean update(Notas notas){
        String sql = "UPDATE notas SET id_disciplina = ?, matricula = ?,nota = ?, nota2 = ?  WHERE id = ?";

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, notas.getId_disciplina ());
            pstmt.setString(2, notas.getMatricula ());
            pstmt.setDouble (3, notas.getNota ());
            pstmt.setDouble(4, notas.getNota2());
            pstmt.setLong(5, notas.getId());



            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Notas> findAll() {
        String sql = "SELECT * FROM notas";
        List<Notas> notas = new ArrayList<> ();

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()){
                notas.add(mapper.map(rs));
            }

            return notas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Media> calcularMediaPorDisciplina(long idDisciplina) {

        String sql = """
        SELECT matricula, AVG(nota) AS media
        FROM notas
        WHERE id_disciplina = ?
        GROUP BY matricula
        """;

        List<Media> medias = new ArrayList<>();

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, idDisciplina);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                String matricula = rs.getString("matricula");
                double media = rs.getDouble("media");

                medias.add(new Media(matricula, media));
            }

            return medias;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int countRecuperacoes(long idDisciplina) {

        String sql = """
        SELECT COUNT(*) AS total
        FROM (
            SELECT matricula
            FROM notas
            WHERE id_disciplina = ?
            GROUP BY matricula
            HAVING AVG(nota) <= 7
        ) AS recuperacoes
        """;

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, idDisciplina);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("total");
            }

            return 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public double calcularMediaGeral(long idDisciplina) {

        String sql = """
        SELECT AVG(nota) AS media
        FROM notas
        WHERE id_disciplina = ?
        """;

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, idDisciplina);

            ResultSet rs = pstmt.executeQuery();

            if(rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
