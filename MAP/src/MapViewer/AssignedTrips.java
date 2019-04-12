package MapViewer;

import MapLogic.Trip;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AssignedTrips {

	Stage stage;
	Scene assignedTripsScene;
	DriverMenu driverMenu;
	TableView<Trip> tableView;

	public AssignedTrips(Stage stage) {
		this.stage = stage;
	}

	public void prepareScene() {

		TableColumn<Trip, String> source = new TableColumn<Trip, String>("Source");
		source.setCellValueFactory(new PropertyValueFactory<>("source"));
		source.setMinWidth(200);
		TableColumn<Trip, String> destination = new TableColumn<Trip, String>("Destination");
		destination.setCellValueFactory(new PropertyValueFactory<>("destination"));
		destination.setMinWidth(200);
		TableColumn<Trip, Double> time = new TableColumn<Trip, Double>("Time");
		time.setCellValueFactory(new PropertyValueFactory<>("time"));
		time.setMinWidth(100);
		TableColumn<Trip, String> vehicle = new TableColumn<Trip, String>("Vehicle");
		vehicle.setCellValueFactory(new PropertyValueFactory<>("vehicle"));
		vehicle.setMinWidth(100);

		tableView = new TableView<>();
		tableView.getColumns().add(source);
		tableView.getColumns().add(destination);
		tableView.getColumns().add(time);
		tableView.getColumns().add(vehicle);

		Button backToDriver = new Button("Back");

		GridPane assignedTripsGrid = new GridPane();

		assignedTripsGrid.add(tableView, 0, 0);
		assignedTripsGrid.add(backToDriver, 0, 1);

		assignedTripsScene = new Scene(assignedTripsGrid, 500, 400);

		backToDriver.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				stage.setScene(driverMenu.getDriverScene());

			}
		});
	}

	public Scene getAssignedTripsScene() {
		return assignedTripsScene;
	}

	public void setDriverMenu(DriverMenu driverMenu) {
		this.driverMenu = driverMenu;
	}

	public TableView<Trip> getTableView() {
		return tableView;
	}

}
