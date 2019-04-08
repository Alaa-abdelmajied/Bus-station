package MapLogic;

import java.io.IOException;
import java.util.ArrayList;

public class TripReader {

	private final ArrayList<Trip> trips = new ArrayList<Trip>();

	public void loadTrips() {
		try {
			this.trips.addAll(FileReaderUtils.readTripFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Trip> findTrip(String source, String destination) {
		ArrayList<Trip> searchResult = new ArrayList<Trip>();

		for (int i = 0; i < this.trips.size(); i++) {
			if (source != null && destination != null) {
				if (source.equals(trips.get(i).getSource()) || destination.equals(trips.get(i).getDestination())) {
					searchResult.add(trips.get(i));
				}
			} else if (source == null && destination != null) {
				if (destination.equals(trips.get(i).getDestination())) {
					searchResult.add(trips.get(i));
				}
			} else if (source != null && destination == null) {
				if (source.equals(trips.get(i).getSource())) {
					searchResult.add(trips.get(i));
				}
			} else if (source == null && destination == null) {
				searchResult.add(trips.get(i));
			}
		}
		return searchResult;
	}

	public ArrayList<Trip> showTrips() {
		return trips;
	}

	public void addTrip(String source, String destination, Double time, String vehicle, int numberOfStops,
			double ticketPrice) {
		trips.add(new Trip(source, destination, vehicle, numberOfStops, time, ticketPrice));
	}

	public ArrayList<String> getSource() {
		ArrayList<String> sources = new ArrayList<String>();
		for (int i = 0; i < trips.size(); i++) {
			sources.add(trips.get(i).getSource());
		}
		return sources;
	}

	public ArrayList<String> getDestination() {
		ArrayList<String> destinations = new ArrayList<String>();
		for (int i = 0; i < trips.size(); i++) {
			destinations.add(trips.get(i).getDestination());
		}
		return destinations;
	}

}
