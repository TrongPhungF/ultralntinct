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
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class JpaConfig {

    /** factory */
    private static EntityManagerFactory factory;

    /**
     * <p>
     * getEntityManager.
     * </p>
     *
     * @return a {@link jakarta.persistence.EntityManager} object.
     *
     * @author MinhNgoc.
     */
    public static EntityManager getEntityManager() {

//        Map<String, Object> configOverrides = new HashMap<>();
        // Dotenv dotenv = Dotenv.load();
        // String hostDbSqlServer = dotenv.get("HOST_DB_SQL_SERVER");
        // String portSqlServer = dotenv.get("PORT_SQL_SERVER");
        // String dbDatabaseSqlServer = dotenv.get("DB_DATABASE_SQL_SERVER");
        // String dbUsernameSqlServer = dotenv.get("DB_USERNAME_SQL_SERVER");
        // String jdbDbPasswordSqlServeRcUrl =
        // dotenv.get("DB_PASSWORD_SQL_SERVER");

//        String hostDbSqlServer = "localhost";
//        String portSqlServer = "1455";
//        String dbDatabaseSqlServer = "DuAn_QuanLyCuaHang";
//        String dbUsernameSqlServer = "sa";
//        String jdbDbPasswordSqlServeRcUrl = "YourC0mpl3xP@ssw0rd!";
//
//        String url = String.format("jdbc:sqlserver://%s:%s;databaseName=%s", hostDbSqlServer, portSqlServer,
//            dbDatabaseSqlServer);
//        configOverrides.put("jakarta.persistence.jdbc.url", url);
//        configOverrides.put("jakarta.persistence.jdbc.user", dbUsernameSqlServer);
//        configOverrides.put("jakarta.persistence.jdbc.password", jdbDbPasswordSqlServeRcUrl);
        if (factory == null || !factory.isOpen()) {
//            factory = Persistence.createEntityManagerFactory("DuAn_QuanLyCuaHang", configOverrides);
            factory = Persistence.createEntityManagerFactory("DuAn_QuanLyCuaHang");
        }
        return factory.createEntityManager();
    }
}
