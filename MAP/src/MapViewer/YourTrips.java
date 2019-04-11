package MapViewer;

import java.util.ArrayList;

import MapLogic.CurrentTripsReader;
import MapLogic.HistoryTripsReader;
import MapLogic.Trip;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class YourTrips {

	Stage stage;
	Scene yourTripsScene;
	PassengerMenu passengerMenu;
	LoginForm loginForm;
	TableView<Trip> tableView;
	HistoryTripsReader history = new HistoryTripsReader();
	CurrentTripsReader current = new CurrentTripsReader();

	public YourTrips(Stage stage) {
		this.stage = stage;
	}

	public void prepareScene() {

		GridPane passengerTripsGrid = new GridPane();

		Button current = new Button("Current Trips");
		Button history = new Button("History");

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

		Button back = new Button("Back");

		passengerTripsGrid.add(current, 0, 0);
		GridPane.setHalignment(current, HPos.LEFT);
		passengerTripsGrid.add(history, 0, 0);
		GridPane.setHalignment(history, HPos.RIGHT);
		passengerTripsGrid.add(tableView, 0, 1);
		passengerTripsGrid.add(back, 0, 2);

		yourTripsScene = new Scene(passengerTripsGrid, 600, 500);

		// actions
		current.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				YourTrips.this.current.setName(loginForm.userNameField.getText());
				YourTrips.this.current.load();
				final ObservableList<Trip> currentData = FXCollections.observableArrayList();
				ArrayList<Trip> current = YourTrips.this.current.showTrips();
				currentData.setAll(current);
				tableView.setItems(currentData);

			}
		});
		
		history.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				YourTrips.this.history.setName(loginForm.userNameField.getText());
				YourTrips.this.history.load();
				final ObservableList<Trip> historyData = FXCollections.observableArrayList();
				ArrayList<Trip> history = YourTrips.this.history.showTrips();
				historyData.setAll(history);
				tableView.setItems(historyData);

			}

		});
		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				stage.setScene(passengerMenu.getPassengerScene());
			}
		});

	}

	public Scene getYourTripsScene() {
		return yourTripsScene;
	}

	public void setPassengerMenu(PassengerMenu passengerMenu) {
		this.passengerMenu = passengerMenu;
	}

	public void setLoginForm(LoginForm loginForm) {
		this.loginForm = loginForm;
	}
	

}
