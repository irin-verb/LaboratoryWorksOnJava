package ru.rsreu.verbickaya0805.datalayer.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.verbickaya0805.utilities.StringOfTableFormer;

public class BookingList {

	private static Resourcer resourcer = ProjectResourcer.getInstance();

	private List<Booking> list;

	public BookingList(ResultSet args) throws SQLException {
		this.list = new ArrayList<Booking>();
		this.add(args);
	}

	public void add(ResultSet args) throws SQLException {
		final String id = "Id";
		final String nomination = "Nomination";
		final String description = "Description";
		final String quantity = "Quantity";
		final String date = "DateValue";
		while (args.next()) {
			Booking booking = new Booking(args.getInt(id), args.getString(nomination), args.getString(description),
					args.getInt(quantity), args.getDate(date));
			this.list.add(booking);
		}
	}

	public List<Booking> getList() {
		return this.list;
	}

	public String toStringTable() {
		final int idWidth = 6;
		final int commonWidth = 22;
		final int descriptionWidth = 50;
		String header = StringOfTableFormer.formCellOfTableWithoutRightBourder(idWidth,
				resourcer.getString("bookingList.id"))
				+ StringOfTableFormer.formCellOfTableWithoutRightBourder(commonWidth,
						resourcer.getString("bookingList.nomination"))
				+ StringOfTableFormer.formCellOfTableWithoutRightBourder(descriptionWidth,
						resourcer.getString("bookingList.description"))
				+ StringOfTableFormer.formStringOfTable(commonWidth, resourcer.getString("bookingList.quantity"),
						resourcer.getString("bookingList.date"))
				+ "\n";
		StringBuilder resultString = new StringBuilder(header);
		Iterator<Booking> iterator = this.list.iterator();
		while (iterator.hasNext()) {
			Booking item = iterator.next();
			resultString.append(StringOfTableFormer.formCellOfTableWithoutRightBourder(idWidth,
					Integer.toString(item.getBookingId()))
					+ StringOfTableFormer.formCellOfTableWithoutRightBourder(commonWidth, item.getCostomerNomination())
					+ StringOfTableFormer.formCellOfTableWithoutRightBourder(descriptionWidth,
							item.getProductDescription())
					+ StringOfTableFormer.formStringOfTable(commonWidth, Integer.toString(item.getQuantity()),
							item.getDate().toString())
					+ "\n");
		}
		return resultString.toString();
	}
}
