package com.mycompany.alamakna_cashier;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main {

    // Menyimpan instance Spring Context agar bisa diakses oleh form Swing lainnya
    public static ApplicationContext springContext;

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Inisialisasi Spring IoC Container
        springContext = new AnnotationConfigApplicationContext(AppConfig.class);

        // VERIFIKASI SPRING DAO & PROXY TRANSACTIONAL
        AdminDao cekDao = springContext.getBean(AdminDao.class);
        System.out.println("[SPRING SUCCESS] Bean AdminDao ditemukan!");
        System.out.println("Class Aktual (Spring Proxy): " + cekDao.getClass().getName());
        System.out.println("Total data admin di DB     : " + cekDao.findAll().size());

        SwingUtilities.invokeLater(() -> {
            loginForm formLogin = new loginForm();
            formLogin.setLocationRelativeTo(null);
            formLogin.setVisible(true);
        });
    }
}