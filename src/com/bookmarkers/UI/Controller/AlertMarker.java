package com.bookmarkers.UI.Controller;


import javafx.scene.control.Alert;

public class AlertMarker {

    private Alert errorAlert;

    private Alert infoAlert;

    private AlertMarker() {
        errorAlert = new Alert(Alert.AlertType.ERROR);
        infoAlert = new Alert(Alert.AlertType.INFORMATION);
    }

    private static final AlertMarker FACTORY = new AlertMarker();

    public static AlertMarker getInstance() {
        return FACTORY;
    }

    public void showErrorMessage(String title, String content) {
        errorAlert.setTitle("Error");
        errorAlert.setHeaderText(title);
        errorAlert.setContentText(content);
        errorAlert.showAndWait();
    }

    public void showInfoMessage(String title, String content) {

        infoAlert.setTitle("Message");
        infoAlert.setHeaderText(title);
        infoAlert.setContentText(content);
        infoAlert.showAndWait();
    }

}


