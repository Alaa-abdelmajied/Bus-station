package MapLogic;

import java.util.ArrayList;

public class Driver {

	private final String driverFirstName;
	private final String driverLastName;
	private final String driverGender;
	private final String driverNumber;
	private ArrayList<Trip> assignedTrips = new ArrayList<Trip>();

	public Driver(String driverFirstName, String driverLastName, String driverGender, String driverNumber,
			ArrayList<Trip> assignedTrips) {
		this.driverFirstName = driverFirstName;
		this.driverLastName = driverLastName;
		this.driverGender = driverGender;
		this.driverNumber = driverNumber;
		this.assignedTrips = assignedTrips;
	}

	public String getDriverFirstName() {
		return driverFirstName;
	}

	public String getDriverLastName() {
		return driverLastName;
	}

	public String getDriverGender() {
		return driverGender;
	}

	public String getDriverNumber() {
		return driverNumber;
	}

	public ArrayList<Trip> getAssignedTrips() {
		return assignedTrips;
	}



}
