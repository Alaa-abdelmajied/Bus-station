package MapViewer;

import java.util.ArrayList;

import MapLogic.Trip;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ManagerMenu {

	Stage stage;
	Scene managerScene;
	LoginForm loginForm;
	AllTrips allTrips;
	PassengerMenu passengerMenu;
	Label managerLabel = new Label();

	public ManagerMenu(Stage stage) {
		this.stage = stage;
	}

	public void prepareScene() {

		Button Trips = new Button("Show All Trips");
		Button assignTrips = new Button("Assign trips to drivers");
		Button logoutManager = new Button("Logout");

		GridPane managerGrid = new GridPane();
		managerGrid.add(managerLabel, 0, 0);
		GridPane.setHalignment(managerLabel, HPos.CENTER);
		managerGrid.add(Trips, 0, 1);
		GridPane.setHalignment(Trips, HPos.CENTER);
		managerGrid.add(assignTrips, 0, 2);
		GridPane.setHalignment(assignTrips, HPos.CENTER);
		managerGrid.add(logoutManager, 0, 3);
		GridPane.setHalignment(logoutManager, HPos.CENTER);

		managerScene = new Scene(managerGrid, 500, 300);

		// actions

		Trips.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				passengerMenu.getTrip().loadTrips();
				final ObservableList<Trip> tripsData = FXCollections.observableArrayList();
				ArrayList<Trip> trips = passengerMenu.getTrip().showTrips();
				tripsData.setAll(trips);
				allTrips.getTableView().setItems(tripsData);
				stage.setScene(allTrips.getAlltrips());

			}
		});

		logoutManager.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				loginForm.setUserNameField("");
				loginForm.setPasswordField("");
				stage.setScene(loginForm.getLoginForm());

			}
		});
	}

	public Scene getManagerScene() {
		return managerScene;
	}

	public void setLoginForm(LoginForm loginForm) {
		this.loginForm = loginForm;
	}

	public void setManagerLabel(String text) {
		this.managerLabel.setText(text);
	}

	public void setAllTrips(AllTrips allTrips) {
		this.allTrips = allTrips;
	}

	public void setPassengerMenu(PassengerMenu passengerMenu) {
		this.passengerMenu = passengerMenu;
	}

}
