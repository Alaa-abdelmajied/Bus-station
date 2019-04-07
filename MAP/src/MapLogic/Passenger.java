package MapLogic;

import java.io.IOException;
import java.util.ArrayList;

public class Passenger {

	private ArrayList<String> passengerName = new ArrayList<String>();
	private ArrayList<Integer> numberOfTrips = new ArrayList<Integer>();

	FileReading loader = new FileReading();

	public Passenger() {
		passengerName = loader.getPassengerName();
		numberOfTrips = loader.getNumberOfTrips();
	}

	public boolean vipCheck(String name) throws IOException {

		loader.readVipFile();
		for (int i = 0; i < passengerName.size(); i++) {
			if (name.equals(passengerName.get(i))) {
				if (numberOfTrips.get(i) >= 6) {
					return true;

				} else {
					return false;
				}
			}
		}
		return false;
	}
}
