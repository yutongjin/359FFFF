package com.bookmarkers.UI.Controller;



import com.bookmarkers.DB.Factory.DAOFactory.ServiceFactory;
import com.bookmarkers.UI.Stage.StageManager;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.sql.SQLException;

//11 借书界面
public class CheckOutBookController  implements StageController {
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
    void onBtnCheckOutClicked(ActionEvent event) throws SQLException {
        System.out.println("这里！！！！"+textfieldItemID.getText());
        boolean result = ServiceFactory.getUserServiceInstance().checkOutItem(stageManager.getUser().getId(),textfieldItemID.getText());
        if(result){
            AlertMarker.showErrorMessage("Check out  Successfully","Please check username or password");
        }
        else             AlertMarker.showErrorMessage("Check out failed","Please check username or password");

    }

    @FXML
    void onBtnBackClicked(ActionEvent event) {
        stageManager.setStage(stageManager.getUser(),"UserPanel","CheckOutBook");
    }

    @Override
    public void initUI() {

    }

}

