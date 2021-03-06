package com.bookmarkers.UI.Controller;

import com.bookmarkers.UI.Stage.StageManager;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
//6 admin find total number
public class InventoryPanelController implements StageController {
    StageManager stageManager;
    @Override
    public void setStageController(StageManager stageManager) {
        this.stageManager = stageManager;
    }
    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private Label labelNoOfBooks;

    @FXML
    private JFXButton btnCheckRatio;

    @FXML
    private Label labelNoOfMag;

    @FXML
    private Label labelNoOfVideo;

    @FXML
    void onBtnBackClicked(ActionEvent event) {
        stageManager.setStage(stageManager.getUser(),"AdminPanel","InventoryPanel");
    }

    @FXML
    void onBtnCheckRatioClicked(ActionEvent event) {

    }

    @FXML
    void onBtnSearchClicked(ActionEvent event) {
        stageManager.setStage(stageManager.getUser(),"SearchPanel","InventoryPanel");

    }

    @Override
    public void initUI() {

        labelNoOfBooks.textProperty().bind(stageManager.getUserModel().allBookProperty());
        labelNoOfMag.textProperty().bind(stageManager.getUserModel().allMagProperty());
        labelNoOfVideo.textProperty().bind(stageManager.getUserModel().allVideoProperty());
    }
}

