package com.project;
import com.project.classes.MainMenu;
import java.sql.SQLException;

public class Main {

    public static void main (String[] args) throws SQLException {
        MainMenu mainMenu = new MainMenu();
        mainMenu.menu();
    }
}

