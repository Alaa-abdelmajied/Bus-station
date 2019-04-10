package MapLogic;

import java.io.IOException;
import java.util.ArrayList;

public class PassengerReader {

	private ArrayList<Passenger> passengers = new ArrayList<Passenger>();
	int tripsNumber;

	public void loadpassengers() {
		this.passengers.clear();
		try {
			this.passengers.addAll(FileReaderUtils.readVipFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean vipCheck(String name) throws IOException {

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

	public int getTripsNumber() {
		return tripsNumber;
	}

}
