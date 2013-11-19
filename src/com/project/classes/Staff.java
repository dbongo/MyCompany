package com.project.classes;
import com.project.mysql.Connect;
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
    private int age;


    /* Реализация. */
    public void Staff () {
        System.out.println("Вы находитесь в: 'Меню программы' -> 'Сотрудники'");
        System.out.println("Вы можете выполнить следующие пункти: \n");
        System.out.println("[1] - Добавить сотрудника");
        System.out.println("[2] - Удалить сотрудника");
        System.out.println("[0] - Выход с программы");

        try {
            Scanner scannerAction = new Scanner(System.in);
            action = scannerAction.nextByte();
        }
        catch (Exception e) {
            System.out.println("Пожалуйста, введите правельные данные!");
            Staff();
        }

        switch (action) {
            case 0: {
                break;
            }
            case 1: {
                addStaff();
                break;
            }
            default: {
                break;
            }
        }
    }

    private void addStaff () {
        System.out.println("Вы находитесь в: 'Меню программы' -> 'Сотрудники' -> 'Добавить должность'");
        System.out.println("Для того что бы добавить дожлность необходимо ввести: \n");

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



        /* Запрос добовляющий новую должность в базу данных. */
       // query = "INSERT INTO companyDB.Position (title, salary)" + " VALUES" + " ('"+ name + "'" + ", " + "'" + salary +"')";
//        connect.connectToDatabase(query);


    }
}
