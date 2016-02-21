package de.illilli.opendata.service.sagsunskoeln;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;

import de.illilli.opendata.service.Facade;
import de.illilli.opendata.service.sagsunskoeln.jdbc.SagsUnsDto;

public abstract class SagsUnsFacade implements Facade {

	List<SagsUnsBo> sagUnsList = new ArrayList<SagsUnsBo>();

	public SagsUnsFacade(List<SagsUnsDto> dtoList) {
		for (SagsUnsDto dto : dtoList) {
			sagUnsList.add(new SagsUnsDtoConverter(dto).getData());
		}
	}

	@Override
	public String getJson() throws JsonProcessingException {
		Gson gson = new Gson();
		return gson.toJson(sagUnsList);
	}

}
