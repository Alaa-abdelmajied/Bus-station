package MapLogic;

import java.io.IOException;
import java.util.ArrayList;

public class PassengerReader {

	private ArrayList<Passenger> passengers = new ArrayList<Passenger>();

	public void loadpassengers() {
		this.passengers.clear();
		try {
			this.passengers.addAll(FileReaderUtils.readVipFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean vipCheck(String name) throws IOException {

		int tripsNumber;
		loadpassengers();
		for (int i = 0; i < passengers.size(); i++) {
			if (name.equals(passengers.get(i).getPassengerName())) {
				tripsNumber = passengers.get(i).getNumberOfTrips();
				if (tripsNumber >= 6) {
					return true;

				} else {
					return false;
				}
			}
		}
		return false;
	}

	public void addTripsNumber(String name) {

		for (int i = 0; i < passengers.size(); i++) {
			if (name.equals(passengers.get(i).getPassengerName())) {
				passengers.get(i).setNumberOfTrips(passengers.get(i).getNumberOfTrips() + 1);
			}
		}
	}

	public void deleteTripsNumber(String name) {

		for (int i = 0; i < passengers.size(); i++) {
			if (name.equals(passengers.get(i).getPassengerName())) {
				passengers.get(i).setNumberOfTrips(passengers.get(i).getNumberOfTrips() - 1);
			}
		}
	}

	public int getTripsNumber(String name) {
		int tripsNumber = 0;
		for (int i = 0; i < passengers.size(); i++) {
			if (name.equals(passengers.get(i).getPassengerName())) {
				tripsNumber = passengers.get(i).getNumberOfTrips();
			}
		}
		return tripsNumber;
	}

	public ArrayList<Passenger> getPassengers() {
		return passengers;
	}

}
