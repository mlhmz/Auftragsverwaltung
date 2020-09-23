package me.mlhmz.sqlApplication;

import me.mlhmz.sqlApplication.Frontend.GUI;
import me.mlhmz.sqlApplication.sqlBackend.*;

public class mainClass {
    public static void main(String[] args) {
        getSqlUsers sqlUsers = new getSqlUsers();
        getSqlDepartment sqlDepartment = new getSqlDepartment();
        getSqlProducts sqlProducts = new getSqlProducts();
        sqlUsers.connectSQL();
        sqlDepartment.connectSQL();
        sqlProducts.connectSQL();
        GUI gui = new GUI();
        gui.start();


    }
}
