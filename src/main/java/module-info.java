module org.dpassignments.fuelconsumption {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.dpassignments.fuelconsumption to javafx.fxml;
    exports org.dpassignments.fuelconsumption;
}