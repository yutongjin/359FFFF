package com.bookmarkers.UI.Controller;

import com.bookmarkers.UI.Stage.StageManager;
import com.jfoenix.controls.JFXButton;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.beans.binding.Bindings;


import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

// 3 管理员登录成功页面
public class AdminPanelController implements ControlledStage, Observer, Initializable {
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

//    void initUI(){
//        labelUsername.textProperty().bind(stageManager.getUserModel().SpName);
//    }

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

//        this.stageManager = new StageManager();
//
        System.out.println("adminPanel stage initialized");
//        System.out.println("Admin Panel, admin name is "+ stageManager.getUserModel().SpName.toString());
//        labelUsername.textProperty().bind(stageManager.getUserModel().SpName);

//        System.out.println("Admin Panel, admin name is "+ stageManager.getUserModel().SpName.toString());
//        labelUsername.textProperty().bind(stageManager.getUserModel().SpName);
//        stageManager.getUserModel().SpName.addListener(new ChangeListener(){
//            @Override public void changed(ObservableValue o, Object oldValue, Object newValue){
////                labelUsername.setText(newValue);
//            }
//        });

//        stageManager.getUserModel().SpName.addListener(new ChangeListener<String>(){
//            @Override public void changed(ObservableValue o,Object oldVal,
//                                          Object newVal){
//                System.out.println("name has changed!");
//            }
//        });
    }
}

