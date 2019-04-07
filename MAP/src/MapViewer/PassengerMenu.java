package MapViewer;

import MapLogic.Trip;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PassengerMenu {

	Stage stage;
	Scene passengerScene;
	LoginForm loginForm;
	BookingScene bookingScene;
	Trip trip = new Trip();
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

		passengerScene = new Scene(passengerGrid, 300, 300);
		
		limo.setVisible(false);
		becomeVip.setVisible(false);

		// actions

		booking.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				trip.loadTrips();
				for (int i = 0; i < trip.getSource().size(); i++) {
					bookingScene.setChoiceBoxS(trip.getSource().get(i));
					bookingScene.setChoiceBoxD(trip.getDestination().get(i));
				}
				
				stage.setScene(bookingScene.getBookingScene());
			}
		});

		becomeVip.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
			}
		});
		
		limo.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
			}
		});
		
		logoutPassenger.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				loginForm.setUserNameField("");
				loginForm.setPasswordField("");
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

	public Trip getTrip() {
		return trip;
	}

	public void setPassengerLabel(String text) {
		this.passengerLabel.setText(text);
	}

	public void setVip(String text) {
		this.vip.setText(text);
	}
	
	
}
