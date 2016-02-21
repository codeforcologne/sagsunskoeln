package de.illilli.opendata.service.sagsunskoeln;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;

import de.illilli.jdbc.Select;
import de.illilli.opendata.service.Facade;
import de.illilli.opendata.service.sagsunskoeln.jdbc.LoggingDto;
import de.illilli.opendata.service.sagsunskoeln.jdbc.SelectLogging;

public class LoggingFacade implements Facade {

	List<LoggingBo> boList = new ArrayList<LoggingBo>();

	public LoggingFacade() throws SQLException, NamingException, IOException {
		Select<LoggingDto> select = new SelectLogging();
		List<LoggingDto> dtoList = select.getDbObjectList();
		for (LoggingDto dto : dtoList) {
			boList.add(new LoggingConverter(dto).getData());
		}
	}

	@Override
	public String getJson() throws JsonProcessingException {
		Gson gson = new Gson();
		return gson.toJson(boList);
	}

}
