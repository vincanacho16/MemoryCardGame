module com.example.memorycardgame {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.memorycardgame to javafx.fxml;
    exports com.example.memorycardgame;
}