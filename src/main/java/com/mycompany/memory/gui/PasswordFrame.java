package com.mycompany.memory.gui;

import com.mycompany.memory.controller.AppController;
import com.mycompany.memory.model.User;
import javax.swing.*;
import java.sql.SQLException;
import com.mycompany.memory.gui.AnswerFrame;

public class PasswordFrame extends javax.swing.JFrame {

    private final AppController controller;
    private User user;

    public PasswordFrame(AppController controller, User user) {

        this.controller = controller;
        this.user = user;
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backButton = new javax.swing.JButton();
        recoveryButton = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        nextButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backButton.setText("Voltar");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        recoveryButton.setText("Esqueci minha senha");
        recoveryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recoveryButtonActionPerformed(evt);
            }
        });

        nextButton.setText("Proximo");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nextButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(backButton))
                    .addComponent(passwordField)
                    .addComponent(recoveryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(112, Short.MAX_VALUE)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nextButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(backButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(recoveryButton)
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        controller.showLoginFrame();
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void recoveryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recoveryButtonActionPerformed
        JOptionPane.showMessageDialog(this, "Contate o administrador do sistema");
    }//GEN-LAST:event_recoveryButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        String enteredPassword = new String(passwordField.getPassword());
        try {
            if (controller.validateUserPassword(user.getLogin(), enteredPassword)) {
                controller.showAnswerFrame();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Senha inválida - Contate o administrador do sistema", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao acessar o banco de dados - Contate o administrador do sistema", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_nextButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton nextButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JButton recoveryButton;
    // End of variables declaration//GEN-END:variables
}
