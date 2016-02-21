package de.illilli.opendata.service.sagsunskoeln;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import de.illilli.opendata.service.sagsunskoeln.jdbc.SelectSagsUnsById;

public class SagsUnsByIdFacade extends SagsUnsFacade {

	public SagsUnsByIdFacade(String id) throws SQLException, NamingException, IOException {
		super(new SelectSagsUnsById(id).getDbObjectList());
	}
}
