package org.dpassignments.fuelconsumption;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloController {
    @FXML
    private Label lblDistance;
    @FXML
    private Label lblFuel;
    @FXML
    private Label lblResult;
    @FXML
    private TextField txtDistance;
    @FXML
    private TextField txtFuel;
    @FXML
    private Button btnCalculate;

    private ResourceBundle resourceBundle;
    private Double lastConsumption;

    @FXML
    public void initialize() {
        setLanguage(new Locale("en", "US"));
    }

    private void setLanguage(Locale locale) {
        try {
            resourceBundle = ResourceBundle.getBundle("messages", locale);
            lblDistance.setText(resourceBundle.getString("distance.label"));
            lblFuel.setText(resourceBundle.getString("fuel.label"));
            lblResult.setText(resourceBundle.getString("result.label"));
            btnCalculate.setText(resourceBundle.getString("calculate.button"));
            if (lastConsumption != null) {
                String consumptionStr = resourceBundle.getString("result.label");
                lblResult.setText(MessageFormat.format(consumptionStr, String.format("%.2f", lastConsumption)));
            } else {
                lblResult.setText("");
            }
        } catch (Exception e) {
            lblResult.setText(resourceBundle.getString("invalid.input"));
        }
    }

    @FXML
    public void onCalculateButtonClick(ActionEvent event) {
        try {
            double distance = Double.parseDouble(txtDistance.getText());
            double fuel = Double.parseDouble(txtFuel.getText());
            double consumption = (fuel / distance) * 100;
            String consumptionStr = resourceBundle.getString("result.label");
            lastConsumption = consumption;
            lblResult.setText(MessageFormat.format(consumptionStr, String.format("%.2f", lastConsumption)));
        } catch (NumberFormatException e) {
            lblResult.setText(resourceBundle.getString("invalid.input"));
        }
    }

    @FXML
    public void onLanguageSelectEN(ActionEvent event) {
        setLanguage(new Locale("en", "US"));
    }

    @FXML
    public void onLanguageSelectFR(ActionEvent event) {
        setLanguage(new Locale("fr", "FR"));
    }

    @FXML
    public void onLanguageSelectJP(ActionEvent event) {
        setLanguage(new Locale("ja", "JP"));
    }

    @FXML
    public void onLanguageSelectIR(ActionEvent event) {
        setLanguage(new Locale("fa", "IR"));
    }
}