package net.john_just.helper;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.john_just.helper.enums.*;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1920, 1080);
        stage.setTitle("Helper");
        stage.setScene(scene);
        stage.show();

        ComponentName name = new ComponentName("ПугВ");
        Manufacturer manufacturer = new Manufacturer("Конкорд");

        ComponentName abbName = new ComponentName("Автоматический выключатель");
        Manufacturer abbManufacturer = new Manufacturer("ABB");
        ModelName abb_s203 = new ModelName("S203");

        Wire wire = new Wire(name, manufacturer, 2.45, 10, StockStatus.AVAILABLE, WireColor.RED, CrossSection.MM1_5);
        CircuitBreaker abb = new CircuitBreaker(abbName, abbManufacturer, abb_s203, 649, 1, StockStatus.IN_DELIVERY, RatedCurrent.A16, BreakerType.B, PoleCount.P1);
        CircuitBreaker abb_2 = new CircuitBreaker(abbName, abbManufacturer, abb_s203, 649, 2, StockStatus.AVAILABLE, RatedCurrent.A63, BreakerType.C, PoleCount.P3);
        System.out.println(wire.getInfo());
        System.out.println(abb.getInfo());
        System.out.println(abb_2.getInfo());
    }

    public static void main(String[] args) {
        launch();

    }
}