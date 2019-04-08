package MapViewer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ConfirmationScene {

	Stage stage;
	Scene confirmationScene;
	BookingScene bookingScene;
	int seatNumber = 1;

	public ConfirmationScene(Stage stage) {
		this.stage = stage;

	}

	public void prepareScene() {

		Label source = new Label("Source: ");
		Label destination = new Label("Destination: ");
		Label price = new Label("Price: ");
		Label seats = new Label();
		Label seatsNum = new Label("No. of seats:");
		Label numOfSeats = new Label(" 1 ");
		Button addSeat = new Button("+");
		Button removeSeat = new Button("-");
		Button back = new Button("Back");
		Button book = new Button("Confirm your trip");

		GridPane confirmationGrid = new GridPane();
		confirmationGrid.add(source, 0, 0);
		GridPane.setHalignment(source, HPos.LEFT);
		confirmationGrid.add(destination, 0, 1);
		GridPane.setHalignment(destination, HPos.LEFT);
		confirmationGrid.add(price, 0, 2);
		GridPane.setHalignment(price, HPos.LEFT);
		confirmationGrid.add(seatsNum, 0, 3);
		GridPane.setHalignment(seatsNum, HPos.LEFT);
		confirmationGrid.add(removeSeat, 2, 3);
		GridPane.setHalignment(removeSeat, HPos.LEFT);
		confirmationGrid.add(numOfSeats, 3, 3);
		GridPane.setHalignment(numOfSeats, HPos.CENTER);
		confirmationGrid.add(addSeat, 4, 3);
		GridPane.setHalignment(addSeat, HPos.RIGHT);
		confirmationGrid.add(back, 0, 4);
		GridPane.setHalignment(back, HPos.CENTER);
		confirmationGrid.add(book, 1, 4);
		GridPane.setHalignment(book, HPos.CENTER);
		confirmationScene = new Scene(confirmationGrid, 500, 400);

		addSeat.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (seatNumber < 8)
					seatNumber++;
				numOfSeats.setText(" " + String.valueOf(seatNumber) + " ");

			}
		});

		removeSeat.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (seatNumber > 1)
					seatNumber--;
				numOfSeats.setText(" " + String.valueOf(seatNumber) + " ");

			}
		});

		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				stage.setScene(bookingScene.getBookingScene());
			}
		});

	}

	public Scene getConfirmationScene() {
		return confirmationScene;
	}

	public void setBookingScene(BookingScene bookingScene) {
		this.bookingScene = bookingScene;
	}
}
