package com.example.serviceappointmentmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.*;

import javafx.scene.control.SplitMenuButton;

import java.time.LocalDate;


public class Home {

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
    @FXML
    private TableColumn showID;
    @FXML
    private TableColumn showName;
    @FXML
    private TableColumn showContact;
    @FXML
    private TableColumn showDate;
    @FXML
    private TableColumn showType;
    @FXML
    private TextField filtName;


    public String data[][] =[][];


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

    //-----------------------------------------------------------------------------------

    public void selectTypeA() {
       addType.setText("Type A");
    }
    public void selectTypeB() {
        addType.setText("Type B");
    }
    public void selectTypeC() {
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
        addName.setText("hi"+name+" "+number+" "+email+" "+type+" "+date);


        String jdbcURL = "jdbc:mysql://localhost:3306/appointmentmanagementsystem";
        String username = "root";
        String password = "";

        Connection conn = DriverManager.getConnection(jdbcURL, username, password);
        if (conn != null) {
            String sql = "INSERT INTO datasheet (ID, Name, Number, Email, Type, Date) VALUES (?, ?, ?, ?, ?, ?)";
            try (
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
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



    public void onReadData(ActionEvent event) throws  SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/appointmentmanagementsystem";
        String username = "root";
        String password = "";

        Connection conn = DriverManager.getConnection(jdbcURL, username, password);
        if (conn != null) {
            String sql2 = "SELECT * FROM datasheet";
            try (
                    PreparedStatement preparedStatement = conn.prepareStatement(sql2);
                    // Execute the query and get the result set
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {
                // Iterate through the result set and print data
                while (resultSet.next()) {
                    String name = resultSet.getString("Name");
                    String type = resultSet.getString("Type");

                    filtName.setText(name);
                    //showType.setText(type);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }}