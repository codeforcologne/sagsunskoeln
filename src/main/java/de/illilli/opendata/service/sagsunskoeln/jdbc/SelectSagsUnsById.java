package de.illilli.opendata.service.sagsunskoeln.jdbc;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import de.illilli.jdbc.Select;

public class SelectSagsUnsById extends Select<SagsUnsDto> {

	String queryString = "/selectSagsUnsById.sql";

	public SelectSagsUnsById(String id) throws SQLException, NamingException, IOException {
		setQueryString(queryString);
		Object[] params = new Object[] { id };
		runSelect(new BeanListHandler<SagsUnsDto>(SagsUnsDto.class), params);
	}
}
