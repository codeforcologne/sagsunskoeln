package de.illilli.opendata.service.sagsunskoeln;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;

import de.illilli.opendata.service.Facade;
import de.illilli.opendata.service.sagsunskoeln.jdbc.SagsUnsDto;
import de.illilli.opendata.service.sagsunskoeln.jdbc.SelectSagsUns;

public class SagsUnsAllFacade implements Facade {

	List<SagsUnsBo> sagUnsList = new ArrayList<SagsUnsBo>();

	public SagsUnsAllFacade() throws SQLException, NamingException, IOException {
		this(new SelectSagsUns().getDbObjectList());
	}

	public SagsUnsAllFacade(List<SagsUnsDto> dtoList) {
		for (SagsUnsDto dto : dtoList) {
			sagUnsList.add(new SagsUnsDtoConverter(dto).getSagsUnsBo());
		}
	}

	@Override
	public String getJson() throws JsonProcessingException {
		Gson gson = new Gson();
		return gson.toJson(sagUnsList);
	}

}
