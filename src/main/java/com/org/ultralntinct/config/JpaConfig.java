package com.org.ultralntinct.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

/**
 * <p>
 * JpaConfig class.
 * </p>
 * 
 * @author MinhNgoc.
 * 
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class JpaConfig {

    private static EntityManagerFactory factory;

    public static EntityManager getEntityManager() {
        if (factory == null || !factory.isOpen()) {
            factory = Persistence
                    .createEntityManagerFactory("DuAn_QuanLyCuaHang");
        }
        return factory.createEntityManager();
    }

}
