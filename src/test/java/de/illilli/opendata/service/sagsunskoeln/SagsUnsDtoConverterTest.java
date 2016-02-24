package de.illilli.opendata.service.sagsunskoeln;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.illilli.opendata.service.sagsunskoeln.jdbc.SagsUnsDto;

public class SagsUnsDtoConverterTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetLat() {
		SagsUnsDto sagsUns = SagsUnsDtoConverterTest.sagsUnsA1627();
		SagsUnsDtoConverter converter = new SagsUnsDtoConverter(sagsUns);
		SagsUnsBo bo = converter.getData();
		Double expected = new Double(50.9384079215);
		Double actual = bo.getLat();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testGetLng() {
		SagsUnsDto sagsUns = SagsUnsDtoConverterTest.sagsUnsA1627();
		SagsUnsDtoConverter converter = new SagsUnsDtoConverter(sagsUns);
		SagsUnsBo bo = converter.getData();
		Double expected = new Double(6.83454483747);
		Double actual = bo.getLng();
		Assert.assertEquals(expected, actual);
	}

	public static SagsUnsDto sagsUnsA1627() {
		SagsUnsDto sagsUns = new SagsUnsDto();
		sagsUns.setLat(50.9384079215);
		sagsUns.setLng(6.83454483747);
		return sagsUns;
	}

}
