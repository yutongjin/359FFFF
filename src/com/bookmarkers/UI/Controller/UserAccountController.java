package com.bookmarkers.UI.Controller;

import com.bookmarkers.Data.Item.Item;
import com.bookmarkers.UI.Stage.StageManager;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.util.Callback;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

//4 用户账号详情页面
public class UserAccountController implements Initializable  , ControlledStage {
    StageManager stageManager;
    @Override
    public void setStageController(StageManager stageManager) {
        this.stageManager = stageManager;
    }
    @FXML
    private JFXButton btnBack;

    @FXML
    private Label labelUserID;

    @FXML
    private Label labelAccountStatus;

    @FXML
    private Label labelVideoBalance;

    @FXML
    private JFXTreeTableView<Item> tableCurrentItems;


    @FXML
    private Label labelMagBalance;

    @FXML
    private Label labelBookBalance;

    @FXML
    void onBtnBackClicked(ActionEvent event) {
        stageManager.setStage(stageManager.getUser(),"UserPanel","UserAccount");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        JFXTreeTableColumn<Item,String> Id = new JFXTreeTableColumn<>("Id");
        Id.setPrefWidth(150);
        Id.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Item, String> param) {
                return param.getValue().getValue().spIdProperty();
            }
        });

        ObservableList<Item> items = FXCollections.observableArrayList();
        items.add(new Item("001"));
        final TreeItem<Item> root = new RecursiveTreeItem<Item>(items,RecursiveTreeObject::getChildren);
        tableCurrentItems.getColumns().setAll(Id);
        tableCurrentItems.setRoot(root);
        tableCurrentItems.setShowRoot(false);
    }
}

