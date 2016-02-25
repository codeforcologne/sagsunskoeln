package de.illilli.opendata.service.sagsunskoeln.jdbc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.junit.Before;

import de.illilli.jdbc.Select;

public class SelectServiceCodesTest {

	@Before
	public void setUp() throws Exception {
	}

	public static void main(String[] args) throws IOException, SQLException, NamingException {
		ConnectionFactory.setUpConnectionForJndi();

		Select<ServiceCodeDto> select = new SelectServiceCodes();
		List<ServiceCodeDto> dtoList = select.getDbObjectList();
		for (ServiceCodeDto dto : dtoList) {
			System.out.println(dto);
		}

	}

}
