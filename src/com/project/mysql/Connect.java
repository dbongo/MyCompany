package com.project.mysql;
import java.sql.*;

public class Connect {

    /* Хранит путь к драйверу. */
    private final String driverName = "com.mysql.jdbc.Driver";
    /* Хранит серверное название. */
    private final String serverName = "localhost";
    /* Хранит название базы данных. */
    private final String databaseName = "companyDB";
    /* Хранит полный url. */
    private final String url = "jdbc:mysql://localhost/companyDB";
    /* Хранит имя пользователя от базы данных. */
    private final String userName = "root";
    /* Хранит пароль от базы данных. */
    private final String password = null;


    public void createDbUserTable (String query) throws SQLException {
        System.out.println("sakfjkdfjkdjsfjdfbjshsdf");
        Connection dbConnection = null;
        Statement statement = null;

        //query = "INSERT INTO companydb.Position (title, salary) VALUES ('pizda', '123');";

        try {
            dbConnection = DriverManager.getConnection(url, userName, password);
            statement = dbConnection.createStatement();

            // выполнить SQL запрос
            statement.execute(query);
            System.out.println("Запрос выполнился успешно!");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("good");
        }
        finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }


}
