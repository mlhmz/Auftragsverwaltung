package me.mlhmz.sqlApplication;

import me.mlhmz.sqlApplication.Frontend.GUI;
import me.mlhmz.sqlApplication.sqlBackend.*;

public class mainClass {
    public static void main(String[] args) {
        testDatabase testDB = new testDatabase();
        sqlUsers sqlUsers = new sqlUsers();
        sqlDepartment sqlDepartment = new sqlDepartment();
        sqlProducts sqlProducts = new sqlProducts();

        // Tests the Database and sends a Message if there's no connection established
        testDB.connect();

        // Connects to the User Database
        sqlOrders.connect();
        sqlUsers.connectSQL();
        sqlDepartment.connectSQL();
        sqlProducts.connectSQL();
        GUI gui = new GUI();
        gui.start();



    }
}
