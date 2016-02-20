package de.illilli.opendata.service.sagsunskoeln.jdbc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.junit.Before;

import de.illilli.jdbc.Select;

public class SelectSagsUnsTest {

	@Before
	public void setUp() throws Exception {
	}

	public static void main(String[] args) throws SQLException, NamingException, IOException {
		// define db-connection
		ConnectionFactory.setUpConnectionForJndi();

		Select<SagsUnsDto> select = new SelectSagsUns();
		List<SagsUnsDto> dtoList = select.getDbObjectList();
		System.out.println(dtoList);
	}

}
