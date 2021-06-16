package com.mycompany.app;

import java.sql.*;
import java.time.LocalDate;

public class Insert {

    public static void main(String[] args) throws SQLException
    {
        Connection con = DatabaseUtils.getConnection();

        DatabaseUtils.prepareTables(con, "customers_restrict", "orders_restrict");
        DatabaseUtils.prepareTables(con, "customers_set_null", "orders_set_null");
        DatabaseUtils.prepareTables(con, "customers_cascade", "orders_cascade");

        PreparedStatement groupStatement = con.prepareStatement("INSERT INTO `groups` (name, curator_name) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
        PreparedStatement studentStatement = con.prepareStatement("INSERT INTO `students` (name, birth, group_id) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        PreparedStatement ratingStatement = con.prepareStatement("INSERT INTO `students_ratings` (rating, created_at, student_id) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

        groupStatement.setString(1, "SP-11");
        groupStatement.setString(2, "John Stone");
        groupStatement.executeUpdate();

        ResultSet resultSet = groupStatement.getGeneratedKeys();
        resultSet.next();
        int groupId = resultSet.getInt(1);
        studentStatement.setString(1, "John Doe");
        studentStatement.setDate(2, Date.valueOf(LocalDate.of(1994, 12, 30)));
        studentStatement.setInt(3, groupId);
        studentStatement.executeUpdate();

        resultSet = studentStatement.getGeneratedKeys();
        resultSet.next();
        int studentId = resultSet.getInt(1);
        ratingStatement.setInt(1, 95);
        ratingStatement.setDate(2, Date.valueOf(LocalDate.of(2021, 1, 15)));
        ratingStatement.setInt(3, studentId);
        ratingStatement.executeUpdate();

        groupStatement.setString(1, "SP-21");
        groupStatement.setString(2, "Ponnappa Priya");
        groupStatement.executeUpdate();
    }
}
