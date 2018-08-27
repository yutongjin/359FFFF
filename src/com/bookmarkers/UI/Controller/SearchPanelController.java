package com.bookmarkers.UI.Controller;

import com.bookmarkers.UI.Stage.StageManager;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
//5 搜索入口界面
public class SearchPanelController implements ControlledStage{
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
    private JFXRadioButton rbtnID;

    @FXML
    private JFXTextField textfieldInpput;

    @FXML
    private JFXRadioButton rbtnName;

    @FXML
    private JFXRadioButton rbtnKeyword;

    @FXML
    private JFXRadioButton rbtnAuthor;

    @FXML
    void onRbtnNameClicked(ActionEvent event) {

    }

    @FXML
    void onRbtnAuthorClicked(ActionEvent event) {

    }

    @FXML
    void onRbtnKeywordClicked(ActionEvent event) {

    }

    @FXML
    void onRbtnIDClicked(ActionEvent event) {

    }

    @FXML
    void onTextfieldInpputClicked(ActionEvent event) {

    }

    @FXML
    void onBtnSearchClicked(ActionEvent event) {
        stageManager.setStage(stageManager.getUser(),"SearchResult","SearchPanel");
    }

    @FXML
    void onBtnBackClicked(ActionEvent event) {
        if(stageManager.getUser().isAdmin())
            stageManager.setStage(stageManager.getUser(),"AdminPanel","SearchPanel");
        else {
            stageManager.setStage(stageManager.getUser(),"UserPanel","SearchPanel");
        }
    }

}
