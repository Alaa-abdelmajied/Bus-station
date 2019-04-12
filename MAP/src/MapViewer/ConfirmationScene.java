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
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;

public class ConfirmationScene {

	Stage stage;
	Scene confirmationScene;
	BookingScene bookingScene;
	RoundTicketScene roundTicketScene;
	PassengerMenu passengerMenu;
	LoginForm loginForm;
	CurrentTripsReader currentTrips = new CurrentTripsReader();
	HistoryTripsReader history = new HistoryTripsReader();
	Label ticketType = new Label("Please choose your ticket type:");
	Button oneWay = new Button("One way ticket");
	Button round = new Button("Round ticket");
	int seatNumber = 1;
	Label source = new Label("Source: ");
	Label destination = new Label("Destination: ");
	Label price = new Label("Price: ");
	Label seatsNum = new Label("No. of seats:");
	Label numOfSeats = new Label(" 1 ");
	Button addSeat = new Button("+");
	Button removeSeat = new Button("-");
	Button book = new Button("Confirm your trip");
	Button back = new Button("Back");
	Button backRound = new Button("back");
	Button bookRound = new Button("Confirm your trip");
	Button nextRound = new Button("next");
	private final ObservableList<Trip> tripsData = FXCollections.observableArrayList();
	boolean onewaycheck = false, roundwaycheck = false, roundPrice = false;

	public ConfirmationScene(Stage stage) {
		this.stage = stage;

	}

	public void prepareScene() {

		seatsNum.setVisible(false);
		numOfSeats.setVisible(false);
		addSeat.setVisible(false);
		removeSeat.setVisible(false);
		book.setVisible(false);
		backRound.setVisible(false);
		bookRound.setVisible(false);
		nextRound.setVisible(false);

		GridPane confirmationGrid = new GridPane();

		confirmationGrid.add(ticketType, 0, 0);
		GridPane.setHalignment(ticketType, HPos.LEFT);
		confirmationGrid.add(oneWay, 1, 0);
		GridPane.setHalignment(oneWay, HPos.CENTER);
		confirmationGrid.add(round, 2, 0);
		GridPane.setHalignment(round, HPos.RIGHT);

		confirmationGrid.add(source, 0, 1);
		GridPane.setHalignment(source, HPos.LEFT);
		confirmationGrid.add(destination, 0, 2);
		GridPane.setHalignment(destination, HPos.LEFT);
		confirmationGrid.add(price, 0, 3);
		GridPane.setHalignment(price, HPos.LEFT);
		confirmationGrid.add(seatsNum, 0, 4);
		GridPane.setHalignment(seatsNum, HPos.LEFT);
		confirmationGrid.add(removeSeat, 1, 4);
		GridPane.setHalignment(removeSeat, HPos.LEFT);
		confirmationGrid.add(numOfSeats, 1, 4);
		GridPane.setHalignment(numOfSeats, HPos.CENTER);
		confirmationGrid.add(addSeat, 1, 4);
		GridPane.setHalignment(addSeat, HPos.RIGHT);
		confirmationGrid.add(back, 0, 5);
		GridPane.setHalignment(back, HPos.LEFT);
		confirmationGrid.add(backRound, 0, 5);
		GridPane.setHalignment(backRound, HPos.LEFT);
		confirmationGrid.add(book, 1, 5);
		GridPane.setHalignment(book, HPos.CENTER);
		confirmationGrid.add(bookRound, 1, 5);
		GridPane.setHalignment(bookRound, HPos.CENTER);
		confirmationGrid.add(nextRound, 1, 5);
		GridPane.setHalignment(nextRound, HPos.CENTER);

		confirmationScene = new Scene(confirmationGrid, 500, 400);

		oneWay.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				onewaycheck = true;
				roundwaycheck = false;

				setSource("Source: " + bookingScene.tableView.getSelectionModel().getSelectedItem().getSource());
				setDestination("Destination: "
						+ bookingScene.tableView.getSelectionModel().getSelectedItem().getDestination());
				setPrice("Price: " + bookingScene.tableView.getSelectionModel().getSelectedItem().getTicketPrice()
						+ " EGP");
				seatsNum.setVisible(true);
				numOfSeats.setVisible(true);
				addSeat.setVisible(true);
				removeSeat.setVisible(true);
				book.setVisible(true);
				nextRound.setVisible(false);
			}
		});

		round.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				onewaycheck = false;
				roundwaycheck = true;

				ArrayList<Trip> trips = new ArrayList<Trip>();
				trips = bookingScene.passengerMenu.getTrip().findRoundTrip(
						bookingScene.tableView.getSelectionModel().getSelectedItem().getDestination(),
						bookingScene.tableView.getSelectionModel().getSelectedItem().getSource(),
						bookingScene.tableView.getSelectionModel().getSelectedItem().getVehicle());
				tripsData.setAll(trips);
				roundTicketScene.getTableView().setItems(tripsData);
				setSource("Source: " + bookingScene.tableView.getSelectionModel().getSelectedItem().getSource());
				setDestination("Destination: "
						+ bookingScene.tableView.getSelectionModel().getSelectedItem().getDestination());
				setPrice("Round Trip");
				seatsNum.setVisible(true);
				numOfSeats.setVisible(true);
				addSeat.setVisible(true);
				removeSeat.setVisible(true);
				nextRound.setVisible(true);
				book.setVisible(false);
			}
		});

		addSeat.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (seatNumber < 4)
					seatNumber++;
				numOfSeats.setText(" " + String.valueOf(seatNumber) + " ");
				if (onewaycheck)
					price.setText("Price:  " + String.valueOf(seatNumber * bookingScene.getTicketPrice()) + " EGP");
				if (roundPrice)
					price.setText("Price:  "
							+ String.valueOf(seatNumber * roundTicketScene.getTickets().roundTicketPrice(
									roundTicketScene.tableView.getSelectionModel().getSelectedItem().getTicketPrice()))
							+ " EGP");
			}
		});

		removeSeat.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (seatNumber > 1)
					seatNumber--;
				numOfSeats.setText(" " + String.valueOf(seatNumber) + " ");
				if (onewaycheck)
					price.setText("Price:  " + String.valueOf(seatNumber * bookingScene.getTicketPrice()) + " EGP");
				if (roundPrice)
					price.setText("Price:  "
							+ String.valueOf(seatNumber * roundTicketScene.getTickets().roundTicketPrice(
									roundTicketScene.tableView.getSelectionModel().getSelectedItem().getTicketPrice()))
							+ " EGP");

			}
		});

		book.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (roundwaycheck || onewaycheck) {
					roundTicketScene.getTickets()
							.setSeatNum(passengerMenu.getTrip().getNumberOfSeats(
									bookingScene.tableView.getSelectionModel().getSelectedItem().getSource(),
									bookingScene.tableView.getSelectionModel().getSelectedItem().getDestination(),
									bookingScene.tableView.getSelectionModel().getSelectedItem().getVehicle()));
					if (roundTicketScene.getTickets().availableSeatsCheck(seatNumber)) {
						passengerMenu.getTrip().setNumberOfSeats(seatNumber);
						try {
							FileWriterUtils.writeTripFile(passengerMenu.getTrip().getTrips());
						} catch (IOException e) {
							e.printStackTrace();

						}
						currentTrips.load();
						for (int i = 0; i < seatNumber; i++) {
							currentTrips.confirmTrip(loginForm.userNameField.getText(),
									bookingScene.tableView.getSelectionModel().getSelectedItem().getSource(),
									bookingScene.tableView.getSelectionModel().getSelectedItem().getDestination(),
									bookingScene.tableView.getSelectionModel().getSelectedItem().getTime(),
									bookingScene.tableView.getSelectionModel().getSelectedItem().getVehicle(),
									bookingScene.tableView.getSelectionModel().getSelectedItem().getNumOfStops(),
									bookingScene.tableView.getSelectionModel().getSelectedItem().getTicketPrice());

							history.load();
							history.setName(loginForm.userNameField.getText());
							history.addHistroy(currentTrips.getCurrents());
							loginForm.getPassenger().addTripsNumber(loginForm.userNameField.getText());
						}
						try {
							FileWriterUtils.writeCurrentTripFile(currentTrips.getCurrents());
							FileWriterUtils.writeHistoryTripFile(history.getHistory());
							FileWriterUtils.writeVipFile(loginForm.getPassenger().getPassengers());
						} catch (IOException e) {
							e.printStackTrace();
						}
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Confirmation");
						alert.setHeaderText(null);
						alert.setContentText("The trip has been booked");
						alert.showAndWait();
						try {
							if (loginForm.getPassenger().vipCheck(loginForm.userNameField.getText())) {
								passengerMenu.limo.setVisible(true);
								passengerMenu.becomeVip.setVisible(false);
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
						stage.setScene(passengerMenu.getPassengerScene());
					} else {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("WARNING");
						alert.setHeaderText("");
						alert.setContentText("No seats left");
						alert.showAndWait();
					}
				} else {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("WARNING");
					alert.setHeaderText("");
					alert.setContentText("Select ticket type");
					alert.showAndWait();
				}
			}
		});

		nextRound.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				roundTicketScene.getTickets()
						.setSeatNum(passengerMenu.getTrip().getNumberOfSeats(
								bookingScene.tableView.getSelectionModel().getSelectedItem().getSource(),
								bookingScene.tableView.getSelectionModel().getSelectedItem().getDestination(),
								bookingScene.tableView.getSelectionModel().getSelectedItem().getVehicle()));
				if (roundTicketScene.getTickets().availableSeatsCheck(seatNumber)) {
					passengerMenu.getTrip().setNumberOfSeats(seatNumber);
					currentTrips.load();
					for (int i = 0; i <= seatNumber; i++) {
						currentTrips.confirmTrip(loginForm.userNameField.getText(),
								bookingScene.tableView.getSelectionModel().getSelectedItem().getSource(),
								bookingScene.tableView.getSelectionModel().getSelectedItem().getDestination(),
								bookingScene.tableView.getSelectionModel().getSelectedItem().getTime(),
								bookingScene.tableView.getSelectionModel().getSelectedItem().getVehicle(),
								bookingScene.tableView.getSelectionModel().getSelectedItem().getNumOfStops(),
								bookingScene.tableView.getSelectionModel().getSelectedItem().getTicketPrice());
						

						history.load();
						history.setName(loginForm.userNameField.getText());
						history.addHistroy(currentTrips.getCurrents());
						loginForm.getPassenger().addTripsNumber(loginForm.userNameField.getText());
					}

					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Confirmation");
					alert.setHeaderText(null);
					alert.setContentText("Select your round trip");
					alert.showAndWait();
					stage.setScene(roundTicketScene.getRoundTicketScene());
				} else {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("WARNING");
					alert.setHeaderText("");
					alert.setContentText("No seats left");
					alert.showAndWait();
				}

			}
		});

		bookRound.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				roundTicketScene.getTickets()
						.setSeatNum(passengerMenu.getTrip().getNumberOfSeats(
								roundTicketScene.tableView.getSelectionModel().getSelectedItem().getSource(),
								roundTicketScene.tableView.getSelectionModel().getSelectedItem().getDestination(),
								roundTicketScene.tableView.getSelectionModel().getSelectedItem().getVehicle()));
				if (roundTicketScene.getTickets().availableSeatsCheck(seatNumber)) {
					passengerMenu.getTrip().setNumberOfSeats(seatNumber);
					try {
						FileWriterUtils.writeTripFile(passengerMenu.getTrip().getTrips());
					} catch (IOException e) {
						e.printStackTrace();

					}
					currentTrips.load();
					for (int i = 0; i <= seatNumber; i++) {
						currentTrips.confirmTrip(loginForm.userNameField.getText(),
								roundTicketScene.tableView.getSelectionModel().getSelectedItem().getSource(),
								roundTicketScene.tableView.getSelectionModel().getSelectedItem().getDestination(),
								roundTicketScene.tableView.getSelectionModel().getSelectedItem().getTime(),
								roundTicketScene.tableView.getSelectionModel().getSelectedItem().getVehicle(),
								roundTicketScene.tableView.getSelectionModel().getSelectedItem().getNumOfStops(),
								roundTicketScene.getTickets().roundTicketPrice(roundTicketScene.tableView
										.getSelectionModel().getSelectedItem().getTicketPrice()));

						history.load();
						history.setName(loginForm.userNameField.getText());
						history.addHistroy(currentTrips.getCurrents());
						loginForm.getPassenger().addTripsNumber(loginForm.userNameField.getText());
					}
					try {
						FileWriterUtils.writeCurrentTripFile(currentTrips.getCurrents());
						FileWriterUtils.writeHistoryTripFile(history.getHistory());
						FileWriterUtils.writeVipFile(loginForm.getPassenger().getPassengers());
					} catch (IOException e) {
						e.printStackTrace();
					}
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Confirmation");
					alert.setHeaderText(null);
					alert.setContentText("The trip has been booked");
					alert.showAndWait();
					try {
						if (loginForm.getPassenger().vipCheck(loginForm.userNameField.getText())) {
							passengerMenu.limo.setVisible(true);
							passengerMenu.becomeVip.setVisible(false);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
					stage.setScene(passengerMenu.getPassengerScene());
				} else {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("WARNING");
					alert.setHeaderText("");
					alert.setContentText("No seats left");
					alert.showAndWait();
				}

			}
		});

		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				source.setText("Source: ");
				destination.setText("Destination: ");
				price.setText("Price: ");
				seatsNum.setVisible(false);
				numOfSeats.setVisible(false);
				addSeat.setVisible(false);
				removeSeat.setVisible(false);
				book.setVisible(false);
				nextRound.setVisible(false);
				numOfSeats.setText("1");
				bookingScene.tableView.getSelectionModel().clearSelection();
				stage.setScene(bookingScene.getBookingScene());
			}
		});

		backRound.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				stage.setScene(roundTicketScene.getRoundTicketScene());
				backRound.setVisible(false);
				back.setVisible(true);
				onewaycheck = false;
				roundPrice = false;
			}
		});
	}

	public Scene getConfirmationScene() {
		return confirmationScene;
	}

	public void setBookingScene(BookingScene bookingScene) {
		this.bookingScene = bookingScene;
	}

	public void setRoundTicketScene(RoundTicketScene roundTicketScene) {
		this.roundTicketScene = roundTicketScene;
	}

	public void setSource(String text) {
		this.source.setText(text);
	}

	public void setDestination(String text) {
		this.destination.setText(text);
	}

	public void setPrice(String text) {
		this.price.setText(text);
	}

	public Label getSource() {
		return source;
	}

	public Label getDestination() {
		return destination;
	}

	public Label getPrice() {
		return price;
	}

	public ObservableList<Trip> getTripsData() {
		return tripsData;
	}

	public Label getTicketType() {
		return ticketType;
	}

	public Button getOneWay() {
		return oneWay;
	}

	public Button getRound() {
		return round;
	}

	public Label getSeatsNum() {
		return seatsNum;
	}

	public Label getNumOfSeats() {
		return numOfSeats;
	}

	public Button getAddSeat() {
		return addSeat;
	}

	public Button getRemoveSeat() {
		return removeSeat;
	}

	public Button getBook() {
		return book;
	}

	public Button getBack() {
		return back;
	}

	public Button getBackRound() {
		return backRound;
	}

	public void setPassengerMenu(PassengerMenu passengerMenu) {
		this.passengerMenu = passengerMenu;
	}

	public void setLoginForm(LoginForm loginForm) {
		this.loginForm = loginForm;
	}

	public HistoryTripsReader getHistory() {
		return history;
	}

	public Button getBookRound() {
		return bookRound;
	}

	public Button getNextRound() {
		return nextRound;
	}

	public void setOnewaycheck(boolean onewaycheck) {
		this.onewaycheck = onewaycheck;
	}

	public void setRoundPrice(boolean roundPrice) {
		this.roundPrice = roundPrice;
	}

}
