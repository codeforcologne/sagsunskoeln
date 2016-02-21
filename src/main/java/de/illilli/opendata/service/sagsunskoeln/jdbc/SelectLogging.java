package de.illilli.opendata.service.sagsunskoeln.jdbc;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import de.illilli.jdbc.Select;

public class SelectLogging extends Select<LoggingDto> {

	String queryString = "/selectLogging.sql";

	public SelectLogging() throws SQLException, NamingException, IOException {
		setQueryString(queryString);
		Object[] params = new Object[] {};
		runSelect(new BeanListHandler<LoggingDto>(LoggingDto.class), params);
	}

}
