package com.mycompany.app;

import java.sql.*;
import java.time.LocalDate;

public class InsertStoredProcedure {

    public static void main(String[] args) throws SQLException {
        Connection con = DatabaseUtils.getConnection();
        PreparedStatement statement = con.prepareCall("{call insertData(?, ?, ?, ?, ?, ?)}");

        statement.setString(1, "SP-11");
        statement.setString(2, "John Stone");
        statement.setString(3, "John Doe");
        statement.setDate(4, Date.valueOf(LocalDate.of(1994, 12, 30)));
        statement.setInt(5, 95);
        statement.setDate(6, Date.valueOf(LocalDate.of(2021, 1, 15)));
        statement.executeQuery();
    }
}
