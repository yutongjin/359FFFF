package com.bookmarkers.UI.Controller;

import com.bookmarkers.UI.Stage.StageManager;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Observable;
import java.util.Observer;

// 3 管理员登录成功页面
public class AdminPanelController implements ControlledStage, Observer {
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

    @FXML
    void Show() {

    }

    @Override
    public void update(Observable o, Object arg) {
        
    }
}

