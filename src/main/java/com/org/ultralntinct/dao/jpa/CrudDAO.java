package com.org.ultralntinct.dao.jpa;

import java.util.List;
import java.util.Optional;

/**
 * <p>
 * CRUDDao interface
 * </p>
 *
 * @author MinhNgoc
 */
public interface CrudDAO<T, ID> {

    /**
     * <p>
     * Save entity
     * </p>
     *
     * @param entity T
     * @author MinhNgoc
     */
    void save(T entity);

    /**
     * <p>
     * Update entity
     * </p>
     * @param entity T
     * @author MinhNgoc
     */
    void update(T entity);

    /**
     * <p>
     * Find entity by ID
     * </p>
     *
     * @param id ID
     * @return Optional<T>
     * @author MinhNgoc
     */
    Optional<T> findById(ID id);

    /**
     * <p>
     * Find all entity
     * </p>
     *
     * @return List<T>
     * @author MinhNgoc
     */
    List<T> findAll();

    /**
     * <p>
     * Delete entity by ID
     * </p>
     *
     * @param id ID
     * @author MinhNgoc
     */
    void deleteById(ID id);
}
