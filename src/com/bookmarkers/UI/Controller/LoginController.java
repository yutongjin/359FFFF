package com.bookmarkers.UI.Controller;

import com.bookmarkers.DB.Service.Impl.AdminServiceImpl;
import com.bookmarkers.DB.Service.Impl.UserServiceImpl;
import com.bookmarkers.Data.Admin;
import com.bookmarkers.Data.LoggedIn;
import com.bookmarkers.Data.Mem;
import com.bookmarkers.Data.User;
import com.bookmarkers.Main;
import com.bookmarkers.UI.Model.UserModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sun.javafx.robot.impl.FXRobotHelper;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.bookmarkers.UI.Stage.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @Author : Yutong Jin
 * @date : 8/25/18
 * @Description :
 */
public class LoginController implements ControlledStage, Initializable {

    StageManager stageManager;

//    public LoginController(UserModel userModel) {
//        this.userModel = userModel;
//    }

    @FXML

    private JFXPasswordField password;


    @FXML
    private JFXTextField username;


    @FXML
    private JFXButton userlogin;

    @FXML
    private JFXButton adminlogin;

    @FXML
    void login(ActionEvent event) throws SQLException {
        if (!stageManager.getUser().isLoggedin()){
            String userName = username.getText();
            String passWord = password.getText();
            System.out.println("userInput Member" + userName +" "+ passWord);
            boolean result =  new UserServiceImpl().login(userName,passWord);
            if(result){
               //
               System.out.println("正确");
               //stage.close();
               User user = new Mem();
               user.setName(new UserServiceImpl().getName(userName));
               user.setId(new UserServiceImpl().getId(userName));

               UserModel userModel = new UserModel(user.getId(),user.getName(),user.getEmail(),user.getPhone(),user.isAdmin());
                stageManager.setUserModel(userModel);

                System.out.println("user itself name id "+ user.getName() + user.getId());
               stageManager.setUser(user);
               System.out.println("this user id" + stageManager.getUser().getId());
              // ((Mem) user).setItemList(new UserServiceImpl().getCheckOutInfo("001"));
               stageManager.setStage(user,"UserPanel","Login");
               //跳转至用户界面
            }
           //弹出登陆失败界面
            else {
               AlertMarker.showErrorMessage("login failed","Please check username or password");
               System.out.println("login failed");
            }
        }
    }

    @FXML
    void loginAsAdmin(ActionEvent event) {

        if (!stageManager.getUser().isLoggedin()){
            String userName = username.getText();
            String passWord = password.getText();
            System.out.println("userInput Admin" + userName +" "+ passWord);
            boolean result =  new AdminServiceImpl().login(userName,passWord);
            if(result){
                //
                System.out.println("管理员登陆成功");
                User user = new Admin(new AdminServiceImpl().getName(userName,passWord),true);

                //UserModel userModel = new UserModel(user.getId(),user.getName(),user.getEmail(),user.getPhone(),user.isAdmin());
                stageManager.getUserModel().setSpName(user.getName());

                //stage.close();
                user.login();
                stageManager.setStage(user,"AdminPanel","Login");
                //跳转至用户界面
            }
            //弹出登陆失败界面
            else {
                System.out.println("login failed");
                AlertMarker.showErrorMessage("login failed","Please check username or password");
            }
        }
    }

    @Override
    public void setStageController(StageManager stageManager) {
        this.stageManager = stageManager;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("login stage initialized");
    }

    @Override
    public void initUI() {

    }
}

