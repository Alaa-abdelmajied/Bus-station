package MapViewer;

import java.util.Observable;

import org.omg.CORBA.PUBLIC_MEMBER;

import MapLogic.Trip;
import javafx.scene.Scene;
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
		
		TableColumn<Trip,String> source = new TableColumn<Trip, String>("Source");
		source.setCellValueFactory(new PropertyValueFactory<Trip, String>("source"));
		source.setMinWidth(100);
		TableColumn<Trip,String> destination = new TableColumn<Trip, String>("Destination");
		source.setCellValueFactory(new PropertyValueFactory<Trip, String>("destination"));
		destination.setMinWidth(100);
		TableColumn<Trip,String> time = new TableColumn<Trip, String>("Time");
		source.setCellValueFactory(new PropertyValueFactory<Trip, String>("time"));
		time.setMinWidth(100);
		TableColumn<Trip,String> vehicle = new TableColumn<Trip, String>("Vehicle");
		source.setCellValueFactory(new PropertyValueFactory<Trip, String>("vehicle"));
		vehicle.setMinWidth(100);
		TableColumn<Trip,Integer> numberOfStops = new TableColumn<Trip,Integer>("Number Of Stops");
		source.setCellValueFactory(new PropertyValueFactory<Trip, String>("numberOfStops"));
		numberOfStops.setMinWidth(100);
		TableColumn<Trip,Double> ticketPrce = new TableColumn<Trip, Double>("Price");
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
		
		GridPane allTripsGrid = new GridPane();
		allTripsGrid.add(tableView, 0, 1);
		
		alltrips = new Scene(allTripsGrid,600,400);
		
	}
	

	public Scene getAlltrips() {
		return alltrips;
	}

	public void setManagerMenu(ManagerMenu managerMenu) {
		this.managerMenu = managerMenu;
	}


}
