package MapViewer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddTrip {

	Stage stage;
	Scene addTrip;
	AllTrips allTrips;

	public AddTrip(Stage stage) {
		this.stage = stage;
	}

	public void prepareScene() {

		Label label = new Label("Add Trip");
		Label source = new Label("Source: ");
		Label destination = new Label("Destination: ");
		Label time = new Label("Time: ");
		Label timeSep = new Label(":");
		Label vehicle = new Label("Vehicle: ");
		Label numberOfStops = new Label("Number of stops: ");
		Label price = new Label("Price: ");
		TextField sourceText = new TextField();
		TextField destinationText = new TextField();
		TextField priceText = new TextField();
		ChoiceBox<String> vehicleSelection = new ChoiceBox<String>();
		ChoiceBox<Integer> hours = new ChoiceBox<Integer>();
		ChoiceBox<Integer> minutes = new ChoiceBox<Integer>();
		ChoiceBox<Integer> numberOfStopsSelection = new ChoiceBox<Integer>();
		Button add = new Button("Finish");
		Button back = new Button("Back");

		vehicleSelection.getItems().addAll("Bus", "Minbus", "Car");
		for (int i = 0; i < 24; i++)
			hours.getItems().add(i);
		for (int i = 0; i < 60; i++)
			minutes.getItems().add(i);
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
		addTripGrid.add(hours, 1, 3);
		GridPane.setHalignment(hours, HPos.LEFT);
		addTripGrid.add(timeSep, 1, 3);
		GridPane.setHalignment(timeSep, HPos.CENTER);
		addTripGrid.add(minutes, 1, 3);
		GridPane.setHalignment(minutes, HPos.RIGHT);
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
		addTripGrid.add(back, 0, 7);
		GridPane.setHalignment(back, HPos.LEFT);
		addTripGrid.add(add, 0, 7);
		GridPane.setHalignment(add, HPos.RIGHT);

		addTrip = new Scene(addTripGrid, 600, 400);

		// actions
		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
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

}
