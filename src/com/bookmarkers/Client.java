package com.bookmarkers;

import com.bookmarkers.Data.Mem;
import com.bookmarkers.Data.User;
import com.bookmarkers.UI.Stage.StageManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class Client extends Application {
    // 1
    public static String mainViewID = "Login";
    public static String mainViewRes = "Login.fxml";

    public static String loginViewID = "UI";
    public static String loginViewRes = "UI.fxml";

    // 2 user home page
    public static String UserPanelID = "UserPanel";
    public static String UserPanelRes = "MemberPanel.fxml";
    // 3admin home page
    public static String AdminPanelID = "AdminPanel";
    public static String AdminPanelRes = "AdminPanel.fxml";
    // 4 user status
    public static String UserAccountID = "UserAccount";
    public static String UserAccountRes = "MemberAccount.fxml";

    // 5 search for item
    public static String SearchPanelID = "SearchPanel";
    public static String SearchPanelRes = "SearchPanel.fxml";

    // 6
    public static String InventoryPanelID = "InventoryPanel";
    public static String InventoryPanelRes = "InventoryPanel.fxml";

    // 7

    public static String CheckedOutRatioPanelID = "CheckedOutRatioPanel";
    public static String CheckedOutRatioPanelRes = "CheckedOutRatioPanel.fxml";

    //9
    public static String ReturnBookID = "ReturnBook";
    public static String ReturnBookRes = "ReturnBook.fxml";

    //10
    public static String SearchResultID = "SearchResult";
    public static String SearchResultRes = "SearchResult.fxml";


    //11
    public static String CheckOutBookID = "CheckOutBook";
    public static String CheckOutBookRes = "CheckOutBook.fxml";
    private StageManager stageManager;



    public static void main(String[] args) {
       launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        System.out.println("start called");
        stageManager = StageManager.getInstance();



        //stageManager.setPrimaryStage("primaryStage", primaryStage);

        User user = new Mem();
        user.logout();
        stageManager.setUser(user);


        stageManager.loadStage(mainViewID, mainViewRes);
        stageManager.loadStage(UserPanelID, UserPanelRes);
        stageManager.loadStage(AdminPanelID, AdminPanelRes);
        stageManager.loadStage(UserAccountID, UserAccountRes);
        stageManager.loadStage(SearchPanelID, SearchPanelRes);
        stageManager.loadStage(InventoryPanelID, InventoryPanelRes);
        stageManager.loadStage(CheckedOutRatioPanelID, CheckedOutRatioPanelRes);
        stageManager.loadStage(ReturnBookID, ReturnBookRes);
        stageManager.loadStage(SearchResultID, SearchResultRes);
        stageManager.loadStage(CheckOutBookID, CheckOutBookRes);

        stageManager.setStage(mainViewID);

    }
//    public void start(Stage primaryStage) throws Exception {
//        primaryStage.setTitle("BookMarkers");
//        button = new Button();
//        button.setText("Click me ");
//        StackPane layout =  new StackPane();
//        layout.getChildren().add(button);
//
//        Scene scene = new Scene(layout,300,250);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
}
