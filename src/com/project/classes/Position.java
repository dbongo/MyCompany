package com.project.classes;
import com.project.mysql.Connect;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

/** Данный клас хранит данные о должностей должностях. */
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


    /* Меню должности. */
    public void positionMenu() throws SQLException {
        System.out.println("Вы можете выполнить следующие пункти: \n");
        System.out.println("[1] - Добавить должность");
        System.out.println("[2] - Удалить должность");
        System.out.println("[0] - Выход с программы");

        try {
            System.out.print("Введите [тег] действия: ");
            Scanner scannerAction = new Scanner(System.in);
            action = scannerAction.nextByte();
        }
        catch (InputMismatchException e) {
            System.out.println("Пожалуйста, введите правельные данные!");
            positionMenu();
        }

        switch (action) {
            case 0: {
                break;
            }
            case 1: {
                addPosition();
                break;
            }
            case 2: {
                deletePosition();
                break;
            }
            default: {
                System.out.println("Действия с тегом [" + action + "] нет! Попробуйте ещё раз.");
                positionMenu();
                break;
            }
        }
    }

    /* Добовление новой должности. */
    private void addPosition () throws SQLException {
        try {
            System.out.println("Для того что бы добавить дожлность необходимо ввести: ");

            System.out.print("Название должности: ");
            Scanner sc = new Scanner(System.in);
            name = sc.nextLine();

            System.out.print("Зарплата должности: ");
            salary = scanner.nextInt();

            /* Запрос добовляющий новую должность в базу данных. */
            query = "INSERT INTO companyDB.Position (title, salary)" + " VALUES" + " ('"+ name + "'" + ", " + "'" + salary +"')";
            connect.connectToDatabase(query);

            System.out.println("Вы успешно добавили должность: " + name);
        }
        catch (Exception e) {
            System.err.println("Error - # " + e);
            addPosition();
        }
    }

    /* Удаление должности. */
    private void deletePosition () throws SQLException {
        try {
            System.out.println("Для удаления должности введите её название: ");

            Scanner scan = new Scanner(System.in);
            name = scan.nextLine();

            /* Запрос на выборку данных. Если  */
            query = "SELECT idPosition FROM companyDB.Position WHERE title = '" + name + "';";
            connect.connectToDatabase(query);

            /* Проверка, если результат не равен 0 то удаляем должность. */
            if (connect.getResultQuery() != null) {
            /* Запрос на удаление должности. */
                query = "DELETE FROM companyDB.Position WHERE idPosition = '" + connect.getResultQuery() + "';";
            /* Передаём запрос в метод. */
                connect.connectToDatabase(query);

                System.out.println("Должность успешно удалена!");
            }
            /* Срабатывает если запрос не выполнился. */
            else {
                System.out.println("ERROR");
            }
        }
        catch (Exception e) {
            System.err.println("Error - # " + e);
            deletePosition();
        }
    }

    /* Редактирование должности. */
    private void editPosition () {
    }
}
