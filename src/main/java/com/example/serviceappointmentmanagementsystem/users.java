package com.example.serviceappointmentmanagementsystem;

public class users {
    int ID;
    String username, number,email, type, date;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public users(int ID, String username, String number, String email, String type, String date) {
        this.ID = ID;
        this.username = username;
        this.number = number;
        this.email = email;
        this.type = type;
        this.date = date;
    }
}
