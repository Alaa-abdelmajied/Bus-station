package MapLogic;
import java.io.IOException;

public class Validate {

	private String username;
	private String password;
	private String[][] loginPassenger = new String[100][2];
	private String[][] loginDriver = new String[100][2];
	private String[][] loginManager = new String[100][2];
	private String type;
	private int accountType;
	private int counter = 0;
	private boolean isCorrect = false;
	FileReading loader = new FileReading();

	public void setType(String type) {
		this.type = type;
		try {
			loader.readLoginFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setLoginData() {
		if (type.equals("Passenger")) {
			this.loginPassenger = loader.getPassengerLogin();
		}

		if (type.equals("Employee")) {
			this.loginDriver = loader.getDriverLogin();
			this.loginManager = loader.getMangerLogin();
		}
	}

	public boolean loginValidation(String username, String password) {
		isCorrect = false;
		counter = 0;
		this.username = username;
		this.password = password;
		while (!isCorrect && counter < 100) {
			if (this.username.equals(loginPassenger[counter][0]) && this.password.equals(loginPassenger[counter][1])) {
				isCorrect = true;
				accountType = 0;
				return true;
			} else if (this.username.equals(loginDriver[counter][0]) && this.password.equals(loginDriver[counter][1])) {
				isCorrect = true;
				accountType = 1;
				return true;
			} else if (this.username.equals(loginManager[counter][0]) && this.password.equals(loginManager[counter][1])) {
				isCorrect = true;
				accountType = 2;
				return true;
			} else
				counter++;
		}
		return false;
	}

	public int getAccountType() {
		return accountType;
	}

}
