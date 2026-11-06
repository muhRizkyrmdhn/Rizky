package com.mycompany.alamakna_cashier;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nama_produk", nullable = false)
    private String namaProduk;

    @Column(name = "harga_per_gram", nullable = false)
    private double hargaPerGram;

    @Column(name = "stok_gram", nullable = false)
    private int stokGram;

    public Product() {}

    public Product(String namaProduk, double hargaPerGram, int stokGram) {
        this.namaProduk = namaProduk;
        this.hargaPerGram = hargaPerGram;
        this.stokGram = stokGram;
    }

    public double hitungSubtotal(int jumlahGram) {
        return this.hargaPerGram * jumlahGram;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNamaProduk() { return namaProduk; }
    public void setNamaProduk(String namaProduk) { this.namaProduk = namaProduk; }
    public double getHargaPerGram() { return hargaPerGram; }
    public void setHargaPerGram(double hargaPerGram) { this.hargaPerGram = hargaPerGram; }
    public int getStokGram() { return stokGram; }
    public void setStokGram(int stokGram) { this.stokGram = stokGram; }
}