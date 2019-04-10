package MapLogic;

import java.io.IOException;
import java.util.ArrayList;

public class DriverReader {
	
	private  ArrayList<Driver> driverInfo = new ArrayList<Driver>();

	public void loadInfo() {
		this.driverInfo.clear();
		try {
			this.driverInfo.addAll(FileReaderUtils.readDriverFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getAssignedTrips() {
		ArrayList<String> assignedTrips = new ArrayList<String>();
		for (int i = 0; i < driverInfo.size(); i++) {
			assignedTrips.add(driverInfo.get(1).getAssignedTrips().get(i));
		}
		return assignedTrips;
	}
}
