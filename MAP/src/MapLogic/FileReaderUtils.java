package MapLogic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FileReaderUtils {

	private String[][] passengerLogin = new String[100][2];
	private String[][] mangerLogin = new String[100][2];
	private String[][] driverLogin = new String[100][2];
	private ArrayList<String> passengerName = new ArrayList<String>();
	private ArrayList<Integer> numberOfTrips = new ArrayList<Integer>();

	public void readLoginFile() throws IOException {

		int driverCounter = 0;
		int passengerCounter = 0;
		int managerCounter = 0;
		String accountType;

		File file = new File("login.txt");

		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line;
		while (bufferedReader.ready()) {
			line = bufferedReader.readLine();
			StringTokenizer stringTokenizer = new StringTokenizer(line, ",");
			while (stringTokenizer.hasMoreTokens()) {
				accountType = stringTokenizer.nextToken();
				if (accountType.equals("Manager") || accountType.equals("Driver")) {
					if (accountType.equals("Driver")) {
						driverLogin[driverCounter][0] = stringTokenizer.nextToken();
						driverLogin[driverCounter][1] = stringTokenizer.nextToken();
						driverCounter++;
					} else if (accountType.equals("Manager")) {
						mangerLogin[managerCounter][0] = stringTokenizer.nextToken();
						mangerLogin[managerCounter][1] = stringTokenizer.nextToken();
						managerCounter++;
					}
				} else if (accountType.equals("Passenger")) {
					passengerLogin[passengerCounter][0] = stringTokenizer.nextToken();
					passengerLogin[passengerCounter][1] = stringTokenizer.nextToken();
					passengerCounter++;
				}
			}
		}
	}

	public static ArrayList<Trip> readTripFile() throws IOException {

		File file = new File("trips.txt");

		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		ArrayList<Trip> trips = new ArrayList<Trip>();
		String line;
		String source = null, destination = null, vehicle = null;
		double time = 0.0, ticketPrice = 0.0;
		int numberOfStops = 0;
		while (bufferedReader.ready()) {
			line = bufferedReader.readLine();
			StringTokenizer stringTokenizer = new StringTokenizer(line, ":,");
			if (stringTokenizer.countTokens() > 0) {
				source = stringTokenizer.nextToken();
				destination = stringTokenizer.nextToken();
				time = Double.parseDouble(stringTokenizer.nextToken());
				vehicle = stringTokenizer.nextToken();
				numberOfStops = Integer.parseInt(stringTokenizer.nextToken());
				ticketPrice = Double.parseDouble(stringTokenizer.nextToken());
				trips.add(new Trip(source, destination, vehicle, numberOfStops, time, ticketPrice));
			}
		}
		return trips;
	}

	public void readVipFile() throws IOException {

		File file = new File("vipPassengers");

		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line;
		while (bufferedReader.ready()) {
			line = bufferedReader.readLine();
			StringTokenizer stringTokenizer = new StringTokenizer(line, ",");
			while (stringTokenizer.hasMoreTokens()) {
				passengerName.add(stringTokenizer.nextToken());
				numberOfTrips.add(Integer.parseInt(stringTokenizer.nextToken()));
			}
		}
	}

	public static ArrayList<Driver> readDriverFile() throws IOException {

		String driverName, driverGender;
		int driverNumber;
		
		ArrayList<Driver> driverInfo = new ArrayList<Driver>();

		File file = new File("DriverFile");

		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line;
		while (bufferedReader.ready()) {
			ArrayList<String> assignedTrips = new ArrayList<String>();
			line = bufferedReader.readLine();
			StringTokenizer stringTokenizer = new StringTokenizer(line, ",");
			if (stringTokenizer.hasMoreTokens()) {
				driverName = stringTokenizer.nextToken();
				driverGender = stringTokenizer.nextToken();
				driverNumber = Integer.parseInt(stringTokenizer.nextToken());
				while (stringTokenizer.hasMoreTokens()) {

					assignedTrips.add(stringTokenizer.nextToken());
				}
				driverInfo.add(new Driver(driverName, driverGender, driverNumber, assignedTrips));
			}
		}
		return driverInfo;
	}

	public String[][] getPassengerLogin() {
		return passengerLogin;
	}

	public String[][] getMangerLogin() {
		return mangerLogin;
	}

	public String[][] getDriverLogin() {
		return driverLogin;
	}

	public ArrayList<String> getPassengerName() {
		return passengerName;
	}

	public ArrayList<Integer> getNumberOfTrips() {
		return numberOfTrips;
	}

}
