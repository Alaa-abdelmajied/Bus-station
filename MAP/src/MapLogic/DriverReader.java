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

	public ArrayList<String> getDriverFirstName() {
		ArrayList<String> driverName = new ArrayList<String>();
		for (int i = 0; i < driverInfo.size(); i++) {
			driverName.add(driverInfo.get(i).getDriverFirstName());
		}
		return driverName;
	}

	public int driverIndex() {
		int index = 0;
		for (int i = 0; i < driverInfo.size(); i++) {
			if (driverFirstName.equals(driverInfo.get(i).getDriverFirstName()))
				index = i;
		}
		return index;
	}

	public ArrayList<Trip> getAssignedTrips() {
		ArrayList<Trip> assignedTrips = new ArrayList<Trip>();
		for (int i = 0; i < driverInfo.get(driverIndex()).getAssignedTrips().size(); i++)
			assignedTrips.add(driverInfo.get(driverIndex()).getAssignedTrips().get(i));
		return assignedTrips;
	}

	/*public void addAssignedTrips(String driverName) {
		setDriverFirstName(driverFirstName);
		driverInfo.get(driverIndex()).getAssignedTrips().add();
	}*/

	public String getDriverLastName() {

		return driverInfo.get(driverIndex()).getDriverLastName();

	}

	public String getDriverGender() {
		return driverInfo.get(driverIndex()).getDriverGender();
	}

	public String getDriverNumber() {
		return driverInfo.get(driverIndex()).getDriverNumber();
	}
}
