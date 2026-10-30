package com.mycompany.alamakna_cashier;

// Inheritance
public class CustomBlend extends Product {
    private int rasioArabika;
    private int rasioRobusta;
    private String grindSize;

    public CustomBlend(int id, String namaProduk, double hargaPerGram, int stokGram, int rasioArabika, int rasioRobusta, String grindSize) {
        super(id, namaProduk, hargaPerGram, stokGram);
        this.rasioArabika = rasioArabika;
        this.rasioRobusta = rasioRobusta;
        this.grindSize = grindSize;
    }

    // Polymorphism
    @Override
    public double hitungSubtotal(int jumlahGram) {
        double biayaRacik = 5000;
        return (getHargaPerGram() * jumlahGram) + biayaRacik;
    }

    public int getRasioArabika() { return rasioArabika; }
    public int getRasioRobusta() { return rasioRobusta; }
    public String getGrindSize() { return grindSize; }
}
