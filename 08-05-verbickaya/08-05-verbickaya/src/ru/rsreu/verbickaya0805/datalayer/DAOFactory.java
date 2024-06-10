package ru.rsreu.verbickaya0805.datalayer;

public abstract class DAOFactory {
	public static DAOFactory getInstance(DBType dbType) {
		DAOFactory result = dbType.getDAOFactory();
		return result;
	}

	public abstract BookingManagerDAO getBookingManagerDAO();
}
