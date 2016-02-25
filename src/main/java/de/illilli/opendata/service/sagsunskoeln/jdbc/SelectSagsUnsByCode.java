package de.illilli.opendata.service.sagsunskoeln.jdbc;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import de.illilli.jdbc.Select;

public class SelectSagsUnsByCode extends Select<SagsUnsDto> {

	String queryString = "/selectSagsUnsByCode.sql";

	public SelectSagsUnsByCode(int code) throws SQLException, NamingException, IOException {
		setQueryString(queryString);
		Object[] params = new Object[] { code };
		runSelect(new BeanListHandler<SagsUnsDto>(SagsUnsDto.class), params);
	}
}
