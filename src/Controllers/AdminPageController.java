package Controllers;

import Models.AdminPage;
import Models.DBHandler;
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

public class AdminPageController {

    AdminPage adminPage = new AdminPage();

    @FXML
    TextField depCity, arrCity, date, price, userIdToDelete;
    @FXML
    Button addTripButton;
    @FXML
    Label tripAddedLabel, userDeletedLabel;

    public AdminPageController() throws Exception {
    }

    public void openScene(Parent root, ActionEvent event){
        Scene scene=new Scene(root);
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void addNewTrip(ActionEvent actionEvent) throws SQLException, IOException {

        adminPage.addTrip(depCity.getText(),arrCity.getText(), date.getText(), Integer.parseInt(price.getText()));
        tripAddedLabel.setText("Trip Added Successfully!");
        clear();
    }

    public void deleteUser(ActionEvent actionEvent) throws SQLException {
        adminPage.deleteU(Integer.parseInt(userIdToDelete.getText()));
        userDeletedLabel.setText("User Deleted Successfully");
    }

    public void adminLogout(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Views/login.fxml"));
        openScene(root,actionEvent);
    }

    private void clear(){
        depCity.setText("");
        arrCity.setText("");
        date.setText("");
        price.setText("");
    }


}
