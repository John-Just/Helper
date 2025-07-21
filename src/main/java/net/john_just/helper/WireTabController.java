package net.john_just.helper;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import net.john_just.helper.enums.CrossSection;

import java.io.IOException;

public class WireTabController {
    @FXML private TableView<Wire> wireTable;
    @FXML private TableColumn<Wire, String> nameColumn;
    @FXML private TableColumn<Wire, String> manufacturerColumn;
    @FXML private TableColumn<Wire, String> colorColumn;
    @FXML private TableColumn<Wire, Double> sectionColumn;
    @FXML private TableColumn<Wire, Double> priceColumn;
    @FXML private TableColumn<Wire, String> statusColumn;
    @FXML private TableColumn<Wire, Integer> lengthColumn;
    @FXML private TableColumn<Wire, String> descriptionColumn;


    private ObservableList<Wire> wires = FXCollections.observableArrayList();
    private ObservableList<String> componentNames = FXCollections.observableArrayList();
    private ObservableList<String> manufacturers = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        nameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName().toString()));
        manufacturerColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getManufacturer().getName()));
        colorColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getColor().toString()));
        sectionColumn.setCellValueFactory(data -> {
            CrossSection section = data.getValue().getCrossSection();
            return new SimpleDoubleProperty(section != null ? section.getValue(): 0.0).asObject();
        });
        priceColumn.setCellValueFactory(data -> {
            return new SimpleDoubleProperty(data.getValue() != null ? data.getValue().getPrice() : 0).asObject();
        });
        statusColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getStockStatus().toString()));
        lengthColumn.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getQuantity()).asObject());
        descriptionColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDescription()));

        wireTable.setItems(wires);
    }

    @FXML
    private void onAddWire() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddWireDialog.fxml"));
            Parent root = loader.load();

            AddWireDialogController controller = loader.getController();

            if (componentNames == null) componentNames = FXCollections.observableArrayList();
            if (manufacturers == null) manufacturers = FXCollections.observableArrayList();

            // Передача списков
            controller.setComponentNames(componentNames);
            controller.setManufacturers(manufacturers);

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Добавить провод");
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.setScene(new Scene(root));
            dialogStage.showAndWait();

            Wire newWire = controller.getResultWire();

            if (newWire != null) {
                wires.add(newWire);
            }

        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Не удалось открыть окно добавления провода.");
            alert.showAndWait();
        }
    }
    @FXML
    public void onDeleteWire() {
        Wire selectedWire = wireTable.getSelectionModel().getSelectedItem();
        if (selectedWire != null) {
            wires.remove(selectedWire);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Удаление провода");
            alert.setHeaderText(null);
            alert.setContentText("Сначала выберите провод для удаления.");
            alert.showAndWait();
        }
    }


}
