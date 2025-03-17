module com.oblativeshielding {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires javafx.base;

    opens com.oblativeshielding.pizzanburgers to javafx.fxml;
    opens com.oblativeshielding.pizzanburgers.controllers to javafx.fxml;
    exports com.oblativeshielding.pizzanburgers;
}
