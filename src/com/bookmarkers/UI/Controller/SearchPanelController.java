package com.bookmarkers.UI.Controller;

import com.bookmarkers.DB.Service.Impl.SearchStrategy.SearchByAuthor;
import com.bookmarkers.DB.Service.Impl.SearchStrategy.SearchById;
import com.bookmarkers.DB.Service.Impl.SearchStrategy.SearchByKeywords;
import com.bookmarkers.DB.Service.Impl.SearchStrategy.SearchByName;
import com.bookmarkers.DB.Service.Impl.UserServiceImpl;
import com.bookmarkers.DB.Service.SearchService;
import com.bookmarkers.Data.Item.Item;
import com.bookmarkers.UI.Stage.StageManager;
import com.jfoenix.controls.*;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.util.Callback;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;

//5 搜索入口界面
public class SearchPanelController implements ControlledStage,Initializable {
    StageManager stageManager;
    ToggleGroup group;
    SearchService searchService;
    List<Item> list ;
    @Override
    public void setStageController(StageManager stageManager) {
        this.stageManager = stageManager;
    }
    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXTextField textfieldInpput;

    @FXML
    private JFXTreeTableView<Item> searchResult;


    @FXML
    private JFXRadioButton rbtnID;

    @FXML
    private JFXRadioButton rbtnName;

    @FXML
    private JFXRadioButton rbtnKeyword;

    @FXML
    private JFXRadioButton rbtnAuthor;

    @FXML
    void onRbtnNameClicked(ActionEvent event) {
        System.out.println(group.getSelectedToggle().getUserData());

    }

    @FXML
    void onRbtnAuthorClicked(ActionEvent event) {
        System.out.println(group.getSelectedToggle().getUserData());

    }

    @FXML
    void onRbtnKeywordClicked(ActionEvent event) {
        System.out.println(group.getSelectedToggle().getUserData());

    }

    @FXML
    void onRbtnIDClicked(ActionEvent event) {
        System.out.println(group.getSelectedToggle().getUserData());
    }

    @FXML
    void onTextfieldInpputClicked(ActionEvent event) {

    }

    @FXML
    void onBtnSearchClicked(ActionEvent event) {
        if(group.getSelectedToggle() != null) {
            System.out.println(group.getSelectedToggle().getUserData());
        }
        String way = (String)group.getSelectedToggle().getUserData();

        System.out.println("chishi shuru shi"+textfieldInpput.getText());

           if(way.equals("KeyWord")) {
               list = new SearchByKeywords().search(textfieldInpput.getText());
           }// list = new SearchByKeywords().search(textfieldInpput.getText());
           else
               if(way.equals("Id"))
                   list = new SearchById().search(textfieldInpput.getText());
            else
                if(way.equals("Author"))
               list = new SearchByAuthor().search(textfieldInpput.getText());
            else  list = new SearchByName().search(textfieldInpput.getText());
        JFXTreeTableColumn<Item,String> Id = new JFXTreeTableColumn<>("Id");
        JFXTreeTableColumn<Item,String> Name = new JFXTreeTableColumn<>("Name");
        JFXTreeTableColumn<Item,String> Author = new JFXTreeTableColumn<>("Author");
        JFXTreeTableColumn<Item,String> Type = new JFXTreeTableColumn<>("Type");
        JFXTreeTableColumn<Item,String>  DetailedType= new JFXTreeTableColumn<>("SpecificType");
        JFXTreeTableColumn<Item,String> ReturnDate = new JFXTreeTableColumn<>("ReturnDate");
        JFXTreeTableColumn<Item,String> Status = new JFXTreeTableColumn<>("Status");
        //JFXTreeTableColumn<Item,String> Booker = new JFXTreeTableColumn<>("Name");

        Id.setPrefWidth(40);
        Name.setPrefWidth(100);
        Author.setPrefWidth(70);
        Type.setPrefWidth(40);
        DetailedType.setPrefWidth(70);
        ReturnDate.setPrefWidth(70);
        Status.setPrefWidth(40);

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
        //System.out.println(stageManager.getUser().getName() + "name");
        //List<Item> list = new UserServiceImpl().getCheckOutInfo(id);
        for(Item item : list) {
            items.add(new Item(item.getId(),item.getName(),item.getAuthor(),item.getType(),item.getDetailedType(),item.getReturnDate()));
            System.out.println(item.getId() );
            System.out.println(item.getName() );
            System.out.println(item.getAuthor() );System.out.println(item.getType() );
            System.out.println(item.getDetailedType() );
           // System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse());


        }
        final TreeItem<Item> root = new RecursiveTreeItem<Item>(items,RecursiveTreeObject::getChildren);
        searchResult.getColumns().setAll(Id,Name,Author,Type,DetailedType,ReturnDate);
        searchResult.setRoot(root);
        searchResult.setShowRoot(false);





       // stageManager.setStage(stageManager.getUser(),"SearchResult","SearchPanel");
    }

    @FXML
    void onBtnBackClicked(ActionEvent event) {
        if(stageManager.getUser().isAdmin())
            stageManager.setStage(stageManager.getUser(),"AdminPanel","SearchPanel");
        else {
            stageManager.setStage(stageManager.getUser(),"UserPanel","SearchPanel");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TODO: see if below code works
        group = new ToggleGroup();
        rbtnID.setToggleGroup(group);
        rbtnAuthor.setToggleGroup(group);
        rbtnName.setToggleGroup(group);
        rbtnKeyword.setToggleGroup(group);
        rbtnAuthor.setUserData("Author");
        rbtnID.setUserData("Id");
        rbtnKeyword.setUserData("KeyWord");
        rbtnName.setUserData("Name");
        System.out.println();
    }
}
