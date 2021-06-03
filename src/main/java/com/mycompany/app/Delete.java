package com.mycompany.app;

import java.sql.*;
import java.time.LocalDate;

public class Delete {

    public static void main(String[] args) throws SQLException
    {
        Connection con = ConnectionUtils.getConnection();

        PreparedStatement groupStatement = con.prepareStatement("DELETE FROM `groups` WHERE name=?");
        PreparedStatement studentStatement = con.prepareStatement("DELETE FROM `students` WHERE name=?");
        PreparedStatement ratingStatement = con.prepareStatement("DELETE FROM `students_ratings` WHERE created_at=?");

        groupStatement.setString(1, "SP-11");
        groupStatement.executeUpdate();
        groupStatement.setString(1, "SP-21");
        groupStatement.executeUpdate();

        studentStatement.setString(1, "John Doe");
        studentStatement.executeUpdate();

        ratingStatement.setDate(1, Date.valueOf(LocalDate.of(2021, 1, 15)));
        ratingStatement.executeUpdate();
    }
}
