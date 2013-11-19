package com.project.classes;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

/** Главное меню программы. */
public class MainMenu {

    /* Переменная для присвоения значений с клавиатуры. */
    private byte action = 0;

    /** Главное меню программы. */
    public void menu () throws SQLException {
        System.out.println("Добро пожаловать! Пожалуйста, выберите то, что вы хотите сделать: ");
        System.out.println("[-1-] - Должности");
        System.out.println("[-2-] - Сотрудники");
        System.out.println("[-0-] - Выход \n");

        /* Проверка на валидность данных. */
        try {
            action = 0;

            System.out.print("Введите [тег] действия: ");
            /* Сканер для обработки нажатий с клавиатуры. */
            Scanner scannerAction = new Scanner(System.in);
            action = scannerAction.nextByte();

            switch (action) {
                case 0: {
                    /* Выходим с программы. */
                    System.out.println("До новых встреч!");
                    break;
                }
                case 1: {
                    /* Переходим к должностям. */
                    Position position = new Position();
                    position.positionMenu();
                    break;
                }
                case 2: {
                    /* Переходим к сотрудникам. */
                    Staff staff = new Staff();
                    staff.staffMenu();
                    break;
                }
                default: {
                    System.out.println("Действия с тегом [" + action + "] нет! Попробуйте ещё раз.");
                    /* Возвращаем пользователя к главному меню. */
                    menu();
                    break;
                }
            }
        }
        catch (InputMismatchException e) {
            System.err.println("Error - #" + e);
            System.out.println("Возникла ошибка, пожалуйста, введите правельные данные! \n");
            /* Возвращаем пользователя к главному меню. */
            menu();
        }
    }
}
