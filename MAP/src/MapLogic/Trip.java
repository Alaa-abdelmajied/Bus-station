package MapLogic;
import java.io.IOException;
import java.util.ArrayList;

public class Trip {

	private ArrayList<String> source = new ArrayList<String>();
	private ArrayList<String> destination = new ArrayList<String>();
	private ArrayList<String> time = new ArrayList<String>();
	private ArrayList<String> vehicle = new ArrayList<String>();
	private ArrayList<Integer> numberOfStops = new ArrayList<Integer>();
	private ArrayList<Double> ticketPrice = new ArrayList<Double>();
	private ArrayList<String> searchResult = new ArrayList<String>();
	private ArrayList<String> allTrips = new ArrayList<String>();
	FileReading loader = new FileReading();

	public void loadTrips() {
		try {
			loader.readTripFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		source = loader.getSource();
		destination = loader.getDestination();
		time = loader.getTime();
		vehicle = loader.getVehicle();
		numberOfStops = loader.getNumberOfStops();
		ticketPrice = loader.getTicketPrice();
	}

	public ArrayList<String> findTrip(String source, String destination) {
		searchResult.clear();
		for (int i = 0; i < this.source.size(); i++) {
			if (source.equals(this.source.get(i)) && destination.equals(this.destination.get(i))) {
				searchResult.add("Source:" + this.source.get(i) + "Destination:" + this.destination.get(i) + "Time:"
						+ time.get(i) + "Vehicle:" + vehicle.get(i) + "Number of stops:" + numberOfStops.get(i)
						+ "Ticket price:" + ticketPrice.get(i));
			}
		}
		return searchResult;
	}

	public ArrayList<String> showTrips() {
		for (int i = 0; i < this.source.size(); i++) {
			allTrips.add("Source:" + this.source.get(i) + "Destination:" + this.destination.get(i) + "Time:"
					+ time.get(i) + "Vehicle:" + vehicle.get(i) + "Number of stops:" + numberOfStops.get(i)
					+ "Ticket price:" + ticketPrice.get(i));
		}
		return allTrips;
	}

	public void addTrip(String source, String destination, String time, String vehicle, int numberOfStops, double ticketPrice) {
		this.source.add(source);
		this.destination.add(destination);
		this.time.add(time);
		this.vehicle.add(vehicle);
		this.numberOfStops.add(numberOfStops);
		this.ticketPrice.add(ticketPrice);
	}

	public ArrayList<String> getSource() {
		return source;
	}

	public ArrayList<String> getDestination() {
		return destination;
	}
	

}
