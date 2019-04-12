package MapViewer;

import java.util.ArrayList;
import MapLogic.Trip;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BookingScene {

	Stage stage;
	Scene bookingScene;
	PassengerMenu passengerMenu;
	ConfirmationScene confirmationScene;
	TableView<Trip> tableView;
	ChoiceBox<String> choiceBoxS = new ChoiceBox<String>();
	ChoiceBox<String> choiceBoxD = new ChoiceBox<String>();
	private final ObservableList<Trip> tripsData = FXCollections.observableArrayList();
	double ticketPrice;

	public BookingScene(Stage stage) {
		this.stage = stage;
	}

	public void prepareScene() {

		Label sourceLabel = new Label("Choose your source:");
		Label destinationLabel = new Label("Choose your destination:");
		Label space = new Label(" ");
		Button search = new Button("Search");
		Button showAll = new Button("Show all trips");
		Button select = new Button("Select");
		Alert alert = new Alert(AlertType.WARNING);
		select.setVisible(false);
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
		tableView.setItems(tripsData);
		tableView.getColumns().add(source);
		tableView.getColumns().add(destination);
		tableView.getColumns().add(time);
		tableView.getColumns().add(vehicle);
		tableView.getColumns().add(numberOfStops);
		tableView.getColumns().add(ticketPrice);

		GridPane bookingGrid = new GridPane();
		bookingGrid.add(sourceLabel, 0, 0);
		bookingGrid.add(choiceBoxS, 0, 1);
		bookingGrid.add(destinationLabel, 0, 2);
		bookingGrid.add(choiceBoxD, 0, 3);
		bookingGrid.add(space, 0, 4);
		bookingGrid.add(search, 0, 5);
		GridPane.setHalignment(search, HPos.RIGHT);
		bookingGrid.add(showAll, 0, 5);
		GridPane.setHalignment(showAll, HPos.LEFT);
		bookingGrid.add(tableView, 0, 6);
		bookingGrid.add(select, 0, 7);
		GridPane.setHalignment(select, HPos.RIGHT);
		bookingGrid.add(back, 0, 7);
		GridPane.setHalignment(back, HPos.LEFT);
		bookingScene = new Scene(bookingGrid, 500, 500);

		// actions

		showAll.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				ArrayList<Trip> trips = passengerMenu.getTrip().showTrips();
				tripsData.setAll(trips);
				select.setVisible(true);

			}
		});

		search.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (choiceBoxS.getSelectionModel().isEmpty() && choiceBoxD.getSelectionModel().isEmpty()) {
					alert.setTitle("WARNING");
					alert.setHeaderText("");
					alert.setContentText("Choose your source and destination or show all trips");
					alert.showAndWait();
				} else {
					String sourceSearch = choiceBoxS.getValue();
					String destination = choiceBoxD.getValue();
					ArrayList<Trip> trips = passengerMenu.getTrip().findTrip(sourceSearch, destination);
					tripsData.setAll(trips);
					select.setVisible(true);

				}

			}

		});

		select.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (tableView.getSelectionModel().getSelectedItem() == null) {
					alert.setTitle("WARNING");
					alert.setHeaderText("");
					alert.setContentText("You must choose a trip first");
					alert.showAndWait();
				} else {
					confirmationScene.getTicketType().setVisible(true);
					confirmationScene.getOneWay().setVisible(true);
					confirmationScene.getRound().setVisible(true);
					BookingScene.this.ticketPrice = tableView.getSelectionModel().getSelectedItem().getTicketPrice();
					stage.setScene(confirmationScene.getConfirmationScene());
				}
			}
		});

		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				choiceBoxS.getSelectionModel().clearSelection();
				choiceBoxS.setValue(null);
				choiceBoxD.getSelectionModel().clearSelection();
				choiceBoxD.setValue(null);
				tableView.getItems().clear();
				stage.setScene(passengerMenu.getPassengerScene());
			}
		});
	}

	public Scene getBookingScene() {
		return bookingScene;
	}

	public void setPassengerMenu(PassengerMenu passengerMenu) {
		this.passengerMenu = passengerMenu;
	}

	public void setChoiceBoxS(String source) {
		this.choiceBoxS.getItems().add(source);
	}

	public void setChoiceBoxD(String destination) {
		this.choiceBoxD.getItems().add(destination);
	}

	public void setConfirmationScene(ConfirmationScene confirmationScene) {
		this.confirmationScene = confirmationScene;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

}
