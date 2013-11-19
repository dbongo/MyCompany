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


        /* Переменная - хранит имя человека (сотрудника). */
        // String name = "saf";
    /* Переменная - хранит фамилию человека (сотрудника). */
       // String lastName = "ddsf";
    /* Переменная - хранит номер телефона человека (сотрудника). */
       // String phone = "324324";
    /* Переменная - хранит возраст человека (сотрудника). */
       // int age = 0;
        //int idPosition = 2  ;

        //System.out.println("INSERT INTO companyDB.Staff (name, lastName, phone, age, idPosition) VALUES ('" + name + "', " + "'" + lastName + "', " + "'" + phone + "', " + "'" + age + "', " + "'" + idPosition + "'" + ")");
    }
}

