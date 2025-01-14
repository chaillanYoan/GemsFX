package com.dlsc.gemsfx.demo;

import com.dlsc.gemsfx.YearMonthPicker;
import fr.brouillard.oss.cssfx.CSSFX;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class YearMonthPickerApp extends Application {

    @Override
    public void start(Stage stage) {
        YearMonthPicker yearMonthPicker = new YearMonthPicker();

        Label valueLabel = new Label();
        valueLabel.textProperty().bind(Bindings.createStringBinding(() -> yearMonthPicker.getConverter().toString(yearMonthPicker.getValue()), yearMonthPicker.valueProperty()));

        CheckBox editable = new CheckBox("Editable");
        editable.selectedProperty().bindBidirectional(yearMonthPicker.editableProperty());

        CheckBox disable = new CheckBox("Disable");
        disable.selectedProperty().bindBidirectional(yearMonthPicker.disableProperty());

        VBox vBox = new VBox(10, yearMonthPicker, valueLabel, editable, disable);

        vBox.setPadding(new Insets(20));
        vBox.setAlignment(Pos.TOP_LEFT);

        Scene scene = new Scene(vBox);
        CSSFX.start();

        stage.setTitle("YearMonthPicker");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.centerOnScreen();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
