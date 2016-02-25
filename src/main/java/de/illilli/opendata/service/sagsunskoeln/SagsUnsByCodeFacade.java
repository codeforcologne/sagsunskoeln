package de.illilli.opendata.service.sagsunskoeln;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import de.illilli.opendata.service.sagsunskoeln.jdbc.SelectSagsUnsByCode;

public class SagsUnsByCodeFacade extends SagsUnsFacade {

	public SagsUnsByCodeFacade(int code) throws SQLException, NamingException, IOException {
		super(new SelectSagsUnsByCode(code).getDbObjectList());
	}

}
