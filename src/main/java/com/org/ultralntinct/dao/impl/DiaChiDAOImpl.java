package com.org.ultralntinct.dao.impl;

import java.util.List;
import java.util.Optional;

import com.org.ultralntinct.config.JpaConfig;
import com.org.ultralntinct.dao.jpa.DiaChiDAO;
import com.org.ultralntinct.model.DiaChi;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

/**
 * <p>
 * DiaChiDAOImpl represents a concrete implementation of DiaChiDAO.
 * </p>
 *
 * @author MinhNgoc.
 */
public class DiaChiDAOImpl implements DiaChiDAO {

    /**
     * <p>
     * The method Save.
     * </p>
     *
     * @author MinhNgoc
     * @param entity the entity
     */
    @Override
    public void save(DiaChi entity) {
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
    public void update(DiaChi entity) {
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
    public Optional<DiaChi> findById(Long id) {
        EntityManager em = JpaConfig.getEntityManager();
        try {
            DiaChi video = em.find(DiaChi.class, id);
            return video != null ? Optional.of(video) : Optional.empty();
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
    public List<DiaChi> findAll() {
        EntityManager em = JpaConfig.getEntityManager();
        try {
            String jpql = "SELECT d FROM DiaChi d";
            return em.createQuery(jpql, DiaChi.class).getResultList();
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
}
