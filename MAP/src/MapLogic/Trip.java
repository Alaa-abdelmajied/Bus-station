package MapLogic;

public class Trip {

	private final String source;
	private final String dest;
	private final String vehicle;
	private final int numOfStops;
	private final double time;
	private final double ticketPrice;

	public Trip(String source, String dest, String vehicle, int numOfStops, double time, double ticketPrice) {
		this.source = source;
		this.dest = dest;
		this.vehicle = vehicle;
		this.numOfStops = numOfStops;
		this.time = time;
		this.ticketPrice = ticketPrice;
	}

	public String getSource() {
		return source;
	}

	public String getDest() {
		return dest;
	}

	public String getVehicle() {
		return vehicle;
	}

	public int getNumOfStops() {
		return numOfStops;
	}

	public double getTime() {
		return time;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}
}
