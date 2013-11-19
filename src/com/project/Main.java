package com.project;
import com.project.classes.Position;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        Position position = new Position();
        try {
            position.statrPosition();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

