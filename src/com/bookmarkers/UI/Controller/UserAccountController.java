package com.bookmarkers.UI.Controller;

import com.bookmarkers.DB.Service.Impl.UserServiceImpl;
import com.bookmarkers.DB.Service.UserService;
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
import java.util.List;
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

    }
    @FXML
    void Show(){

        JFXTreeTableColumn<Item,String> Id = new JFXTreeTableColumn<>("Id");
        JFXTreeTableColumn<Item,String> Name = new JFXTreeTableColumn<>("Name");
        JFXTreeTableColumn<Item,String> Author = new JFXTreeTableColumn<>("Author");
        JFXTreeTableColumn<Item,String> Type = new JFXTreeTableColumn<>("Type");
        JFXTreeTableColumn<Item,String>  DetailedType= new JFXTreeTableColumn<>("Specific");
        JFXTreeTableColumn<Item,String> ReturnDate = new JFXTreeTableColumn<>("Return Date");
        JFXTreeTableColumn<Item,String> Status = new JFXTreeTableColumn<>("Status");
        //JFXTreeTableColumn<Item,String> Booker = new JFXTreeTableColumn<>("Name");

//        Id.setPrefWidth(40);
//        Name.setPrefWidth(100);
//        Author.setPrefWidth(70);
//        Type.setPrefWidth(40);
//        DetailedType.setPrefWidth(70);
//        ReturnDate.setPrefWidth(70);
//        Status.setPrefWidth(40);

        Id.setPrefWidth(80);
        Name.setPrefWidth(140);
        Author.setPrefWidth(110);
        Type.setPrefWidth(80);
        DetailedType.setPrefWidth(80);
        ReturnDate.setPrefWidth(80);
        Status.setPrefWidth(80);


        Id.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Item, String> param) {
                return param.getValue().getValue().spIdProperty();
            }
        });

        Name.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Item, String> param) {
                return param.getValue().getValue().spNameProperty();            }
        });

        Author.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Item, String> param) {
                return param.getValue().getValue().spAuthorProperty();            }
        });

        Type.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Item, String> param) {
                return param.getValue().getValue().spTypeProperty();            }
        });

        DetailedType.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Item, String> param) {
                return param.getValue().getValue().spDetailedTypeProperty();            }
        });

        ReturnDate.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Item, String> param) {
                return param.getValue().getValue().spReturnDateProperty();  }
        });

        Status.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Item, String> param) {
                return param.getValue().getValue().spActiveProperty();            }
        });

        ObservableList<Item> items = FXCollections.observableArrayList();

        String id  = stageManager.getUser().getId();
        System.out.println(stageManager.getUser().getName() + "name");
        List<Item> list = new UserServiceImpl().getCheckOutInfo(id);
        for(Item item : list) {
            items.add(new Item(item.getId(),item.getName(),item.getAuthor(),item.getType(),item.getDetailedType(),item.getReturnDate()));
            System.out.println(item.getId());
        }
        final TreeItem<Item> root = new RecursiveTreeItem<Item>(items,RecursiveTreeObject::getChildren);
        tableCurrentItems.getColumns().setAll(Id,Name,Author,Type,DetailedType,ReturnDate);
        tableCurrentItems.setRoot(root);
        tableCurrentItems.setShowRoot(false);
    }
}

