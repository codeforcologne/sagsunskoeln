package de.illilli.opendata.service.sagsunskoeln;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

import de.illilli.opendata.service.AskFor;
import de.illilli.opendata.service.Facade;

public class PutSagUnsFacade implements Facade {

	public PutSagUnsFacade() throws MalformedURLException, IOException {

		List<SagsUnsBo> boList = new ArrayList<SagsUnsBo>();
		// get Data
		AskFor<SagsUns[]> askFor = new AskForSagsuns();
		// put to List
		for (SagsUns sagsUns : askFor.getData()) {
			boList.add(new SagsUnsDao(sagsUns).getSagsUnsBo());
		}
	}

	@Override
	public String getJson() throws JsonProcessingException {
		// TODO Auto-generated method stub
		return null;
	}

}
