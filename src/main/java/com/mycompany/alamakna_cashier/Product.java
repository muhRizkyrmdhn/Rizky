package com.mycompany.alamakna_cashier;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name; // Contoh: Arabika Gayo, Robusta Lampung

    @Column(name = "category", length = 50)
    private String category; // Contoh: Arabika, Robusta, House Blend

    @Column(name = "grind_size", length = 50)
    private String grindSize; // "Whole Bean (Tanpa Digiling)", "Fine", "Medium", "Coarse"

    @Column(name = "weight_gram")
    private Integer weightGram; // Contoh: 200, 250, 500, 1000

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @Column(name = "is_available", nullable = false)
    private Boolean available = true; // Status ketersediaan untuk Admin & Self-Cashier

    public Product() {
    }

    public Product(String name, String category, String grindSize, Integer weightGram, Double price, Integer stock, Boolean available) {
        this.name = name;
        this.category = category;
        this.grindSize = grindSize;
        this.weightGram = weightGram;
        this.price = price;
        this.stock = stock;
        this.available = available;
    }
    // 2. Constructor 3 parameter (Untuk menjaga kompatibilitas super(...) di CustomBlend.java)
    public Product(String namaProduk, double hargaPerGram, int stokGram) {
        this.name = namaProduk;
        this.price = hargaPerGram;
        this.stock = stokGram;
        this.available = stokGram > 0;
    }

    // Getter & Setter
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getGrindSize() { return grindSize; }
    public void setGrindSize(String grindSize) { this.grindSize = grindSize; }

    public Integer getWeightGram() { return weightGram; }
    public void setWeightGram(Integer weightGram) { this.weightGram = weightGram; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }

    public Boolean getAvailable() { return available; }
    public void setAvailable(Boolean available) { this.available = available; }
}