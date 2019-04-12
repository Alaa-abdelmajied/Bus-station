package MapLogic;

public class Passenger {
	
	private final String passengerName;
	private int numberOfTrips;
	

	public Passenger(String passengerName , int numberOfTrips){
		
		this.passengerName = passengerName;
		this.numberOfTrips = numberOfTrips;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public int getNumberOfTrips() {
		return numberOfTrips;
	}

	public void setNumberOfTrips(int numberOfTrips) {
		this.numberOfTrips = numberOfTrips;
	}
	
	
}
