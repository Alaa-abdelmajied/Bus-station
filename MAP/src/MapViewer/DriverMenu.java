package MapViewer;

import java.awt.List;
import java.util.ArrayList;

import MapLogic.DriverReader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DriverMenu {

	Stage stage;
	Scene driverScene;
	LoginForm loginForm;
	AssignedTrips assignedTrips;
	DriverReader driverReader = new DriverReader();
	Label driverLabel = new Label();

	public DriverMenu(Stage stage) {
		this.stage = stage;
	}

	public void prepareScene() {

		Label gender = new Label();
		Label number = new Label();
		Button assignedTrips = new Button("Assigned Trips");
		Button logoutDriver = new Button("Logout");

		GridPane driverGrid = new GridPane();
		driverGrid.add(driverLabel, 0, 0);
		GridPane.setHalignment(driverLabel, HPos.CENTER);
		driverGrid.add(gender, 0, 1);
		GridPane.setHalignment(gender, HPos.CENTER);
		driverGrid.add(number, 0, 2);
		GridPane.setHalignment(number, HPos.CENTER);
		driverGrid.add(assignedTrips, 0, 3);
		GridPane.setHalignment(assignedTrips, HPos.CENTER);
		driverGrid.add(logoutDriver, 0, 4);
		GridPane.setHalignment(logoutDriver, HPos.CENTER);

		driverScene = new Scene(driverGrid, 300, 300);

		// actions

		assignedTrips.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				driverReader.loadInfo();
				DriverMenu.this.assignedTrips.clearListView();
				ArrayList<String> assignedTrips = new ArrayList<String>();
				assignedTrips = driverReader.getAssignedTrips();
				for (int i = 0; i < assignedTrips.size(); i++) {
					DriverMenu.this.assignedTrips.setListView(assignedTrips.get(i));
				}
				stage.setScene(DriverMenu.this.assignedTrips.getAssignedTripsScene());

			}

		});

		logoutDriver.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				loginForm.setUserNameField(null);
				loginForm.setPasswordField(null);
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

	public void setDriverLabel(String text) {
		this.driverLabel.setText(text);
	}

	public void setAssignedTrips(AssignedTrips assignedTrips) {
		this.assignedTrips = assignedTrips;
	}

}
