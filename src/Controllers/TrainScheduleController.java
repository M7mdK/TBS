package Controllers;

import Models.TrainSchedule;
import Models.Trip;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TrainScheduleController implements Initializable {

    TrainSchedule ts = new TrainSchedule();
    Trip trip;
    @FXML
    ListView<Trip> tripsList;
    @FXML
    Label trainLabel;
    @FXML
    TextField choosenTripId;
    @FXML
    Label helpLabel;

    public TrainScheduleController() throws Exception {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            viewTrainSchedule();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewTrainSchedule() throws SQLException {
        ResultSet resultSet = ts.getTrips();
        while (resultSet.next()){
             trip = new Trip(resultSet.getInt("idtrip"),
                    resultSet.getString("depCity"),
                    resultSet.getString("arrCity"),
                    resultSet.getString("date"),
                    resultSet.getInt("price"));
            tripsList.getItems().add(trip);
        }

    }

    public void openScene(Parent root, ActionEvent event){
        Scene scene=new Scene(root);
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void goToSeatReserved(ActionEvent actionEvent) throws IOException, SQLException {
        if(!(choosenTripId.getText().equals(""))){
            ts.insertReservation(LoginController.loggedUser.get("uid") , trip.getTripId());
            Parent root = FXMLLoader.load(getClass().getResource("../Views/seatreserved.fxml"));
            openScene(root,actionEvent);
        }else{
            helpLabel.setText("You have to enter a trip number!");

        }
    }

    public void backToHomePage(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Views/homepage.fxml"));
        openScene(root,actionEvent);
    }

}
