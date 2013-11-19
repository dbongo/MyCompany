package com.project.classes;
import com.project.mysql.Connect;
import java.sql.SQLException;
import java.util.Scanner;

/** Данный клас хранит данные о должностей сотрудников. */

public class Position {
    /* Ссылка на класс Connect. */
    private Connect connect = new Connect();
    /* Сканер для ввода информации с клавиатуры. */
    private Scanner scanner = new Scanner(System.in);

    /* Название должности. */
    private String name = null;
    /* Данные о зарплате. */
    private int salary = 2000;
    /* Так называемый "тег". */
    private byte action = 0;
    /* Переменная содержащая SQL запрос. */
    private String query = null;


    public void position () throws SQLException {
        System.out.println("Вы можете выполнить следующие пункти: \n");
        System.out.println("[1] - Добавить должность");
        System.out.println("[2] - Удалить должность");
        System.out.println("[0] - Выход с программы");

        System.out.print("Введите [тег] действия: ");
        action = scanner.nextByte();

        switch (action) {
            case 0: {
                break;
            }
            case 1: {
                System.out.println("Для того что бы добавить дожлность необходимо ввести:");

                System.out.print("Название должности: ");
                Scanner sc = new Scanner(System.in);
                name = sc.nextLine();

                System.out.print("Зарплата должности: ");
                salary = scanner.nextInt();

                query = "INSERT INTO companyDB.Position (title, salary)" + " VALUES" + " ('"+ name + "'" + ", " + "'" + salary +"')";
                connect.createDbUserTable(query);
                break;
            }
            default: {
                break;
            }
        }
    }
}
