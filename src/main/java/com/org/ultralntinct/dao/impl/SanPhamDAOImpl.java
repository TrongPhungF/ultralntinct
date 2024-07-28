package com.org.ultralntinct.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.org.ultralntinct.config.JpaConfig;
import com.org.ultralntinct.dao.jpa.SanPhamDAO;
import com.org.ultralntinct.model.DiaChi;
import com.org.ultralntinct.model.SanPham;
import com.org.ultralntinct.request.SearchSanPhamRequest;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

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
            DiaChi video = em.find(DiaChi.class, id);
            if (video != null) {
                em.remove(video);
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
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<SanPham> searchSanPham(SearchSanPhamRequest request) {
        // TODO Auto-generated method stub
        return null;
    }

}
