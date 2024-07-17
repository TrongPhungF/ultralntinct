package com.org.ultralntinct.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.NoArgsConstructor;

/**
 * <p>
 * DatabaseConnection class relate config connection sql.
 * </p>
 *
 * @author MinhNgoc
 */
@NoArgsConstructor
public class DatabaseConnection {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = Logger.getLogger(DatabaseConnection.class.getName());

    /**
     * connection
     */
    private static Connection connection = null;

    /**
     * <p>
     * Method config connection sql
     * </p>
     *
     * @return Connection
     * @throws SQLException
     */
    public static synchronized Connection getConnection() throws SQLException {
        if (connection == null) {
            // config
            String sqlHost = "localhost";
            String sqlPort = "1433";
            String sqlUsername = "sa";
            String sqlPassword = "123456789";
            String sqlDatabase = "DuAn_QuanLyCuaHang";

            String url = String.format("jdbc:sqlserver://%s:%s;databaseName=%s", sqlHost, sqlPort,
                sqlDatabase);

            try {
                connection = DriverManager.getConnection(url, sqlUsername, sqlPassword);
                LOGGER.log(Level.INFO, "Connected to the database successfully.");
            } catch (SQLException e) {
                LOGGER.log(Level.SEVERE, "Failed to connect to the database.", e);
                throw e;
            }
        }

        return connection;
    }

    public static PreparedStatement prepareStatement(String sql, Object... args)
        throws SQLException {
        Connection connection = getConnection();
        PreparedStatement pstmt = null;
        if (sql.trim().startsWith("{")) {
            pstmt = connection.prepareCall(sql);
        } else {
            pstmt = connection.prepareStatement(sql);
        }
        for (int i = 0; i < args.length; i++) {
            pstmt.setObject(i + 1, args[i]);
        }
        return pstmt;
    }

    /**
     * Thực hiện câu lệnh SQL thao tác (INSERT, UPDATE, DELETE) hoặc thủ tục lưu thao tác dữ liệu
     *
     * @param sql  là câu lệnh SQL chứa có thể chứa tham số. Nó có thể là một lời gọi thủ tục lưu
     * @param args là danh sách các giá trị được cung cấp cho các tham số trong câu lệnh sql *
     */
    public static void executeUpdate(String sql, Object... args) {
        try (PreparedStatement stmt = prepareStatement(sql, args)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Thực hiện câu lệnh SQL truy vấn (SELECT) hoặc thủ tục lưu truy vấn dữ liệu
     *
     * @param sql  là câu lệnh SQL chứa có thể chứa tham số. Nó có thể là một lời gọi thủ tục lưu
     * @param args là danh sách các giá trị được cung cấp cho các tham số trong câu lệnh sql
     */
    public static ResultSet executeQuery(String sql, Object... args) {
        try (PreparedStatement stmt = prepareStatement(sql, args)) {
            return stmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
