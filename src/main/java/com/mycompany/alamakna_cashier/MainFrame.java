/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.alamakna_cashier;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author MUHAMMAD RIZKY R
 */
public class MainFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainFrame.class.getName());
    
    // Komponen Logika & GUI Kustom
    private JSlider sliderArabika;
    private JLabel lblArabika, lblRobusta, lblFlavorScore, lblTotalHarga;
    private JComboBox<String> cbGrindSize;
    private JTextField txtGramasi;
    private JButton btnPesan;
    private BlendSimulator simulator;
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents(); // Method bawaan NetBeans
    
        // Setel ukuran jendela GUI agar langsung terlihat di layar
        this.setTitle("ALAMAKNA - Self Cashier & Coffee Blend Simulator");
        this.setSize(600, 500);
        this.setLocationRelativeTo(null); // Posisikan di tengah layar

        // Inisialisasi komponen racikan kopi & Hibernate
        initComponentsCustom();
        simulator = new BlendSimulator();
        updateKalkulasiRasa();
    }
    
    // Inisialisasi Tampilan Dashboard & Event Listener
    private void initComponentsCustom() {
        setTitle("ALAMAKNA - Self Cashier & Coffee Blend Simulator");
        setSize(600, 450);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(7, 2, 10, 10));

        add(new JLabel(" Rasio Arabika (%) :"));
        sliderArabika = new JSlider(0, 100, 70);
        add(sliderArabika);

        lblArabika = new JLabel(" Arabika: 70%");
        lblRobusta = new JLabel(" Robusta: 30%");
        add(lblArabika);
        add(lblRobusta);

        add(new JLabel(" Ukuran Gilingan (Grind Size) :"));
        cbGrindSize = new JComboBox<>(new String[]{"Fine", "Medium", "Coarse"});
        add(cbGrindSize);

        add(new JLabel(" Kuantitas (Gram) :"));
        txtGramasi = new JTextField("200");
        add(txtGramasi);

        lblFlavorScore = new JLabel(" Flavor Score SCAA : 0.0");
        lblTotalHarga = new JLabel(" Total Bayar : Rp 0");
        add(lblFlavorScore);
        add(lblTotalHarga);

        btnPesan = new JButton("Simpan Pesanan (Hibernate ORM)");
        add(new JLabel("")); 
        add(btnPesan);

        // Event listener saat slider digeser
        sliderArabika.addChangeListener(e -> updateKalkulasiRasa());

        // Event listener tombol simpan
        btnPesan.addActionListener(e -> simpanPesananViaHibernate());
    }
    
    // Kalkulasi Real-time profil rasa SCAA & total harga
    private void updateKalkulasiRasa() {
        int arabika = sliderArabika.getValue();
        int robusta = 100 - arabika;
        lblArabika.setText(" Arabika: " + arabika + "%");
        lblRobusta.setText(" Robusta: " + robusta + "%");

        double score = simulator.hitungProfilRasaSCAA(arabika);
        lblFlavorScore.setText(String.format(" Flavor Score SCAA : %.1f", score));

        try {
            int gram = Integer.parseInt(txtGramasi.getText().trim());
            double total = (gram * 300.0) + 5000; // Harga/g + Jasa Racik
            lblTotalHarga.setText(" Total Bayar : Rp " + total);
        } catch (NumberFormatException ex) {
            lblTotalHarga.setText(" Total Bayar : Rp -");
        }
    }

    // Integrasi Penyimpanan Data Pesanan ke MySQL via Hibernate ORM
    private void simpanPesananViaHibernate() {
        try {
            int arabika = sliderArabika.getValue();
            int robusta = 100 - arabika;
            String grind = cbGrindSize.getSelectedItem().toString();
            int gram = Integer.parseInt(txtGramasi.getText().trim());

            CustomBlend pesanan = new CustomBlend("Custom Blend (GUI)", 300.0, 5000, arabika, robusta, grind);

            Transaction tx = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                tx = session.beginTransaction();
                session.persist(pesanan);
                tx.commit();

                JOptionPane.showMessageDialog(this,
                        """
                        Pesanan Berhasil Disimpan ke Database via Hibernate ORM!
                        ID Pesanan DB: """ + pesanan.getId() + "\n" +
                        "Total Bayar: Rp " + pesanan.hitungSubtotal(gram),
                        "Hibernate ORM Success",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                if (tx != null) tx.rollback();
                JOptionPane.showMessageDialog(this, "Gagal menyimpan ke database: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Masukkan jumlah gramasi yang valid!", "Input Error", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSlider1 = new javax.swing.JSlider();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new MainFrame().setVisible(true));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSlider jSlider1;
    // End of variables declaration//GEN-END:variables
}
