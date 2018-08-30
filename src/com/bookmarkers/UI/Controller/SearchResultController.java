package com.bookmarkers.UI.Controller;

import com.bookmarkers.UI.Stage.StageManager;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
//10 搜索结果 设计改为用户和管理员共用同一个搜索页面
public class SearchResultController implements StageController {
    StageManager stageManager;
    @Override
    public void setStageController(StageManager stageManager) {
        this.stageManager = stageManager;
    }
    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXTreeTableView<?> tableResult;

    @FXML
    private Label labelKeyword;

    @FXML
    private JFXButton btnNewSearch;

    @FXML
    void onBtnNewSearchClicked(ActionEvent event) {

    }

    @FXML
    void onBtnBackClicked(ActionEvent event) {

    }

    @Override
    public void initUI() {

    }

}

