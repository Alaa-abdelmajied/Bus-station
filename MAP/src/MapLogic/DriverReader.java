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
	
	public ArrayList<String> getAssignedTrips(String driverName) {
		ArrayList<String> assignedTrips = new ArrayList<String>();
		for (int i = 0; i < driverInfo.size(); i++) {
			if (driverName.equals(driverInfo.get(i).getDriverName())) {
				for (int j = 0; j < driverInfo.get(i).getAssignedTrips().size(); j++)
					assignedTrips.add(driverInfo.get(i).getAssignedTrips().get(j));
			}

		}
		return assignedTrips;
	}
}
