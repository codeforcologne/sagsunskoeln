package de.illilli.opendata.service.sagsunskoeln;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.postgis.PGgeometry;
import org.postgis.Point;

import de.illilli.opendata.service.sagsunskoeln.jdbc.SagsUnsDto;

public class SagsUnsDtoConverterTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetLat() {
		SagsUnsDto sagsUns = SagsUnsDtoConverterTest.sagsUnsA1627();
		SagsUnsDtoConverter converter = new SagsUnsDtoConverter(sagsUns);
		SagsUnsBo bo = converter.getSagsUnsBo();
		Double expected = new Double(50.9384079215);
		Double actual = bo.getLat();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testGetLng() {
		SagsUnsDto sagsUns = SagsUnsDtoConverterTest.sagsUnsA1627();
		SagsUnsDtoConverter converter = new SagsUnsDtoConverter(sagsUns);
		SagsUnsBo bo = converter.getSagsUnsBo();
		Double expected = new Double(6.83454483747);
		Double actual = bo.getLng();
		Assert.assertEquals(expected, actual);
	}

	public static SagsUnsDto sagsUnsA1627() {
		SagsUnsDto sagsUns = new SagsUnsDto();
		Point point = new Point(50.9384079215, 6.83454483747);
		PGgeometry geom = new PGgeometry(point);
		point.setSrid(SagsUnsConverter.SRID);
		sagsUns.setGeom(geom);
		return sagsUns;
	}

}
