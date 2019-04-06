package MapViewer;

import javafx.application.Application;
import javafx.stage.Stage;

public class MapViewer extends Application {

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

		loginForm.prepareScene();
		passengerMenu.prepareScene();
		driverMenu.prepareScene();
		managerMenu.prepareScene();
		bookingScene.prepareScene();
		allTrips.prepareScene();

		loginForm.setPassengerMenu(passengerMenu);
		loginForm.setDriverMenu(driverMenu);
		loginForm.setManagerMenu(managerMenu);
		passengerMenu.setBookingScene(bookingScene);
		passengerMenu.setLoginForm(loginForm);
		driverMenu.setLoginForm(loginForm);
		managerMenu.setLoginForm(loginForm);
		managerMenu.setAllTrips(allTrips);
		bookingScene.setPassengerMenu(passengerMenu);
		allTrips.setManagerMenu(managerMenu);

		primaryStage.setScene(loginForm.getLoginForm());
		primaryStage.setTitle("MAP");
		primaryStage.show();

	}

}
