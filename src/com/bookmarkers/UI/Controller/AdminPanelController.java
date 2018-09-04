package com.bookmarkers.UI.Controller;

import com.bookmarkers.UI.Stage.StageManager;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;


import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

// 3 admin login
public class AdminPanelController implements StageController, Observer, Initializable {
    StageManager stageManager;


    @Override
    public void setStageController(StageManager stageManager) {
        this.stageManager = stageManager;
    }
    @FXML
    private JFXButton btnSearch;

    @FXML
    private Label labelWelcome;

    @FXML
    private JFXButton btnLogout;

    @FXML
    private Label labelUsername;

    @FXML
    private JFXButton btnCheckRatio;

    @FXML
    private JFXButton btnCheckInventory;




    public AdminPanelController() {

    }

    @Override
    public void initUI() {
        labelUsername.textProperty().bind(stageManager.getUserModel().SpName);
    }

    @FXML
    void onBtnCheckInventoryClicked(ActionEvent event) {
        stageManager.setStage(stageManager.getUser(),"InventoryPanel","AdminPanel");
    }

    @FXML
    void onBtnSearchClicked(ActionEvent event) {
        stageManager.setStage(stageManager.getUser(),"SearchPanel","AdminPanel");
    }

    @FXML
    void onBtnCheckRatioClicked(ActionEvent event) {
        stageManager.setStage(stageManager.getUser(),"CheckedOutRatioPanel","AdminPanel");
    }

    @FXML
    void onBtnLogoutClicked(ActionEvent event) {

        stageManager.getUser().logout();
        stageManager.setStage(stageManager.getUser(),"Login","AdminPanel");
    }

    @Override
    public void update(Observable o, Object arg) {
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("adminPanel stage initialized");
    }
}

