package com.project.mysql;
import java.sql.*;

public class Connect {

    /* Хранит путь к драйверу. */
    private final String driverName = "com.mysql.jdbc.Driver";
    /* . */
    private final String serverName = "localhost";
    /* . */
    private final String databaseName = "myDb";
    /* . */
    private final String url = "jdbc:mysql://localhost/myDb";
    /* . */
    private final String userName = "root";
    /* . */
    private final String password = null;

    public void LocalhostDBConnection() throws SQLException {
        Connection connection;
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, userName, password);

            System.out.println("Подключение прошло успешно к: " + connection);
            connection.close();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }





        createTable();




    }

    public void createTable () throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        /*
        String createTableSQL = "CREATE TABLE fuckfuck2("
                + "USER_ID INT(5) NOT NULL, "
                + "USERNAME VARCHAR(20) NOT NULL, "
                + "CREATED_BY VARCHAR(20) NOT NULL, "
                + "CREATED_DATE DATE NOT NULL, " + "PRIMARY KEY (USER_ID) "
                + ")";  */

        /*
        String createTableSQL = "INSERT INTO DBUSER"
                + "(USER_ID, USERNAME, CREATED_BY, CREATED_DATE) " + "VALUES"
                + "(1,'mkyong','system', " + "to_date('"
                + getCurrentTimeStamp() + "', 'yyyy/mm/dd hh24:mi:ss'))"      */

        try {
            dbConnection = DriverManager.getConnection(url, userName, password);
            statement = dbConnection.createStatement();

            // выполнить SQL запрос
            statement.execute(createTableSQL);
            System.out.println("Таблица в Базе данныйх успешно создана!");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("good");
        }
        /*
        finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        } */

    }

    public void addNotes () {

    }
























    //String query = "SELECT name FROM tableses\t";

    //Statement stmt = connection.createStatement();

    //ResultSet rs = stmt.executeQuery(query);
    //String dbtime;

            /*
            while (rs.next()) {
                dbtime = rs.getString(1);
                System.out.println(dbtime);
            } // end while
            */
}
