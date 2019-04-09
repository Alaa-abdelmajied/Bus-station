package MapViewer;

import MapLogic.Trip;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AllTrips {

	Stage stage;
	Scene alltrips;
	ManagerMenu managerMenu;
	PassengerMenu passengerMenu;
	TableView<Trip> tableView;

	public AllTrips(Stage stage) {
		this.stage = stage;
	}

	public void prepareScene() {

		Button add = new Button("Add trip");
		Button delete = new Button("Delete trip");
		Button back = new Button("Back");

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
		vehicle.setMinWidth(150);
		TableColumn<Trip, Integer> numberOfStops = new TableColumn<Trip, Integer>("Number Of Stops");
		numberOfStops.setCellValueFactory(new PropertyValueFactory<>("numOfStops"));
		numberOfStops.setMinWidth(100);
		TableColumn<Trip, Double> ticketPrice = new TableColumn<Trip, Double>("Price");
		ticketPrice.setCellValueFactory(new PropertyValueFactory<>("ticketPrice"));
		ticketPrice.setMinWidth(100);

		tableView = new TableView<>();
		tableView.getColumns().add(source);
		tableView.getColumns().add(destination);
		tableView.getColumns().add(time);
		tableView.getColumns().add(vehicle);
		tableView.getColumns().add(numberOfStops);
		tableView.getColumns().add(ticketPrice);

		GridPane allTripsGrid = new GridPane();

		allTripsGrid.add(tableView, 0, 0);
		allTripsGrid.add(add, 0, 4);
		GridPane.setHalignment(add, HPos.CENTER);
		allTripsGrid.add(delete, 0, 4);
		GridPane.setHalignment(delete, HPos.RIGHT);
		allTripsGrid.add(back, 0, 4);
		GridPane.setHalignment(back, HPos.LEFT);

		alltrips = new Scene(allTripsGrid, 500, 500);

		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				stage.setScene(managerMenu.getManagerScene());
			}
		});
	}

	public Scene getAlltrips() {
		return alltrips;
	}

	public void setManagerMenu(ManagerMenu managerMenu) {
		this.managerMenu = managerMenu;
	}

	public TableView<Trip> getTableView() {
		return tableView;
	}

}
