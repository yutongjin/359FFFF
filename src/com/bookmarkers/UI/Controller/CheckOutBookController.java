package com.bookmarkers.UI.Controller;



import com.bookmarkers.DB.Factory.DAOFactory.ServiceFactory;
import com.bookmarkers.UI.Model.UserModel;
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

            StageManager.showInfoMessage("Check out  Successfully","Congratulations!");
    }
        else             AlertMarker.showErrorMessage("Check out failed","Please check !");


        stageManager.setUserModel(  new UserModel(stageManager.getUser().getId(),stageManager.getUser().getName(),stageManager.getUser().getEmail(),stageManager.getUser().getPhone(),stageManager.getUser().isAdmin(),
                ServiceFactory.getUserServiceInstance().getBookBalance(stageManager.getUser().getId()),
                ServiceFactory.getUserServiceInstance().getMagazineBalance(stageManager.getUser().getId()),
                ServiceFactory.getUserServiceInstance().getVideoBalance(stageManager.getUser().getId()),
                0,"000","000","000","000","000"));


        //在这里让stageManager重新调用一下所有controller的initUI方法
        stageManager.refreshUI();
    }

    @FXML
    void onBtnBackClicked(ActionEvent event) {
        stageManager.setStage(stageManager.getUser(),"UserPanel","CheckOutBook");
    }

    @Override
    public void initUI() {

    }

}

