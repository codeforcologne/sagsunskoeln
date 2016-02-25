package de.illilli.opendata.service.sagsunskoeln.jdbc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.junit.Before;

import de.illilli.jdbc.Select;

public class SelectSagsUnsByStatusAndCodeTest {

	@Before
	public void setUp() throws Exception {
	}

	public static void main(String[] args) throws IOException, SQLException, NamingException {
		// define db-connection
		ConnectionFactory.setUpConnectionForJndi();

		String status = "open";
		int servicecode = 11;
		Select<SagsUnsDto> select = new SelectSagsUnsByStatusAndCode(status, servicecode);
		List<SagsUnsDto> dtoList = select.getDbObjectList();
		for (SagsUnsDto dto : dtoList) {
			System.out.println(dto);
		}
	}

}
