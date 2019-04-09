package MapViewer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AssignedTrips {

	Stage stage;
	Scene assignedTripsScene;
	DriverMenu driverMenu;
	private ListView<String> listView;

	public AssignedTrips(Stage stage) {
		this.stage = stage;
	}

	public void prepareScene() {

		listView = new ListView<>();
		listView.setPrefSize(500, 200);
		Button backToDriver = new Button("Back");

		GridPane assignedTripsGrid = new GridPane();

		assignedTripsGrid.add(listView, 0, 0);
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

	public void setListView(String text) {
		this.listView.getItems().add(text);
	}
	
	public void clearListView() {
		this.listView.getItems().clear();
	}

}
