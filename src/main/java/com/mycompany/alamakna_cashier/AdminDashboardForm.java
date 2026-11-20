package com.mycompany.alamakna_cashier;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
/**
 *
 * @author MUHAMMAD RIZKY R
 */
public class AdminDashboardForm extends JFrame {
    private final Color COLOR_PRIMARY = new Color(62, 39, 35);   // Espresso Dark Brown
    private final Color COLOR_BG = new Color(248, 245, 242);     // Cream Latte
    private final Color COLOR_CARD = Color.WHITE;

    public AdminDashboardForm() {
        setupUI();
        setLocationRelativeTo(null);
    }

    private void setupUI() {
        setTitle("ALAMAKNA — Portal Admin & Kasir");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(720, 440);
        setResizable(false);
        getContentPane().setBackground(COLOR_BG);
        setLayout(new BorderLayout(0, 20));

        // ==================== HEADER ====================
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(COLOR_PRIMARY);
        headerPanel.setBorder(new EmptyBorder(20, 28, 20, 28));

        JLabel lblTitle = new JLabel("PORTAL ADMINISTRATOR ALAMAKNA");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitle.setForeground(Color.WHITE);

        JLabel lblSub = new JLabel("Pilih menu pengelolaan operasional kedai atau masuk ke mode transaksi pelanggan");
        lblSub.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblSub.setForeground(new Color(215, 204, 200));

        JPanel titleBox = new JPanel(new BorderLayout(0, 4));
        titleBox.setOpaque(false);
        titleBox.add(lblTitle, BorderLayout.NORTH);
        titleBox.add(lblSub, BorderLayout.SOUTH);

        JButton btnLogout = new JButton("Logout");
        btnLogout.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnLogout.setBackground(new Color(198, 40, 40));
        btnLogout.setForeground(Color.WHITE);
        btnLogout.setFocusPainted(false);
        btnLogout.setBorder(new EmptyBorder(8, 16, 8, 16));
        btnLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLogout.addActionListener(e -> {
            new loginForm().setVisible(true);
            dispose();
        });

        headerPanel.add(titleBox, BorderLayout.WEST);
        headerPanel.add(btnLogout, BorderLayout.EAST);
        add(headerPanel, BorderLayout.NORTH);

        // ==================== MENU PILIHAN UTAMA ====================
        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 20, 0));
        centerPanel.setOpaque(false);
        centerPanel.setBorder(new EmptyBorder(10, 28, 10, 28));

        // Tombol 1: Kelola Stok Produk
        JButton btnKelolaStok = createMenuCard(
            "KELOLA STOK PRODUK",
            "Tambah, ubah, atur ketersediaan & varian gilingan biji kopi (Whole Bean / Giling)",
            new Color(78, 52, 46)
        );
        btnKelolaStok.addActionListener(e -> {
            new AdminProductForm().setVisible(true);
            dispose();
        });

        // Tombol 2: Lihat Pembelian & Laporan
        JButton btnLihatPembelian = createMenuCard(
            "LIHAT PEMBELIAN",
            "Pantau riwayat pesanan biji kopi pelanggan & cetak laporan JasperReports",
            new Color(46, 125, 50)
        );
        btnLihatPembelian.addActionListener(e -> {
            new AdminSalesReportForm().setVisible(true);
            dispose();
        });

        centerPanel.add(btnKelolaStok);
        centerPanel.add(btnLihatPembelian);
        add(centerPanel, BorderLayout.CENTER);

        // ==================== FOOTER (MODE SELF-CASHIER) ====================
        JPanel footerPanel = new JPanel(new BorderLayout());
        footerPanel.setOpaque(false);
        footerPanel.setBorder(new EmptyBorder(0, 28, 22, 28));

        JButton btnSelfCashier = new JButton("Buka Layar Self-Cashier (Mode Pelanggan) →");
        btnSelfCashier.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnSelfCashier.setBackground(new Color(141, 110, 99));
        btnSelfCashier.setForeground(Color.WHITE);
        btnSelfCashier.setPreferredSize(new Dimension(0, 44));
        btnSelfCashier.setFocusPainted(false);
        btnSelfCashier.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSelfCashier.addActionListener(e -> {
            new MainFrame().setVisible(true);
            dispose();
        });

        footerPanel.add(btnSelfCashier, BorderLayout.CENTER);
        add(footerPanel, BorderLayout.SOUTH);
    }

    private JButton createMenuCard(String title, String desc, Color accentColor) {
        JButton card = new JButton();
        card.setLayout(new BorderLayout(0, 10));
        card.setBackground(COLOR_CARD);
        card.setFocusPainted(false);
        card.setCursor(new Cursor(Cursor.HAND_CURSOR));
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(5, 1, 1, 1, accentColor),
            new EmptyBorder(24, 20, 24, 20)
        ));

        JLabel lblTitle = new JLabel(title, SwingConstants.CENTER);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblTitle.setForeground(accentColor);

        JLabel lblDesc = new JLabel("<html><div style='text-align:center;'>" + desc + "</div></html>", SwingConstants.CENTER);
        lblDesc.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblDesc.setForeground(new Color(100, 100, 100));

        card.add(lblTitle, BorderLayout.NORTH);
        card.add(lblDesc, BorderLayout.CENTER);
        return card;
    }
}
