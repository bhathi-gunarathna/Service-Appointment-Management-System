package com.example.serviceappointmentmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.*;
import javafx.scene.control.SplitMenuButton;
import java.time.LocalDate;

import java.util.ArrayList;


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
    private TextField cancel;
    @FXML
    private TextField reNum;

    @FXML
    private TextArea colID;
    @FXML
    private TextArea colName;
    @FXML
    private TextArea colContact;
    @FXML
    private TextArea colDate;
    @FXML
    private TextArea colType;




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
    String jdbcURL = "jdbc:mysql://localhost:3306/appointmentmanagementsystem";
    String username = "root";
    String password = "";
    @FXML
    public void onAddData(ActionEvent event) throws SQLException {
        String name = addName.getText();
        String number = addNumber.getText();
        String email = addEmail.getText();
        String date = getSelectedDateAsString();
        String type = addType.getText();
        
        

        Connection conn = DriverManager.getConnection(jdbcURL, username, password);
        if (conn != null) {
            String sql = "INSERT INTO datasheet ( Name, Number, Email, Type, Date) VALUES ( ?, ?, ?, ?, ?)";
            try (
                    PreparedStatement preparedStatement = conn.prepareStatement(sql)
            ) {
                // Set values for parameters in the SQL query

                preparedStatement.setString(1, name);
                preparedStatement.setString(2, number);
                preparedStatement.setString(3, email);
                preparedStatement.setString(4, type);
                preparedStatement.setString(5, date);

                // Execute the insert statement
                int rowsAffected = preparedStatement.executeUpdate();

                // Check if the insertion was successful
                if (rowsAffected > 0) {
                    System.out.println("Data inserted successfully!");
                } else {
                    System.out.println("Failed to insert data.");
                }
                addName.setText("");
                addNumber.setText("");
                addEmail.setText("");
                addType.setText("");

            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("connected");
        } else {
            System.out.println("error");
        }
    }


    ArrayList<String> details = new ArrayList<String>();

    public void onReadData() throws SQLException {
       

        Connection conn = DriverManager.getConnection(jdbcURL, username, password);
        if (conn != null) {
            String sql2 = "SELECT * FROM datasheet";
            try (
                    PreparedStatement preparedStatement = conn.prepareStatement(sql2);
                    // Execute the query and get the result set
                    ResultSet resultSet = preparedStatement.executeQuery()
            ) {
                // Iterate through the result set and print data
                while (resultSet.next()) {
                    details.add(resultSet.getString("Name"));
                    details.add(resultSet.getString("Email"));
                    details.add(resultSet.getString("Number"));
                    details.add(resultSet.getString("Date"));
                    details.add(resultSet.getString("Type"));
                }

                for (String detail : details) {
                    System.out.println(detail);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //----------------------------------------------------------------------------------------------
    ArrayList<String> idNumbers = new ArrayList<String>();

    public void cancel(ActionEvent event) throws SQLException {
        

        Connection conn = DriverManager.getConnection(jdbcURL, username, password);
        if (conn != null) {
            String sql2 = "SELECT ID FROM datasheet";
            try (
                    PreparedStatement preparedStatement = conn.prepareStatement(sql2);
                    ResultSet resultSet = preparedStatement.executeQuery()
            ) {

                while (resultSet.next()) {
                    idNumbers.add(resultSet.getString("ID"));
                                    }
                for (String idNumber : idNumbers) {
                    System.out.println(idNumber);
                }
                String cancelingID = cancel.getText();
                for (int i = 0; i < idNumbers.size(); i++) {
                    if (idNumbers.get(i).equals(cancelingID)) {
                        int rowIdToRemove = Integer.parseInt(cancelingID);
                        String deleteQuery = "DELETE FROM datasheet WHERE id = ?";

                        try (
                                PreparedStatement preparedStatementDelete = conn.prepareStatement(deleteQuery)
                        ) {
                            preparedStatementDelete.setInt(1, rowIdToRemove);
                            int rowsAffected = preparedStatementDelete.executeUpdate();

                            if (rowsAffected > 0) {
                                System.out.println("Row removed successfully!");
                                idNumbers.clear();
                                cancel.setText("");
                            } else {
                                System.out.println("No rows found with the given ID.");
                            }

                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //----------------------------------------------------------------------------------------------
    public void Reschedule(ActionEvent event) throws SQLException {
        
        Connection conn = DriverManager.getConnection(jdbcURL, username, password);
        if (conn != null) {
            String num = reNum.getText();
            String date = getSelectedDateAsString();
            String type = addType.getText();
            String updateQuery = "UPDATE datasheet SET  Type=?, Date=? WHERE ID=?";

            try (
                    PreparedStatement preparedStatement = conn.prepareStatement(updateQuery)

            ) {
                preparedStatement.setString(1, type);
                preparedStatement.setString(2, date);
                preparedStatement.setString(3, num);
                reNum.setText("");
                addType.setText("");

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Data updated successfully!");
                } else {
                    System.out.println("Failed to update data.");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


//----------------------------------------------------------------------------------------------


   public void search(ActionEvent event) throws SQLException {
        onReadData();
        for(int i=0;i<details.size();i=i+5){
            colID.appendText(details.get(i)+"\n");
            colName.appendText(details.get(i+1)+"\n");
            colContact.appendText(details.get(i+2)+"\n");
            colDate.appendText(details.get(i+3)+"\n");
            colType.appendText(details.get(i+4)+"\n");
        }
        details.clear();

   }
}