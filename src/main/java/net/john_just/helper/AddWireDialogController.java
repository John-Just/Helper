package net.john_just.helper;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import net.john_just.helper.enums.*;

public class AddWireDialogController {
    @FXML private ComboBox<String> nameBox;
    @FXML private ComboBox<String> manufacturerBox;
    @FXML private TextField priceField;
    @FXML private TextField lengthField;
    @FXML private ComboBox<StockStatus> statusBox;
    @FXML private ComboBox<WireColor> colorBox;
    @FXML private ComboBox<CrossSection> sectionBox;
    @FXML private TextField descriptionField;

    private Wire resultWire = null;
    private ObservableList<String> componentNames;
    private ObservableList<String> manufacturers;

    public void setComponentNames(ObservableList<String> componentNames) {
        this.componentNames = componentNames;
        nameBox.setItems(componentNames);
    }

    public void setManufacturers(ObservableList<String> manufacturers) {
        this.manufacturers = manufacturers;
        manufacturerBox.setItems(manufacturers);
    }

    @FXML
    public void initialize() {
        nameBox.setEditable(true);
        manufacturerBox.setEditable(true);


        statusBox.getItems().setAll(StockStatus.values());
        colorBox.getItems().setAll(WireColor.values());
        sectionBox.getItems().setAll(CrossSection.values());
    }

    @FXML
    private void onAdd() {
        try {
            ComponentName name = new ComponentName(nameBox.getEditor().getText());
            Manufacturer manufacturer = new Manufacturer(manufacturerBox.getEditor().getText());
            Double price = Double.parseDouble(priceField.getText().trim());
            try {
                resultWire.setPrice(price);
            } catch (NumberFormatException e) {
                resultWire.setPrice(0.0); // Значение по умолчанию
            }
            int quantity = Integer.parseInt(lengthField.getText());

            StockStatus status = statusBox.getValue();
            WireColor color = colorBox.getValue();
            CrossSection section = sectionBox.getValue();
            sectionBox.toString();
            String description = descriptionField.getText();

            resultWire = new Wire(name, manufacturer, price, quantity, status, color, section);
            resultWire.setDescription(description);

            String nameText = nameBox.getEditor().getText();
            if (!componentNames.contains(nameText)) {
                componentNames.add(nameText);
            }

            String manufacturerText = manufacturerBox.getEditor().getText();
            if (!manufacturers.contains(manufacturerText)) {
                manufacturers.add(manufacturerText);
            }

            ((Stage) nameBox.getScene().getWindow()).close();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Ошибка при вводе данных: " + e.getMessage()).showAndWait();
        }
    }

    @FXML
    private void onCancel() {
        ((Stage) nameBox.getScene().getWindow()).close();
    }

    public Wire getResultWire() {
        return resultWire;
    }
}
