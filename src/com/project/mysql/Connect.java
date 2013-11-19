package com.project.mysql;
import java.sql.*;

public class Connect {

    /*
    /* Хранит путь к драйверу. */
    //private final String driverName = "com.mysql.jdbc.Driver";
    /* Хранит серверное название. */
    //private final String serverName = "localhost";
    /* Хранит название базы данных. */
    //private final String databaseName = "companyDB";

    /* Хранит полный url. */
    private final String url = "jdbc:mysql://localhost/companyDB";
    /* Хранит имя пользователя от базы данных. */
    private final String userName = "root";
    /* Хранит пароль от базы данных. */
    private final String password = null;

    /* Метод принимающий SQL запрос. */
    public void createDbUserTable (String query) throws SQLException {
        /* Три главных переменных для роботы с базой данных. */
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        /* Подключение к Базе данных. */
        try {
            /* Подключение (проверка на соотвецтвие). */
            connection = DriverManager.getConnection(url, userName, password);
            statement = connection.createStatement();

            /* Выполнение запроса. */
            statement.execute(query);

            //-------------------------
            Statement stmt = connection.createStatement();

            resultSet = stmt.executeQuery(query);
            String dbtime;
            while (resultSet.next()) {
                dbtime = resultSet.getString(1);
                System.out.println(dbtime);
            }
            //----------------------------

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
