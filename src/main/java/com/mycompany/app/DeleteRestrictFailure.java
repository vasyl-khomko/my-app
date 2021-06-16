package com.mycompany.app;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class DeleteRestrictFailure {

    public static void main(String[] args) throws SQLException
    {
        Connection con = DatabaseUtils.getConnection();

        con.createStatement().executeUpdate("DELETE FROM `customers_restrict` WHERE id=1");
    }
}
