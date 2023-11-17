package com.example.serviceappointmentmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javafx.scene.control.SplitMenuButton;
import java.sql.SQLException;
import java.time.LocalDate;


public class Home {

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private TextField addName;
    @FXML
    private TextField addNumber;
    @FXML
    private TextField addEmail;
    @FXML
    private SplitMenuButton addType;
    @FXML
    private DatePicker addDate;




    private String getSelectedDateAsString() {
        LocalDate selectedDate = addDate.getValue();
        if (selectedDate != null) {
            // Convert the LocalDate to a String (customize the format as needed)
            return selectedDate.toString();
        } else {
            // Handle the case where no date is selected
            return "No date selected";
        }
    }

    public void selectTypeA(ActionEvent event) {
       addType.setText("Type A");
    }
    public void selectTypeB(ActionEvent event) {
        addType.setText("Type B");
    }
    public void selectTypeC(ActionEvent event) {
        addType.setText("Type C");
    }
    //-----------------------------------------------------------------------------------

    @FXML
    public void onAddData(ActionEvent event) throws SQLException {
        String name = addName.getText();
        String number = addNumber.getText();
        String email = addEmail.getText();
        String date = getSelectedDateAsString();
        String type = addType.getText();
        //String date="dfsd";
        addName.setText("hi"+name+" "+number+" "+email+" "+type+" "+date);


        String jdbcURL = "jdbc:mysql://localhost:3306/appointmentmanagementsystem";
        String username = "root";
        String password = "";

        Connection conn;
        conn = DriverManager.getConnection(jdbcURL, username, password);
        if (conn != null) {
            String sql = "INSERT INTO datasheet (ID, Name, Number, Email, Type, Date) VALUES (?, ?, ?, ?, ?, ?)";
            try (
                Connection connection = DriverManager.getConnection(jdbcURL, username, password);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ) {

                // Set values for parameters in the SQL query
                preparedStatement.setInt(1, 3);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, number);
                preparedStatement.setString(4, email);
                preparedStatement.setString(5, type);
                preparedStatement.setString(6, date);

                // Execute the insert statement
                int rowsAffected = preparedStatement.executeUpdate();

                // Check if the insertion was successful
                if (rowsAffected > 0) {
                    System.out.println("Data inserted successfully!");
                } else {
                    System.out.println("Failed to insert data.");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("connected");
        } else {
            System.out.println("error");
        }

    }
}