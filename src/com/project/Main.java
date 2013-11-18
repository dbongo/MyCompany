package com.project;
import com.project.mysql.MySQL;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        try {
            MySQL mySQL = new MySQL();
            mySQL.connectionToMySql();
            MySQL.createDbUserTable();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
       catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

