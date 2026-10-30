/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.alamakna_cashier;

/**
 *
 * @author MUHAMMAD RIZKY R
 */
public class main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            loginForm form = new loginForm();
            form.setLocationRelativeTo(null); // Menampilkan form persis di tengah layar
            form.setVisible(true);            // Menampilkan window loginForm
        });
    }
}