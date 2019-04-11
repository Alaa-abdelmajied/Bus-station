package MapLogic;

public class Trip {

	private final String source;
	private final String destination;
	private final String vehicle;
	private final int numOfStops;
	private final String time;
	private final double ticketPrice;
	private int numberOfSeats;

	public Trip(String source, String destination, String vehicle, int numOfStops, String time, double ticketPrice, int numberOfSeats) {
		this.source = source;
		this.destination = destination;
		this.vehicle = vehicle;
		this.numOfStops = numOfStops;
		this.time = time;
		this.ticketPrice = ticketPrice;
		this.numberOfSeats = numberOfSeats;
	}

	public String getSource() {
		return source;
	}

	public String getDestination() {
		return destination;
	}

	public String getVehicle() {
		return vehicle;
	}

	public int getNumOfStops() {
		return numOfStops;
	}

	public String getTime() {
		return time;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	
	
}
