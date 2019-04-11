package MapViewer;

import java.io.IOException;

import MapLogic.PassengerReader;
import MapLogic.Validate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginForm {

	Stage stage;
	Scene loginForm;
	PassengerMenu passengerMenu;
	DriverMenu driverMenu;
	ManagerMenu managerMenu;
	Validate validate = new Validate();
	PassengerReader passenger = new PassengerReader();
	boolean showEmployee = false;
	boolean showPassenger = false;
	TextField userNameField = new TextField();
	PasswordField passwordField = new PasswordField();
	// CheckBox passengerCB = new CheckBox("Passenger");
	// CheckBox employeeCB = new CheckBox("Employee");
	// RadioButton passengerRB = new RadioButton("Passenger");
	// RadioButton empolyeeRB = new RadioButton("Employee");

	public LoginForm(Stage stage) {
		this.stage = stage;
	}

	public void prepareScene() {

		Label space = new Label("   ");
		Label space2 = new Label("   ");
		Label space3 = new Label("   ");
		Label space4 = new Label("   ");
		Button passenger = new Button("Passenger");
		Button employee = new Button("Employee");
		Button login = new Button("Login");
		Alert alert = new Alert(AlertType.WARNING);
		userNameField.setPromptText("username");
		passwordField.setPromptText("password");

		// GridPane.setHalignment(passengerRB, HPos.LEFT);
		// GridPane.setHalignment(empolyeeRB, HPos.RIGHT);

		GridPane.setHalignment(passenger, HPos.LEFT);
		GridPane.setHalignment(employee, HPos.RIGHT);
		GridPane.setHalignment(userNameField, HPos.CENTER);
		GridPane.setHalignment(passwordField, HPos.CENTER);
		GridPane.setHalignment(login, HPos.RIGHT);

		GridPane loginGrid = new GridPane();

		loginGrid.add(space, 0, 0);
		loginGrid.add(space2, 1, 1);
		loginGrid.add(userNameField, 1, 2);
		loginGrid.add(passwordField, 1, 3);
		loginGrid.add(login, 2, 3);
		loginGrid.add(space3, 1, 4);
		loginGrid.add(space4, 1, 5);
		// loginGrid.add(passengerRB, 0, 6);
		// loginGrid.add(empolyeeRB, 2, 6);
		loginGrid.add(passenger, 0, 6);
		loginGrid.add(employee, 2, 6);

		loginForm = new Scene(loginGrid, 360, 200);

		// actions

		/*
		 * passengerRB.setOnAction(new EventHandler<ActionEvent>() {
		 * 
		 * @Override public void handle(ActionEvent event) {
		 * 
		 * userNameField.setText(null); passwordField.setText(null);
		 * userNameField.setPromptText("Passenger's username");
		 * validate.setType("Passenger"); validate.setLoginData(); showPassenger = true;
		 * if (!passengerRB.isSelected()) { userNameField.setPromptText("username");
		 * passwordField.setPromptText("password"); } empolyeeRB.setSelected(false);
		 * 
		 * }
		 * 
		 * });
		 */

		/*
		 * empolyeeRB.setOnAction(new EventHandler<ActionEvent>() {
		 * 
		 * @Override public void handle(ActionEvent event) {
		 * 
		 * userNameField.setText(null); passwordField.setText(null);
		 * userNameField.setPromptText("Employee's username");
		 * validate.setType("Employee"); validate.setLoginData(); showEmployee = true;
		 * if (!passengerRB.isSelected()) { userNameField.setPromptText("username");
		 * passwordField.setPromptText("password"); } passengerRB.setSelected(false); }
		 * 
		 * });
		 */

		passenger.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				userNameField.setText(null);
				passwordField.setText(null);
				userNameField.setPromptText("Passenger's username");
				validate.setType("Passenger");
				validate.setLoginData();
				showPassenger = true;
			}

		});

		employee.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				userNameField.setText(null);
				passwordField.setText(null);
				userNameField.setPromptText("Employee's username");
				validate.setType("Employee");
				validate.setLoginData();
				showEmployee = true;
			}

		});

		login.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (showPassenger || showEmployee) {
					String username = userNameField.getText();
					String password = passwordField.getText();
					boolean loginVal = validate.loginValidation(username, password);
					if (loginVal) {
						if (validate.getAccountType() == 0) {
							stage.setScene(passengerMenu.getPassengerScene());
							passengerMenu.setPassengerLabel("Hello, " + userNameField.getText() + "!");
							try {
								if (LoginForm.this.passenger.vipCheck(userNameField.getText())) {
									passengerMenu.limo.setVisible(true);
									passengerMenu.becomeVip.setVisible(false);
								} else {
									passengerMenu.becomeVip.setVisible(true);
									passengerMenu.limo.setVisible(false);
								}
							} catch (IOException e) {
								e.printStackTrace();
							}
						} else if (validate.getAccountType() == 1) {
							stage.setScene(driverMenu.getDriverScene());
							driverMenu.driverReader.loadInfo();
							driverMenu.driverReader.setDriverFirstName(userNameField.getText());
							driverMenu.setDriverLabel("Hello, " + userNameField.getText() + "!");

						} else if (validate.getAccountType() == 2) {
							stage.setScene(managerMenu.getManagerScene());
							managerMenu.setManagerLabel("Hello, " + userNameField.getText() + "!");
						}
					} else {
						alert.setTitle("WARNING");
						alert.setHeaderText("");
						alert.setContentText("Invalid username or password!");
						alert.showAndWait();
					}
				} else {
					alert.setTitle("WARNING");
					alert.setHeaderText("");
					alert.setContentText("You must choose a login option. Please try again!");
					alert.showAndWait();

				}
			}
		});

	}

	public Scene getLoginForm() {
		return loginForm;
	}

	public void setPassengerMenu(PassengerMenu passengerMenu) {
		this.passengerMenu = passengerMenu;
	}

	public void setDriverMenu(DriverMenu driverMenu) {
		this.driverMenu = driverMenu;
	}

	public void setManagerMenu(ManagerMenu managerMenu) {
		this.managerMenu = managerMenu;
	}

	public void setUserNameField(String text) {
		this.userNameField.setText(text);
	}

	public void setPasswordField(String text) {
		this.passwordField.setText(text);
	}

	/*
	 * public void setPassengerRB(CheckBox passengerRB) {
	 * this.passengerRB.setSelected(false); }
	 */

	/*
	 * public void setEmployeeRB(CheckBox empolyeeRB) { // this.employeeCB =
	 * employeeCB; this.empolyeeRB.setSelected(false); }
	 */

}
