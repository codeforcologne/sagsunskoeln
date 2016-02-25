package de.illilli.opendata.service.sagsunskoeln.jdbc;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import de.illilli.jdbc.Select;

public class SelectServiceCodes extends Select<ServiceCodeDto> {

	String queryString = "/selectServiceCodes.sql";

	public SelectServiceCodes() throws SQLException, NamingException, IOException {
		setQueryString(queryString);
		Object[] params = new Object[] {};
		runSelect(new BeanListHandler<ServiceCodeDto>(ServiceCodeDto.class), params);
	}
}
