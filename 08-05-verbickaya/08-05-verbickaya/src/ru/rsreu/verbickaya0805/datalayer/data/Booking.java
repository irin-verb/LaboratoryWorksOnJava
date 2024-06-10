package ru.rsreu.verbickaya0805.datalayer.data;

import java.sql.Date;

public class Booking {

	private int bookingId;
	private String customerNomination;
	private String productDescription;
	private int quantity;
	private Date date;

	public Booking(int bookingId, String customerNomination, String productDescription, int quantity, Date date) {
		this.bookingId = bookingId;
		this.customerNomination = customerNomination;
		this.productDescription = productDescription;
		this.quantity = quantity;
		this.date = date;
	}

	public int getBookingId() {
		return this.bookingId;
	}

	public String getCostomerNomination() {
		return this.customerNomination;
	}

	public String getProductDescription() {
		return this.productDescription;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public Date getDate() {
		return this.date;
	}

}
