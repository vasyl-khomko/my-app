package com.mycompany.app;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App 
{
    public static void main( String[] args ) throws SQLException, ClassNotFoundException
    {
	    Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/simple", "vasyl", "1502");

	    ResultSet result = con.createStatement()
                .executeQuery("SELECT * FROM cats");

	    while (result.next()) {
	        System.out.println(
	                "Id: " + result.getInt("id") +
                    "\t\tName: " + result.getString("name") +
                    "\t\tOwner: " + result.getString("owner") +
                    "\t\tBirth: " + result.getDate("birth")

            );
        }
    }
}
