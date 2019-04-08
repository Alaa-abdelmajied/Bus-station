package MapLogic;
import java.io.IOException;
import java.util.ArrayList;

public class Trip {

	private ArrayList<String> source = new ArrayList<String>();
	private ArrayList<String> destination = new ArrayList<String>();
	private ArrayList<Double> time = new ArrayList<Double>();
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
			if(source != null && destination != null) {
				if (source.equals(this.source.get(i)) || destination.equals(this.destination.get(i))) {
				searchResult.add(this.source.get(i) + "   " + this.destination.get(i) + "   "
						+ time.get(i) + "   " + vehicle.get(i) + "   " + numberOfStops.get(i)
						+ "   " + ticketPrice.get(i));
				}
			}else if(source == null && destination != null) {
				if (destination.equals(this.destination.get(i))) {
					searchResult.add(this.source.get(i) + "   " + this.destination.get(i) + "   "
							+ time.get(i) + "   " + vehicle.get(i) + "   " + numberOfStops.get(i)
							+ "   " + ticketPrice.get(i));
					}
			}else if(source != null &&destination == null) {
				if (source.equals(this.source.get(i))) {
					searchResult.add(this.source.get(i) + "   " + this.destination.get(i) + "   "
							+ time.get(i) + "   " + vehicle.get(i) + "   " + numberOfStops.get(i)
							+ "   " + ticketPrice.get(i));
					}
			} else if(source == null &&destination == null) {
				searchResult.add(this.source.get(i) + "   " + this.destination.get(i) + "   "
						+ time.get(i) + "   " + vehicle.get(i) + "   " + numberOfStops.get(i)
						+ "   " + ticketPrice.get(i));
			}
		}
		return searchResult;
	}

	public ArrayList<String> showTrips() {
		for (int i = 0; i < this.source.size(); i++) {
			allTrips.add(this.source.get(i) + "  " + this.destination.get(i) + "  "
					+ time.get(i) + "  " + vehicle.get(i) + "  " + numberOfStops.get(i)
					+ "  " + ticketPrice.get(i));
		}
		return allTrips;
	}

	public void addTrip(String source, String destination, Double time, String vehicle, int numberOfStops, double ticketPrice) {
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
