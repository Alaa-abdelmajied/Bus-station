package MapLogic;

import java.io.IOException;
import java.util.ArrayList;

public class TripReader implements Reader {

	private int index = 0;
	private final ArrayList<Trip> trips = new ArrayList<Trip>();

	@Override
	public void load() {
		this.trips.clear();
		try {
			this.trips.addAll(FileReaderUtils.readTripFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public ArrayList<Trip> showTrips() {
		return trips;
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

	public void addTrip(String source, String destination, String time, String vehicle, int numberOfStops,
			double ticketPrice, int numberOfSeats) {
		trips.add(new Trip(source, destination, vehicle, numberOfStops, time, ticketPrice, numberOfSeats));
	}

	public void assignTrip(String source, String destination, String time, String vehicle, String driverName) {
		for (int i = 0; i < this.trips.size(); i++) {
			if (source.equals(trips.get(i).getSource()) && destination.equals(trips.get(i).getDestination())
					&& vehicle.equals(trips.get(i).getVehicle()) && time.equals(trips.get(i).getTime())) {
				trips.get(i).setDriverName(driverName);
			}
		}
	}

	public void deleteTrip(String source, String destination, String vehicle, String time) {

		for (int i = 0; i < this.trips.size(); i++) {
			if (source.equals(trips.get(i).getSource()) && destination.equals(trips.get(i).getDestination())
					&& vehicle.equals(trips.get(i).getVehicle()) && time.equals(trips.get(i).getTime())) {
				trips.remove(i);
			}
		}
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

	public ArrayList<Trip> findRoundTrip(String source, String destination, String vehicle) {
		ArrayList<Trip> searchResult = new ArrayList<Trip>();

		for (int i = 0; i < this.trips.size(); i++) {
			if (source.equals(trips.get(i).getSource()) && destination.equals(trips.get(i).getDestination())
					&& vehicle.equals(trips.get(i).getVehicle())) {
				searchResult.add(trips.get(i));
			}
		}

		return searchResult;
	}

	public int getNumberOfSeats(String source, String destination, String vehicle) {

		for (int i = 0; i < this.trips.size(); i++) {
			if (source.equals(trips.get(i).getSource()) && destination.equals(trips.get(i).getDestination())
					&& vehicle.equals(trips.get(i).getVehicle())) {
				index = i;
			}
		}
		return trips.get(index).getNumberOfSeats();
	}
	

	public void setNumberOfSeats(int bookedtickets) {
		int numberOfSeats = 0;
		numberOfSeats = trips.get(index).getNumberOfSeats();
		trips.get(index).setNumberOfSeats(numberOfSeats - bookedtickets);
	}

	public ArrayList<Trip> getTrips() {
		return trips;
	}

}
