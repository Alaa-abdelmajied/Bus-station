package MapViewer;

import java.io.IOException;
import java.util.ArrayList;

import MapLogic.FileWriterUtils;
import MapLogic.Trip;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ManagerAssignedTrips {

	Stage stage;
	Scene managerAssignedTrips;
	ManagerMenu managerMenu;
	PassengerMenu passengerMenu;
	DriverMenu driverMenu;
	TableView<Trip> tableView;
	ChoiceBox<String> drivers = new ChoiceBox<String>();

	public ManagerAssignedTrips(Stage stage) {
		this.stage = stage;
	}

	public void prepareScene() {

		Label select = new Label("Select a driver");
		Label space = new Label(" ");
		Button assign = new Button("Assign driver");
		Button back = new Button("Back");

		TableColumn<Trip, String> source = new TableColumn<Trip, String>("Source");
		source.setCellValueFactory(new PropertyValueFactory<>("source"));
		source.setMinWidth(200);
		TableColumn<Trip, String> destination = new TableColumn<Trip, String>("Destination");
		destination.setCellValueFactory(new PropertyValueFactory<>("destination"));
		destination.setMinWidth(200);
		TableColumn<Trip, String> driverName = new TableColumn<Trip, String>("Driver");
		driverName.setCellValueFactory(new PropertyValueFactory<>("driverName"));
		driverName.setMinWidth(150);
		TableColumn<Trip, Double> time = new TableColumn<Trip, Double>("Time");
		time.setCellValueFactory(new PropertyValueFactory<>("time"));
		time.setMinWidth(100);
		TableColumn<Trip, String> vehicle = new TableColumn<Trip, String>("Vehicle");
		vehicle.setCellValueFactory(new PropertyValueFactory<>("vehicle"));
		vehicle.setMinWidth(150);
		TableColumn<Trip, Integer> numberOfStops = new TableColumn<Trip, Integer>("Number Of Stops");
		numberOfStops.setCellValueFactory(new PropertyValueFactory<>("numOfStops"));
		numberOfStops.setMinWidth(150);
		TableColumn<Trip, Double> ticketPrice = new TableColumn<Trip, Double>("Price");
		ticketPrice.setCellValueFactory(new PropertyValueFactory<>("ticketPrice"));
		ticketPrice.setMinWidth(100);

		tableView = new TableView<>();
		tableView.getColumns().add(source);
		tableView.getColumns().add(destination);
		tableView.getColumns().add(driverName);
		tableView.getColumns().add(time);
		tableView.getColumns().add(vehicle);
		tableView.getColumns().add(numberOfStops);
		tableView.getColumns().add(ticketPrice);

		GridPane mangerAssignGrid = new GridPane();

		mangerAssignGrid.add(select, 0, 0);
		mangerAssignGrid.add(drivers, 0, 1);
		mangerAssignGrid.add(space, 0, 2);
		mangerAssignGrid.add(tableView, 0, 3);
		mangerAssignGrid.add(assign, 0, 4);
		GridPane.setHalignment(assign, HPos.RIGHT);
		mangerAssignGrid.add(back, 0, 4);
		GridPane.setHalignment(back, HPos.LEFT);

		managerAssignedTrips = new Scene(mangerAssignGrid, 500, 500);

		// actions

		assign.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (drivers.getValue() == null || tableView.getSelectionModel().isEmpty()) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("WARNING");
					alert.setHeaderText("");
					alert.setContentText("Please, Select a driver and a trip");
					alert.showAndWait();
				} else {
					passengerMenu.getTrip().assignTrip(tableView.getSelectionModel().getSelectedItem().getSource(),
							tableView.getSelectionModel().getSelectedItem().getDestination(),
							tableView.getSelectionModel().getSelectedItem().getTime(),
							tableView.getSelectionModel().getSelectedItem().getVehicle(), drivers.getValue());
					driverMenu.getDriverReader().setDriverFirstName(drivers.getValue());
					driverMenu.getDriverReader().addAssignedTrips(
							tableView.getSelectionModel().getSelectedItem().getSource(),
							tableView.getSelectionModel().getSelectedItem().getDestination(),
							tableView.getSelectionModel().getSelectedItem().getTime(),
							tableView.getSelectionModel().getSelectedItem().getVehicle());

					try {
						FileWriterUtils.writeDriverFile(driverMenu.getDriverReader().getDriverInfo());
						FileWriterUtils.writeTripFile(passengerMenu.getTrip().getTrips());
					} catch (IOException e) {
						e.printStackTrace();
					}
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Confirmation");
					alert.setHeaderText(null);
					alert.setContentText("The driver has been assigned");
					alert.showAndWait();
					stage.setScene(managerMenu.getManagerScene());
				}
			}
		});

		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				drivers.getSelectionModel().clearSelection();
				drivers.setValue(null);
				stage.setScene(managerMenu.getManagerScene());
			}
		});

	}

	public Scene getManagerAssignedTrips() {
		return managerAssignedTrips;
	}

	public TableView<Trip> getTableView() {
		return tableView;
	}

	public void setManagerMenu(ManagerMenu managerMenu) {
		this.managerMenu = managerMenu;
	}

	public void setPassengerMenu(PassengerMenu passengerMenu) {
		this.passengerMenu = passengerMenu;
	}

	public ChoiceBox<String> getDrivers() {
		return drivers;
	}

	public void setDriverMenu(DriverMenu driverMenu) {
		this.driverMenu = driverMenu;
	}

}
