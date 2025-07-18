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
import net.john_just.helper.enums.StockStatus;
import net.john_just.helper.enums.WireColor;

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

    @FXML
    public void initialize() {
        nameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName().toString()));
        manufacturerColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getManufacturer().getName()));
        colorColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getColor().toString()));
        sectionColumn.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getCrossSection().getValue()).asObject());
        priceColumn.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getPrice()).asObject());
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

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Добавить провод");
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.setScene(new Scene(root));
            dialogStage.showAndWait();

            AddWireDialogController controller = loader.getController();
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

}
