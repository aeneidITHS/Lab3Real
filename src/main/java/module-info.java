module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;


    opens com.example.javafxttlabthree to javafx.fxml;
    exports com.example.javafxttlabthree;
    exports com.example.javafxttlabthree.Controller;
    opens com.example.javafxttlabthree.Controller to javafx.fxml;
    exports com.example.javafxttlabthree.Model;
    opens com.example.javafxttlabthree.Model to javafx.fxml;
}