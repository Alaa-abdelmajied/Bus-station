package MapViewer;

import java.io.IOException;
import java.util.ArrayList;

import MapLogic.CurrentTripsReader;
import MapLogic.FileWriterUtils;
import MapLogic.HistoryTripsReader;
import MapLogic.Trip;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class YourTrips {

	Stage stage;
	Scene yourTripsScene;
	PassengerMenu passengerMenu;
	LoginForm loginForm;
	ConfirmationScene confirmationScene;
	TableView<Trip> tableView;

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
		Button cancel = new Button("Cancel Trip");
		cancel.setVisible(false);

		passengerTripsGrid.add(current, 0, 0);
		GridPane.setHalignment(current, HPos.LEFT);
		passengerTripsGrid.add(history, 0, 0);
		GridPane.setHalignment(history, HPos.RIGHT);
		passengerTripsGrid.add(tableView, 0, 1);
		passengerTripsGrid.add(back, 0, 2);
		GridPane.setHalignment(back, HPos.LEFT);
		passengerTripsGrid.add(cancel, 0, 2);
		GridPane.setHalignment(cancel, HPos.RIGHT);

		yourTripsScene = new Scene(passengerTripsGrid, 600, 500);

		// actions
		current.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				confirmationScene.currentTrips.setName(loginForm.userNameField.getText());
				confirmationScene.currentTrips.load();
				final ObservableList<Trip> currentData = FXCollections.observableArrayList();
				ArrayList<Trip> current = confirmationScene.currentTrips.showTrips();
				currentData.setAll(current);
				tableView.setItems(currentData);
				cancel.setVisible(true);

			}
		});

		history.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				confirmationScene.getHistory().setName(loginForm.userNameField.getText());
				confirmationScene.getHistory().load();
				final ObservableList<Trip> historyData = FXCollections.observableArrayList();
				ArrayList<Trip> history = confirmationScene.getHistory().showTrips();
				historyData.setAll(history);
				tableView.setItems(historyData);
				cancel.setVisible(false);

			}

		});
		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				tableView.getItems().clear();
				stage.setScene(passengerMenu.getPassengerScene());
			}
		});

		cancel.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (tableView.getSelectionModel().getSelectedItem() != null) {
					confirmationScene.currentTrips.cancelTrip(loginForm.userNameField.getText(),
							tableView.getSelectionModel().getSelectedItem().getSource(),
							tableView.getSelectionModel().getSelectedItem().getDestination(),
							tableView.getSelectionModel().getSelectedItem().getTime(),
							tableView.getSelectionModel().getSelectedItem().getVehicle());

					try {
						FileWriterUtils.writeCurrentTripFile(confirmationScene.currentTrips.getCurrents());
					} catch (IOException e) {
						e.printStackTrace();
					}
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Cancellation");
					alert.setHeaderText(null);
					alert.setContentText("The trip has been cancelled");
					alert.showAndWait();
					tableView.getItems().remove(tableView.getSelectionModel().getSelectedItem());
					loginForm.getPassenger().deleteTripsNumber(loginForm.userNameField.getText());
					try {
						FileWriterUtils.writeVipFile(loginForm.getPassenger().getPassengers());
					} catch (IOException e) {
						e.printStackTrace();
					}
					try {
						if (!loginForm.getPassenger().vipCheck(loginForm.userNameField.getText())) {
							passengerMenu.limo.setVisible(false);
							passengerMenu.becomeVip.setVisible(true);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}

				} else {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("WARNING");
					alert.setHeaderText("");
					alert.setContentText("Select a trip to cancel");
					alert.showAndWait();
				}

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

	public void setConfirmationScene(ConfirmationScene confirmationScene) {
		this.confirmationScene = confirmationScene;
	}

}
