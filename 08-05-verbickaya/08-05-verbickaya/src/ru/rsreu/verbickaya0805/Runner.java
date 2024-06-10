package ru.rsreu.verbickaya0805;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.verbickaya0805.datalayer.BookingManagerDAO;
import ru.rsreu.verbickaya0805.datalayer.DAOFactory;
import ru.rsreu.verbickaya0805.datalayer.DBType;
import ru.rsreu.verbickaya0805.datalayer.data.BookingList;
import ru.rsreu.verbickaya0805.datalayer.data.CustomerList;
import ru.rsreu.verbickaya0805.datalayer.data.CustomerWithCountOfBookingsList;

public class Runner {

	private static Resourcer resourcer = ProjectResourcer.getInstance();

	private Runner() {
	};

	public static void main(String[] args) {
		StringBuilder resultString = new StringBuilder("\n");
		try {

			DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
			BookingManagerDAO bookingManager = factory.getBookingManagerDAO();

			// query 1
			try {
				BookingList query1 = bookingManager.getBookingsForPeriodOfTime(resourcer.getString("query.date1"),
						resourcer.getString("query.date2"));
				resultString.append(
						resourcer.getString("message.bookingForPeriodOfTime") + "\n" + query1.toStringTable() + "\n");
			} catch (MyException e) {
				resultString.append(e.toString() + "\n");
			}

			// query 2
			int productId = Integer.parseInt(resourcer.getString("query.productId"));
			CustomerList query2 = bookingManager.getCustomersOfSomeProduct(productId);
			resultString.append(resourcer.getString("message.customersOfSomeProduct") + " "
					+ resourcer.getString("query.productId") + "\n" + query2.toStringTable() + "\n");

			// query 3
			CustomerWithCountOfBookingsList query3 = bookingManager.getBookingCountForEachCustomer();
			resultString.append(
					resourcer.getString("message.bookingCountForEachCustomer") + "\n" + query3.toStringTable() + "\n");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println(resultString.toString());
		}

	}

}