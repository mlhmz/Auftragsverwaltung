package me.mlhmz.sqlApplication.sqlBackend;

import me.mlhmz.sqlApplication.Database;
import me.mlhmz.sqlApplication.objects.Products;

import java.sql.*;
import java.util.ArrayList;

public class getSqlProducts {
    public ArrayList<Products> connectSQL() {

        String url = "jdbc:mysql://localhost:3306/auftragsverwaltung";
        String user = "root";
        String password = "";

        // Initialize Database
        Database database = new Database();

        // Connect to MySQL
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            System.out.println("[MySQL] Es wurde eine Verbindung mit der SQL Datenbank hergestellt für die Produkt-Tabelle!");

            // Get Data from Query
            String query = "SELECT * FROM produkte ORDER BY id ASC";

            // Create new Statement
            Statement stmt = con.createStatement();

            // Get Result with Statement
            ResultSet rs = stmt.executeQuery(query);

            // Save Amount of Columns in a int
            int columns = rs.getMetaData().getColumnCount();



            // Store all Userdata's into an ArrayList
            while (rs.next()) {
                Products product = new Products(rs.getInt(1), rs.getString(2));
                database.productList.add(product);
            }


            // Close SQL Connection
            rs.close();
            stmt.close();
        // If theres an Error, catch and report it.
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("[MySQL] Ein Datenbank Technischer Fehler ist aufgetreten bei der Produkt-Tabelle.");
        }

        // Return the Userdata to the List
        return Database.productList;
    }
}


