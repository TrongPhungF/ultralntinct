package com.org.ultralntinct.dao.impl;

import java.util.List;
import java.util.Optional;

import com.org.ultralntinct.config.JpaConfig;
import com.org.ultralntinct.dao.jpa.KhachHangDAO;
import com.org.ultralntinct.model.KhachHang;
import com.org.ultralntinct.model.SanPham;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

/**
 * <p>
 * KhachHangDAOImpl represents a concrete implementation of KhachHangDAO.
 * </p>
 *
 * @author MinhNgoc.
 */
public class KhachHangDAOImpl implements KhachHangDAO {

    /**
     * <p>
     * The method Save.
     * </p>
     *
     * @author MinhNgoc
     * @param entity the entity
     */
    @Override
    public void save(KhachHang entity) {
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
    public void update(KhachHang entity) {
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
    public Optional<KhachHang> findById(Long id) {
        EntityManager em = JpaConfig.getEntityManager();
        try {
            KhachHang entity = em.find(KhachHang.class, id);
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
    public List<KhachHang> findAll() {
        EntityManager em = JpaConfig.getEntityManager();
        try {
            String jpql = "SELECT s FROM KhachHang s";
            return em.createQuery(jpql, KhachHang.class).getResultList();
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

    /**
     * <p>
     * Method findByMaKhachHang.
     * </p>
     *
     * @param maKhachHang String
     *
     * @return KhachHang.
     *
     * @author MinhNgoc.
     */
    @Override
    public Optional<KhachHang> findByMaKhachHang(String maKhachHang) {
        EntityManager em = JpaConfig.getEntityManager();
        try {
            String jpql = "SELECT s FROM KhachHang s WHERE s.maKhachHang = :maKhachHang";
            TypedQuery<KhachHang> query = em.createQuery(jpql, KhachHang.class);
            query.setParameter("maKhachHang", maKhachHang);

            List<KhachHang> results = query.getResultList();
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
