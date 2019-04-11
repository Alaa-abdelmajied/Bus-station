package MapViewer;

import java.awt.List;
import java.util.ArrayList;

import MapLogic.DriverReader;
import MapLogic.Trip;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class DriverMenu {

	Stage stage;
	Scene driverScene;
	LoginForm loginForm;
	AssignedTrips assignedTrips;
	DriverProfile driverProfile;
	PassengerMenu passengerMenu;
	DriverReader driverReader = new DriverReader();
	Label driverLabel = new Label();
	private final ObservableList<Trip> tripsData = FXCollections.observableArrayList();

	public DriverMenu(Stage stage) {
		this.stage = stage;
	}

	public void prepareScene() {

		Button profile = new Button("Go to your profile");
		Button assignedTrips = new Button("Assigned Trips");
		Button logoutDriver = new Button("Logout");
		GridPane driverGrid = new GridPane();
		driverGrid.add(driverLabel, 0, 0);
		GridPane.setHalignment(driverLabel, HPos.CENTER);
		driverGrid.add(profile, 0, 1);
		GridPane.setHalignment(profile, HPos.CENTER);
		driverGrid.add(assignedTrips, 0, 7);
		GridPane.setHalignment(assignedTrips, HPos.CENTER);
		driverGrid.add(logoutDriver, 0, 8);
		GridPane.setHalignment(logoutDriver, HPos.CENTER);

		driverScene = new Scene(driverGrid, 300, 300);

		// actions

		profile.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				driverProfile.setPersonalData("WELCOME TO YOUR PROFILE");
				driverProfile.setfName("First Name: " + loginForm.userNameField.getText());
				driverProfile.setlName("Last Name: " + driverReader.getDriverLastName());
				driverProfile.setGender("Gender: " + driverReader.getDriverGender());
				driverProfile.setNumber("Phone Number: " + driverReader.getDriverNumber());
				stage.setScene(driverProfile.getDriverProfileScene());

			}
		});

		assignedTrips.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				driverReader.loadInfo();
				final ObservableList<Trip> tripsData = FXCollections.observableArrayList();
				ArrayList<Trip> assignedTrips = driverReader.getAssignedTrips();
				tripsData.setAll(assignedTrips);
				DriverMenu.this.assignedTrips.getTableView().setItems(tripsData);
				stage.setScene(DriverMenu.this.assignedTrips.getAssignedTripsScene());

			}

		});

		logoutDriver.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				loginForm.setUserNameField(null);
				loginForm.setPasswordField(null);
				//loginForm.setPassengerRB(null);
				//loginForm.setEmployeeRB(null);
				stage.setScene(loginForm.getLoginForm());
				

			}
		});
	}

	public Scene getDriverScene() {
		return driverScene;
	}

	public void setLoginForm(LoginForm loginForm) {
		this.loginForm = loginForm;
	}

	public void setDriverProfile(DriverProfile driverProfile) {
		this.driverProfile = driverProfile;
	}

	public void setDriverLabel(String text) {
		this.driverLabel.setText(text);
	}

	public void setAssignedTrips(AssignedTrips assignedTrips) {
		this.assignedTrips = assignedTrips;
	}

	public void setPassengerMenu(PassengerMenu passengerMenu) {
		this.passengerMenu = passengerMenu;
	}
	
	

}
