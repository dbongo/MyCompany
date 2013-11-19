package com.project;
import com.project.classes.MainMenu;
import com.project.mysql.Connect;

import java.sql.SQLException;

/**
 * @autor Зарочинцев Александр Георгиевич
 */

/** Точка входа программы. */
public class Main {

    public static void main (String[] args) throws SQLException {
        MainMenu mainMenu = new MainMenu();
        mainMenu.menu();


        /*
        Connect connect = new Connect();
        String s = "SELECT * FROM companyDB.Position";
        connect.connectToDatabase(s);
        */
    }
}

