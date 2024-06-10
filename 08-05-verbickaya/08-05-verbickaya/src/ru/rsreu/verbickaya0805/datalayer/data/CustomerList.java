package ru.rsreu.verbickaya0805.datalayer.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.verbickaya0805.utilities.StringOfTableFormer;

public class CustomerList {

	private static Resourcer resourcer = ProjectResourcer.getInstance();

	private List<Customer> list;

	public CustomerList(ResultSet args) throws SQLException {
		this.list = new ArrayList<Customer>();
		this.add(args);
	}

	public void add(ResultSet args) throws SQLException {
		final String id = "CustomerId";
		while (args.next()) {
			Customer customer = new Customer(args.getInt(id));
			this.list.add(customer);
		}
	}

	public String toStringTable() {
		final int columnWidth = 15;
		String header = StringOfTableFormer.formStringOfTable(columnWidth, resourcer.getString("customerList.id"))
				+ "\n";
		StringBuilder resultString = new StringBuilder(header);
		Iterator<Customer> iterator = this.list.iterator();
		while (iterator.hasNext()) {
			Customer item = iterator.next();
			resultString
					.append(StringOfTableFormer.formStringOfTable(columnWidth, Integer.toString(item.getId())) + "\n");
		}
		return resultString.toString();
	}

}
