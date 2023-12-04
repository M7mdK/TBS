package Controllers;

import Models.Register;
import Models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class RegisterController {
    Register register = new Register();
    @FXML
    TextField regFirstName, regLastName,regUserName, regPhoneNumber, regAge, regCity;
    @FXML
    PasswordField regPassword;
    @FXML
    Button regButton;
    @FXML
    Label regSuccLabel;

    public RegisterController() throws Exception {
    }

    public void openScene(Parent root, ActionEvent event){
        Scene scene=new Scene(root);
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void registerUser(ActionEvent actionEvent) throws SQLException, IOException {

        register.addUser(regFirstName.getText(),
                regLastName.getText(),
                regUserName.getText(),
                regPassword.getText(),
                Integer.parseInt(regAge.getText()),
                regCity.getText(),
                regPhoneNumber.getText());

        regSuccLabel.setText("Registered Successfully");
        Parent root = FXMLLoader.load(getClass().getResource("../Views/login.fxml"));
        openScene(root,actionEvent);
    }

    public void backToLogin(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Views/login.fxml"));
        openScene(root,actionEvent);
    }
}
