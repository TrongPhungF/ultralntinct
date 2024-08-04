package com.org.ultralntinct.dao.impl;

import java.util.List;
import java.util.Optional;

import com.org.ultralntinct.config.JpaConfig;
import com.org.ultralntinct.dao.jpa.LoaiSanPhamDAO;
import com.org.ultralntinct.model.LoaiSanPham;

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
public class LoaiSanPhamDAOImpl implements LoaiSanPhamDAO {

    /**
     * <p>
     * The method Save.
     * </p>
     *
     * @author MinhNgoc
     * @param entity the entity
     */
    @Override
    public void save(LoaiSanPham entity) {
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
    public void update(LoaiSanPham entity) {
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
    public Optional<LoaiSanPham> findById(Long id) {
        EntityManager em = JpaConfig.getEntityManager();
        try {
            LoaiSanPham entity = em.find(LoaiSanPham.class, id);
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
    public List<LoaiSanPham> findAll() {
        EntityManager em = JpaConfig.getEntityManager();
        try {
            String jpql = "SELECT s FROM LoaiSanPham s";
            return em.createQuery(jpql, LoaiSanPham.class).getResultList();
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
            LoaiSanPham entity = em.find(LoaiSanPham.class, id);
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
     * The method Find by ma loai san pham.
     * </p>
     *
     * @author MinhNgoc
     * @param maLoaiSanPham the ma loai san pham
     * @return the optional
     */
    @Override
    public Optional<LoaiSanPham> findByMaLoaiSanPham(String maLoaiSanPham) {
        EntityManager em = JpaConfig.getEntityManager();
        try {
            String jpql = "SELECT s FROM LoaiSanPham s WHERE s.maLoaiSanPham = :maLoaiSanPham";
            TypedQuery<LoaiSanPham> query = em.createQuery(jpql, LoaiSanPham.class);
            query.setParameter("maLoaiSanPham", maLoaiSanPham);

            List<LoaiSanPham> results = query.getResultList();
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
