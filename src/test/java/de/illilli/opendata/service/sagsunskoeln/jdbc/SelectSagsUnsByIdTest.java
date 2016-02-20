package de.illilli.opendata.service.sagsunskoeln.jdbc;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.junit.Before;

import de.illilli.jdbc.Select;

/**
 * As long as there is no integration test stage, database related tests are
 * just main Methods.
 */
public class SelectSagsUnsByIdTest {

	@Before
	public void setUp() throws Exception {
	}

	public static void main(String[] args) throws SQLException, NamingException, IOException {
		// define db-connection
		ConnectionFactory.setUpConnectionForJndi();

		String id = "A-1627";
		Select<SagsUnsDto> select = new SelectSagsUnsById(id);
		SagsUnsDto dto = select.getDbObject();
		System.out.println(dto);
	}

}
