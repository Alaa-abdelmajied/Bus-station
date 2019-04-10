package MapLogic;

public class Tickets {
	private int seatNum;

	public double roundTicketPrice(double price) {
		double ticketPrice = (2 * price) - (0.4 * price);
		return ticketPrice;
	}

	public boolean availableSeatsCheck(int numOfSeats) {

		if (seatNum - numOfSeats > 0) {

			return true;
		} else
			return false;
	}

	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}

}
