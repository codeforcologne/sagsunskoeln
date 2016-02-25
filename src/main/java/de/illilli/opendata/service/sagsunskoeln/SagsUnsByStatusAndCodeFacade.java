package de.illilli.opendata.service.sagsunskoeln;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import de.illilli.opendata.service.sagsunskoeln.jdbc.SelectSagsUnsByStatusAndCode;

public class SagsUnsByStatusAndCodeFacade extends SagsUnsFacade {

	public SagsUnsByStatusAndCodeFacade(String status, int code) throws SQLException, NamingException, IOException {
		super(new SelectSagsUnsByStatusAndCode(status, code).getDbObjectList());
	}

}
