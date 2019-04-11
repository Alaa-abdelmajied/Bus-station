package MapLogic;

import java.util.ArrayList;

public class Current {
	
	private final String name;
	private ArrayList<Trip> trips = new ArrayList<Trip>();
	
	public Current(String name, ArrayList<Trip> trips) {
		
		this.name = name;
		this.trips = trips;
	}

	public String getName() {
		return name;
	}

	public ArrayList<Trip> getTrips() {
		return trips;
	}

}
