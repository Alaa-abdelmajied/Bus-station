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

}
