package com.mycompany.alamakna_cashier;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Main Entry Point untuk Aplikasi Self-Cashier ALAMAKNA
 * 
 * @author MUHAMMAD RIZKY R
 */
public class main {

    public static void main(String[] args) {
        // Set Look and Feel Swing ke mode sistem (Nimbus / System Default)
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
            // Jika Nimbus gagal, gunakan tampilan default OS
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            }
        }

        // Jalankan Form Login pada Event Dispatch Thread (EDT) Swing
        SwingUtilities.invokeLater(() -> {
            loginForm formLogin = new loginForm();
            formLogin.setLocationRelativeTo(null); // Posisikan di tengah layar
            formLogin.setVisible(true);            // Tampilkan Form Login
        });
    }
}