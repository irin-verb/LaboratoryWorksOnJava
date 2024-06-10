package ru.rsreu.verbickaya0805.datalayer.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.verbickaya0805.datalayer.DAOFactory;
import ru.rsreu.verbickaya0805.datalayer.BookingManagerDAO;

public class OracleDAOFactory extends DAOFactory {

	private static Resourcer resourcer = ProjectResourcer.getInstance();

	private static volatile OracleDAOFactory instance;
	private Connection connection;

	private OracleDAOFactory() {
	}

	public static OracleDAOFactory getInstance() throws ClassNotFoundException, SQLException {
		OracleDAOFactory factory = instance;
		if (instance == null) {
			synchronized (OracleDAOFactory.class) {
				factory = new OracleDAOFactory();
				instance = factory;
				factory.connected();
			}
		}
		return factory;
	}

	private void connected() throws ClassNotFoundException, SQLException {
		Locale.setDefault(Locale.ENGLISH);
		String url = resourcer.getString("oracle.url");
		String user = resourcer.getString("oracle.user");
		String password = resourcer.getString("oracle.password");
		connection = DriverManager.getConnection(url, user, password);
	}

	@Override
	public BookingManagerDAO getBookingManagerDAO() {
		return new OracleBookingManagerDAO(this.connection);
	}

}
