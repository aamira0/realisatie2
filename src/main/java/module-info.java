module com.example.realisatiebp2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.realisatiebp2 to javafx.fxml;
    exports com.example.realisatiebp2;
    exports com.example.realisatiebp2.classes;
}