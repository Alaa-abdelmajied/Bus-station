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
		AssignedTrips assignedTrips = new AssignedTrips(primaryStage);

		loginForm.prepareScene();
		passengerMenu.prepareScene();
		driverMenu.prepareScene();
		managerMenu.prepareScene();
		bookingScene.prepareScene();
		allTrips.prepareScene();
		confirmationScene.prepareScene();
		assignedTrips.prepareScene();

		loginForm.setPassengerMenu(passengerMenu);
		loginForm.setDriverMenu(driverMenu);
		loginForm.setManagerMenu(managerMenu);
		passengerMenu.setBookingScene(bookingScene);
		passengerMenu.setLoginForm(loginForm);
		driverMenu.setLoginForm(loginForm);
		driverMenu.setAssignedTrips(assignedTrips);
		managerMenu.setLoginForm(loginForm);
		managerMenu.setAllTrips(allTrips);
		managerMenu.setPassengerMenu(passengerMenu);
		bookingScene.setPassengerMenu(passengerMenu);
		bookingScene.setConfirmationScene(confirmationScene);
		allTrips.setManagerMenu(managerMenu);
		confirmationScene.setBookingScene(bookingScene);
		assignedTrips.setDriverMenu(driverMenu);

		

		primaryStage.setScene(loginForm.getLoginForm());
		primaryStage.setTitle("MAP");
		primaryStage.show();

	}

}
