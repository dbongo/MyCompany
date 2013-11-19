package com.project;
import com.project.classes.MainMenu;
import java.sql.SQLException;

/**
 * @autor Зарочинцев Александр Георгиевич
 */

/** Точка входа программы. */
public class Main {

    public static void main (String[] args) throws SQLException {
        MainMenu mainMenu = new MainMenu();
        mainMenu.menu();
    }
}

