module net.john_just.helper {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens net.john_just.helper to javafx.fxml;
    exports net.john_just.helper;
    exports net.john_just.helper.enums;
    opens net.john_just.helper.enums to javafx.fxml;
}