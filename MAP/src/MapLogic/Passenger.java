package MapLogic;

import java.io.IOException;
import java.util.ArrayList;

public class Passenger {

	private ArrayList<String> passengerName = new ArrayList<String>();
	private ArrayList<Integer> numberOfTrips = new ArrayList<Integer>();
	int tripsNumber;

	FileReaderUtils loader = new FileReaderUtils();

	public Passenger() {
		passengerName = loader.getPassengerName();
		numberOfTrips = loader.getNumberOfTrips();
	}

	public boolean vipCheck(String name) throws IOException {

		loader.readVipFile();
		for (int i = 0; i < passengerName.size(); i++) {
			if (name.equals(passengerName.get(i))) {
				tripsNumber = numberOfTrips.get(i);
				if (numberOfTrips.get(i) >= 6) {
					return true;

				} else {
					return false;
				}
			}
		}
		return false;
	}

	public int getTripsNumber() {
		return tripsNumber;
	}

}
