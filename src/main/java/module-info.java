module com.example.serviceappointmentmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires mysql.connector.j;

    opens com.example.serviceappointmentmanagementsystem to javafx.fxml;
    exports com.example.serviceappointmentmanagementsystem;
}