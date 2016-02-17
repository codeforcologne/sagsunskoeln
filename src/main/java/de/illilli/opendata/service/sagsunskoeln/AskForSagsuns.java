package de.illilli.opendata.service.sagsunskoeln;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.illilli.opendata.service.AskFor;
import de.illilli.opendata.service.Config;

public class AskForSagsuns implements AskFor<SagsUns[]> {

	private static final Logger logger = Logger.getLogger(AskForSagsuns.class);

	String url = Config.getProperty("sagsuns.url");

	private SagsUns[] sagsUnsList;
	private InputStream inputStream;

	public AskForSagsuns() throws MalformedURLException, IOException {
		this.inputStream = new URL(url).openStream();
		mapData();
	}

	public AskForSagsuns(InputStream inputStream) throws JsonParseException, JsonMappingException, IOException {
		this.inputStream = inputStream;
		mapData();
	}

	private void mapData() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		sagsUnsList = mapper.readValue(inputStream, SagsUns[].class);
	}

	@Override
	public SagsUns[] getData() {
		return sagsUnsList;
	}

}
