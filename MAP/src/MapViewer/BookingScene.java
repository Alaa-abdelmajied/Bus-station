package MapViewer;

import java.util.ArrayList;

import MapLogic.Trip;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BookingScene {

	Stage stage;
	Scene bookingScene;
	PassengerMenu passengerMenu;
	//ListView<String> listView;
	TableView<Trip> tableView;
	ChoiceBox<String> choiceBoxS = new ChoiceBox<String>();
	ChoiceBox<String> choiceBoxD = new ChoiceBox<String>();

	public BookingScene(Stage stage) {
		this.stage = stage;
	}

	public void prepareScene() {

		Label sourceLabel = new Label("Choose your source:");
		Label destinationLabel = new Label("Choose your destination:");
		Label space5 = new Label("");
		Button search = new Button("Search");
		Button back = new Button("Back");
		
		//tableView.setEditable(true);
		TableColumn<Trip,String> source = new TableColumn<Trip, String>("Source");
		source.setCellValueFactory(new PropertyValueFactory<>("source"));
		source.setMinWidth(100);
		TableColumn<Trip,String> destination = new TableColumn<Trip, String>("Destination");
		source.setCellValueFactory(new PropertyValueFactory<>("destination"));
		destination.setMinWidth(100);
		TableColumn<Trip,String> time = new TableColumn<Trip, String>("Time");
		source.setCellValueFactory(new PropertyValueFactory<>("time"));
		time.setMinWidth(100);
		TableColumn<Trip,String> vehicle = new TableColumn<Trip, String>("Vehicle");
		source.setCellValueFactory(new PropertyValueFactory<>("vehicle"));
		vehicle.setMinWidth(100);
		TableColumn<Trip,Integer> numberOfStops = new TableColumn<Trip,Integer>("Number Of Stops");
		source.setCellValueFactory(new PropertyValueFactory<>("numberOfStops"));
		numberOfStops.setMinWidth(100);
		TableColumn<Trip,Double> ticketPrce = new TableColumn<Trip, Double>("Price");
		source.setCellValueFactory(new PropertyValueFactory<>("ticketPrice"));
		ticketPrce.setMinWidth(100);
		
		tableView = new TableView<>();
		tableView.setItems(null);
		tableView.getColumns().add(source);
		tableView.getColumns().add(destination);
		tableView.getColumns().add(time);
		tableView.getColumns().add(vehicle);
		tableView.getColumns().add(numberOfStops);
		tableView.getColumns().add(ticketPrce);
		
		//listView = new ListView<>();
		//listView.setVisible(false);
		//listView.setPrefSize(500, 200);

		GridPane bookingGrid = new GridPane();
		bookingGrid.add(sourceLabel, 0, 0);
		bookingGrid.add(choiceBoxS, 0, 1);
		bookingGrid.add(destinationLabel, 0, 2);
		bookingGrid.add(choiceBoxD, 0, 3);
		bookingGrid.add(search, 0, 4);
		GridPane.setHalignment(search, HPos.RIGHT);
		bookingGrid.add(space5, 0, 5);
		bookingGrid.add(tableView, 0, 6);
		bookingGrid.add(back, 0, 7);
		GridPane.setHalignment(back, HPos.RIGHT);
		bookingScene = new Scene(bookingGrid, 500, 400);

		// actions

		search.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String sourceSearch = choiceBoxS.getValue();
				String destination = choiceBoxD.getValue();
				//listView.getItems().clear();
				//ArrayList<String> findTrip = passengerMenu.getTrip().findTrip(source, destination);
				//ArrayList<String> source1 = passengerMenu.getTrip().getSource();
				//for (int i = 0; i < source1.size(); i++)
					//tableView.getItems().add(new );
					//listView.getItems().add(findTrip.get(i));

				//listView.setVisible(true);

			}

		});

		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
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

}
