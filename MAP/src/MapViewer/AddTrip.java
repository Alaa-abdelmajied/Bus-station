package MapViewer;

import java.io.IOException;
import java.util.regex.Pattern;
import MapLogic.FileWriterUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AddTrip {

	Stage stage;
	Scene addTrip;
	AllTrips allTrips;
	ManagerMenu managerMenu;
	PassengerMenu passengerMenu;

	public AddTrip(Stage stage) {
		this.stage = stage;
	}

	public void prepareScene() {

		Label label = new Label("Add Trip");
		Label source = new Label("Source: ");
		Label destination = new Label("Destination: ");
		Label time = new Label("Time: ");
		Label vehicle = new Label("Vehicle: ");
		Label numberOfStops = new Label("Number of stops: ");
		Label price = new Label("Price: ");
		Label numberOfSeats = new Label("Number of seats: ");
		TextField sourceText = new TextField();
		sourceText.setPromptText("Enter source");
		TextField destinationText = new TextField();
		destinationText.setPromptText("Enter destination");
		TextField timeText = new TextField();
		timeText.setPromptText("Enter time (hh.mm)");
		TextField priceText = new TextField();
		priceText.setPromptText("Enter price");
		TextField numberOfSeatsText = new TextField();
		numberOfSeatsText.setPromptText("Enter number of seats");
		ChoiceBox<String> vehicleSelection = new ChoiceBox<String>();
		ChoiceBox<Integer> numberOfStopsSelection = new ChoiceBox<Integer>();
		Button add = new Button("Finish");
		Button back = new Button("Back");

		vehicleSelection.getItems().addAll("Bus", "Minbus", "Car");
		for (int i = 0; i < 5; i++)
			numberOfStopsSelection.getItems().add(i);

		GridPane addTripGrid = new GridPane();

		addTripGrid.add(label, 0, 0);
		addTripGrid.add(source, 0, 1);
		GridPane.setHalignment(source, HPos.LEFT);
		addTripGrid.add(sourceText, 1, 1);
		GridPane.setHalignment(sourceText, HPos.LEFT);
		addTripGrid.add(destination, 0, 2);
		GridPane.setHalignment(destination, HPos.LEFT);
		addTripGrid.add(destinationText, 1, 2);
		GridPane.setHalignment(destinationText, HPos.LEFT);
		addTripGrid.add(time, 0, 3);
		GridPane.setHalignment(time, HPos.LEFT);
		addTripGrid.add(timeText, 1, 3);
		GridPane.setHalignment(timeText, HPos.LEFT);
		addTripGrid.add(vehicle, 0, 4);
		GridPane.setHalignment(vehicle, HPos.LEFT);
		addTripGrid.add(vehicleSelection, 1, 4);
		GridPane.setHalignment(vehicleSelection, HPos.LEFT);
		addTripGrid.add(numberOfStops, 0, 5);
		GridPane.setHalignment(numberOfStops, HPos.LEFT);
		addTripGrid.add(numberOfStopsSelection, 1, 5);
		GridPane.setHalignment(numberOfStopsSelection, HPos.LEFT);
		addTripGrid.add(price, 0, 6);
		GridPane.setHalignment(price, HPos.LEFT);
		addTripGrid.add(priceText, 1, 6);
		GridPane.setHalignment(priceText, HPos.LEFT);
		addTripGrid.add(numberOfSeats, 0, 7);
		GridPane.setHalignment(numberOfSeats, HPos.LEFT);
		addTripGrid.add(numberOfSeatsText, 1, 7);
		GridPane.setHalignment(numberOfSeatsText, HPos.LEFT);
		addTripGrid.add(back, 0, 8);
		GridPane.setHalignment(back, HPos.LEFT);
		addTripGrid.add(add, 0, 8);
		GridPane.setHalignment(add, HPos.RIGHT);

		addTrip = new Scene(addTripGrid, 600, 400);

		// actions

		add.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (sourceText.getText().isEmpty() || destinationText.getText().isEmpty()
						|| timeText.getText().isEmpty() || vehicleSelection.getValue() == null
						|| numberOfStopsSelection.getValue() == null || priceText.getText().isEmpty()
						|| numberOfSeatsText.getText().isEmpty()) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("WARNING");
					alert.setHeaderText("");
					alert.setContentText("Please, Fill all feilds");
					alert.showAndWait();
				} else if (!Pattern.matches("[a-zA-Z- ]+", sourceText.getText())
						|| !Pattern.matches("[a-zA-Z- ]+", destinationText.getText())
						|| !Pattern.matches("[0-9.]+", timeText.getText())
						|| !Pattern.matches("[0-9.]+", priceText.getText())
						|| !Pattern.matches("[0-9]+", numberOfSeatsText.getText())) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("WARNING");
					alert.setHeaderText("");
					alert.setContentText("Invalid inputs");
					alert.showAndWait();
					sourceText.setText(null);
					destinationText.setText(null);
					timeText.setText(null);
					vehicleSelection.getSelectionModel().clearSelection();
					numberOfStopsSelection.getSelectionModel().clearSelection();
					priceText.setText(null);
					numberOfSeatsText.setText(null);

				}else {
					passengerMenu.getTrip().addTrip(sourceText.getText(), destinationText.getText(), timeText.getText(),
							vehicleSelection.getValue(), numberOfStopsSelection.getValue(),
							Double.parseDouble(priceText.getText()), Integer.parseInt(numberOfSeatsText.getText()));
					try {
						FileWriterUtils.writeTripFile(passengerMenu.getTrip().getTrips());
					} catch (IOException e) {
						e.printStackTrace();
					}
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Confirmation");
					alert.setHeaderText(null);
					alert.setContentText("The trip has been added");
					alert.showAndWait();
					managerMenu.getTrips().fireEvent(event);
				}
			}
		});

		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				sourceText.setText(null);
				destinationText.setText(null);
				timeText.setText(null);
				vehicleSelection.getSelectionModel().clearSelection();
				numberOfStopsSelection.getSelectionModel().clearSelection();
				priceText.setText(null);
				numberOfSeatsText.setText(null);
				stage.setScene(allTrips.getAlltrips());
			}
		});

	}

	public Scene getAddTrip() {
		return addTrip;
	}

	public void setAllTrips(AllTrips allTrips) {
		this.allTrips = allTrips;
	}

	public void setPassengerMenu(PassengerMenu passengerMenu) {
		this.passengerMenu = passengerMenu;
	}

	public void setManagerMenu(ManagerMenu managerMenu) {
		this.managerMenu = managerMenu;
	}

}
