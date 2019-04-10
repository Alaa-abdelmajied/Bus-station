package MapLogic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileWriterUtils {

	public static void writeTripFile(ArrayList<Trip> trips) throws IOException {

		ArrayList<Trip> trip = new ArrayList<Trip>();
		trip.addAll(trips);
		BufferedWriter writer = new BufferedWriter(new FileWriter("trips.txt"));
		for (int i = 0; i < trip.size(); i++) {
			writer.write(trip.get(i).getSource() + "," + trip.get(i).getDestination() + "," + trip.get(i).getTime()
					+ "," + trip.get(i).getVehicle() + "," + trip.get(i).getNumOfStops() + ","
					+ trip.get(i).getTicketPrice() + "\n");
		}
		writer.close();
	}

	public static void writeDriverFile(ArrayList<Driver> trips) throws IOException {

		ArrayList<Driver> trip = new ArrayList<Driver>();
		trip.addAll(trips);
		BufferedWriter writer = new BufferedWriter(new FileWriter("trips.txt"));
		for (int i = 0; i < trip.size(); i++) {
			writer.write(trip.get(i).getDriverFirstName() + "," + trip.get(i).getDriverLastName() + ","
					+ trip.get(i).getDriverGender() + "," + trip.get(i).getDriverNumber());
			for(int j = 0; i < trip.get(i).getAssignedTrips().size(); j++)
				writer.write(","+trip.get(i).getAssignedTrips().get(j));
			writer.write("\n");
		}
		writer.close();
	}
	// current, history//
}
