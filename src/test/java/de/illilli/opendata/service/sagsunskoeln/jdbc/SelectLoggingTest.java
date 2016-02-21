package de.illilli.opendata.service.sagsunskoeln.jdbc;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.junit.Before;

import de.illilli.jdbc.Select;

public class SelectLoggingTest {

	@Before
	public void setUp() throws Exception {
	}

	public static void main(String[] args) throws SQLException, NamingException, IOException {
		// define db-connection
		ConnectionFactory.setUpConnectionForJndi();

		Select<LoggingDto> select = new SelectLogging();
		System.out.println(select.getDbObjectList());
	}

}
