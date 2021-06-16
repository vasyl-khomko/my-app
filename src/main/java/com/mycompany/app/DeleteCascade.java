package com.mycompany.app;

import java.sql.Connection;
import java.sql.SQLException;

public class DeleteCascade {

    public static void main(String[] args) throws SQLException
    {
        Connection con = DatabaseUtils.getConnection();

        con.createStatement().executeUpdate("DELETE FROM `customers_cascade` WHERE id=1");
    }
}
