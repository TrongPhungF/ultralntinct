package com.org.ultralntinct.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.org.ultralntinct.config.JpaConfig;
import com.org.ultralntinct.dao.jpa.SanPhamDAO;
import com.org.ultralntinct.model.SanPham;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

/**
 * <p>
 * DiaChiDAOImpl represents a concrete implementation of DiaChiDAO.
 * </p>
 *
 * @author MinhNgoc.
 */
public class SanPhamDAOImpl implements SanPhamDAO {
	@Override
    public void save(SanPham entity) {
        EntityManager em = JpaConfig.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void update(SanPham entity) {
        EntityManager em = JpaConfig.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public Optional<SanPham> findById(Long id) {
        EntityManager em = JpaConfig.getEntityManager();
        try {
            SanPham entity = em.find(SanPham.class, id);
            return entity != null ? Optional.of(entity) : Optional.empty();
        } finally {
            em.close();
        }
    }

    @Override
    public List<SanPham> findAll() {
        EntityManager em = JpaConfig.getEntityManager();
        try {
            String jpql = "SELECT s FROM SanPham s";
            return em.createQuery(jpql, SanPham.class).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteById(Long id) {
        EntityManager em = JpaConfig.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            SanPham entity = em.find(SanPham.class, id);
            if (entity != null) {
                em.remove(entity);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public long getMaxMaSanPham() throws SQLException {
        // Implementation for this method if needed
        return 0;
    }

    @Override
    public List<SanPham> searchSanPham(String keySearch) {
        EntityManager em = JpaConfig.getEntityManager();
        try {
            String jpql = "SELECT s FROM SanPham s WHERE s.maSanPham = :keySearch OR s.tenSanPham LIKE CONCAT('%', :keySearch, '%')";
            TypedQuery<SanPham> query = em.createQuery(jpql, SanPham.class);
            query.setParameter("keySearch", keySearch);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public Optional<SanPham> findByMaSanPham(String maSanPham) {
        EntityManager em = JpaConfig.getEntityManager();
        try {
            String jpql = "SELECT s FROM SanPham s WHERE s.maSanPham = :maSanPham";
            TypedQuery<SanPham> query = em.createQuery(jpql, SanPham.class);
            query.setParameter("maSanPham", maSanPham);

            List<SanPham> results = query.getResultList();
            if (results.isEmpty()) {
                return Optional.empty();
            } else {
                return Optional.of(results.get(0));
            }
        } finally {
            em.close();
        }
    }
}
