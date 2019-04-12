package MapLogic;

import java.io.IOException;
import java.util.ArrayList;

public class CurrentTripsReader implements Reader {

	private String name;
	private final ArrayList<Current> currents = new ArrayList<Current>();

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void load() {
		this.currents.clear();
		try {
			this.currents.addAll(FileReaderUtils.readCurrentTripsFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Trip> showTrips() {

		ArrayList<Trip> trips = new ArrayList<Trip>();

		for (int i = 0; i < currents.size(); i++) {
			if (name.equals(currents.get(i).getName())) {
				trips = currents.get(i).getTrips();
			}
		}
		return trips;
	}

	public void confirmTrip(String name, String source, String destination, String time, String vehicle,
			int numberOfStops, double ticketPrice) {
		for (int i = 0; i < currents.size(); i++) {
			if (name.equals(currents.get(i).getName())) {
				currents.get(i).getTrips()
						.add(new Trip(source, destination, vehicle, numberOfStops, time, ticketPrice));
			}
		}
	}

	public void cancelTrip(String name, String source, String destination, String time, String vehicle) {
		for (int i = 0; i < currents.size(); i++) {
			if (name.equals(currents.get(i).getName())) {
				for (int j = 0; j < showTrips().size(); j++) {
					if (source.equals(currents.get(i).getTrips().get(j).getSource())
							&& destination.equals(currents.get(i).getTrips().get(j).getDestination())
							&& vehicle.equals(currents.get(i).getTrips().get(j).getVehicle())
							&& time.equals(currents.get(i).getTrips().get(j).getTime())) {
						currents.get(i).getTrips().remove(j);
					}
				}
			}
		}
	}

	public void cancelTripFromManger(String source, String destination, String time, String vehicle) {
		for (int i = 0; i < currents.size(); i++) {
			for (int j = 0; j < currents.get(i).getTrips().size(); j++) {
				if (source.equals(currents.get(i).getTrips().get(j).getSource())
						&& destination.equals(currents.get(i).getTrips().get(j).getDestination())
						&& vehicle.equals(currents.get(i).getTrips().get(j).getVehicle())
						&& time.equals(currents.get(i).getTrips().get(j).getTime())) {
					System.out.println("ok");
					currents.get(i).getTrips().remove(j);
				}
			}
		}
	}

	public ArrayList<Current> getCurrents() {
		return currents;
	}

}
