package ru.rsreu.verbickaya0805.datalayer.data;

public class CustomerWithBookingCount {

	private int customerId;
	private int bookingCount;

	public CustomerWithBookingCount(int customerId, int bookingCount) {
		this.customerId = customerId;
		this.bookingCount = bookingCount;
	}

	public int getCustomerId() {
		return this.customerId;
	}

	public int getBookingCount() {
		return this.bookingCount;
	}

}
