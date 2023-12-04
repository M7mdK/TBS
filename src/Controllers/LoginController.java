package Controllers;

import Models.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;

import javafx.scene.control.*;

public class LoginController {

    public static HashMap<String , Integer> loggedUser = new HashMap<String , Integer>();//Will be used to save logged in user id
    Login login = new Login();
    @FXML
    TextField loginUserName;
    @FXML
    PasswordField loginPassword;
    @FXML
    Button loginButton, goToRegisterButton;
    @FXML
    Label wrongUserLabel;

    public LoginController() throws Exception {
    }

    public void openScene(Parent root, ActionEvent event){
        Scene scene=new Scene(root);
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void loginUser(ActionEvent actionEvent) throws SQLException, IOException {

         ResultSet resultSet = login.searchUser(loginUserName.getText(),loginPassword.getText());
         if (resultSet.next()){
             if(resultSet.getInt("iduser") == 1){  //The Admin
                 Parent root = FXMLLoader.load(getClass().getResource("../Views/adminpage.fxml"));
                 openScene(root,actionEvent);
             }
             else{  //Normal User
                 loggedUser.put("uid" , resultSet.getInt("iduser"));//logged in user id saved
                 Parent root = FXMLLoader.load(getClass().getResource("../Views/homepage.fxml"));
                 openScene(root,actionEvent);
             }
         }else{
             wrongUserLabel.setText("You Entered Wrong UserName or Password!");
         }

    }

    public void goToRegister(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Views/register.fxml"));
        openScene(root,actionEvent);
    }

}
