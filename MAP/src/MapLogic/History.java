package MapLogic;

import java.util.ArrayList;

public class History {
	
	private final String name;
	private ArrayList<Trip> trips = new ArrayList<Trip>();
	
	public History(String name, ArrayList<Trip> trips) {
		
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
