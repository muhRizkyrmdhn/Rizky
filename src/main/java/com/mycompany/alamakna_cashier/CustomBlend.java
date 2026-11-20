package com.mycompany.alamakna_cashier;

import jakarta.persistence.*;

@Entity
@Table(name = "custom_blends")
public class CustomBlend extends Product {

    @Column(name = "rasio_arabika", nullable = false)
    private int rasioArabika;

    @Column(name = "rasio_robusta", nullable = false)
    private int rasioRobusta;

    @Column(name = "grind_size", nullable = false)
    private String grindSize;

    public CustomBlend() {}

    public CustomBlend(String namaProduk, double hargaPerGram, int stokGram, int rasioArabika, int rasioRobusta, String grindSize) {
        super(namaProduk, hargaPerGram, stokGram);
        this.rasioArabika = rasioArabika;
        this.rasioRobusta = rasioRobusta;
        this.grindSize = grindSize;
    }

    public double hitungSubtotal(int jumlahGram) {
        double biayaRacik = 5000;
        return (getHargaPerGram() * jumlahGram) + biayaRacik;
    }

    public int getRasioArabika() { return rasioArabika; }
    public void setRasioArabika(int rasioArabika) { this.rasioArabika = rasioArabika; }
    public int getRasioRobusta() { return rasioRobusta; }
    public void setRasioRobusta(int rasioRobusta) { this.rasioRobusta = rasioRobusta; }
    public String getGrindSize() { return grindSize; }
    public void setGrindSize(String grindSize) { this.grindSize = grindSize; }

    String getNamaProduk() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private int getHargaPerGram() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}