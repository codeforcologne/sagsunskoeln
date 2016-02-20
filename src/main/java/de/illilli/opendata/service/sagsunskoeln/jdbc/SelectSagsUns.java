package de.illilli.opendata.service.sagsunskoeln.jdbc;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import de.illilli.jdbc.Select;

public class SelectSagsUns extends Select<SagsUnsDto> {

	String queryString = "/selectSagsUns.sql";

	public SelectSagsUns() throws SQLException, NamingException, IOException {
		setQueryString(queryString);
		Object[] params = new Object[] {};
		runSelect(new BeanListHandler<SagsUnsDto>(SagsUnsDto.class), params);
	}
}
