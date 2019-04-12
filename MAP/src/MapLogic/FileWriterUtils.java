package MapLogic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileWriterUtils {

	public static void writeTripFile(ArrayList<Trip> trips) throws IOException {

		ArrayList<Trip> trip = new ArrayList<Trip>();
		trip.addAll(trips);
		BufferedWriter writer = new BufferedWriter(new FileWriter("trips"));
		for (int i = 0; i < trip.size(); i++) {
			if (trip.get(i).getDriverName() == null) {
				writer.write(trip.get(i).getSource() + "," + trip.get(i).getDestination() + "," + trip.get(i).getTime()
						+ "," + trip.get(i).getVehicle() + "," + trip.get(i).getNumOfStops() + ","
						+ trip.get(i).getTicketPrice() + "," + trip.get(i).getNumberOfSeats() + "\n");
			} else {
				writer.write(trip.get(i).getSource() + "," + trip.get(i).getDestination() + "," + trip.get(i).getTime()
						+ "," + trip.get(i).getVehicle() + "," + trip.get(i).getNumOfStops() + ","
						+ trip.get(i).getTicketPrice() + "," + trip.get(i).getNumberOfSeats() + ","
						+ trip.get(i).getDriverName() + "\n");
			}
		}
		writer.close();
	}

	public static void writeVipFile(ArrayList<Passenger> passengers) throws IOException {

		ArrayList<Passenger> passenger = new ArrayList<Passenger>();
		passenger.addAll(passengers);
		BufferedWriter writer = new BufferedWriter(new FileWriter("vipPassengers"));
		for (int i = 0; i < passenger.size(); i++) {
			writer.write(passenger.get(i).getPassengerName() + "," + passenger.get(i).getNumberOfTrips() + "\n");
		}
		writer.close();
	}

	public static void writeDriverFile(ArrayList<Driver> trips) throws IOException {

		ArrayList<Driver> trip = new ArrayList<Driver>();
		trip.addAll(trips);
		BufferedWriter writer = new BufferedWriter(new FileWriter("DriverFile"));
		for (int i = 0; i < trip.size(); i++) {
			writer.write(trip.get(i).getDriverFirstName() + "," + trip.get(i).getDriverLastName() + ","
					+ trip.get(i).getDriverGender() + "," + trip.get(i).getDriverNumber());
			for (int j = 0; j < trip.get(i).getAssignedTrips().size(); j++) {
				writer.write("," + trip.get(i).getAssignedTrips().get(j).getSource() + ","
						+ trip.get(i).getAssignedTrips().get(j).getDestination() + ","
						+ trip.get(i).getAssignedTrips().get(j).getTime() + ","
						+ trip.get(i).getAssignedTrips().get(j).getVehicle());
			}
			writer.write("\n");
		}
		writer.close();
	}

	public static void writeHistoryTripFile(ArrayList<History> histories) throws IOException {

		ArrayList<History> history = new ArrayList<History>();
		history.addAll(histories);
		BufferedWriter writer = new BufferedWriter(new FileWriter("HistoryTrips"));
		for (int i = 0; i < history.size(); i++) {
			writer.write(history.get(i).getName());
			for (int j = 0; j < history.get(i).getTrips().size(); j++) {
				writer.write("," + history.get(i).getTrips().get(j).getSource() + ","
						+ history.get(i).getTrips().get(j).getDestination() + ","
						+ history.get(i).getTrips().get(j).getTime() + ","
						+ history.get(i).getTrips().get(j).getVehicle() + ","
						+ history.get(i).getTrips().get(j).getNumOfStops() + ","
						+ history.get(i).getTrips().get(j).getTicketPrice());
			}
			writer.write("\n");
		}
		writer.close();
	}

	public static void writeCurrentTripFile(ArrayList<Current> currents) throws IOException {

		ArrayList<Current> current = new ArrayList<Current>();
		current.addAll(currents);
		BufferedWriter writer = new BufferedWriter(new FileWriter("CurrentTrips"));
		for (int i = 0; i < current.size(); i++) {
			writer.write(current.get(i).getName());
			for (int j = 0; j < current.get(i).getTrips().size(); j++) {
				writer.write("," + current.get(i).getTrips().get(j).getSource() + ","
						+ current.get(i).getTrips().get(j).getDestination() + ","
						+ current.get(i).getTrips().get(j).getTime() + ","
						+ current.get(i).getTrips().get(j).getVehicle() + ","
						+ current.get(i).getTrips().get(j).getNumOfStops() + ","
						+ current.get(i).getTrips().get(j).getTicketPrice());
			}
			writer.write("\n");
		}
		writer.close();
	}
}
