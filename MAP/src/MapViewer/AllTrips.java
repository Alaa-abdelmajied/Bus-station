package MapViewer;

import java.util.Observable;

import org.omg.CORBA.PUBLIC_MEMBER;

import MapLogic.Trip;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
	//TableView<Trip> tableView;
	ListView<String> listView;
	
	public AllTrips(Stage stage) {
		this.stage = stage;
	}

	public void prepareScene() {

		/*TableColumn<Trip, String> source = new TableColumn<Trip, String>("Source");
		source.setCellValueFactory(new PropertyValueFactory<Trip, String>("source"));
		source.setMinWidth(100);
		TableColumn<Trip, String> destination = new TableColumn<Trip, String>("Destination");
		source.setCellValueFactory(new PropertyValueFactory<Trip, String>("destination"));
		destination.setMinWidth(100);
		TableColumn<Trip, String> time = new TableColumn<Trip, String>("Time");
		source.setCellValueFactory(new PropertyValueFactory<Trip, String>("time"));
		time.setMinWidth(100);
		TableColumn<Trip, String> vehicle = new TableColumn<Trip, String>("Vehicle");
		source.setCellValueFactory(new PropertyValueFactory<Trip, String>("vehicle"));
		vehicle.setMinWidth(100);
		TableColumn<Trip, Integer> numberOfStops = new TableColumn<Trip, Integer>("Number Of Stops");
		source.setCellValueFactory(new PropertyValueFactory<Trip, String>("numberOfStops"));
		numberOfStops.setMinWidth(100);
		TableColumn<Trip, Double> ticketPrce = new TableColumn<Trip, Double>("Price");
		source.setCellValueFactory(new PropertyValueFactory<Trip, String>("ticketPrice"));
		ticketPrce.setMinWidth(100);

		tableView = new TableView<>();
		tableView.setItems(null);
		tableView.getColumns().add(source);
		tableView.getColumns().add(destination);
		tableView.getColumns().add(time);
		tableView.getColumns().add(vehicle);
		tableView.getColumns().add(numberOfStops);
		tableView.getColumns().add(ticketPrce);

		
		allTripsGrid.add(tableView, 0, 1);*/
		
		listView = new ListView<>();
		listView.setPrefSize(400, 200);
		Label info = new Label("Source  Destination  Time  Vehicle  Number of Stops  Price(EGP)");
		Button add = new Button("Add trip");
		Button delete = new Button("Delete trip");
		Button back = new Button("Back");
		
		GridPane allTripsGrid = new GridPane();
		
		allTripsGrid.add(info,0, 0);
		GridPane.setHalignment(info, HPos.LEFT);
		allTripsGrid.add(listView,0, 2);
		GridPane.setHalignment(listView, HPos.CENTER);
		allTripsGrid.add(add,0, 4);
		GridPane.setHalignment(add, HPos.LEFT);
		allTripsGrid.add(delete,1, 4);
		GridPane.setHalignment(delete, HPos.CENTER);
		allTripsGrid.add(back,2, 4);
		GridPane.setHalignment(back, HPos.RIGHT);

		
		alltrips = new Scene(allTripsGrid, 400, 300);
		
		
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

	public ListView<String> getListView() {
		return listView;
	}
	
	
}
