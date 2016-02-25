package de.illilli.opendata.service.sagsunskoeln.jdbc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.junit.Before;

import de.illilli.jdbc.Select;

public class SelectSagsUnsByCodeTest {

	@Before
	public void setUp() throws Exception {
	}

	public static void main(String[] args) throws IOException, SQLException, NamingException {
		// define db-connection
		ConnectionFactory.setUpConnectionForJndi();

		int code = 11;
		Select<SagsUnsDto> select = new SelectSagsUnsByCode(code);
		List<SagsUnsDto> dtoList = select.getDbObjectList();
		for (SagsUnsDto dto : dtoList) {
			System.out.println(dto);
		}

	}

}
