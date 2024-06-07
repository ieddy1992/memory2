package com.mycompany.memory.gui;

import com.mycompany.memory.controller.AppController;
import com.mycompany.memory.model.User;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;

public class CredenciaisFrame extends javax.swing.JFrame {

    private final User user;
    private final AppController appController;
    private final DefaultListModel<String> credenciaisListModel;
    private JList<String> credenciaisList;

    public CredenciaisFrame(User user) {
        this.user = user;
        this.appController = new AppController(); // Inicializa o controlador
        this.credenciaisListModel = new DefaultListModel<>();
        this.credenciaisList = new JList<>(credenciaisListModel);

        initComponents();
        carregarCredenciais();
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        jScrollPane1 = new javax.swing.JScrollPane();
        credencialList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 164, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        credencialList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(credencialList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void carregarCredenciais() {
    credenciaisList = appController.getCredenciaisPorUsuarioId(user.getId());
        credenciaisListModel.removeAllElements(); // Limpa o modelo atual
        for (String credencial : credenciais) {
            credenciaisListModel.addElement(credencial); // Adiciona as credenciais ao modelo da lista
        }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> credencialList;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Panel panel1;
    // End of variables declaration//GEN-END:variables
}
