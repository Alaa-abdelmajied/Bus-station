package MapViewer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class DriverProfile {

	Stage stage;
	Scene driverProfileScene;
	DriverMenu driverMenu;
	Label personalData = new Label();
	Label fName = new Label();
	Label lName = new Label();
	Label gender = new Label();
	Label number = new Label();

	public DriverProfile(Stage stage) {
		this.stage = stage;
	}

	public void prepareScene() {

		Button back = new Button("Back");
		Label space = new Label(" ");
		Label space2 = new Label(" ");
		GridPane driverProfileGrid = new GridPane();
		driverProfileGrid.add(personalData, 0, 0);
		GridPane.setHalignment(personalData, HPos.CENTER);
		driverProfileGrid.add(space, 0, 1);
		driverProfileGrid.add(fName, 0, 2);
		GridPane.setHalignment(fName, HPos.LEFT);
		driverProfileGrid.add(lName, 0, 3);
		GridPane.setHalignment(lName, HPos.LEFT);
		driverProfileGrid.add(gender, 0, 5);
		GridPane.setHalignment(gender, HPos.LEFT);
		driverProfileGrid.add(number, 0, 6);
		GridPane.setHalignment(number, HPos.LEFT);
		driverProfileGrid.add(space2, 0, 7);
		driverProfileGrid.add(back, 0, 8);
		GridPane.setHalignment(back, HPos.LEFT);

		driverProfileScene = new Scene(driverProfileGrid, 300, 300);
		// actions

		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				stage.setScene(driverMenu.getDriverScene());

			}
		});

	}

	public Scene getDriverProfileScene() {
		return driverProfileScene;
	}

	public void setDriverMenu(DriverMenu driverMenu) {
		this.driverMenu = driverMenu;
	}

	public void setPersonalData(String text) {
		this.personalData.setText(text);
		this.personalData.setFont(Font.font("Artistik", FontWeight.BOLD, 20));

	}

	public void setfName(String text) {
		this.fName.setText(text);
		this.fName.setFont(Font.font("Calibri", 15));
	}

	public void setlName(String text) {
		this.lName.setText(text);
		this.lName.setFont(Font.font("Calibri", 15));
	}

	public void setGender(String text) {
		this.gender.setText(text);
		this.gender.setFont(Font.font("Calibri", 15));
	}

	public void setNumber(String text) {
		this.number.setText(text);
		this.number.setFont(Font.font("Calibri", 15));
	}

}
