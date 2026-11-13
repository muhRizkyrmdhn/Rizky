package com.mycompany.alamakna_cashier;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AdminDaoImpl implements AdminDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(Admin admin) {
        getCurrentSession().persist(admin);
    }

    @Override
    @Transactional(readOnly = true)
    public Admin findById(Integer id) {
        return getCurrentSession().get(Admin.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public Admin login(String username, String password) {
        String hql = "FROM Admin WHERE username = :user AND password = :pass";
        Query<Admin> query = getCurrentSession().createQuery(hql, Admin.class);
        query.setParameter("user", username);
        query.setParameter("pass", password);
        List<Admin> hasil = query.list();
        return hasil.isEmpty() ? null : hasil.get(0);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByUsername(String username) {
        String hql = "FROM Admin WHERE username = :user";
        Query<Admin> query = getCurrentSession().createQuery(hql, Admin.class);
        query.setParameter("user", username);
        return !query.list().isEmpty();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Admin> findAll() {
        return getCurrentSession().createQuery("FROM Admin", Admin.class).list();
    }

    @Override
    public void update(Admin admin) {
        getCurrentSession().merge(admin);
    }

    @Override
    public void delete(Integer id) {
        Admin admin = findById(id);
        if (admin != null) {
            getCurrentSession().remove(admin);
        }
    }
}