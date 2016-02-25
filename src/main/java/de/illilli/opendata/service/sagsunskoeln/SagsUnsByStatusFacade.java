package de.illilli.opendata.service.sagsunskoeln;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import de.illilli.opendata.service.sagsunskoeln.jdbc.SelectSagsUnsByStatus;

public class SagsUnsByStatusFacade extends SagsUnsFacade {

	public SagsUnsByStatusFacade(String status) throws SQLException, NamingException, IOException {
		super(new SelectSagsUnsByStatus(status).getDbObjectList());
	}

}
