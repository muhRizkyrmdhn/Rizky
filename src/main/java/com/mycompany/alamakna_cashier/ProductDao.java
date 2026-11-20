package com.mycompany.alamakna_cashier;

import java.util.List;

public interface ProductDao {
    void save(Product product);
    Product findById(Integer id);
    List<Product> findAll();
    List<Product> findAvailableProducts();
    void update(Product product);
    void delete(Integer id);
}