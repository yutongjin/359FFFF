package com.bookmarkers.UI.Controller;

import com.bookmarkers.DB.Service.Impl.SearchStrategy.SearchByAuthor;
import com.bookmarkers.DB.Service.Impl.SearchStrategy.SearchById;
import com.bookmarkers.DB.Service.Impl.SearchStrategy.SearchByKeywords;
import com.bookmarkers.DB.Service.Impl.SearchStrategy.SearchByName;
import com.bookmarkers.DB.Service.SearchService;
import com.bookmarkers.Data.Item.Item;
import com.bookmarkers.UI.Model.ItemModel;
import com.bookmarkers.UI.Model.MemberModel;
import com.bookmarkers.UI.Stage.StageManager;
import com.jfoenix.controls.*;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.paint.Color;
import javafx.util.Callback;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

//5 search for items
public class SearchPanelController implements StageController,Initializable {

    StageManager stageManager;
    ToggleGroup group;
    SearchService searchService;
    List<Item> list ;
    MemberModel memberModel;


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
    public JFXTreeTableView<ItemModel> searchResult;


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
        show();

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
        group = new ToggleGroup();
        rbtnID.setToggleGroup(group);
        rbtnAuthor.setToggleGroup(group);
        rbtnName.setToggleGroup(group);
        rbtnKeyword.setToggleGroup(group);

        rbtnAuthor.setUserData("Author");
        rbtnID.setUserData("Id");
        rbtnKeyword.setUserData("KeyWord");
        rbtnName.setUserData("Name");

        rbtnName.setSelectedColor(Color.BLACK);
        rbtnKeyword.setSelectedColor(Color.BLACK);
        rbtnID.setSelectedColor(Color.BLACK);
        rbtnAuthor.setSelectedColor(Color.BLACK);
        rbtnName.setSelected(true);

        System.out.println();

        textfieldInpput.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                show();
            }
        });

    }

    @Override
    public void initUI() {

    }
    public  void show(){
        String way = (String)group.getSelectedToggle().getUserData();

        System.out.println(way.equals("Author") + way);

        if(way.equals("KeyWord")) {
            list = new SearchByKeywords().search(textfieldInpput.getText());
        }// list = new SearchByKeywords().search(textfieldInpput.getText());
        else
        if(way.equals("Id")){
            list = new SearchById().search(textfieldInpput.getText());
        }
        else
        if(way.equals("Author")){
            list = new SearchByAuthor().search(textfieldInpput.getText());
        }
        else  {
            list = new SearchByName().search(textfieldInpput.getText());
        }
        JFXTreeTableColumn<ItemModel,String> Id = new JFXTreeTableColumn<>("Id");
        JFXTreeTableColumn<ItemModel,String> Name = new JFXTreeTableColumn<>("Name");
        JFXTreeTableColumn<ItemModel,String> Author = new JFXTreeTableColumn<>("Author");
        JFXTreeTableColumn<ItemModel,String> Type = new JFXTreeTableColumn<>("Type");
        JFXTreeTableColumn<ItemModel,String>  DetailedType= new JFXTreeTableColumn<>("Specific Type");
        JFXTreeTableColumn<ItemModel,String> ReturnDate = new JFXTreeTableColumn<>("Return Date");
        JFXTreeTableColumn<ItemModel,String> Status = new JFXTreeTableColumn<>("Status");
        //JFXTreeTableColumn<Item,String> Booker = new JFXTreeTableColumn<>("Name");
        JFXTreeTableColumn<ItemModel,String> Loc = new JFXTreeTableColumn<>("Location");
        JFXTreeTableColumn<ItemModel,String> Booker = new JFXTreeTableColumn<>("Booker");
        Id.setPrefWidth(90);
        Name.setPrefWidth(200);
        Author.setPrefWidth(120);
        Type.setPrefWidth(80);
        DetailedType.setPrefWidth(100);
        ReturnDate.setPrefWidth(80);
        Status.setPrefWidth(80);
        Loc.setPrefWidth(80);
        Booker.setPrefWidth(80);

        Id.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ItemModel, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<ItemModel, String> param) {
                return param.getValue().getValue().spIdProperty();
            }
        });

        Name.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ItemModel, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<ItemModel, String> param) {
                return param.getValue().getValue().spNameProperty();            }
        });

        Author.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ItemModel, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<ItemModel, String> param) {
                return param.getValue().getValue().spAuthorProperty();            }
        });

        Type.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ItemModel, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<ItemModel, String> param) {
                return param.getValue().getValue().spTypeProperty();            }
        });

        DetailedType.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ItemModel, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<ItemModel, String> param) {
                return param.getValue().getValue().spDetailedTypeProperty();            }
        });

        ReturnDate.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ItemModel, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<ItemModel, String> param) {
                return param.getValue().getValue().spReturnDateProperty();  }
        });

        Status.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ItemModel, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<ItemModel, String> param) {
                return param.getValue().getValue().spActiveProperty();            }
        });
        Loc.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ItemModel, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<ItemModel, String> param) {
                return param.getValue().getValue().spLocProperty();            }
        });
        Booker.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ItemModel, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<ItemModel, String> param) {
                return param.getValue().getValue().spBookerProperty();            }
        });

        //到这里 loc

        ObservableList<ItemModel> items = FXCollections.observableArrayList();

        String id  = stageManager.getUser().getId();
        //System.out.println(stageManager.getUser().getName() + "name");
        //List<Item> list = new UserServiceImpl().getCheckOutInfo(id);
        for(Item item : list) {
            items.add(new ItemModel(item.getId(),item.getName(),item.getAuthor(),item.getType(),item.getDetailedType(),item.getReturnDate(),item.isActive(),item.getLoc(),item.getBooker()));
            System.out.println(item.getId() );
            System.out.println(item.getName() );
            System.out.println(item.getAuthor() );System.out.println(item.getType() );
            System.out.println(item.getDetailedType() );
            // System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse());
        }
        TreeItem<ItemModel> root = new RecursiveTreeItem<ItemModel>(items,RecursiveTreeObject::getChildren);
        if(!stageManager.getUser().isAdmin()) {
            searchResult.getColumns().setAll(Id, Name, Author, Type, DetailedType, ReturnDate, Status,Loc);
        }
        else {
            searchResult.getColumns().setAll(Id, Name, Author, Type, DetailedType, ReturnDate, Status,Loc,Booker);

        }
        searchResult.setRoot(root);
        searchResult.setShowRoot(false);



    }
}
