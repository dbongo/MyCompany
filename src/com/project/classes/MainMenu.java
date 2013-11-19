package com.project.classes;
import java.sql.SQLException;
import java.util.Scanner;

public class MainMenu {

    /* Сканер для обработки нажатий с клавиатуры. */
    private Scanner scanner = new Scanner(System.in);
    /* Переменная для присвоения значений с клавиатуры. */
    private byte action = 0;


    public void menu () throws SQLException {
        System.out.println("Добро пожаловать! Пожалуйста, выберите то, что вы хотите сделать: \n");
        System.out.println("[1] - Добавить/Удалить должность");
        System.out.println("[2] - Добавить/Удалить сотрудника");
        System.out.println("[0] - Выход");

        System.out.print("Введите [тег] действия: ");
        action = scanner.nextByte();

        switch (action) {
            case 0: {
                System.out.println("До новых встреч!");
                break;
            }
            case 1: {
                Position position = new Position();
                position.position();
                break;
            }
            case 2: {
                Staff staff = new Staff();
                staff.Staff();
                break;
            }
            default: {
                action = 0;
                menu();
                break;
            }
        }
    }
}
