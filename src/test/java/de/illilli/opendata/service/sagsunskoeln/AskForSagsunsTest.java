package de.illilli.opendata.service.sagsunskoeln;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.JsonSyntaxException;

import de.illilli.opendata.service.AskFor;

public class AskForSagsunsTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetSize() throws MalformedURLException, IOException {
		InputStream inputStream = this.getClass().getResourceAsStream("/sagsuns.json");
		AskFor<SagsUns[]> askFor = new AskForSagsuns(inputStream);
		SagsUns[] sagsUnsList = askFor.getData();
		int expected = 50;
		int actual = sagsUnsList.length;
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testA1627() throws JsonSyntaxException, IOException {
		InputStream inputStream = this.getClass().getResourceAsStream("/sagsuns.json");
		AskFor<SagsUns[]> askFor = new AskForSagsuns(inputStream);
		SagsUns[] sagsUnsList = askFor.getData();
		SagsUns expected = getA1627();
		SagsUns actual = sagsUnsList[0];
		Assert.assertEquals(expected, actual);
	}

	SagsUns getA1627() {

		SagsUns sagsUns = new SagsUns();

		sagsUns.service_request_id = "A-1627";
		sagsUns.status = "open";
		sagsUns.service_code = "017";
		sagsUns.service_name = "Ampel defekt";
		sagsUns.description = "Die Ampel an der Nordseite der Aachener ist verdreht. Die Lichter f\u00fcr die Fu\u00dfg\u00e4nger stehen mehr in Rtg. Autos.";
		sagsUns.agency_responsible = null;
		sagsUns.service_notice = null;
		sagsUns.address_id = null;
		sagsUns.requested_datetime = "2016-02-16T21:26:17+01:00";
		sagsUns.updated_datetime = "2016-02-16T21:26:17+01:00";
		sagsUns.address = "Schillerstr. 1, 50858 K\u00f6ln - Weiden";
		sagsUns.zipcode = null;
		sagsUns.lat = "50.9384079215";
		sagsUns.lng = "6.83454483747";

		return sagsUns;
	}

}
