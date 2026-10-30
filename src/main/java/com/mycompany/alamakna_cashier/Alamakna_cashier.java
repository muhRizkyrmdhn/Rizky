package com.mycompany.alamakna_cashier;

import java.util.Scanner;

public class Alamakna_cashier {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // 1. PENERAPAN POLYMORPHISM
        BlendSimulator simulator = new BlendSimulator();

        System.out.println("==================================================");
        System.out.println("   SELAMAT DATANG DI KASIR MANDIRI ALAMAKNA      ");
        System.out.println("==================================================");
        System.out.println("\n--- FORMULIR RACIK KOPI MANDIRI (CUSTOM BLEND) ---");

        // Proses Menerima Input Dinamis dari Pembeli
        System.out.print("Masukkan persentase Arabika (%) [0-100] : ");
        int rasioArabika = input.nextInt();
        
        int rasioRobusta = 100 - rasioArabika;
        System.out.println("-> Persentase Robusta otomatis        : " + rasioRobusta + "%");

        input.nextLine(); // Membersihkan buffer enter
        System.out.print("Masukkan ukuran gilingan (Fine/Medium/Coarse): ");
        String grindSize = input.nextLine();

        System.out.print("Masukkan jumlah pesanan (gram)          : ");
        int jumlahGram = input.nextInt();

        // 2. PENERAPAN POLYMORPHISM (Method Overloading - Eksekusi)
        double flavorScore = simulator.hitungProfilRasaSCAA(rasioArabika);

        // 3. PENERAPAN INHERITANCE (Instansiasi Objek Kelas Turunan)
        CustomBlend pesananPelanggan = new CustomBlend(
                1, 
                "Custom Blend Pilihan Kamu", 
                300.0, 
                5000, 
                rasioArabika, 
                rasioRobusta, 
                grindSize
        );

        // 4. PENERAPAN POLYMORPHISM (Method Overriding - Eksekusi)
        double totalHarga = pesananPelanggan.hitungSubtotal(jumlahGram);

        System.out.println("\n==================================================");
        System.out.println("               RINGKASAN PESANAN KOPI             ");
        System.out.println("==================================================");
        
        // 5. PENERAPAN ENCAPSULATION (Akses Data Terproteksi)
        System.out.println("Nama Produk  : " + pesananPelanggan.getNamaProduk()); // ENCAPSULATION
        System.out.println("Komposisi    : " + pesananPelanggan.getRasioArabika() + "% Arabika / " + pesananPelanggan.getRasioRobusta() 
                + "% Robusta"); // ENCAPSULATION
        System.out.println("Grind Size   : " + pesananPelanggan.getGrindSize()); // ENCAPSULATION
        System.out.println("Berat        : " + jumlahGram + " gram");
        System.out.println("Flavor Score : " + flavorScore + " (SCAA Standard)");
        System.out.println("--------------------------------------------------");
        System.out.println("TOTAL BAYAR  : Rp " + totalHarga + " (termasuk jasa racik)");
        System.out.println("==================================================");

        input.close();
    }
}
