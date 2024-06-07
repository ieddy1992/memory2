package com.mycompany.memory.gui;

import com.mycompany.memory.controller.AppController;
import com.mycompany.memory.model.User;
import javax.swing.*;
import javax.swing.JOptionPane;

public class AnswerFrame extends JFrame {

    private JButton verifyButton;
    private AppController controller;
    private User user;

    public AnswerFrame(AppController controller, User user) {
        this.controller = controller;
        this.user = user;
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        answer1Field = new javax.swing.JPasswordField();
        answer2Field = new javax.swing.JPasswordField();
        enterButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        recoveryButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        enterButton.setText("Entrar");
        enterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterButtonActionPerformed(evt);
            }
        });

        backButton.setText("voltar");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        recoveryButton.setText("Esqueci minhas respostas");
        recoveryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recoveryButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(enterButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backButton))
                    .addComponent(answer1Field)
                    .addComponent(answer2Field)
                    .addComponent(recoveryButton, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(answer1Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(answer2Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enterButton)
                    .addComponent(backButton))
                .addGap(18, 18, 18)
                .addComponent(recoveryButton)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterButtonActionPerformed
        String enteredAnswer1 = answer1Field.getText();
        String enteredAnswer2 = answer2Field.getText();
        if (enteredAnswer1.equals(user.getPerguntaSecreta1()) && enteredAnswer2.equals(user.getPerguntaSecreta2())) {
            controller.showWelcomeFrame();
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Credenciais inválidas", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_enterButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        controller.showLoginFrame();
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void recoveryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recoveryButtonActionPerformed
        JOptionPane.showMessageDialog(this, "Contate o administrador do sistema");
    }//GEN-LAST:event_recoveryButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField answer1Field;
    private javax.swing.JPasswordField answer2Field;
    private javax.swing.JButton backButton;
    private javax.swing.JButton enterButton;
    private javax.swing.JButton recoveryButton;
    // End of variables declaration//GEN-END:variables
}
