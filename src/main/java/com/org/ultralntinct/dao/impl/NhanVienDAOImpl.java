package com.org.ultralntinct.dao.impl;

import java.util.List;
import java.util.Optional;

import com.org.ultralntinct.config.JpaConfig;
import com.org.ultralntinct.dao.jpa.NhanVienDAO;
import com.org.ultralntinct.model.NhanVien;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

/**
 * <p>
 * The Class NhanVienDAOImpl.
 * </p>
 *
 * @author MinhNgoc
 */
public class NhanVienDAOImpl implements NhanVienDAO {

    /**
     * <p>
     * The method Save.
     * </p>
     *
     * @author MinhNgoc
     * @param entity the entity
     */
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

    /**
     * <p>
     * The method Update.
     * </p>
     *
     * @author MinhNgoc
     * @param entity the entity
     */
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

    /**
     * *
     * <p>
     * The method Find by id.
     * </p>
     *
     * @author MinhNgoc
     * @param id the id
     * @return the optional
     */
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

    /**
     * *
     * <p>
     * The method Find all.
     * </p>
     *
     * @author MinhNgoc
     * @return the list
     */
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

    /**
     * <p>
     * The method Delete by id.
     * </p>
     *
     * @author MinhNgoc
     * @param id the id
     */
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

    /**
     * *
     * <p>
     * The method Find by ma nhan vien.
     * </p>
     *
     * @author MinhNgoc
     * @param maNhanVien the ma nhan vien
     * @return the optional
     */
    @Override
    public Optional<NhanVien> findByMaNhanVien(String maNhanVien) {
        EntityManager em = JpaConfig.getEntityManager();
        try {
            String jpql = "SELECT nv FROM NhanVien nv WHERE nv.maNhanVien = :maNhanVien";
            TypedQuery<NhanVien> query = em.createQuery(jpql, NhanVien.class);
            query.setParameter("maNhanVien", maNhanVien);

            List<NhanVien> results = query.getResultList();
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
