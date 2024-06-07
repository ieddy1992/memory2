package com.mycompany.memory.gui;

import com.mycompany.memory.controller.AppController;
import com.mycompany.memory.dao.UserDAO;
import com.mycompany.memory.model.User;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

public class WelcomeFrame extends JFrame {
    private User user;
    private AppController controller;

    public WelcomeFrame(AppController controller, User user) {
        this.controller = controller;
        this.user = user;
        initComponents();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        visualizarButton = new javax.swing.JButton();
        credencialButton = new javax.swing.JButton();
        cadastrarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        visualizarButton.setText("Visualizar credenciais");
        visualizarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizarButtonActionPerformed(evt);
            }
        });

        credencialButton.setText("Cadastrar credenciais");
        credencialButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                credencialButtonActionPerformed(evt);
            }
        });

        cadastrarButton.setText("Cadastrar usuário");
        cadastrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(visualizarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(credencialButton, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                    .addComponent(cadastrarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(visualizarButton)
                .addGap(33, 33, 33)
                .addComponent(credencialButton)
                .addGap(34, 34, 34)
                .addComponent(cadastrarButton)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void visualizarButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
    CredenciaisFrame credenciaisFrame = null; // Declare aqui
    try {
        credenciaisFrame = new CredenciaisFrame(user);
        credenciaisFrame.setVisible(true);
        this.dispose();
    } catch (SQLException ex) {
        Logger.getLogger(WelcomeFrame.class.getName()).log(Level.SEVERE, null, ex);
    }

    }                                                

    private void credencialButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        UserDAO userDAO = new UserDAO();
        User user = null;
        try {
            user = userDAO.getUserByLogin(this.user.getLogin());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao acessar o banco de dados - Contate o administrador do sistema", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (user.isAdmin()) {
            AdicionarFrame adicionarFrame = new AdicionarFrame();
            adicionarFrame.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Você não tem permissão para cadastrar credenciais.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }                                                

    private void cadastrarButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                
        UserDAO userDAO = new UserDAO();
        User user = null;
        try {
            user = userDAO.getUserByLogin(this.user.getLogin());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao acessar o banco de dados - Contate o administrador do sistema", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (user.isAdmin()) {
            CadastroFrame cadastroFrame = new CadastroFrame();
            cadastroFrame.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Você não tem permissão para cadastrar usuários.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }                                               

    // Variables declaration - do not modify                     
    private javax.swing.JButton cadastrarButton;
    private javax.swing.JButton credencialButton;
    private javax.swing.JButton visualizarButton;
    // End of variables declaration                   
}
