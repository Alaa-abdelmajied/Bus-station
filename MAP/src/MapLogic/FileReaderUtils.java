package MapLogic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.print.attribute.standard.MediaSize.JIS;

public class FileReaderUtils {

	private String[][] passengerLogin = new String[100][2];
	private String[][] mangerLogin = new String[100][2];
	private String[][] driverLogin = new String[100][2];

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
			if (stringTokenizer.hasMoreTokens()) {
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
		String source = null, destination = null, vehicle = null, time = null;
		double ticketPrice = 0.0;
		int numberOfStops = 0, numberOfSeats = 0;
		while (bufferedReader.ready()) {
			line = bufferedReader.readLine();
			StringTokenizer stringTokenizer = new StringTokenizer(line, ":,");
			if (stringTokenizer.countTokens() > 0) {
				source = stringTokenizer.nextToken();
				destination = stringTokenizer.nextToken();
				time = stringTokenizer.nextToken();
				vehicle = stringTokenizer.nextToken();
				numberOfStops = Integer.parseInt(stringTokenizer.nextToken());
				ticketPrice = Double.parseDouble(stringTokenizer.nextToken());
				numberOfSeats = Integer.parseInt(stringTokenizer.nextToken());
				trips.add(new Trip(source, destination, vehicle, numberOfStops, time, ticketPrice, numberOfSeats));
			}
		}
		return trips;
	}

	public static ArrayList<Passenger> readVipFile() throws IOException {

		File file = new File("vipPassengers");

		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		ArrayList<Passenger> passengers = new ArrayList<Passenger>();
		String passengerName;
		int numberOfTrips;
		String line;
		while (bufferedReader.ready()) {
			line = bufferedReader.readLine();
			StringTokenizer stringTokenizer = new StringTokenizer(line, ",");
			if (stringTokenizer.hasMoreTokens()) {
				passengerName = stringTokenizer.nextToken();
				numberOfTrips = Integer.parseInt(stringTokenizer.nextToken());
				passengers.add(new Passenger(passengerName, numberOfTrips));
			}
		}
		return passengers;
	}

	public static ArrayList<Driver> readDriverFile() throws IOException {

		String driverFirstName, driverLastName, driverGender, driverNumber;

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
				driverFirstName = stringTokenizer.nextToken();
				driverLastName = stringTokenizer.nextToken();
				driverGender = stringTokenizer.nextToken();
				driverNumber = stringTokenizer.nextToken();
				while (stringTokenizer.hasMoreTokens()) {

					assignedTrips.add(stringTokenizer.nextToken());
				}
				driverInfo.add(new Driver(driverFirstName, driverLastName, driverGender, driverNumber, assignedTrips));
			}
		}
		return driverInfo;
	}

	public static ArrayList<History> readHistoryTripsFile() throws IOException {

		String passengerName = null, source = null, destination = null, vehicle = null, time = null;
		double ticketPrice = 0.0;
		int numberOfStops = 0;
		ArrayList<Trip> trips = new ArrayList<Trip>();
		ArrayList<History> histories = new ArrayList<History>();

		File file = new File("HistoryTrips");

		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line;
		while (bufferedReader.ready()) {
			line = bufferedReader.readLine();
			StringTokenizer stringTokenizer = new StringTokenizer(line, ",");
			if (stringTokenizer.hasMoreTokens()) {
				passengerName = stringTokenizer.nextToken();
				source = stringTokenizer.nextToken();
				destination = stringTokenizer.nextToken();
				time = stringTokenizer.nextToken();
				vehicle = stringTokenizer.nextToken();
				numberOfStops = Integer.parseInt(stringTokenizer.nextToken());
				ticketPrice = Double.parseDouble(stringTokenizer.nextToken());
				trips.add(new Trip(source, destination, vehicle, numberOfStops, time, ticketPrice));
				while (stringTokenizer.hasMoreTokens()) {
					passengerName = stringTokenizer.nextToken();
					source = stringTokenizer.nextToken();
					destination = stringTokenizer.nextToken();
					time = stringTokenizer.nextToken();
					vehicle = stringTokenizer.nextToken();
					numberOfStops = Integer.parseInt(stringTokenizer.nextToken());
					ticketPrice = Double.parseDouble(stringTokenizer.nextToken());
					trips.add(new Trip(source, destination, vehicle, numberOfStops, time, ticketPrice));
				}
				histories.add(new History(passengerName, trips));
			}
		}
		return histories;
	}
	
	public static ArrayList<Current> readCurrentTripsFile() throws IOException {

		String passengerName = null, source = null, destination = null, vehicle = null, time = null;
		double ticketPrice = 0.0;
		int numberOfStops = 0;
		ArrayList<Trip> trips = new ArrayList<Trip>();
		ArrayList<Current> currents = new ArrayList<Current>();

		File file = new File("CurrentTrips");

		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line;
		while (bufferedReader.ready()) {
			line = bufferedReader.readLine();
			StringTokenizer stringTokenizer = new StringTokenizer(line, ",");
			if (stringTokenizer.hasMoreTokens()) {
				passengerName = stringTokenizer.nextToken();
				source = stringTokenizer.nextToken();
				destination = stringTokenizer.nextToken();
				time = stringTokenizer.nextToken();
				vehicle = stringTokenizer.nextToken();
				numberOfStops = Integer.parseInt(stringTokenizer.nextToken());
				ticketPrice = Double.parseDouble(stringTokenizer.nextToken());
				trips.add(new Trip(source, destination, vehicle, numberOfStops, time, ticketPrice));
				while (stringTokenizer.hasMoreTokens()) {
					passengerName = stringTokenizer.nextToken();
					source = stringTokenizer.nextToken();
					destination = stringTokenizer.nextToken();
					time = stringTokenizer.nextToken();
					vehicle = stringTokenizer.nextToken();
					numberOfStops = Integer.parseInt(stringTokenizer.nextToken());
					ticketPrice = Double.parseDouble(stringTokenizer.nextToken());
					trips.add(new Trip(source, destination, vehicle, numberOfStops, time, ticketPrice));
				}
				currents.add(new Current(passengerName, trips));
			}
		}
		return currents;
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

}
