package org.example.repository;

import org.example.mapper.AdministradorMapper;
import org.example.model.Administrador;
import org.example.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdministradorRepository {
    private final ConnectionFactory connectionFactory;

    private final AdministradorMapper mapper = new AdministradorMapper ();


    public AdministradorRepository (ConnectionFactory connectionFactory) {this.connectionFactory = connectionFactory;}

    public Administrador findByLogin (String login){
        String sql = "SELECT * FROM administrador WHERE login = ? ";

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString (1, login);
            ResultSet rs = pstmt.executeQuery();

            return rs.next() ? mapper.map(rs) : null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Administrador findBySenha (String senha){
        String sql = "SELECT * FROM administrador WHERE senha = ? ";

        try (Connection conn = connectionFactory.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString (1, senha);
            ResultSet rs = pstmt.executeQuery();

            return rs.next() ? mapper.map(rs) : null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}



