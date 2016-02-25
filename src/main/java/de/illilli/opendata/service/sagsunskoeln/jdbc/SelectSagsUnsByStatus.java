package de.illilli.opendata.service.sagsunskoeln.jdbc;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import de.illilli.jdbc.Select;

public class SelectSagsUnsByStatus extends Select<SagsUnsDto> {

	String queryString = "/selectSagsUnsByStatus.sql";

	public SelectSagsUnsByStatus(String code) throws SQLException, NamingException, IOException {
		setQueryString(queryString);
		Object[] params = new Object[] { code };
		runSelect(new BeanListHandler<SagsUnsDto>(SagsUnsDto.class), params);
	}

}
