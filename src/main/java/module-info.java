module com.example.ejercicioexamen2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.xml.bind;
    requires java.xml;

    exports com.example.ejercicioexamen2;
    opens com.example.ejercicioexamen2 to javafx.fxml, com.google.gson, java.xml, java.xml.bind;
    exports com.example.ejercicioexamen2.controller;
    opens com.example.ejercicioexamen2.controller to javafx.fxml, com.google.gson, java.xml, java.xml.bind;
    exports com.example.ejercicioexamen2.model;
    opens com.example.ejercicioexamen2.model to javafx.fxml, com.google.gson, java.xml, java.xml.bind;

}