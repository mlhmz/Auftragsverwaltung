package me.mlhmz.sqlApplication.sqlBackend;

import me.mlhmz.sqlApplication.Database;
import me.mlhmz.sqlApplication.objects.Products;

import java.sql.*;
import java.util.ArrayList;

public class sqlProducts {
    public ArrayList<Products> connectSQL() {


        String url = Database.credentialList.get(0).getUrl() + "/" + Database.credentialList.get(0).getDatabaseName();
        String user = Database.credentialList.get(0).getUsername();
        String password = Database.credentialList.get(0).getPassword();

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

            // Save Amount of Columns in an int
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

    public static void insertSQL(String produktname) {
        String url = Database.credentialList.get(0).getUrl() + "/" + Database.credentialList.get(0).getDatabaseName();
        String user = Database.credentialList.get(0).getUsername();
        String password = Database.credentialList.get(0).getPassword();

        try (Connection con = DriverManager.getConnection(url,user,password)) {
            // Creates a new Statement
            Statement stmt = con.createStatement();

            // Inserts the Data into the SQL Table with a SQL Statement
            stmt.executeUpdate("INSERT INTO `produkte` (`id`, `produktname`) VALUES (NULL, '" + produktname + "')");

            // Debug Message so the User know the Insert was successful.
            System.out.println("[MySQL] Das Einfügen der Daten war soweit erfolgreich!");

            // Finally closes the Statement
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("[MySQL] Es ist ein Fehler aufgetreten bei dem Einsetzen der Benutzer-Werte.");
        }

    }


    public static void update(int id, String updatename, String updatewert) {
        String url = Database.credentialList.get(0).getUrl() + "/" + Database.credentialList.get(0).getDatabaseName();
        String user = Database.credentialList.get(0).getUsername();
        String password = Database.credentialList.get(0).getPassword();

        try (Connection con = DriverManager.getConnection(url,user,password)) {
            String update = "UPDATE `produkte` SET " + updatename + "='" + updatewert + "' WHERE id=" + id;

            Statement stmt = con.createStatement();

            stmt.executeUpdate(update);

            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("[MySQL] Es ist ein Fehler beim Werteupdate in der Benutzer-Tabelle aufgetreten!");
        }
    }

    public static void delete(int id) {
        String url = "jdbc:mysql://localhost:3306/auftragsverwaltung";
        String user = "root";
        String password = "";
        try (Connection con = DriverManager.getConnection(url,user,password)) {
            String query = "DELETE from `produkte` where id=" + id;
            Statement s = con.createStatement();
            s.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("[MySQL] Ein Fehler ist aufgetreten beim löschen von Auftragsdaten.");
        }
    }
}


