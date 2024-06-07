package com.mycompany.memory;

import com.mycompany.memory.controller.AppController;
import com.mycompany.memory.gui.LoginFrame;

public class Memory {

    public static void main(String[] args) {
        AppController controller = new AppController();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                controller.showLoginFrame();
            }
        });
    }
}