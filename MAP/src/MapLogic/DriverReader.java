package MapLogic;

import java.io.IOException;
import java.util.ArrayList;

public class DriverReader {
	
	private final ArrayList<Driver> driverInfo = new ArrayList<Driver>();

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
		int index = 0;
		for (int i = 0; i < driverInfo.size(); i++) {
			if(driverName.equals(driverInfo.get(i).getDriverName())) {
				index = i;
				break;
			}
		for(i = 0 ; i < index ; i ++)
			assignedTrips.add(driverInfo.get(i).getAssignedTrips().get(i));
		}
		return assignedTrips;
	}
}
