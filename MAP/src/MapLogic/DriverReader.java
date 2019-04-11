package MapLogic;

import java.io.IOException;
import java.util.ArrayList;

public class DriverReader {

	private ArrayList<Driver> driverInfo = new ArrayList<Driver>();
	private String driverFirstName;

	public void loadInfo() {
		this.driverInfo.clear();
		try {
			this.driverInfo.addAll(FileReaderUtils.readDriverFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setDriverFirstName(String driverFirstName) {
		this.driverFirstName = driverFirstName;
	}

	public int DriverIndex() {
		int index = 0;
		for (int i = 0; i < driverInfo.size(); i++) {
			if (driverFirstName.equals(driverInfo.get(i).getDriverFirstName()))
				index = i;
		}
		return index;
	}

	public ArrayList<Trip> getAssignedTrips() {
		ArrayList<Trip> assignedTrips = new ArrayList<Trip>();
		for (int i = 0; i < driverInfo.get(DriverIndex()).getAssignedTrips().size(); i++)
			assignedTrips.add(driverInfo.get(DriverIndex()).getAssignedTrips().get(i));
		return assignedTrips;
	}

	public String getDriverLastName() {
	
		return driverInfo.get(DriverIndex()).getDriverLastName();
		
	}
	public String getDriverGender() {
		return driverInfo.get(DriverIndex()).getDriverGender();
	}
	public String getDriverNumber() {
		return driverInfo.get(DriverIndex()).getDriverNumber();
	}
}
