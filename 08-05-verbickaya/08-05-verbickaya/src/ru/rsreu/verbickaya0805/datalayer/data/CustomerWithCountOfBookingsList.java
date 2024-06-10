package ru.rsreu.verbickaya0805.datalayer.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.verbickaya0805.utilities.StringOfTableFormer;

public class CustomerWithCountOfBookingsList {

	private static Resourcer resourcer = ProjectResourcer.getInstance();

	private List<CustomerWithBookingCount> list;

	public CustomerWithCountOfBookingsList(ResultSet args) throws SQLException {
		this.list = new ArrayList<CustomerWithBookingCount>();
		this.add(args);
	}

	public void add(ResultSet args) throws SQLException {
		final String id = "CustomerId";
		final String count = "COUNT(*)";
		while (args.next()) {
			CustomerWithBookingCount item = new CustomerWithBookingCount(args.getInt(id), args.getInt(count));
			this.list.add(item);
		}
	}

	public List<CustomerWithBookingCount> getList() {
		return this.list;
	}

	public String toStringTable() {
		final int columnWidth = 15;
		String header = StringOfTableFormer.formStringOfTable(columnWidth,
				resourcer.getString("customerWithCountOfBookingsList.id"),
				resourcer.getString("customerWithCountOfBookingsList.count")) + "\n";
		StringBuilder resultString = new StringBuilder(header);
		Iterator<CustomerWithBookingCount> iterator = this.list.iterator();
		while (iterator.hasNext()) {
			CustomerWithBookingCount item = iterator.next();
			resultString.append(StringOfTableFormer.formStringOfTable(columnWidth,
					Integer.toString(item.getCustomerId()), Integer.toString(item.getBookingCount())) + "\n");
		}
		return resultString.toString();
	}

}
