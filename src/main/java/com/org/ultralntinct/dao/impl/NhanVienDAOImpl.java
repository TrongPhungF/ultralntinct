package com.org.ultralntinct.dao.impl;

import java.util.List;
import java.util.Optional;

import com.org.ultralntinct.config.JpaConfig;
import com.org.ultralntinct.dao.jpa.NhanVienDAO;
import com.org.ultralntinct.model.NhanVien;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

/**
 * <p>
 * DiaChiDAOImpl represents a concrete implementation of DiaChiDAO.
 * </p>
 *
 * @author MinhNgoc.
 */
public class NhanVienDAOImpl implements NhanVienDAO {

    @Override
    public void save(NhanVien entity) {
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
    public void update(NhanVien entity) {
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
    public Optional<NhanVien> findById(Long id) {
        EntityManager em = JpaConfig.getEntityManager();
        try {
            NhanVien entity = em.find(NhanVien.class, id);
            return entity != null ? Optional.of(entity) : Optional.empty();
        } finally {
            em.close();
        }
    }

    @Override
    public List<NhanVien> findAll() {
        EntityManager em = JpaConfig.getEntityManager();
        try {
            String jpql = "SELECT n FROM NhanVien n";
            return em.createQuery(jpql, NhanVien.class).getResultList();
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
            NhanVien entity = em.find(NhanVien.class, id);
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

}
