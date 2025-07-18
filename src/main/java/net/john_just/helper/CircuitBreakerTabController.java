package net.john_just.helper;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;

public class CircuitBreakerTabController {
    @FXML private TableView<CircuitBreaker> circuitBreakerTable;

    private ObservableList<CircuitBreaker> circuitBreakers = FXCollections.observableArrayList();

    @FXML
    public void initialize() {



        circuitBreakerTable.setItems(circuitBreakers);
    }

    @FXML
    private void onAddModule(ActionEvent event) {
        // Пример обработки кнопки "Добавить модуль"
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Добавление модульного оборудования ещё не реализовано.", ButtonType.OK);
        alert.setHeaderText(null);
        alert.setTitle("Информация");
        alert.showAndWait();
    }

}