package com.bookmarkers.UI.Controller;


import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import com.bookmarkers.UI.Stage.*;
/**
 * @Author : Yutong Jin
 * @date : 8/25/18
 * @Description :
 */

public class   ControllerTest {

    StageManager stageManager;
    private static final String ASS_WE_CAN = "Ass we can";
    private static final String BOY_NEXT_DOOR = "Boy next door";

    @FXML
    private JFXButton button;

    @FXML
    void onButonCLick(ActionEvent event) {
        if (button.getText().equals(ASS_WE_CAN)) button.setText(BOY_NEXT_DOOR);
        else button.setText(ASS_WE_CAN);
    }
    @FXML
    public void login(ActionEvent actionEvent) {


    }

}

