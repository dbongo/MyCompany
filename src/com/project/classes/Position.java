package com.project.classes;
import com.project.mysql.Connect;
import java.sql.SQLException;
import java.util.Scanner;

/* Данный клас хранит данные о должностей сотрудников. */

public class Position {

    private Scanner scanner = new Scanner(System.in);

    /* Названия должности. */
    private String name;
    /* Данные о зарплате. */
    private int salary;


    /* Так называемый "тег". */
    byte action = 0;
    /* Переменная содержащая SQL запрос. */
    String query = "";


    public void statrPosition () throws SQLException {
        System.out.println("Вы можете выполнить следующие пункти: \n");
        System.out.println("[1] - Добавить должность");

        System.out.println("[0] - Выход с программы");

        //action = scanner.nextByte();

        action = 1;
        String tittle = "FUCK YOU";
        int salar = 3000;

        switch (action) {
            case 0: {
                break;
            }
            case 1: {
                query = "INSERT INTO companyDB.Position (title, salary)" + " VALUES" + " ('"+ tittle + "'" + ", " + "'" + salar +"')";

                Connect connect = new Connect();
                connect.createDbUserTable(query);
                break;
            }
            default: {
                break;
            }
        }
    }
}
