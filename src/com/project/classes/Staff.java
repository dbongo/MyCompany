package com.project.classes;
import com.project.mysql.Connect;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

/** Данный класс хранит данные о людях (сотрудники). */
public class Staff {

    /* Ссылка на класс Connect. */
    private Connect connect = new Connect();
    /* Ссылка на класс MainMenu. */
    private MainMenu mainMenu = new MainMenu();
    /* Так называемый "тег". */
    private byte action = 0;
    /* Переменная содержащая SQL запрос. */
    private String query = null;
    /* Переменная - хранит имя сотрудника. */
    private String name = null;
    /* Переменная - хранит фамилию сотрудника. */
    private String lastName = null;
    /* Переменная - хранит номер телефона сотрудника. */
    private String phone = null;
    /* Переменная - хранит возраст сотрудника. */
    private int age = 0;
    /* Переменная - для хранения названия должности. */
    private String namePosition = null;


    /** Меню сотрудников. */
    public void staffMenu() throws SQLException {
        System.out.println("Вы находитесь в: 'Меню программы' -> 'Сотрудники'");
        System.out.println("Вы можете выполнить следующие пункти: \n");
        System.out.println("[1] - Добавить сотрудника");
        System.out.println("[2] - Удалить сотрудника");
        System.out.println("[9] - Вернуться в предыдущее меню");
        System.out.println("[0] - Выход с программы");

        try {
            Scanner scannerAction = new Scanner(System.in);
            action = scannerAction.nextByte();
        }
        catch (InputMismatchException e) {
            System.out.println("Пожалуйста, введите правельные данные!");
            staffMenu();
        }

        switch (action) {
            case 0: {
                break;
            }
            case 1: {
                addStaff();
                break;
            }
            case 2: {
                deleteStaff();
                break;
            }
            case 9: {
                mainMenu.menu();
                break;
            }
            default: {
                System.out.println("Действия с тегом [" + action + "] нет! Попробуйте ещё раз.");
                staffMenu();
                break;
            }
        }
    }

    /** Метод, который позволет добавить сотрудника. */
    private void addStaff () throws SQLException {
        System.out.println("Вы находитесь в: 'Меню программы' -> 'Сотрудники' -> 'Добавить сотрудника' \n");
        try {
            System.out.println("Для того что бы добавить сотрудника необходимо ввести: \n");

            System.out.print("Для добовления сотрудника введите название должности: ");
            Scanner scan = new Scanner(System.in);
            namePosition = scan.nextLine();

            /* Запрос на выборку данных. */
            query = "SELECT idPosition FROM companyDB.Position WHERE title = '" + namePosition + "';";
            connect.connectToDatabase(query);

            /* Проверка - проверяте, есть ли должность. */
            if (connect.getResultQuery() != null) {
                System.out.print("Имя сотрудника: ");
                Scanner scennerName = new Scanner(System.in);
                name = scennerName.nextLine();

                System.out.print("Фамилия сорудника: ");
                Scanner scennerLastName = new Scanner(System.in);
                lastName = scennerLastName.nextLine();

                System.out.print("Возраст сорудника: ");
                Scanner scennerAge = new Scanner(System.in);
                age = scennerAge.nextInt();

                System.out.print("Телефон сорудника: ");
                Scanner scennerPhone = new Scanner(System.in);
                phone = scennerPhone.nextLine();

                /* SQL запрос на добовление сотрудника. */
                query = "INSERT INTO companyDB.Staff (name, lastName, phone, age, idPosition) VALUES ('" + name + "', " + "'" + lastName + "', " + "'" + phone + "', " + "'" + age + "', " + "'" + connect.getResultQuery() + "'" + ")";
                /* Передаём запрос в метод. */
                connect.connectToDatabase(query);
                System.out.println("Чувак добавлен");
                /* Возвращаем пользователя к меню сотрудники. */
                staffMenu();
            }
            /* Срабатывает если должности которую ввел пользователь нет. */
            else  {
                System.out.println("К сожелению должности " + connect.getResultQuery() + " нет! Введите существующею должность");
                /* Возвращаем пользователя к добовлению сотрудников. */
                addStaff();
            }
        }
        catch (Exception e) {
            System.out.println("Error - # " + e);
            /* Возвращаем пользователя к добовлению сотрудников. */
            addStaff();
        }
    }

    /** Метож, который позволяет удалить сотрудника. */
    private void deleteStaff () {
        System.out.println("Вы находитесь в: 'Меню программы' -> 'Сотрудники' -> 'Удалить сотрудника' \n");
        try {
            System.out.println("Для того что бы удалить сотрудника необходимо ввести: \n");
            System.out.print("Для удаления сотрудника необходимо ввести его фамилию: ");

            Scanner scannerNamePosition = new Scanner(System.in);
            lastName = scannerNamePosition.nextLine();

            /* Запрос на выборку данных. Если  */
            query = "SELECT idStaff FROM companyDB.Staff WHERE lastName = '" + lastName + "';";
            connect.connectToDatabase(query);

            /* Проверка, если результат не равен 0 то удаляем сотрудника. */
            if (connect.getResultQuery() != null) {
                /* Запрос на удаление сотрудника. */
                query = "DELETE FROM companyDB.Staff WHERE idStaff = '" + connect.getResultQuery() + "';";
                /* Передаём запрос в метод. */
                connect.connectToDatabase(query);

                System.out.println("Должность успешно удалена!");
                /* Возвращаем пользователя к меню сотрудники. */
                staffMenu();
            }
            /* Срабатывает если запрос не выполнился. */
            else {
                deleteStaff();
                System.out.println("ERROR");
            }
        }
        catch (Exception e) {
            System.err.println("Error - # " + e);
        }
    }

    /** Метож, который позволяет редактировать данные сотрудников. */
    private void editStaff () {

    }
}
