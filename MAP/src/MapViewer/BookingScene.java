package MapViewer;

import java.util.ArrayList;

import MapLogic.Trip;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
	ConfirmationScene confirmationScene;
	 ListView<String> listView;
	//TableView<Trips> tableView;
	ChoiceBox<String> choiceBoxS = new ChoiceBox<String>();
	ChoiceBox<String> choiceBoxD = new ChoiceBox<String>();
	ArrayList<String> findTrip = new ArrayList<>();

	public BookingScene(Stage stage) {
		this.stage = stage;
	}

	public void prepareScene() {

		Label sourceLabel = new Label("Choose your source:");
		Label destinationLabel = new Label("Choose your destination:");
		Label info = new Label("Source  Destination  Time  Vehicle  Number of Stops  Price(EGP)");
		Button search = new Button("Search");
		Button confirm = new Button("Confirm");
		Button back = new Button("Back");


		confirm.setVisible(false);
		info.setVisible(false);
		
		//tableView.setEditable(true);
		/*TableColumn<Trips,String> source = new TableColumn<Trips, String>("Source");
		source.setCellValueFactory(new PropertyValueFactory<>("source"));
		source.setMinWidth(100);
		TableColumn<Trips,String> destination = new TableColumn<Trips, String>("Destination");
		source.setCellValueFactory(new PropertyValueFactory<>("destination"));
		destination.setMinWidth(100);
		TableColumn<Trips,String> time = new TableColumn<Trips, String>("Time");
		source.setCellValueFactory(new PropertyValueFactory<>("time"));
		time.setMinWidth(100);
		TableColumn<Trips,String> vehicle = new TableColumn<Trips, String>("Vehicle");
		source.setCellValueFactory(new PropertyValueFactory<>("vehicle"));
		vehicle.setMinWidth(100);
		TableColumn<Trips,Integer> numberOfStops = new TableColumn<Trips,Integer>("Number Of Stops");
		source.setCellValueFactory(new PropertyValueFactory<>("numberOfStops"));
		numberOfStops.setMinWidth(100);
		TableColumn<Trips,Double> ticketPrce = new TableColumn<Trips, Double>("Price");
		source.setCellValueFactory(new PropertyValueFactory<>("ticketPrice"));
		ticketPrce.setMinWidth(100);*/
		
		/*tableView = new TableView<>();
		tableView.setItems(null);
		tableView.getColumns().add(source);
		tableView.getColumns().add(destination);
		tableView.getColumns().add(time);
		tableView.getColumns().add(vehicle);
		tableView.getColumns().add(numberOfStops);
		tableView.getColumns().add(ticketPrce);*/
		
		listView = new ListView<>();
		listView.setVisible(false);
		listView.setPrefSize(500, 200);

		GridPane bookingGrid = new GridPane();
		bookingGrid.add(sourceLabel, 0, 0);
		bookingGrid.add(choiceBoxS, 0, 1);
		bookingGrid.add(destinationLabel, 0, 2);
		bookingGrid.add(choiceBoxD, 0, 3);
		bookingGrid.add(search, 0, 4);
		GridPane.setHalignment(search, HPos.RIGHT);
		bookingGrid.add(info, 0, 5);
		bookingGrid.add(listView, 0, 6);
		bookingGrid.add(confirm, 0, 7);
		GridPane.setHalignment(confirm, HPos.RIGHT);
		bookingGrid.add(back, 0, 8);
		GridPane.setHalignment(back, HPos.RIGHT);
		bookingScene = new Scene(bookingGrid, 500, 400);

		// actions

		search.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String sourceSearch = choiceBoxS.getValue();
				String destination = choiceBoxD.getValue();
				listView.getItems().clear();
				findTrip = passengerMenu.getTrip().findTrip(sourceSearch, destination);
				//tableView.getColumns().add(source);
				//ArrayList<String> source1 = passengerMenu.getTrip().getSource();
				for(int i = 0; i < findTrip.size();i++)
					listView.getItems().add(findTrip.get(i));
					//tableView.getItems().add(new);
					
				confirm.setVisible(true);
				info.setVisible(true);
				listView.setVisible(true);

			}

		});
		
		confirm.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				stage.setScene(confirmationScene.getConfirmationScene());
				
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

	public void setConfirmationScene(ConfirmationScene confirmationScene) {
		this.confirmationScene = confirmationScene;
	}

}
