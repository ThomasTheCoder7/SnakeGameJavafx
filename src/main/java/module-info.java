module com.example.javafxproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.javafxproject to javafx.fxml;
    exports com.example.javafxproject;
}