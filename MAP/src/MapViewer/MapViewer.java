package MapViewer;

import MapLogic.TripReader;
import javafx.application.Application;
import javafx.stage.Stage;

public class MapViewer extends Application {

	TripReader trip = new TripReader();

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {

		LoginForm loginForm = new LoginForm(primaryStage);
		PassengerMenu passengerMenu = new PassengerMenu(primaryStage);
		DriverMenu driverMenu = new DriverMenu(primaryStage);
		ManagerMenu managerMenu = new ManagerMenu(primaryStage);
		BookingScene bookingScene = new BookingScene(primaryStage);
		AllTrips allTrips = new AllTrips(primaryStage);
		ConfirmationScene confirmationScene = new ConfirmationScene(primaryStage);
		DriverProfile driverProfile = new DriverProfile(primaryStage);
		AssignedTrips assignedTrips = new AssignedTrips(primaryStage);
		RoundTicketScene roundTicketScene = new RoundTicketScene(primaryStage);
		AddTrip addTrip = new AddTrip(primaryStage);
		YourTrips yourTripsScene = new YourTrips(primaryStage);
		CurrentTripsTab currentTripsScene = new CurrentTripsTab(primaryStage);
		HistoryTab historyTabScene = new HistoryTab(primaryStage);

		loginForm.prepareScene();
		passengerMenu.prepareScene();
		driverMenu.prepareScene();
		managerMenu.prepareScene();
		bookingScene.prepareScene();
		allTrips.prepareScene();
		confirmationScene.prepareScene();
		assignedTrips.prepareScene();
		driverProfile.prepareScene();
		roundTicketScene.prepareScene();
		addTrip.prepareScene();
		yourTripsScene.prepareScene();
		currentTripsScene.prepareScene();
		historyTabScene.prepareScene();

		loginForm.setPassengerMenu(passengerMenu);
		loginForm.setDriverMenu(driverMenu);
		loginForm.setManagerMenu(managerMenu);
		passengerMenu.setBookingScene(bookingScene);
		passengerMenu.setLoginForm(loginForm);
		driverMenu.setLoginForm(loginForm);
		driverMenu.setAssignedTrips(assignedTrips);
		driverMenu.setPassengerMenu(passengerMenu);
		managerMenu.setLoginForm(loginForm);
		managerMenu.setAllTrips(allTrips);
		managerMenu.setPassengerMenu(passengerMenu);
		bookingScene.setPassengerMenu(passengerMenu);
		bookingScene.setConfirmationScene(confirmationScene);
		allTrips.setManagerMenu(managerMenu);
		allTrips.setAddTrip(addTrip);
		allTrips.setPassengerMenu(passengerMenu);
		confirmationScene.setBookingScene(bookingScene);
		confirmationScene.setRoundTicketScene(roundTicketScene);
		assignedTrips.setDriverMenu(driverMenu);
		roundTicketScene.setConfirmationScene(confirmationScene);
		addTrip.setAllTrips(allTrips);
		addTrip.setPassengerMenu(passengerMenu);
		addTrip.setManagerMenu(managerMenu);
		confirmationScene.setPassengerMenu(passengerMenu);
		driverMenu.setDriverProfile(driverProfile);
		driverProfile.setDriverMenu(driverMenu);
		passengerMenu.setYourTripsScene(yourTripsScene);
		yourTripsScene.setPassengerMenu(passengerMenu);
		yourTripsScene.setLoginForm(loginForm);

		primaryStage.setScene(loginForm.getLoginForm());
		primaryStage.setTitle("MAP");
		primaryStage.show();

	}

}
