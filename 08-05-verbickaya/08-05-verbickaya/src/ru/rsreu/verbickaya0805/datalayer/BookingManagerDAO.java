package ru.rsreu.verbickaya0805.datalayer;

import ru.rsreu.verbickaya0805.MyException;
import ru.rsreu.verbickaya0805.datalayer.data.BookingList;
import ru.rsreu.verbickaya0805.datalayer.data.CustomerList;
import ru.rsreu.verbickaya0805.datalayer.data.CustomerWithCountOfBookingsList;

public interface BookingManagerDAO {

	BookingList getBookingsForPeriodOfTime(String date1, String date2) throws MyException;

	CustomerList getCustomersOfSomeProduct(int productId);

	CustomerWithCountOfBookingsList getBookingCountForEachCustomer();
}
