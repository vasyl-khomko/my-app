package com.mycompany.app;

import java.sql.*;
import java.time.LocalDate;

public class Update {

    public static void main(String[] args) throws SQLException
    {
        Connection con = ConnectionUtils.getConnection();

        PreparedStatement groupStatement = con.prepareStatement("UPDATE `groups` SET curator_name=? WHERE name=?");
        PreparedStatement studentStatement = con.prepareStatement("UPDATE `students` SET birth=?, gender=? WHERE name=?");
        PreparedStatement ratingStatement = con.prepareStatement("UPDATE `students_ratings` SET rating=? WHERE created_at=?");

        groupStatement.setString(1, "Ang Li");
        groupStatement.setString(2, "SP-11");
        groupStatement.executeUpdate();

        studentStatement.setDate(1, Date.valueOf(LocalDate.of(1994, 12, 30)));
        studentStatement.setString(2, "female");
        studentStatement.setString(3, "John Doe");
        studentStatement.executeUpdate();

        ratingStatement.setInt(1, 95);
        ratingStatement.setDate(2, Date.valueOf(LocalDate.of(2021, 1, 15)));
        ratingStatement.executeUpdate();
    }
}
