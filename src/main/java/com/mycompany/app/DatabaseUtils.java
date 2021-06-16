package com.mycompany.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtils {

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/simple", "vasyl", "1502");
    }

    public static void prepareTables(Connection con, String customersTable, String ordersTable) throws SQLException {
        con.createStatement().executeUpdate("INSERT INTO `" + customersTable + "` (id, name) VALUES (1, 'John Due') ON DUPLICATE KEY UPDATE name=name");
        con.createStatement().executeUpdate("INSERT INTO `" + ordersTable + "` (id, product, customer_id) VALUES (1, 'Xiaomi Redmi note 10', 1) ON DUPLICATE KEY UPDATE product=product, customer_id=1");

    }
}
