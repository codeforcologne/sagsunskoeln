package de.illilli.opendata.service.sagsunskoeln.jdbc;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.junit.Before;

import de.illilli.opendata.service.sagsunskoeln.AskForSagsunsTest;
import de.illilli.opendata.service.sagsunskoeln.SagsUnsConverter;

/**
 * As long as there is no integration test stage, database related tests are
 * just main Methods.
 */
public class InsertSagsUnsTest {

	@Before
	public void setUp() throws Exception {
	}

	public static void main(String[] args) throws SQLException, NamingException, IOException {
		// define db-connection
		ConnectionFactory.setUpConnectionForJndi();

		SagsUnsDto dto = new SagsUnsConverter(AskForSagsunsTest.getA1627()).getSagsUnsDto();
		InsertSagsUns insert = new InsertSagsUns(dto);
		int inserts = insert.getInserts();
		System.out.println("inserts='" + inserts + "'");
	}

}
