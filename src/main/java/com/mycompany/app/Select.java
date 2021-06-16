package com.mycompany.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select {

    public static void main(String[] args) throws SQLException {
        Connection con = DatabaseUtils.getConnection();

        PreparedStatement groupStatement = con.prepareStatement("SELECT * FROM `groups`");
        PreparedStatement studentStatement = con.prepareStatement("SELECT * FROM `students`");
        PreparedStatement ratingStatement = con.prepareStatement("SELECT * FROM `students_ratings`");

        System.out.println("Groups");
        ResultSet resultSet = groupStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(
                    "Id: " + resultSet.getInt("id") +
                            ";\tName: " + resultSet.getString("name") +
                            ";\tCurator name: " + resultSet.getString("curator_name")
            );
        }

        System.out.println("\nStudents:");
        resultSet = studentStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(
                    "Id: " + resultSet.getInt("id") +
                            ";\tName: " + resultSet.getString("name") +
                            ";\tGroup ID: " + resultSet.getString("group_id") +
                            ";\tBirth: " + resultSet.getDate("birth") +
                            ";\tGender: " + resultSet.getString("gender")
            );
        }

        System.out.println("\nStudents ratings:");
        resultSet = ratingStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(
                    "Id: " + resultSet.getInt("id") +
                            ";\tRating: " + resultSet.getInt("rating") +
                            ";\tCreated at: " + resultSet.getString("created_at") +
                            ";\tStudent ID: " + resultSet.getString("student_id")
            );
        }
    }
}
