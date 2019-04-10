package MapViewer;

import javafx.scene.Scene;
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
		Label vehicle = new Label("Vehicle: ");
		Label numberOfStops = new Label("Number of stops: ");
		Label price = new Label("Price: ");
		TextField sourceText = new TextField();
		TextField destinationText = new TextField();
		TextField priceText = new TextField();
		ChoiceBox<String> vehicleSelection = new ChoiceBox<String>();
		vehicleSelection.getItems().addAll("Bus","Minbus","Car");
		//ChoiceBox<String>
		
		GridPane addTripGrid = new GridPane();
		
		/*addTripGrid.add(label, 0, 0);
		addTripGrid.add(source, 0, 1);
		addTripGrid.add(sourceText, 2, 1);
		addTripGrid.add(destinationText, 0, 2);
		addTripGrid.add(destinationText, 2, 2);
		addTripGrid.add(time, 0, 3);*/
		
		
		
		
	}

	public Scene getAddTrip() {
		return addTrip;
	}

	public void setAllTrips(AllTrips allTrips) {
		this.allTrips = allTrips;
	}
	
	
}
