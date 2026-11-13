package com.mycompany.alamakna_cashier;

import java.util.List;

public interface AdminDao {
    void save(Admin admin);               // Create
    Admin findById(Integer id);           // Read by ID
    Admin login(String username, String password); // Read for Login
    boolean existsByUsername(String username);
    List<Admin> findAll();                // Read All
    void update(Admin admin);             // Update
    void delete(Integer id);              // Delete
}