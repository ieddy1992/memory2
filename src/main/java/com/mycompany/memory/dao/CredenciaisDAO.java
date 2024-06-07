package com.mycompany.memory.dao;

import com.mycompany.memory.model.Credenciais;
import com.mycompany.memory.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CredenciaisDAO {

    public boolean adicionarCredenciais(Credenciais credenciais) {
        String query = "INSERT INTO acessos (usuario_id, sistema, login, senha) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, credenciais.getUsuarioId());
            preparedStatement.setString(2, credenciais.getSistema());
            preparedStatement.setString(3, credenciais.getLogin());
            preparedStatement.setString(4, credenciais.getSenha());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao adicionar credenciais: " + ex.getMessage());
            return false;
        }
    }


    public List<Credenciais> getCredenciaisPorUsuarioId(int usuarioId) {
        List<Credenciais> credenciaisList = new ArrayList<>();
        String query = "SELECT * FROM acessos WHERE usuario_id = ?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, usuarioId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Credenciais credenciais = new Credenciais();
                    credenciais.setId(resultSet.getInt("id"));
                    credenciais.setUsuarioId(resultSet.getInt("usuario_id"));
                    credenciais.setSistema(resultSet.getString("sistema"));
                    credenciais.setLogin(resultSet.getString("login"));
                    credenciais.setSenha(resultSet.getString("senha"));
                    credenciaisList.add(credenciais);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao obter credenciais: " + ex.getMessage());
        }
        return credenciaisList;
    }
}