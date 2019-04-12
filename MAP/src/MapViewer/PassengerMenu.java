package MapViewer;

import java.io.IOException;

import MapLogic.FileWriterUtils;
import MapLogic.TripReader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PassengerMenu {

	Stage stage;
	Scene passengerScene;
	LoginForm loginForm;
	BookingScene bookingScene;
	YourTrips yourTripsScene;
	ConfirmationScene confirmationScene;
	TripReader trip = new TripReader();
	Label passengerLabel = new Label();
	Button becomeVip = new Button("Become a vip");
	Button limo = new Button("Book a limo");

	public PassengerMenu(Stage stage) {
		this.stage = stage;
	}

	public void prepareScene() {

		Button booking = new Button("Book a trip");
		Button trips = new Button("Your Trips");
		Button logoutPassenger = new Button("Logout");

		GridPane passengerGrid = new GridPane();
		passengerGrid.add(passengerLabel, 0, 0);
		GridPane.setHalignment(passengerLabel, HPos.CENTER);
		passengerGrid.add(booking, 0, 1);
		GridPane.setHalignment(booking, HPos.CENTER);
		passengerGrid.add(trips, 0, 2);
		GridPane.setHalignment(trips, HPos.CENTER);
		passengerGrid.add(becomeVip, 0, 3);
		GridPane.setHalignment(becomeVip, HPos.CENTER);
		passengerGrid.add(limo, 0, 3);
		GridPane.setHalignment(becomeVip, HPos.CENTER);
		passengerGrid.add(logoutPassenger, 0, 4);
		GridPane.setHalignment(logoutPassenger, HPos.CENTER);

		passengerScene = new Scene(passengerGrid, 250, 250);

		limo.setVisible(false);
		becomeVip.setVisible(false);

		// actions

		booking.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				trip.load();
				bookingScene.choiceBoxS.getItems().clear();
				bookingScene.choiceBoxD.getItems().clear();
				for (int i = 0; i < trip.getSource().size(); i++) {
					bookingScene.setChoiceBoxS(trip.getSource().get(i));
					bookingScene.setChoiceBoxD(trip.getDestination().get(i));
				}
				stage.setScene(bookingScene.getBookingScene());
			}
		});

		trips.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				trip.load();
				stage.setScene(yourTripsScene.getYourTripsScene());
			}
		});

		becomeVip.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Become a VIP");
				alert.setHeaderText("You made " + loginForm.passenger.getTripsNumber(loginForm.userNameField.getText())
						+ "/6 trips");
				alert.setContentText("Complete 6 rides to become a VIP.");
				alert.showAndWait();

			}
		});

		limo.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Book a limousine");
				alert.setHeaderText("");
				alert.setContentText("The limousine is on the way to you");
				alert.showAndWait();
				confirmationScene.getHistory().load();
				confirmationScene.getHistory().setName(loginForm.userNameField.getText());
				confirmationScene.getHistory().limoHistory();
				loginForm.getPassenger().addTripsNumber(loginForm.userNameField.getText());
				try {
					FileWriterUtils.writeHistoryTripFile(confirmationScene.getHistory().getHistory());
					FileWriterUtils.writeVipFile(loginForm.getPassenger().getPassengers());
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		});

		logoutPassenger.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				loginForm.setUserNameField(null);
				loginForm.setPasswordField(null);
				stage.setScene(loginForm.getLoginForm());

			}
		});

	}

	public Scene getPassengerScene() {
		return passengerScene;
	}

	public void setLoginForm(LoginForm loginForm) {
		this.loginForm = loginForm;
	}

	public void setBookingScene(BookingScene bookingScene) {
		this.bookingScene = bookingScene;
	}

	public void setYourTripsScene(YourTrips yourTripsScene) {
		this.yourTripsScene = yourTripsScene;
	}

	public TripReader getTrip() {
		return trip;
	}

	public void setPassengerLabel(String text) {
		this.passengerLabel.setText(text);
	}

	public void setConfirmationScene(ConfirmationScene confirmationScene) {
		this.confirmationScene = confirmationScene;
	}

}
