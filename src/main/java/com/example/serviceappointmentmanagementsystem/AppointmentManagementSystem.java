package com.example.serviceappointmentmanagementsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AppointmentManagementSystem extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AppointmentManagementSystem.class.getResource("Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 690, 526);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        Class.forName("com.mysql.cj.jdbc.Driver");

        String jdbcURL = "jdbc:mysql://localhost:3306/appointmentmanagementsystem";
        String username = "root";
        String password = "";

        Connection conn;
        conn = DriverManager.getConnection(jdbcURL, username, password);
        if (conn != null) {
            launch();
            System.out.println("connected");
        } else {
            System.out.println("error");
        }
    }
}