package me.mlhmz.sqlApplication.sqlBackend;

import me.mlhmz.sqlApplication.Database;
import me.mlhmz.sqlApplication.objects.Orders;

import java.sql.*;

public class sqlOrders {
    public static void connect() {
        String url = Database.credentialList.get(0).getUrl() + "/" + Database.credentialList.get(0).getDatabaseName();
        String user = Database.credentialList.get(0).getUsername();
        String password = Database.credentialList.get(0).getPassword();

        try (Connection con = DriverManager.getConnection(url,user,password)) {
            System.out.println("[MySQL] Es wurde eine Verbindung mit der SQL Datenbank hergestellt für die Auftrags-Tabelle!");

            // Get Data from Query
            String query = "SELECT * FROM auftraege ORDER BY auftragsid ASC";

            // Create new Statement
            Statement stmt = con.createStatement();

            // Get Result with Statement
            ResultSet rs = stmt.executeQuery(query);

            // Save Amount of Columns in an int
            int columns = rs.getMetaData().getColumnCount();

            // Store all Userdata's into an ArrayList
            // And get the right Table Data with help of the
            // Order Id's
            while (rs.next()) {

                // Query for Users
                int userid = rs.getInt(2);
                String queryUser = "SELECT * FROM benutzer WHERE id = '" + userid + "'";
                Statement sUser = con.createStatement();
                ResultSet rsUser = sUser.executeQuery(queryUser);
                String firmenname = "";
                String firmentelefonnummer = "";
                String firmenadresse = "";
                String firmenemail = "";
                while(rsUser.next()) {
                    firmenname = rsUser.getString(2);
                    firmenadresse = rsUser.getString(3);
                    firmentelefonnummer = rsUser.getString(4);
                    firmenemail = rsUser.getString(5);
                }

                // Query for Productname
                int productid = rs.getInt(1);
                String queryProduct = "SELECT * FROM produkte WHERE id = '" + productid + "'";
                Statement sProduct = con.createStatement();
                ResultSet rsProdukt = sProduct.executeQuery(queryProduct);
                String produkt = "";
                while (rsProdukt.next()) {
                    produkt = rsProdukt.getString(2);
                }

                // Query for Departments
                int departmentid = rs.getInt(3);
                String queryDepartment = "SELECT * FROM abteilungen WHERE abteilungsid = '" + departmentid + "'";
                Statement sDepartment = con.createStatement();
                ResultSet rsDepartment = sDepartment.executeQuery(queryDepartment);
                String abteilungsname = "";
                String abteilungstelefonnummer = "";
                String abteilungsleiter = "";
                while (rsDepartment.next()) {
                    abteilungsname = rsDepartment.getString(2);
                    abteilungstelefonnummer =  rsDepartment.getString(3);
                    abteilungsleiter = rsDepartment.getString(4);
                }

                // Remaining Data from the Order Table
                int menge = rs.getInt(7);
                String deadline = rs.getString(6);
                String datum = rs.getString(5);
                int auftragsid = rs.getInt(4);

                Orders order = new Orders(auftragsid, firmenname, firmentelefonnummer, firmenadresse,
                        firmenemail, produkt, menge, abteilungsname, abteilungsleiter, abteilungstelefonnummer, datum, deadline);
                Database.orderList.add(order);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("[MySQL] Ein Datenbank Technischer Fehler ist aufgetreten bei der Auftrags-Tabelle.");

        }
    }

    public static void insert(int produktid, int kundenid, int abteilungsid, String auftragsdatum, String deadline, int menge) {
        String url = "jdbc:mysql://localhost:3306/auftragsverwaltung";
        String user = "root";
        String password = "";

        try (Connection con = DriverManager.getConnection(url,user,password)) {
            // Creates new Statements
            Statement s = con.createStatement();

            // Inserts the Data into the SQL Table with a SQL Statement
            s.executeUpdate("INSERT INTO `auftraege` (`produktid`, `kundenid`, `abteilungsid`, `auftragsid`, `auftragsdatum`, `deadline`, `menge`) VALUES ('" + produktid + "', '" + kundenid + "', '" + abteilungsid + "', NULL, '" + auftragsdatum + "', '" + deadline + "', '" + menge +"')");

            // Debug Message so the User know the Insert was successful.
            System.out.println("[MySQL] Das Einfügen der Daten war soweit erfolgreich!");

            // Close the Connection
            s.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("[MySQL] Es ist ein Fehler aufgetreten bei dem Einsetzen der Auftrags-Werte.");
        }
    }

    public static void delete(int id) {
        String url = "jdbc:mysql://localhost:3306/auftragsverwaltung";
        String user = "root";
        String password = "";
        try (Connection con = DriverManager.getConnection(url,user,password)) {
            String query = "DELETE from `auftraege` where auftragsid=" + id;
            Statement s = con.createStatement();
            s.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("[MySQL] Ein Fehler ist aufgetreten beim löschen von Auftragsdaten.");
        }
    }
}
