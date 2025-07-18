package net.john_just.helper;

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

    @FXML
    public void initialize() {
        nameBox.setEditable(true);
        manufacturerBox.setEditable(true);

        // Можешь заполнить заранее если хочешь
        //nameBox.getItems().addAll("ПУГВ", "ВВГ", "Кабель 3x1.5");
        //manufacturerBox.getItems().addAll("КЭАЗ", "Электрокабель", "IEK");

        statusBox.getItems().setAll(StockStatus.values());
        colorBox.getItems().setAll(WireColor.values());
        sectionBox.getItems().setAll(CrossSection.values());
    }

    @FXML
    private void onAdd() {
        try {
            ComponentName name = new ComponentName(nameBox.getEditor().getText());
            Manufacturer manufacturer = new Manufacturer(manufacturerBox.getEditor().getText());
            double price = Double.parseDouble(priceField.getText());
            int quantity = Integer.parseInt(lengthField.getText());

            StockStatus status = statusBox.getValue();
            WireColor color = colorBox.getValue();
            CrossSection section = sectionBox.getValue();
            String description = descriptionField.getText();

            resultWire = new Wire(name, manufacturer, price, quantity, status, color, section);
            resultWire.setDescription(description);

            nameBox.getItems().addAll(nameBox.getValue());
            manufacturerBox.getItems().addAll(manufacturerBox.getValue());

            new Alert(Alert.AlertType.INFORMATION, "Провод успешно добавлен").show();

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
