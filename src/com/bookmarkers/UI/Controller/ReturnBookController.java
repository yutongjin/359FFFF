package com.bookmarkers.UI.Controller;

import com.bookmarkers.DB.Factory.DAOFactory.ServiceFactory;
import com.bookmarkers.UI.Model.UserModel;
import com.bookmarkers.UI.Stage.StageManager;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.sql.SQLException;

//9 mem return
public class ReturnBookController  implements StageController {
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
            AlertMarker.getInstance().showInfoMessage("Return Successfully","Congratulations");
        }
        else {
            AlertMarker.getInstance().showErrorMessage("Return failed","Please check !");
        }

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
        stageManager.setStage(stageManager.getUser(),"UserPanel","ReturnBook");

    }

    @Override
    public void initUI() {

    }

}
