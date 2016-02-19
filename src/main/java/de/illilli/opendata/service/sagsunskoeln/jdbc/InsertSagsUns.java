package de.illilli.opendata.service.sagsunskoeln.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import de.illilli.jdbc.ConnectionFactory;

public class InsertSagsUns {

	private static final Logger logger = Logger.getLogger(InsertSagsUns.class);

	private int inserts;

	public InsertSagsUns(SagsUnsDto dto) throws SQLException, NamingException, IOException {
		Connection conn = ConnectionFactory.getConnection();
		InputStream inputStream = this.getClass().getResourceAsStream("/insertIntoSagsUns.sql");
		String sql = IOUtils.toString(inputStream);
		logger.debug(sql);
		QueryRunner run = new QueryRunner();
		inserts = run.update(conn, sql, dto.getId(), dto.getStatus(), dto.getServiceCode(), dto.getServiceName(),
				dto.getDescription(), dto.getRequesteddatetime(), dto.getUpdateddatetime(), dto.getAddress(),
				dto.getMediaUrl(), dto.getStatusnotes(), dto.getGeom());
		conn.close();
	}

	public int getInserts() {
		return inserts;
	}

}
