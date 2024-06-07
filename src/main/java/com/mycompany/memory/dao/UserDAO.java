package com.mycompany.memory.dao;

import com.mycompany.memory.model.Credenciais;
import com.mycompany.memory.model.User;
import com.mycompany.memory.util.DatabaseConnection;
import javax.swing.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    // CRUD para tabela de usuários

    public User getUserByLogin(String login) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE Login = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, login);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setNome(rs.getString("Nome"));
                    user.setLogin(rs.getString("Login"));
                    user.setSenha(rs.getString("Senha"));
                    user.setEmail(rs.getString("Email"));
                    user.setTelefone(rs.getString("Telefone"));
                    user.setCpf(rs.getString("CPF"));
                    user.setPerguntaSecreta1(rs.getString("Pergunta_Secreta_1"));
                    user.setPerguntaSecreta2(rs.getString("Pergunta_Secreta_2"));
                    user.setAdmin(rs.getBoolean("isAdmin"));
                    return user;
                }
            }
        }
        return null;
    }

    public boolean addUser(User user) throws SQLException {
        String sql = "INSERT INTO usuarios (Nome, Login, Senha, Email, Telefone, CPF, Pergunta_Secreta_1, Pergunta_Secreta_2, isAdmin) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getLogin());
            stmt.setString(3, user.getSenha());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getTelefone());
            stmt.setString(6, user.getCpf());
            stmt.setString(7, user.getPerguntaSecreta1());
            stmt.setString(8, user.getPerguntaSecreta2());
            stmt.setBoolean(9, user.isAdmin());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean updateUser(User user) throws SQLException {
        String sql = "UPDATE usuarios SET Nome = ?, Login = ?, Senha = ?, Email = ?, Telefone = ?, CPF = ?, Pergunta_Secreta_1 = ?, Pergunta_Secreta_2 = ?, isAdmin = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getLogin());
            stmt.setString(3, user.getSenha());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getTelefone());
            stmt.setString(6, user.getCpf());
            stmt.setString(7, user.getPerguntaSecreta1());
            stmt.setString(8, user.getPerguntaSecreta2());
            stmt.setBoolean(9, user.isAdmin());
            stmt.setInt(10, user.getId());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean deleteUser(int userId) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            return stmt.executeUpdate() > 0;
        }
    }

    // CRUD para tabela de credenciais

    public List<Credenciais> getCredenciaisByUserId(int usuarioId) throws SQLException {
        String sql = "SELECT * FROM acessos WHERE usuario_id = ?";
        List<Credenciais> credenciaisList = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, usuarioId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Credenciais credenciais = new Credenciais();
                    credenciais.setId(rs.getInt("id"));
                    credenciais.setUsuarioId(rs.getInt("usuario_id"));
                    credenciais.setSistema(rs.getString("Sistema"));
                    credenciais.setLogin(rs.getString("Login"));
                    credenciais.setSenha(rs.getString("Senha"));
                    credenciaisList.add(credenciais);
                }
            }
        }
        return credenciaisList;
    }

    public boolean addCredenciais(Credenciais credenciais) throws SQLException {
        String sql = "INSERT INTO acessos (usuario_id, Sistema, Login, Senha) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, credenciais.getUsuarioId());
            stmt.setString(2, credenciais.getSistema());
            stmt.setString(3, credenciais.getLogin());
            stmt.setString(4, credenciais.getSenha());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean updateCredenciais(Credenciais credenciais) throws SQLException {
        String sql = "UPDATE acessos SET Sistema = ?, Login = ?, Senha = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, credenciais.getSistema());
            stmt.setString(2, credenciais.getLogin());
            stmt.setString(3, credenciais.getSenha());
            stmt.setInt(4, credenciais.getId());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean deleteCredenciais(int credenciaisId) throws SQLException {
        String sql = "DELETE FROM acessos WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, credenciaisId);
            return stmt.executeUpdate() > 0;
        }
    }
}
