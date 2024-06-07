package com.mycompany.memory.controller;

import com.mycompany.memory.dao.CredenciaisDAO;
import com.mycompany.memory.dao.UserDAO;
import com.mycompany.memory.gui.*;
import com.mycompany.memory.model.Credenciais;
import com.mycompany.memory.model.User;

import java.sql.SQLException;
import java.util.List;

public class AppController {
    private User currentUser;
    private static final AppController instance = new AppController();
    private UserDAO userDAO = new UserDAO();
    private CredenciaisDAO credenciaisDAO = new CredenciaisDAO(); // Adicionar DAO para credenciais

    public AppController() {}

    public static AppController getInstance() {
        return instance;
    }
    
    public boolean validateUserPassword(String login, String password) throws SQLException {
        User user = userDAO.getUserByLogin(login);
        return user != null && user.getSenha().equals(password);
    }

    public List<Credenciais> getCredenciaisPorUsuarioId(int usuarioId) throws SQLException {
        return credenciaisDAO.getCredenciaisPorUsuarioId(usuarioId);
    }

    public static void main(String[] args) {
        new AppController().showLoginFrame();
    }

    public void showLoginFrame() {
        LoginFrame loginFrame = new LoginFrame(this);
        loginFrame.setVisible(true);
    }

    public void showPasswordFrame(User user) {
        this.currentUser = user;
        PasswordFrame passwordFrame = new PasswordFrame(this, user);
        passwordFrame.setVisible(true);
    }

    public void showAnswerFrame() {
        AnswerFrame answerFrame = new AnswerFrame(this, currentUser);
        answerFrame.setVisible(true);
    }

    public void showWelcomeFrame() {
        WelcomeFrame welcomeFrame = new WelcomeFrame(this, currentUser);
        welcomeFrame.setVisible(true);
    }

    public User getCurrentUser() {
        return currentUser;
    }
}