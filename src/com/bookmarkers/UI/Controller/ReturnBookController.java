package com.bookmarkers.UI.Controller;

import com.bookmarkers.DB.Factory.DAOFactory.ServiceFactory;
import com.bookmarkers.UI.Stage.StageManager;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.SQLException;

//9 用户 还书界面
public class ReturnBookController  implements ControlledStage{
    StageManager stageManager;
    @Override
    public void setStageController(StageManager stageManager) {
        this.stageManager = stageManager;
    }
    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnReturnItem;

    @FXML
    private JFXTextField textFieldReturnItemID;

    @FXML
    void onBtnReturnItemClicked(ActionEvent event) throws SQLException {

        System.out.println("这里！！！！"+textFieldReturnItemID.getText());

        boolean result = ServiceFactory.getUserServiceInstance().returnItem(stageManager.getUser().getId(),textFieldReturnItemID.getText());
        if(result){
            System.out.println("Return successfully!");
        }
        else {
            System.out.println("Return failed");
        }
    }

    @FXML
    void onBtnBackClicked(ActionEvent event) {
        stageManager.setStage(stageManager.getUser(),"UserPanel","ReturnBook");

    }

    @Override
    public void initUI() {

    }

}
