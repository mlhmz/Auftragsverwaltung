package me.mlhmz.sqlApplication;

import me.mlhmz.sqlApplication.Frontend.GUI;
import me.mlhmz.sqlApplication.sqlBackend.*;

public class mainClass {
    public static void main(String[] args) {
        testDatabase testDB = new testDatabase();
        sqlUsers sqlUsers = new sqlUsers();
        getSqlDepartment sqlDepartment = new getSqlDepartment();
        getSqlProducts sqlProducts = new getSqlProducts();
        testDB.connect();
        sqlUsers.connectSQL();
        sqlDepartment.connectSQL();
        sqlProducts.connectSQL();
        GUI gui = new GUI();
        gui.start();


    }
}
