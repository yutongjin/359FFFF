package com.bookmarkers.UI.Controller.Login;

import com.bookmarkers.DB.Service.Impl.AdminServiceImpl;
import com.bookmarkers.DB.Service.Impl.UserServiceImpl;
import com.bookmarkers.Data.Admin;
import com.bookmarkers.Data.Mem;
import com.bookmarkers.Data.User;
import com.bookmarkers.UI.Controller.AlertMarker;
import com.bookmarkers.UI.Controller.StageController;
import com.bookmarkers.UI.Model.AdminModel;
import com.bookmarkers.UI.Model.MemberModel;
import com.bookmarkers.UI.Model.UserModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import com.bookmarkers.UI.Stage.*;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @Author : Yutong Jin
 * @date : 8/25/18
 * @Description :
 */
public class LoginController implements StageController, Initializable {

    StageManager stageManager;

    LoginValidator loginValidator;

    @FXML

    private JFXPasswordField password;


    @FXML
    private JFXTextField username;


    @FXML
    private JFXButton userlogin;

    @FXML
    private JFXButton adminlogin;

    @FXML
    void userLogin(ActionEvent event) throws SQLException {
        if (!stageManager.getUser().isLoggedin()){
            String userName = username.getText();
            String passWord = password.getText();
//            System.out.println("userInput Member" + userName +" "+ passWord);
            loginValidator = new UserLoginValidator();
            boolean result = loginValidator.validateLogin(userName, passWord);
            if(result){
               //
               System.out.println("正确");
               //stage.close();
               User user = new Mem();
               user.setName(new UserServiceImpl().getName(userName));
               user.setId(new UserServiceImpl().getId(userName));
               stageManager.setUser(user);
               user.login();

               UserModel memberModel = new MemberModel(user.getId(),user.getName(),user.getEmail(),user.getPhone(),user.isAdmin());

               stageManager.setUserModel(memberModel);

               //在这里让stageManager重新调用一下所有controller的initUI方法
                 stageManager.refreshUI();

               stageManager.setStage(user,"UserPanel","Login");
//               MemberModel userModel = new MemberModel(user.getId(),user.getName(),user.getEmail(),user.getPhone(),user.isAdmin());
//                stageManager.setMemberModel(userModel);

                System.out.println("user itself name id "+ user.getName() + user.getId());
                System.out.println("this user id" + stageManager.getUser().getId());
                // ((Mem) user).setItemList(new UserServiceImpl().getCheckOutInfo("001"));
               //跳转至用户界面
            }
           //弹出登陆失败界面
            else {
                showErrorAlert();
            }
        }
    }

    @FXML
    void loginAsAdmin(ActionEvent event) {

        if (!stageManager.getUser().isLoggedin()){
            String userName = username.getText();
            String passWord = password.getText();
//            System.out.println("userInput Admin" + userName +" "+ passWord);
            loginValidator = new AdminLoginValidator();
            boolean result = loginValidator.validateLogin(userName, passWord);
            if(result){

                //System.out.println("管理员登陆成功");
                User user = new Admin(new AdminServiceImpl().getName(userName,passWord),true);
                stageManager.setUser(user);

                UserModel adminModel = new AdminModel(user.getId(),user.getName(),user.getEmail(),user.getPhone(),user.isAdmin());

                stageManager.setUserModel(adminModel);
//                stageManager.getUserModel().setSpName(user.getName());

                //stage.close();
                user.login();

                //在这里让stageManager重新调用一下所有controller的initUI方法
                stageManager.refreshUI();

                stageManager.setStage(user,"AdminPanel","Login");
                //跳转至用户界面
            }
            //弹出登陆失败界面
            else {
                showErrorAlert();
            }
        }
    }

    private void showErrorAlert(){
        System.out.println("login failed");
        AlertMarker.showErrorMessage("login failed","Please check username or password");
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

