package com.project.classes;
import com.project.mysql.Connect;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

/** Данный класс хранит данные о людях (сотрудники). */
public class Staff {

    /* Ссылка на класс Connect. */
    private Connect connect = new Connect();
    /* Так называемый "тег". */
    private byte action = 0;
    /* Переменная содержащая SQL запрос. */
    private String query = null;
    /* Переменная - хранит имя человека (сотрудника). */
    private String name = null;
    /* Переменная - хранит фамилию человека (сотрудника). */
    private String lastName = null;
    /* Переменная - хранит номер телефона человека (сотрудника). */
    private String phone = null;
    /* Переменная - хранит возраст человека (сотрудника). */
    private int age = 0;
    /* Переменная - для хранения названия должности. */
    private String namePosition = null;


    /* Меню сотрудников. */
    public void staffMenu() throws SQLException {
        System.out.println("Вы находитесь в: 'Меню программы' -> 'Сотрудники'");
        System.out.println("Вы можете выполнить следующие пункти: \n");
        System.out.println("[1] - Добавить сотрудника");
        System.out.println("[2] - Удалить сотрудника");
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
            default: {
                System.out.println("Действия с тегом [" + action + "] нет! Попробуйте ещё раз.");
                staffMenu();
                break;
            }
        }
    }

    /* Метод, который позволет добавить сотрудника. */
    private void addStaff () throws SQLException {
        System.out.println("Вы находитесь в: 'Меню программы' -> 'Сотрудники' -> 'Добавить сотрудника'");
        try {
            System.out.println("Для того что бы добавить сотрудника необходимо ввести: \n");


            System.out.print("Для добовления сотрудника введите название должности: ");
            Scanner scan = new Scanner(System.in);
            namePosition = scan.nextLine();

            /* Запрос на выборку данных. Если  */
            query = "SELECT idPosition FROM companyDB.Position WHERE title = '" + namePosition + "';";
            connect.connectToDatabase(query);


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
            }
            else  {
                System.out.println("К сожелению должности " + connect.getResultQuery() + " нет! Введите существующею должность");
                addStaff();
            }
        }
        catch (Exception e) {
            System.out.println("Error - # " + e);
            addStaff();
        }
    }

    /* Метож, который позволяет удалить сотрудника. */
    private void deleteStaff () {
        System.out.println("Вы находитесь в: 'Меню программы' -> 'Сотрудники' -> 'Удалить сотрудника'");

        try {
            System.out.println("Для того что бы удалить сотрудника необходимо ввести: \n");
            System.out.print("Для удаления сотрудника необходимо ввести его фамилию: ");

            Scanner scannerNamePosition = new Scanner(System.in);
            lastName = scannerNamePosition.nextLine();

            /* Запрос на выборку данных. Если  */
            query = "SELECT idStaff FROM companyDB.Staff WHERE lastName = '" + lastName + "';";
            connect.connectToDatabase(query);

            /* Проверка, если результат не равен 0 то удаляем должность. */
            if (connect.getResultQuery() != null) {
            /* Запрос на удаление должности. */
                query = "DELETE FROM companyDB.Staff WHERE idStaff = '" + connect.getResultQuery() + "';";
            /* Передаём запрос в метод. */
                connect.connectToDatabase(query);

                System.out.println("Должность успешно удалена!");
            }
            /* Срабатывает если запрос не выполнился. */
            else {
                System.out.println("ERROR");
            }

        }   //try
        catch (Exception e) {
            System.err.println("Error - # " + e);
        }   //catcha
    } //deleteStaff
} //class
