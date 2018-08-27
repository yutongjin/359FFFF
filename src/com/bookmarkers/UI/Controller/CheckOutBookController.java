package com.bookmarkers.UI.Controller;



import com.bookmarkers.UI.Stage.StageManager;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
//11 借书界面
public class CheckOutBookController  implements ControlledStage{
    StageManager stageManager;
    @Override
    public void setStageController(StageManager stageManager) {
        this.stageManager = stageManager;
    }
    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnCheckOut;

    @FXML
    private JFXTextField textfieldItemID;

    @FXML
    void onBtnCheckOutClicked(ActionEvent event) {

    }

    @FXML
    void onBtnBackClicked(ActionEvent event) {
        stageManager.setStage(stageManager.getUser(),"UserPanel","CheckOutBook");
    }

}

