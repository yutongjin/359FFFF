package com.bookmarkers.UI.Controller;


import javafx.scene.control.Alert;

public class AlertMarker {

    private static Alert alert;

    public static void showErrorMessage(String title, String content) {
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

}


