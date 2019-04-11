package MapLogic;

import java.io.IOException;
import java.util.ArrayList;

public class HistoryTripsReader implements Reader {

	private String name;
	private final ArrayList<History> history = new ArrayList<History>();

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void load() {
		this.history.clear();
		try {
			this.history.addAll(FileReaderUtils.readHistoryTripsFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Trip> showTrips() {

		ArrayList<Trip> trips = new ArrayList<Trip>();

		for (int i = 0; i < history.size(); i++) {
			if (name.equals(history.get(i).getName())) {
				trips = history.get(i).getTrips();
			}
		}
		return trips;
	}

	public void addHistroy(ArrayList<Current> currentTrips) {

		int index = 0;
		for(int j = 0 ; j < currentTrips.size() ; j++) {
			if(name.equals(currentTrips.get(j).getName()))
				index = j;
		}	
		for (int i = 0; i < history.size(); i++) {
			if (name.equals(history.get(i).getName())) {
				if (currentTrips.size() > 6) {
					history.get(i).getTrips().add(currentTrips.get(index).getTrips().get(0));
					currentTrips.get(index).getTrips().remove(0);
				}
			}
		}

	}

}
