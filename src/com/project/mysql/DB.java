package com.project.mysql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

    public static void start() throws SQLException {
        Connection connection;
        try {
            // Название драйвера
            String driverName = "com.mysql.jdbc.Driver";

            Class.forName(driverName);

            // Create a connection to the database
            String serverName = "localhost";
            String mydatabase = "myDb";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String username = "root";
            String password = null;

            //           jdbc:mysql://localhost/myDb

            connection = DriverManager.getConnection(url, username, password);
            System.out.println("is connect to DB" + connection);

            String query;// = "SELECT * FROM tableses\t";
            query = "CREATE TABLE DubStep("
                    + "USER_ID INT(5) NOT NULL, "
                    + "USERNAME VARCHAR(20) NOT NULL, "
                    + "CREATED_BY VARCHAR(20) NOT NULL, "
                    + "CREATED_DATE DATE NOT NULL, " + "PRIMARY KEY (USER_ID) "
                    + ")";

            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(query);
            String dbtime;
            while (rs.next()) {
                dbtime = rs.getString(1);
                System.out.println(dbtime);
            } // end while

            connection.close();
        } // end try


        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


            // Could not find the database driver
        //} catch (SQLException e) {
          //  e.printStackTrace();
            // Could not connect to the database
        //}

        //try {
            //createDbUserTable();
        //}
        //catch (SQLException e) {
           // e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        //}
    }

    /*
    private static Connection getDBConnection () {
        Connection dbConnection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/myDb", "root", null);
            return dbConnection;
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return dbConnection;
    }

    public static void createDbUserTable() throws SQLException {
        System.out.println("sakfjkdfjkdjsfjdfbjshsdf");
        Connection dbConnection = null;
        Statement statement = null;

        String createTableSQL = "CREATE TABLE DBUSEsR("
                + "USER_ID INT(5) NOT NULL, "
                + "USERNAME VARCHAR(20) NOT NULL, "
                + "CREATED_BY VARCHAR(20) NOT NULL, "
                + "CREATED_DATE DATE NOT NULL, " + "PRIMARY KEY (USER_ID) "
                + ")";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            // выполнить SQL запрос
            statement.execute(createTableSQL);
            System.out.println("Table \"DBUSERasffds\" is created!");
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
    }*/
}