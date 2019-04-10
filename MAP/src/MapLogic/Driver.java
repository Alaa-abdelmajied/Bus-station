package MapLogic;

import java.util.ArrayList;

public class Driver {

	private final String driverName;
	private final String driverGender;
	private final int driverNumber;
	private ArrayList<String> assignedTrips = new ArrayList<String>();

	public Driver(String driverName, String driverGender, int driverNumber, ArrayList<String> assignedTrips) {
		this.driverName = driverName;
		this.driverGender = driverGender;
		this.driverNumber = driverNumber;
		this.assignedTrips = assignedTrips;
	}

	public String getDriverName() {
		return driverName;
	}

	public String getDriverGender() {
		return driverGender;
	}

	public int getDriverNumber() {
		return driverNumber;
	}

	public ArrayList<String> getAssignedTrips() {
		return assignedTrips;
	}


}
