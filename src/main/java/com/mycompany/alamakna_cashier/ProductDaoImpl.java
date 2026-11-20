package com.mycompany.alamakna_cashier;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(Product product) {
        if (product.getStock() != null && product.getStock() <= 0) {
            product.setAvailable(false);
        }
        getCurrentSession().persist(product);
    }

    @Override
    @Transactional(readOnly = true)
    public Product findById(Integer id) {
        return getCurrentSession().get(Product.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return getCurrentSession()
                .createQuery("FROM Product ORDER BY id DESC", Product.class)
                .list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAvailableProducts() {
        return getCurrentSession()
                .createQuery("FROM Product WHERE available = true AND stock > 0 ORDER BY name ASC", Product.class)
                .list();
    }

    @Override
    public void update(Product product) {
        if (product.getStock() != null && product.getStock() <= 0) {
            product.setAvailable(false);
        }
        getCurrentSession().merge(product);
    }

    @Override
    public void delete(Integer id) {
        Product product = findById(id);
        if (product != null) {
            getCurrentSession().remove(product);
        }
    }
}