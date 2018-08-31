package com.bookmarkers.UI.Controller;


import com.bookmarkers.UI.Stage.StageManager;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
//7 管理员查看借书比
public class CheckedOutRatioPanelController implements StageController {
    StageManager stageManager;
    @Override
    public void setStageController(StageManager stageManager) {
        this.stageManager = stageManager;
    }

    @Override
    public void initUI() {

        labelNoOfBooks.textProperty().bind(stageManager.getUserModel().bookedBookProperty());
//        labelNoOfMag.textProperty().bind(stageManager.getUserModel().bookedMagProperty());
        labelNoOfMag.setText("25.00");
        labelNoOfVideo.textProperty().bind(stageManager.getUserModel().bookedVideoProperty());
    }

    @FXML
    private JFXButton btnBack;

    @FXML
    private Label labelNoOfBooks;

    @FXML
    private Label labelNoOfMag;

    @FXML
    private Label labelNoOfVideo;

    @FXML
    void onBtnBackClicked(ActionEvent event) {
        stageManager.setStage(stageManager.getUser(),"AdminPanel","CheckedOutRatioPanel");
    }

}

