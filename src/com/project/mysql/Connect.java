package com.project.mysql;
import java.sql.*;

/** Класс отвечающий за подключение к базе данных и выполняющий SQL запросы.. */
public class Connect {

    /* Хранит полный url. */
    private final String url = "jdbc:mysql://localhost/companyDB";
    /* Хранит имя пользователя от базы данных. */
    private final String userName = "root";
    /* Хранит пароль от базы данных. */
    private final String password = null;
    /* Перемення для результата запроса с базы данных. */
    private String resultQuery = null;

    /* Геттер для resultQuery. */
    public String getResultQuery() {
        return resultQuery;
    }

    /** Метод принимающий SQL запрос. */
    public void connectToDatabase(String query) throws SQLException {
        /* Три главных переменных для роботы с базой данных. */
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Statement stmt = null;

        /* Подключение к Базе данных. */
        try {
            /* Подключение (проверка на соотвецтвие). */
            connection = DriverManager.getConnection(url, userName, password);
            statement = connection.createStatement();

            /* Выполнение запроса. */
            statement.execute(query);

            //-------------------------
            stmt = connection.createStatement();
            resultSet = stmt.executeQuery(query);

            while (resultSet.next()) {
                resultQuery = resultSet.getString(1);
                System.out.println(resultQuery);
            }
            //----------------------------

            System.out.println(resultQuery);
            System.out.println("Запрос выполнился успешно!");
        }
        catch (SQLException e) {
            /* Если возникла ошибка - выводим её в консоль. */
            System.err.println(e.getMessage());
        }
        /* Выполниться в любом случае. */
        finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
