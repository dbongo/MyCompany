package com.project;
import com.project.mysql.Connect;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        Connect connect = new Connect();
        connect.LocalhostDBConnection();
    }
}

