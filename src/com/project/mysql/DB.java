package com.project.mysql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

    String serverName = "localhost";
    String mydatabase = "companydb";
    String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
    String username = "root";
    String password = null;


    /*
    public void start() throws SQLException {
        Connection connection;
        try {
            // Название драйвера
            String driverName = "com.mysql.jdbc.Driver";

            Class.forName(driverName);

            // Create a connection to the database




            connection = DriverManager.getConnection(url, username, password);
            System.out.println("is connect to DB" + connection);

            String query;// = "SELECT * FROM tableses\t";
            //query = "INSERT INTO companyDB.Position(title,salary) VALUES('pizda','213')";

            query = "SELECT * FROM Position";

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

        createDbUserTable();


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

    */


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



    }  */






    public void createDbUserTable() throws SQLException {
        System.out.println("sakfjkdfjkdjsfjdfbjshsdf");
        Connection dbConnection = null;
        Statement statement = null;

        String createTableSQL = "INSERT INTO companydb.Position (title, salary) VALUES ('pizda', '123');";

        try {
            //dbConnection = getDBConnection();
            dbConnection = DriverManager.getConnection(url, username, password);

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
    }
}