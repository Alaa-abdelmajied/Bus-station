package MapViewer;

import MapLogic.Tickets;
import MapLogic.Trip;
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

public class RoundTicketScene {

	Stage stage;
	Scene roundTicketScene;
	ConfirmationScene confirmationScene;
	Tickets tickets = new Tickets();

	TableView<Trip> tableView;

	public RoundTicketScene(Stage stage) {
		this.stage = stage;
	}

	public void prepareScene() {

		Button back = new Button("Back");
		Button select = new Button("Select");

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

		GridPane roundTicketGrid = new GridPane();
		roundTicketGrid.add(tableView, 0, 0);
		roundTicketGrid.add(back, 0, 1);
		GridPane.setHalignment(back, HPos.LEFT);
		roundTicketGrid.add(select, 0, 1);
		GridPane.setHalignment(select, HPos.RIGHT);

		roundTicketScene = new Scene(roundTicketGrid, 600, 400);

		select.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if(!tableView.getSelectionModel().isEmpty()) {
				stage.setScene(confirmationScene.getConfirmationScene());
				confirmationScene.getOneWay().setVisible(false);
				confirmationScene.getRound().setVisible(false);
				confirmationScene.getTicketType().setVisible(false);
				confirmationScene.setSource("Source: " + tableView.getSelectionModel().getSelectedItem().getSource());
				confirmationScene.setDestination(
						"Destination: " + tableView.getSelectionModel().getSelectedItem().getDestination());
				confirmationScene.setPrice("Price: "
						+ tickets.roundTicketPrice(tableView.getSelectionModel().getSelectedItem().getTicketPrice())
						+ " EGP");
				confirmationScene.getSeatsNum().setVisible(true);
				confirmationScene.getNumOfSeats().setVisible(true);
				confirmationScene.getAddSeat().setVisible(true);
				confirmationScene.getRemoveSeat().setVisible(true);
				confirmationScene.getBookRound().setVisible(true);
				confirmationScene.getBack().setVisible(false);
				confirmationScene.getBackRound().setVisible(true);
				confirmationScene.getNextRound().setVisible(false);
				confirmationScene.setOnewaycheck(true);
				confirmationScene.setRoundPrice(true);
				}else {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("WARNING");
					alert.setHeaderText("");
					alert.setContentText("Select a trip");
					alert.showAndWait();
				}

			}
		});

		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				stage.setScene(confirmationScene.getConfirmationScene());
			}
		});

	}

	public Scene getRoundTicketScene() {
		return roundTicketScene;
	}

	public void setConfirmationScene(ConfirmationScene confirmationScene) {
		this.confirmationScene = confirmationScene;
	}

	public TableView<Trip> getTableView() {
		return tableView;
	}

	public Tickets getTickets() {
		return tickets;
	}
	

}
