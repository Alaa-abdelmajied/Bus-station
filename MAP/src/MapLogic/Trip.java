package MapLogic;

public class Trip {

	private final String source;
	private final String destination;
	private final String vehicle;
	private final int numOfStops;
	private final String time;
	private final double ticketPrice;
	private int numberOfSeats;
	private String driverName = null;

	public Trip(String source, String destination, String vehicle, String time) {
		this.source = source;
		this.destination = destination;
		this.vehicle = vehicle;
		this.time = time;
		this.numOfStops = 0;
		this.ticketPrice = 0;
	}

	public Trip(String source, String destination, String vehicle, int numOfStops, String time, double ticketPrice) {
		this.source = source;
		this.destination = destination;
		this.vehicle = vehicle;
		this.numOfStops = numOfStops;
		this.time = time;
		this.ticketPrice = ticketPrice;
	}

	public Trip(String source, String destination, String vehicle, int numOfStops, String time, double ticketPrice,
			int numberOfSeats) {
		this.source = source;
		this.destination = destination;
		this.vehicle = vehicle;
		this.numOfStops = numOfStops;
		this.time = time;
		this.ticketPrice = ticketPrice;
		this.numberOfSeats = numberOfSeats;
	}
	
	public Trip(String source, String destination, String vehicle, int numOfStops, String time, double ticketPrice,
			int numberOfSeats, String driverName) {
		this.source = source;
		this.destination = destination;
		this.vehicle = vehicle;
		this.numOfStops = numOfStops;
		this.time = time;
		this.ticketPrice = ticketPrice;
		this.numberOfSeats = numberOfSeats;
		this.driverName = driverName;
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

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	
	

}
