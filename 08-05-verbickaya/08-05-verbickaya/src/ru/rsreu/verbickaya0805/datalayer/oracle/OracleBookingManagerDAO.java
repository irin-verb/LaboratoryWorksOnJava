package ru.rsreu.verbickaya0805.datalayer.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.verbickaya0805.MyException;
import ru.rsreu.verbickaya0805.datalayer.BookingManagerDAO;
import ru.rsreu.verbickaya0805.datalayer.data.BookingList;
import ru.rsreu.verbickaya0805.datalayer.data.CustomerList;
import ru.rsreu.verbickaya0805.datalayer.data.CustomerWithCountOfBookingsList;

public class OracleBookingManagerDAO implements BookingManagerDAO {

	private static Resourcer resourcer = ProjectResourcer.getInstance();

	private Connection connection;

	public OracleBookingManagerDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public BookingList getBookingsForPeriodOfTime(String date1, String date2) throws MyException {
		BookingList bookingList = null;
		try {
			PreparedStatement st = this.connection
					.prepareStatement(resourcer.getString("request.bookingForPeriodOfTime"));
			DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
			st.setDate(1, new java.sql.Date(format.parse(date1).getTime()));
			st.setDate(2, new java.sql.Date(format.parse(date2).getTime()));
			ResultSet rs = st.executeQuery();
			bookingList = new BookingList(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			throw new MyException(resourcer.getString("myException.wrongDate"));
		}
		return bookingList;
	}

	@Override
	public CustomerList getCustomersOfSomeProduct(int productId) {
		CustomerList customerList = null;
		try {
			PreparedStatement st = this.connection
					.prepareStatement(resourcer.getString("request.customersOfSomeProduct"));
			st.setInt(1, productId);
			ResultSet rs = st.executeQuery();
			customerList = new CustomerList(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerList;
	}

	@Override
	public CustomerWithCountOfBookingsList getBookingCountForEachCustomer() {
		CustomerWithCountOfBookingsList resultList = null;
		try {
			PreparedStatement st = this.connection
					.prepareStatement(resourcer.getString("request.bookingCountForEachCustomer"));
			ResultSet rs = st.executeQuery();
			resultList = new CustomerWithCountOfBookingsList(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;
	}

}
