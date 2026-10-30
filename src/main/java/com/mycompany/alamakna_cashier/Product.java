package com.mycompany.alamakna_cashier;

public class Product {
    // Encapsulation: Attribute private
    private int id;
    private String namaProduk;
    private double hargaPerGram;
    private int stokGram;

    public Product(int id, String namaProduk, double hargaPerGram, int stokGram) {
        this.id = id;
        this.namaProduk = namaProduk;
        this.hargaPerGram = hargaPerGram;
        this.stokGram = stokGram;
    }

    // Polymorphism
    public double hitungSubtotal(int jumlahGram) {
        return this.hargaPerGram * jumlahGram;
    }

    // Getter and Setter
    public int getId() { return id; }
    public String getNamaProduk() { return namaProduk; }
    public double getHargaPerGram() { return hargaPerGram; }
    public int getStokGram() { return stokGram; }
    public void setStokGram(int stokGram) { this.stokGram = stokGram; }
}
