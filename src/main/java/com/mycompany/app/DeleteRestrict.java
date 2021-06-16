package com.mycompany.app;

import java.sql.Connection;
import java.sql.SQLException;

public class DeleteRestrict {

    public static void main(String[] args) throws SQLException
    {
        Connection con = DatabaseUtils.getConnection();

        con.createStatement().executeUpdate("DELETE FROM `orders_restrict` WHERE id=1");
        con.createStatement().executeUpdate("DELETE FROM `customers_restrict` WHERE id=1");
    }
}
