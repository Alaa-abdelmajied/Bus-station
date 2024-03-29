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
		ManagerAssignedTrips managerAssignedTrips = new ManagerAssignedTrips(primaryStage);

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
		managerAssignedTrips.prepareScene();

		loginForm.setPassengerMenu(passengerMenu);
		loginForm.setDriverMenu(driverMenu);
		loginForm.setManagerMenu(managerMenu);
		passengerMenu.setBookingScene(bookingScene);
		passengerMenu.setLoginForm(loginForm);
		passengerMenu.setConfirmationScene(confirmationScene);
		driverMenu.setLoginForm(loginForm);
		driverMenu.setAssignedTrips(assignedTrips);
		driverMenu.setPassengerMenu(passengerMenu);
		managerMenu.setLoginForm(loginForm);
		managerMenu.setAllTrips(allTrips);
		managerMenu.setPassengerMenu(passengerMenu);
		managerMenu.setManagerAssignedTrips(managerAssignedTrips);
		managerMenu.setDriverMenu(driverMenu);
		bookingScene.setPassengerMenu(passengerMenu);
		bookingScene.setConfirmationScene(confirmationScene);
		allTrips.setManagerMenu(managerMenu);
		allTrips.setAddTrip(addTrip);
		allTrips.setPassengerMenu(passengerMenu);
		allTrips.setConfirmationScene(confirmationScene);
		confirmationScene.setBookingScene(bookingScene);
		confirmationScene.setRoundTicketScene(roundTicketScene);
		confirmationScene.setLoginForm(loginForm);
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
		yourTripsScene.setConfirmationScene(confirmationScene);
		managerAssignedTrips.setManagerMenu(managerMenu);
		managerAssignedTrips.setPassengerMenu(passengerMenu);
		managerAssignedTrips.setDriverMenu(driverMenu);



		primaryStage.setScene(loginForm.getLoginForm());
		primaryStage.setTitle("MAP");
		primaryStage.show();

	}

}
