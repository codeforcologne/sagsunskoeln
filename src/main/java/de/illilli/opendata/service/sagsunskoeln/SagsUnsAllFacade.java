package de.illilli.opendata.service.sagsunskoeln;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import de.illilli.opendata.service.sagsunskoeln.jdbc.SelectSagsUns;

public class SagsUnsAllFacade extends SagsUnsFacade {

	public SagsUnsAllFacade() throws SQLException, NamingException, IOException {
		super(new SelectSagsUns().getDbObjectList());
	}

}
